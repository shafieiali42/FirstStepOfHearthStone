package Controller;

import Logic.NonePlayLogics.CollectionState;
import Logic.NonePlayLogics.ShopState;
import Logic.NonePlayLogics.StatusState;
import Logic.PlayLogic.Alliance;
import Logic.PlayLogic.Game;
import Logic.Status;

import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import View.Gui.Panels.CollectionPages.DeckPage;
import View.Gui.Panels.CollectionPages.DeckViewer;
import View.Gui.Panels.CollectionPages.LittleCardPanel;
import View.Gui.Panels.GamePage.DiscoverCardsPage;
import View.Gui.Panels.GamePage.FirstThreeCardsPage;
import View.Gui.Panels.GamePage.GamePage;
import View.Gui.Panels.GamePage.PlayPanel;


import Models.Cards.CardClasses.Cards;
import Models.Deck.Deck;
import Models.Heroes.*;


import Utility.LengthOfMessage;
import Utility.MethodsOfShowCardsOnPanel;
import Utility.Sounds;
import View.CardView.CardImagePanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import View.Gui.Panels.StatusPanel.ShowDeckInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class Administer {

    private static Administer administer = new Administer();

    public static Administer getInstance() {
        return administer;
    }

    //gameState


    public static void setTargetOfSpell(int number, String alliance) {
        Game.getInstance().setTargetOfSpell(number);
        Game.getInstance().setAllianceOfSpellsTarget(alliance);
    }

    public static Minion getTargetOfSpell() {
        if (Game.getInstance().getAllianceOfSpellsTarget() == null) {
            return new Minion();
        } else if (Game.getInstance().getTargetOfSpell() == 0) {
            return new Minion();
        }
        if (Game.getInstance().getAllianceOfSpellsTarget().equalsIgnoreCase("FRIENDLY")) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfSpell() - 1);
        } else if (Game.getInstance().getAllianceOfSpellsTarget().equalsIgnoreCase("ENEMY")) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfSpell() - 1);
        }
        return null;
    }

    public static ArrayList<Cards> getDeckCards() {
        return Game.getInstance().getCurrentPlayer().getDeckCards();
    }

    public static ArrayList<Cards> getHandCards() {
        return Game.getInstance().getCurrentPlayer().getHandsCards();
    }

    public static ArrayList<Minion> getBattleGround() {
        return Game.getInstance().getCurrentPlayer().getBattleGroundCards();
    }

    public static void reStartDiscoverPageSetting() {
        DiscoverCardsPage.getInstance().reStartSetting();
    }

    public static Weapon getSelectedWeapon() {
        for (Weapon weapon : Weapon.getWeapons()) {
            if (weapon.getName().equalsIgnoreCase(DiscoverCardsPage.getInstance().getSelectedWeapon())) {
                return weapon;
            }
        }
        return null;
    }

    public static boolean getWaitingOfDiscoverPage() {
        return DiscoverCardsPage.getInstance().getWaiting();
    }

    public static void setGamePageContentPane() {
        ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);

    }

    public static void setDiscoverPageContentPane() {
        MyMainFrame.getInstance().setContentPane(DiscoverCardsPage.getInstance());
    }

    public static ArrayList<Cards> getListOfWeapons() {
        ArrayList<Cards> cards = new ArrayList<>();
        for (Cards card : Weapon.getWeapons()) {
            if (card.getName().equalsIgnoreCase(DiscoverCardsPage.getInstance().getFirstCard())) {
                cards.add(card);
            }
            if (card.getName().equalsIgnoreCase(DiscoverCardsPage.getInstance().getSecondCard())) {
                cards.add(card);
            }
            if (card.getName().equalsIgnoreCase(DiscoverCardsPage.getInstance().getThirdCard())) {
                cards.add(card);
            }
        }
        return cards;
    }

    public static void setThreeWeapon() {

        Random random = new Random();
        int firstNum = random.nextInt(Weapon.getWeapons().size());
        int secondNum = random.nextInt(Weapon.getWeapons().size());
        int thirdNum = random.nextInt(Weapon.getWeapons().size());
        DiscoverCardsPage.getInstance().setFirstCard(Weapon.getWeapons().get(firstNum).getName());
        DiscoverCardsPage.getInstance().setSecondCard(Weapon.getWeapons().get(secondNum).getName());
        DiscoverCardsPage.getInstance().setThirdCard(Weapon.getWeapons().get(thirdNum).getName());
    }


    public static Cards getPlyingCardOfGameState() {
        return Game.getInstance().getPlayingCard();
    }


    public static void refreshPlayPanel() {
        PlayPanel.getInstance().setNeedsToRepaint(true);
        PlayPanel.getInstance().repaint();
        PlayPanel.getInstance().revalidate();
    }


    public static void setAttacker(int attacker) {
        Game.getInstance().setAttacker(attacker);
    }

    public static void setTarget(int target) {
        Game.getInstance().setTarget(target);
    }

    public static void removeDeadCharacters() {

//        for (int i = 0; i < Game.getInstance().getFriendlyPlayer().getBattleGroundCards().size(); i++) {
//            if (Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(i).getHealthPower()<=0){
//                Game.getInstance().getFriendlyPlayer().getBattleGroundCards().remove(i);
//            }
//        }
//        for (int i = 0; i < Game.getInstance().getEnemyPlayer().getBattleGroundCards().size(); i++) {
//            if (Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(i).getHealthPower()<=0){
//                Game.getInstance().getEnemyPlayer().getBattleGroundCards().remove(i);
//            }
//        }
        if (Game.getInstance().getFriendlyPlayer().getCurrentWeapon() != null) {
            if (Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getDurability() == 0) {
                Game.getInstance().getFriendlyPlayer().setCurrentWeapon(null);
            }
        }

        if (Game.getInstance().getEnemyPlayer().getCurrentWeapon() != null) {
            if (Game.getInstance().getEnemyPlayer().getCurrentWeapon().getDurability() == 0) {
                Game.getInstance().getEnemyPlayer().setCurrentWeapon(null);
            }
        }

        if (Game.getInstance().getFriendlyPlayer().getHero().getHealthPower() <= 0) {
            //TODO Friendly player wins
        } else if (Game.getInstance().getEnemyPlayer().getHero().getHealthPower() <= 0) {
            //TODO ENEMY player wins
        }

        Iterator<Minion> itr = Game.getInstance().getFriendlyPlayer().getBattleGroundCards().iterator();

        while (itr.hasNext()) {
            Minion minion = itr.next();
            if (minion.getHealthPower() <= 0) {
                itr.remove();
            }
        }

        Iterator<Minion> itr2 = Game.getInstance().getEnemyPlayer().getBattleGroundCards().iterator();

        while (itr2.hasNext()) {
            Minion minion = itr2.next();
            if (minion.getHealthPower() <= 0) {
                itr2.remove();
            }
        }

    }

//    public static void attack1(int attacker, int target) {
//        attack(attacker, target);
//
//    }

    public static int getAttacker() {
        return Game.getInstance().getAttacker();
    }

    public static int getTarget() {
        return Game.getInstance().getTarget();
    }


    public static void attack(int attacker, int target) {

        if (attacker == -2) {
            Weapon weapon = Game.getInstance().getCurrentPlayer().getCurrentWeapon();
            Minion minion = Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(target);
            minion.setHealthPower(minion.getHealthPower() - weapon.getAttackPower());
            removeDeadCharacters();
        } else {

            if (attacker == -5) {
                //TODO choose attacker
                return;
            } else if (target == -5) {
                //TODO choose attacker
                return;
            }

            Minion minion = Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(attacker);
            Minion minion2 = Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(target);

            if (minion.getIsActive() && !minion.getHasAttackInThisTurn()) {
                if (minion2.getCanBeAttacked()) {
                    System.out.println("Before attack:");
                    System.out.println(minion.getName() + " Attack: " + minion.getAttackPower() + " Hp: " + minion.getHealthPower());
                    System.out.println(minion2.getName() + " Attack: " + minion2.getAttackPower() + " Hp: " + minion2.getHealthPower());
                    minion.setHealthPower(minion.getHealthPower() - minion2.getAttackPower());
                    minion2.setHealthPower(minion2.getHealthPower() - minion.getAttackPower());
                    removeDeadCharacters();
                    System.out.println("After attack:");
                    System.out.println(minion.getName() + " Attack: " + minion.getAttackPower() + " Hp: " + minion.getHealthPower());
                    System.out.println(minion2.getName() + " Attack: " + minion2.getAttackPower() + " Hp: " + minion2.getHealthPower());
                } else {
                    //TODO you first need to destroy Taunt OR you cant attack to this minion
                }
            } else {
                //TODO you cant attack with this minion in this turn
            }

        }

    }

    public static void attack(Minion minion, Heroes hero) {
        if (minion.getIsActive() && !minion.getHasAttackInThisTurn()) {
            if (hero.getCanBeAttacked()) {
                if (hero.getShield() - minion.getAttackPower() >= 0) {
                    hero.setShield(hero.getShield() - minion.getAttackPower());
//                    removeDeadCharacters();//TODO SHOULD UNCOMMENT
                } else {
                    hero.setShield(0);
                    hero.setHealthPower(hero.getHealthPower() - (minion.getAttackPower() - hero.getShield()));
//                    removeDeadCharacters();//TODO SHOULD UNCOMMENT
                }
            } else {
                //TODO you first need to destroy Taunt OR you cant attack to this hero
            }
        } else {
            //TODO you cant attack with this minion in this turn
        }
    }

    public static void reStartFirstThreeCardsSetting() {
        FirstThreeCardsPage.getInstance().reStartSetting();
    }


    public static void ChangeThisCardFromHands(String cardName) {

//        System.out.println(Game.getInstance().getFriendlyPlayer().getDeckCards());
//        System.out.println("CardName: " + cardName + " First: " + FirstThreeCardsPage.getInstance().getFirstCard());
//        System.out.println("CardName: " + cardName + " First: " + FirstThreeCardsPage.getInstance().getSecondCard());
//        System.out.println("CardName: " + cardName + " First: " + FirstThreeCardsPage.getInstance().getThirdCard());
        boolean changed = false;
        if (cardName.equals(FirstThreeCardsPage.getInstance().getFirstCard()) && FirstThreeCardsPage.getInstance().getCanChangeFirstCard()) {
            changed = true;
            FirstThreeCardsPage.getInstance().setCanChangeFirstCard(false);
            Game.getInstance().getFriendlyPlayer().getDeckCards().add(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(0));
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().remove(0);
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().add(0, Game.getInstance().getFriendlyPlayer().getDeckCards().get(3));
            Game.getInstance().getFriendlyPlayer().getDeckCards().remove(3);
            Game.getInstance().getFriendlyPlayer().setHandsCards(Game.getInstance().getFriendlyPlayer().getFirstThreeCards());

        } else if (cardName.equals(FirstThreeCardsPage.getInstance().getSecondCard()) && FirstThreeCardsPage.getInstance().getCanChangeSecondCard()) {
            changed = true;
            FirstThreeCardsPage.getInstance().setCanChangeSecondCard(false);
            Game.getInstance().getFriendlyPlayer().getDeckCards().add(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(1));
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().remove(1);
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().add(1, Game.getInstance().getFriendlyPlayer().getDeckCards().get(3));
            Game.getInstance().getFriendlyPlayer().getDeckCards().remove(3);
            Game.getInstance().getFriendlyPlayer().setHandsCards(Game.getInstance().getFriendlyPlayer().getFirstThreeCards());
        } else if (cardName.equals(FirstThreeCardsPage.getInstance().getThirdCard()) && FirstThreeCardsPage.getInstance().getCanChangeThirdCard()) {
            changed = true;
            FirstThreeCardsPage.getInstance().setCanChangeThirdCard(false);
            Game.getInstance().getFriendlyPlayer().getDeckCards().add(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(2));
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().remove(2);
            Game.getInstance().getFriendlyPlayer().getFirstThreeCards().add(2, Game.getInstance().getFriendlyPlayer().getDeckCards().get(3));
            Game.getInstance().getFriendlyPlayer().getDeckCards().remove(3);
            Game.getInstance().getFriendlyPlayer().setHandsCards(Game.getInstance().getFriendlyPlayer().getFirstThreeCards());
        }

        if (!changed) {
            JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You cant change this card", "Error", JOptionPane.ERROR_MESSAGE);
        }

        FirstThreeCardsPage.getInstance().repaint();
        FirstThreeCardsPage.getInstance().revalidate();

    }

    public static void setNameOfFirstFriendlyThreeCards() {
        FirstThreeCardsPage.getInstance().setFirstCard(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(0).getName());
        FirstThreeCardsPage.getInstance().setSecondCard(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(1).getName());
        FirstThreeCardsPage.getInstance().setThirdCard(Game.getInstance().getFriendlyPlayer().getFirstThreeCards().get(2).getName());
    }

    public static ArrayList<Cards> getFirstFriendlyThreeCards() {
        return Game.getInstance().getFriendlyPlayer().getFirstThreeCards();
    }


    public static boolean canDragCard(int y) {
        if (Game.getInstance().getCurrentAlliance().equals(Alliance.FRIENDLY)) {
            return y >= 670;
        } else {
            return y <= 100;
        }
    }

    public static boolean isPlayedBefore(String cardName) {
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().equalsIgnoreCase(cardName)) {
                return card.isPlayed();
            }
        }
        return true;
    }

    public static boolean checkThatCanReleaseCard(int x, int y) {
        if (Game.getInstance().getCurrentAlliance().equals(Alliance.FRIENDLY)) {
            return x > 0 && x < 1200 && y > 385 && y < 770;

        } else {
            return x > 0 && x < 1200 && y > 0 && y < 385;
        }
    }


    public static void setGameMode(int mode) {
        Game.getInstance().setGameMode(mode);
        try {
            Game.getInstance().initGameState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getGameMode() {
        return Game.getInstance().getGameMode();
    }

    public static int getHpOfCurrentFriendlyHeroInGameState() {
        return Game.getInstance().getFriendlyPlayer().getHero().getHealthPower();
    }

    public static int getHpOfCurrentEnemyHeroInGameState() {
        return Game.getInstance().getEnemyPlayer().getHero().getHealthPower();
    }

    public static void showFriendlyWeaponOfGameState(JPanel panel, int widthOfWeaponImage, int heightOfWeaponImage, int xCoordinateOfWeapon, int yCoordinateOfWeapon) {
        if (Game.getInstance().getFriendlyPlayer().getCurrentWeapon() != null) {
            try {
                CardImagePanel cardImagePanel = new CardImagePanel(Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getName(),
                        widthOfWeaponImage, heightOfWeaponImage, "weapon","FRIENDLY");

                MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                        xCoordinateOfWeapon, yCoordinateOfWeapon, widthOfWeaponImage, heightOfWeaponImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showEnemyWeaponOfGameState(JPanel panel, int widthOfWeaponImage, int heightOfWeaponImage, int xCoordinateOfWeapon, int yCoordinateOfWeapon) {
        if (Game.getInstance().getEnemyPlayer().getCurrentWeapon() != null) {
            try {
                CardImagePanel cardImagePanel = new CardImagePanel(Game.getInstance().getEnemyPlayer().getCurrentWeapon().getName(),
                        widthOfWeaponImage, heightOfWeaponImage, "weapon","ENEMY");

                MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                        xCoordinateOfWeapon, yCoordinateOfWeapon, widthOfWeaponImage, heightOfWeaponImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showEnemyHandsCardInPlay(JPanel panel, int numberOfCardsPerRowHandsCards, int typeOfBackOfCards, int gameMode) throws IOException {
        if (gameMode == 1) {
            MethodsOfShowCardsOnPanel.showBackOfEnemyHandsCards(Game.getInstance().getEnemyPlayer().getHandsCards(),
                    panel, numberOfCardsPerRowHandsCards, typeOfBackOfCards);
        } else {
            MethodsOfShowCardsOnPanel.showEnemyHandsCards(Game.getInstance().getEnemyPlayer().getHandsCards(),
                    panel, numberOfCardsPerRowHandsCards);
        }
    }

    public static void showFriendlyHandsCardInPlay(JPanel panel, int numberOfCardsPerRowHandsCards) throws IOException {
        MethodsOfShowCardsOnPanel.showFriendlyHandsCards(Game.getInstance().getFriendlyPlayer().getHandsCards(),
                panel, numberOfCardsPerRowHandsCards);
    }

    public static void showFriendlyBattleGroundCardsInPlay(JPanel panel, int numberOfCardsPerRowGamePanel) throws IOException {
        MethodsOfShowCardsOnPanel.showFriendlyBattleGroundCards(Game.getInstance().getFriendlyPlayer().getBattleGroundCards(), panel, numberOfCardsPerRowGamePanel, Alliance.FRIENDLY);
    }

    public static void showEnemyBattleGroundCardsInPlay(JPanel panel, int numberOfCardsPerRowGamePanel) throws IOException {
        MethodsOfShowCardsOnPanel.showEnemyBattleGroundCards(Game.getInstance().getEnemyPlayer().getBattleGroundCards(), panel, numberOfCardsPerRowGamePanel, Game.getInstance().getCurrentAlliance());
    }

    public static String getNameOfFriendlyHeroOfGameState() {
        return Game.getInstance().getFriendlyPlayer().getHero().getName();
    }

    public static String getNameOfEnemyHeroOfGameState() {
        return Game.getInstance().getEnemyPlayer().getHero().getName();
    }

    public static String getNameOfFriendlyPassive(int numberOfPassive) {
        return Game.getInstance().getFriendlyPlayer().getPassivesToChoose().get(numberOfPassive).getName();
    }

    public static String getNameOfEnemyPassive(int numberOfPassive) {
        return Game.getInstance().getEnemyPlayer().getPassivesToChoose().get(numberOfPassive).getName();
    }

    public static void setFriendlyInfoPassiveOfGameState(int numberOfPassive) {
        Game.getInstance().getFriendlyPlayer().setInfoPassive(Game.getInstance().getFriendlyPlayer().getPassivesToChoose().get(numberOfPassive));
    }

    public static void setEnemyInfoPassiveOfGameState(int numberOfPassive) {
        Game.getInstance().getEnemyPlayer().setInfoPassive(Game.getInstance().getEnemyPlayer().getPassivesToChoose().get(numberOfPassive));
    }

    public static int getManaOfCurrentPlayer() {
        return Game.getInstance().getCurrentPlayer().getMana();
    }

    public static int getEnemyManaOfGameState() {
        return Game.getInstance().getEnemyPlayer().getMana();
    }

    public static void initializeGameState() throws IOException {
        Game.getInstance().initGameState();
    }

    public static boolean canAddFriendlyMinionToBattleGround() {
        return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().size() <= 7 - 1;
    }

    public static boolean canAddEnemyMinionToBattleGround() {
        return Game.getInstance().getEnemyPlayer().getBattleGroundCards().size() <= 7 - 1;
    }

    public static void setPlayingCardOfGameState(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                Game.getInstance().setPlayingCard(cards);
            }
        }
    }

    public static String getPlayingCardName() {
        return Game.getInstance().getPlayingCard().getName();
    }

    public static boolean isCurrentPlayersCurrentDeckNull() {
        return ControllerOfMainComponents.currentPlayer.getCurrentDeck().getHero() == null;
    }

    public static int getNumberOfFriendlyCardsOfDeckInGameState() {
        return Game.getInstance().getFriendlyPlayer().getDeckCards().size();
    }

    public static int getNumberOfEnemyCardsOfDeckInGameState() {
        return Game.getInstance().getEnemyPlayer().getDeckCards().size();
    }


    //statusState
    public static void changeBackOfCards(int typeOfBackOfCards) {
        PlayPanel.getInstance().setTypeOfBackOfCards(typeOfBackOfCards);
    }

    public static void setDeckToShowOFStatusState(int deckNumber) {
        ShowDeckInfoPanel.getInstance().setNameOfDeckToShow(ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer().get(deckNumber - 1).getName());
        StatusState.getInstance().setDeckToShow(ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer().get(deckNumber - 1));
    }

    public static void showDeckOfStatusState(JPanel panel, Graphics2D graphics2D) {
        String name = "Name: " + StatusState.getInstance().getDeckToShow().getName();
        int lengthOfName = LengthOfMessage.lengthOfMessage(name, graphics2D);
        String heroName = "Hero: " + StatusState.getInstance().getDeckToShow().getHero().getName();
        int lengthOfHeroName = LengthOfMessage.lengthOfMessage(heroName, graphics2D);
        String wins = "Wins:" + StatusState.getInstance().getDeckToShow().getNumberOfWins();
        int lengthOfWins = LengthOfMessage.lengthOfMessage(wins, graphics2D);
        String use = "Uses: " + StatusState.getInstance().getDeckToShow().getNumberOfUses();
        int lengthOfUse = LengthOfMessage.lengthOfMessage(use, graphics2D);
        String mostUsedCard = "Most Used Card: " + StatusState.getInstance().getDeckToShow().getMostUsedCard().getName();
        int lengthOfCard = LengthOfMessage.lengthOfMessage(mostUsedCard, graphics2D);
        String manaAvg = "Average of Mana: " + StatusState.getInstance().getDeckToShow().getManaAvg();
        int lengthOfMana = LengthOfMessage.lengthOfMessage(manaAvg, graphics2D);
        if (StatusState.getInstance().getDeckToShow().getNumberOfUses() == 0) {
            StatusState.getInstance().getDeckToShow().setNumberOfUses(1);
        }
        String winsPerPlay = "Wins per Play: " +
                (StatusState.getInstance().getDeckToShow().getNumberOfWins() / StatusState.getInstance().getDeckToShow().getNumberOfUses()) * 100 + " %";
        int lengthOfWinsPerPlay = LengthOfMessage.lengthOfMessage(winsPerPlay, graphics2D);
        graphics2D.drawString(name, (panel.getWidth() - lengthOfName) / 2, 50);
        graphics2D.drawString(heroName, (panel.getWidth() - lengthOfHeroName) / 2, 100);
        graphics2D.drawString(wins, (panel.getWidth() - lengthOfWins) / 2, 150);
        graphics2D.drawString(use, (panel.getWidth() - lengthOfUse) / 2, 200);
        graphics2D.drawString(mostUsedCard, (panel.getWidth() - lengthOfCard) / 2, 250);
        graphics2D.drawString(manaAvg, (panel.getWidth() - lengthOfMana) / 2, 300);
        graphics2D.drawString(winsPerPlay, (panel.getWidth() - lengthOfWinsPerPlay) / 2, 350);
    }

    public static void defineMostUsedCardInDeck(String deckName) {
        for (Deck deck : ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer()) {
            if (deck.getName().equals(deckName)) {
                deck.defineMostUsedCard();
            }
        }
    }

    public static void sortDecksOfCurrentPlayer() {
        Collections.sort(ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer());
    }


    //settingState
    public static void changeStatusOfSound(int numberOfPushMuteBtn) {
        Sounds.changeStatus(numberOfPushMuteBtn);
    }

    public static void increaseSound() {
        Sounds.increaseSound();
    }

    public static void decreaseSound() {
        Sounds.decreaseSound();
    }

    public static void playMainSound(String path) {
        Sounds.playMainSound(path);
    }

    public static void playActionSounds(String action) {
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/" + action + ".wav");
    }


    //  player
//    public static void showJOptionPaneWrongPassWordErrorForDeletePlayer() {
//        JOptionPane.showMessageDialog(MainMenuPage.getInstance(), "Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
//    }
//
//    public static void showJOptionPaneOfLogInError() {
//        JOptionPane.showMessageDialog(LogInPage.getInstance(),
//                "Please Enter a Valid UserName or Password!", "LogIn Error", JOptionPane.ERROR_MESSAGE);
//    }
//
//    public static void signUpErrorJOptionPane() {
//        JOptionPane.showMessageDialog(LogInPage.getInstance(),
//                "There is an account with this username!", "SignUp Error", JOptionPane.ERROR_MESSAGE);
//    }
//    public static void deletePlayer(String passWord) throws IOException {
//        PlayerController.DeletePlayer(passWord);
//    }
//
//    public static void logOut() throws IOException {
//        PlayerController.logOut();
//    }
//
//    public static void signUp(String userName, String passWord) throws IOException {
//        PlayerController.signUp(userName, passWord);
//    }
//
//    public static void signIn(String userName, String passWord) throws IOException {
//        PlayerController.signIn(userName, passWord);
//    }


    //collectionState
    public static void defineUsesHashMap() {
        CollectionState.getInstance().getDeckToChange().defineUsesHashMapFromArrayList();

    }

    public static void makeCollectionStatesDeckToNull() {
        CollectionState.getInstance().setDeckToChange(new Deck());

    }

    public static void addCollectionStatesDeckToPlayersDecksList() {
        ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer().add(CollectionState.getInstance().getDeckToChange());
    }

    public static ArrayList<String> getListOfPlayersDeckNames() {
        ArrayList<String> listOfPlayersDeckNames = new ArrayList<String>();
        for (Deck deck : ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer()) {
            listOfPlayersDeckNames.add(deck.getName());
        }
        return listOfPlayersDeckNames;
    }

    public static void setCollectionDeck(String deckName) {
        CollectionState.getInstance().setDeckToChange(getDeckThatIsInPlayersDeck(deckName));
//        CollectionState.getInstance().getDeckToChange().setLittleCardsListFromHashMap();
        DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(
                setLittleCardsListFromHashMap(CollectionState.getInstance().getDeckToChange().getUsesHashMap()));

    }

    public static ArrayList<LittleCardPanel> setLittleCardsListFromHashMap(HashMap<String, Integer> hashMap) {
        ArrayList<LittleCardPanel> littleCardPanelsOfThisHashMap = LittleCardPanel.getAllLittleCardPanels();
        for (String cardName : hashMap.keySet()) {
            int useOfCard = hashMap.get(cardName);
            for (LittleCardPanel littleCardPanel : littleCardPanelsOfThisHashMap) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(cardName)) {
                    littleCardPanel.getUsedLabel().setText(useOfCard + "");
                }
            }
        }
        return littleCardPanelsOfThisHashMap;
    }

    public static void makeNewDeck(String name, String heroName) {
        CollectionState.getInstance().setDeckToChange(new Deck());
        CollectionState.getInstance().getDeckToChange().setName(name);
//        CollectionState.getInstance().getDeckToChange().setLittleCardsListFromHashMap();
        switch (heroName) {
            case ("Mage"):
                CollectionState.getInstance().getDeckToChange().setHero(Mage.getInstance());
                break;
            case ("Rogue"):
                CollectionState.getInstance().getDeckToChange().setHero(Rogue.getInstance());
                break;
            case ("Warlock"):
                CollectionState.getInstance().getDeckToChange().setHero(Warlock.getInstance());
                break;
            case ("Hunter"):
                CollectionState.getInstance().getDeckToChange().setHero(Hunter.getInstance());
                break;
            case ("Priest"):
                CollectionState.getInstance().getDeckToChange().setHero(Priest.getInstance());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + heroName);
        }
        DeckPage.getInstance().setNameOfDeckToChange(CollectionState.getInstance().getDeckToChange().getName());
        DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());
    }

    public static String getHeroNameOfDeckToChange() {
        return CollectionState.getInstance().getDeckToChange().getHero().getName();
    }

    public static Deck getDeckThatIsInPlayersDeck(String deckName) {
        if (ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer() != null) {
            for (Deck deck : ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer()) {
                if (deck.getName().equals(deckName)) {
                    return deck;
                }
            }
        }
        return null;
    }

    public static void showAllCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(Cards.getAllCards(), panel, numberOfCardsPerRow);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show all cards ");
    }

    public static void showLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        ControllerOfMainComponents.currentPlayer.setLockCardsList();
        MethodsOfShowCardsOnPanel.showCards(ControllerOfMainComponents.currentPlayer.getLockCards(), panel, numberOfCardsPerRow);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show lock cards ");
    }

    public static void showUnLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        ControllerOfMainComponents.currentPlayer.setAllCardsOfPlayer();
        MethodsOfShowCardsOnPanel.showCards(ControllerOfMainComponents.currentPlayer.getAllCardsOfPlayer(), panel, numberOfCardsPerRow);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show unlock cards ");

    }

    public static void showLittleCardPanelOnDeckViewer(LittleCardPanel littleCardPanel, JPanel panel, int xCoordinate, int yCoordinate) {
        MethodsOfShowCardsOnPanel.addPanel(littleCardPanel, panel,
                xCoordinate, yCoordinate, littleCardPanel.getWidth(), littleCardPanel.getHeight());
    }

    public static ArrayList<LittleCardPanel> getLittleCardPanelOfDeckToChangeFromDeckPage() {
//        return CollectionState.getInstance().getDeckToChange().getLittleCardPanelsOfThisDeck();
        return DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange();
    }

    public static ArrayList<Cards> getListOfCardsOfCollectionStatesDeck() {
        return CollectionState.getInstance().getDeckToChange().getListOfCards();
    }

    public static void selectMainDeck() {
        ControllerOfMainComponents.currentPlayer.setCurrentDeck(CollectionState.getInstance().getDeckToChange());
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("select " + CollectionState.getInstance().getDeckToChange().getName() + " for main deck");
    }

    public static void changeNameOfDeck(String name) {
        CollectionState.getInstance().getDeckToChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Change name of deck ");
    }

    public static void changeHeroOfDeck(String heroName) {
        switch (heroName) {
            case ("Mage"):
                CollectionState.getInstance().getDeckToChange().setHero(Mage.getInstance());
                break;
            case ("Rogue"):
                CollectionState.getInstance().getDeckToChange().setHero(Rogue.getInstance());
                break;
            case ("Warlock"):
                CollectionState.getInstance().getDeckToChange().setHero(Warlock.getInstance());
                break;
            case ("Hunter"):
                CollectionState.getInstance().getDeckToChange().setHero(Hunter.getInstance());
                break;
            case ("Priest"):
                CollectionState.getInstance().getDeckToChange().setHero(Priest.getInstance());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + heroName);
        }
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Changed hero to " + heroName);

    }

    public static void removeDeck() {
        ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer().remove(CollectionState.getInstance().getDeckToChange());
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Removed " + CollectionState.getInstance().getDeckToChange().getName());
    }

    public static void showCardsOnCardPanelWithSpecifiedClass(String className, JPanel panel, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> filteredCardsByClassOfCard = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getClassOfCard().equalsIgnoreCase(className)) {
                filteredCardsByClassOfCard.add(card);
            }
        }
        MethodsOfShowCardsOnPanel.showCards(filteredCardsByClassOfCard, panel, numberOfCardsPerRow);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show " + className + " cards");
    }

    public static void showCardsWithSpecifiedManaCost(int mana, JPanel cardPanelOfCollectionPage,
                                                      JPanel cardPanelOfDeckPage, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> filteredByManaCards = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getManaCost() == mana) {
                filteredByManaCards.add(card);
            }
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.COLLECTIONS_PAGE)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfCollectionPage, numberOfCardsPerRow);
        } else if (ControllerOfMainComponents.getStatus().equals(Status.MAKE_DECK) || ControllerOfMainComponents.getStatus().equals(Status.CHANGE_DECK)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfDeckPage, numberOfCardsPerRow);
        }
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show cards with mana: " + mana);
    }

    public static void showSearchedCards(String searchFieldText, JPanel cardPanelOfCollectionPage,
                                         JPanel cardPanelOfDeckPage, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> foundCards = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().toLowerCase().contains(searchFieldText)) {
                foundCards.add(card);
            }
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.COLLECTIONS_PAGE)) {
            MethodsOfShowCardsOnPanel.showCards(foundCards, cardPanelOfCollectionPage, numberOfCardsPerRow);
        } else if (ControllerOfMainComponents.getStatus().equals(Status.CHANGE_DECK) || ControllerOfMainComponents.getStatus().equals(Status.MAKE_DECK)) {
            MethodsOfShowCardsOnPanel.showCards(foundCards, cardPanelOfDeckPage, numberOfCardsPerRow);
        }
    }

    public static void initializeAllLittleCardPanels() {
        for (Cards card : Cards.getAllCards()) {
            LittleCardPanel.getAllLittleCardPanels().add(new LittleCardPanel(card.getManaCost(), card.getName(), 0));
        }
    }

    public static void removeThisCardFromCollectionStatesDeck(LittleCardPanel littleCardPanel) {
        Iterator<Cards> itr = CollectionState.getInstance().getDeckToChange().getListOfCards().iterator();
        while (itr.hasNext()) {
            Cards card = itr.next();
            if (card.getName().equalsIgnoreCase(littleCardPanel.getNameLabel().getText())) {
                if (Integer.parseInt(littleCardPanel.getUsedLabel().getText()) == 1) {
                    itr.remove();
//                    DeckViewer.getInstance().showCardsInDecK();//TODO MAYBE ITS WRONG
                    break;
                } else if (Integer.parseInt(littleCardPanel.getUsedLabel().getText()) == 2) {
                    littleCardPanel.getUsedLabel().setText(1 + "");
                    break;
                }
//                DeckViewer.getInstance().showCardsInDecK();
//                    DeckPage.getInstance().getDeckTOChange().defineUsesHashMap();
//                    DeckPage.getInstance().getDeckTOChange().setLittleCardsListFromHashMap();
            }
        }

    }


    //shopState


    public static void setBuyableCard() {
        ControllerOfMainComponents.currentPlayer.setBuyableCards();
        System.out.println(ControllerOfMainComponents.currentPlayer.getBuyableCards());
    }

    public static int getMoneyOfShopStatesCard() {
        return ShopState.getInstance().getCardsToBuyOrSell().getMoneyCost();
    }

    public static boolean isShopStateCardNull() {
        return ShopState.getInstance().getCardsToBuyOrSell() == null;
    }

    public static void makeShopStateCardNull() {
        ShopState.getInstance().setCardsToBuyOrSell(null);
    }

    public static void buyShopStateCard() throws IOException {
        ControllerOfMainComponents.currentPlayer.buy(ShopState.getInstance().getCardsToBuyOrSell());
    }

    public static void showSalableCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(ControllerOfMainComponents.currentPlayer.getSalableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showBuyableCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(ControllerOfMainComponents.currentPlayer.getBuyableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showShopStateCardInBuySellPanel(JPanel panel) throws IOException {//todo check.....
        CardImagePanel cardImagePanel = new CardImagePanel(ShopState.getInstance().getCardsToBuyOrSell().getName());
        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel, 0, 0, panel.getWidth(), panel.getHeight());
    }

    public static void sellShopStateCard() throws IOException {
        ControllerOfMainComponents.currentPlayer.sell(ShopState.getInstance().getCardsToBuyOrSell());
    }

    public static boolean isShopStateCardInMyDecks() {
        for (Deck deck : ControllerOfMainComponents.currentPlayer.getAllDecksOfPlayer()) {
            if (deck.getListOfCards().contains(ShopState.getInstance().getCardsToBuyOrSell())) {
                return true;
            }
        }
        return false;
    }

    public static void defineShopStateCard(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                ShopState.getInstance().setCardsToBuyOrSell(cards);
            }
        }
    }


    //cardController
    public static String getTypeOfGivenCard(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                return cards.getType();
            }
        }
        return null;
    }

    public static boolean isThisCardLock(String cardName) throws IOException {
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().equals(cardName)) {
                return !ControllerOfMainComponents.currentPlayer.getAllCardsOfPlayer().contains(card);
            }
        }
        return true;
    }

    public static void addGivenCardToCollectionDeck(String cardName, boolean isLock) throws IOException {//todo maybe needs to changeee
        Cards cards = null;
        for (Cards cards1 : Cards.getAllCards()) {
            if (cards1.getName().equals(cardName)) {
                cards = cards1.copy();

            }
        }


        for (int i = 0; i < DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().size(); i++) {
            if (cards.getName().equalsIgnoreCase(DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getNameLabel().getText())) {
                if (Integer.parseInt(DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getUsedLabel().getText()) < 2) {
                    if (!isLock) {
                        CollectionState.getInstance().getDeckToChange().getListOfCards().add(cards);
                    }
                    DeckViewer.getInstance().showCardsInDecK();
                    int k = Integer.parseInt(DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getUsedLabel().getText()) + 1;
                    DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getUsedLabel().setText(k + "");
                    break;
                } else if (!isLock) {
                    JOptionPane.showMessageDialog(null,
                            "You have two card of this card in your Deck!", "Add To Deck Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    public static void writeLog(String log) {
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info(log);
    }


}
