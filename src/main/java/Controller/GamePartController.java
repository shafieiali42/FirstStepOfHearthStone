package Controller;

import Logic.PlayLogic.Alliance;
import Logic.PlayLogic.Game;
import Logic.Status;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import Models.HeroPower.HeroPower;
import Models.Heroes.Heroes;
import Utility.MethodsOfShowCardsOnPanel;
import View.CardView.CardImagePanel;
import View.Gui.Mapper;
import View.Gui.Panels.GamePage.DiscoverCardsPage;
import View.Gui.Panels.GamePage.FirstThreeCardsPage;
import View.Gui.Panels.GamePage.PlayPanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import Visitors.CardVisitors.GetDamageVisitor;
import Visitors.PassiveVisitor.InfoPassiveVisitor;
import Visitors.PowerVisitor.HeroPowerVisitor.HeroPowerVisitor;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GamePartController {


    public static boolean showThreeCardsForChange() {
        System.out.println(Game.getInstance().getGameMode());
        return Game.getInstance().getGameMode() != 3;
    }

    public static String getFriendlyImprovementOfQuest() {
        if (Game.getInstance().getFriendlyPlayer().getQuestCard() != null) {
            return Game.getInstance().getFriendlyPlayer().getQuestCard().getManaSpendForQuest() +
                    "/" + Game.getInstance().getFriendlyPlayer().getQuestCard().getManaNeededForQuest();
        } else {
            return "NoActiveQuest";
        }
    }

    public static String getEnemyImprovementOfQuest() {
        if (Game.getInstance().getFriendlyPlayer().getQuestCard() != null) {
            return Game.getInstance().getEnemyPlayer().getQuestCard().getManaSpendForQuest() +
                    "/" + Game.getInstance().getEnemyPlayer().getQuestCard().getManaSpendForQuest();
        } else {
            return "NoActiveQuest";
        }
    }


    public static void setNeedTimer(boolean show) {
        PlayPanel.getInstance().setNeedTimer(show);
    }


    public static void attack(int attacker, int target, Alliance attackerAlliance, Alliance targetAlliance) {


        if (attacker == -5) {
            return;
        } else if (target == -5) {
            return;
        }


        if (attacker == -2) {//Weapon

            if (attackerAlliance.equals(targetAlliance)) {
                return;
            }

            if (target == -3) { //weapon vs hero
                Heroes hero = Game.getInstance().getFormerPlayer().getHero();
                Weapon weapon = Game.getInstance().getCurrentPlayer().getCurrentWeapon();
                if (!weapon.isHasAttackInThisTurn() && hero.getCanBeAttacked()) {
                    hero.setHealthPower(hero.getHealthPower() - weapon.getAttackPower());
                    weapon.setDurability(weapon.getDurability() - 1);
                    weapon.setHasAttackInThisTurn(true);
                    removeDeadCharacters();
                }
            } else {// weapon vs minion
                Weapon weapon = Game.getInstance().getCurrentPlayer().getCurrentWeapon();
                Minion minion = Game.getInstance().getFormerPlayer().getBattleGroundCards().get(target);
                if (!weapon.isHasAttackInThisTurn() && minion.getCanBeAttacked()) {
                    minion.setHealthPower(minion.getHealthPower() - weapon.getAttackPower());
                    Game.getInstance().getCurrentPlayer().getHero().setHealthPower
                            (Game.getInstance().getCurrentPlayer().getHero().getHealthPower() - minion.getAttackPower());

                    weapon.setDurability(weapon.getDurability() - 1);
                    weapon.setHasAttackInThisTurn(true);
                    minion.accept(new GetDamageVisitor(), Game.getInstance().getFormerPlayer().getBattleGroundCards(),
                            null, null, minion, null, null, null, null);

                    removeDeadCharacters();
                }
            }
        } else {

            if (target == -3) {//target is hero    minion vs hero
                Minion minion = Game.getInstance().getCurrentPlayer().getBattleGroundCards().get(attacker);
                Heroes hero = Game.getInstance().getFormerPlayer().getHero();
                if (minion.getIsActive() && !minion.getHasAttackInThisTurn() && hero.getCanBeAttacked()) {
                    hero.setHealthPower(hero.getHealthPower() - minion.getAttackPower());
                    minion.setHasAttackInThisTurn(true);
                    removeDeadCharacters();
                }
            } else {//minion vs minion

//                System.out.println(attackerAlliance);
//                System.out.println(targetAlliance);
                if (attackerAlliance.equals(targetAlliance)) {
                    return;
                }

                Minion minion = Game.getInstance().getCurrentPlayer().getBattleGroundCards().get(attacker);
                Minion minion2 = Game.getInstance().getFormerPlayer().getBattleGroundCards().get(target);

                if (minion.getIsActive() && !minion.getHasAttackInThisTurn()) {
                    if (minion2.getCanBeAttacked()) {
//                        System.out.println("Before attack:");
//                        System.out.println(minion.getName() + " Attack: " + minion.getAttackPower() + " Hp: " + minion.getHealthPower());
//                        System.out.println(minion2.getName() + " Attack: " + minion2.getAttackPower() + " Hp: " + minion2.getHealthPower());
                        minion.setHealthPower(minion.getHealthPower() - minion2.getAttackPower());
                        minion2.setHealthPower(minion2.getHealthPower() - minion.getAttackPower());
                        minion.setHasAttackInThisTurn(true);
                        removeDeadCharacters();
//                        System.out.println("After attack:");
//                        System.out.println(minion.getName() + " Attack: " + minion.getAttackPower() + " Hp: " + minion.getHealthPower());
//                        System.out.println(minion2.getName() + " Attack: " + minion2.getAttackPower() + " Hp: " + minion2.getHealthPower());

                        minion2.accept(new GetDamageVisitor(), Game.getInstance().getFormerPlayer().getBattleGroundCards(),
                                null, null, minion, null, null, null, null);

                    } else {
                        //TODO you first need to destroy Taunt OR you cant attack to this minion
                    }
                } else {
                    //TODO you cant attack with this minion in this turn``````````````````````````````````````````````````````````````````````````````````````
                }
            }


        }

    }


    public static void removeDeadCharacters() {

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
            Game.getInstance().getFriendlyPlayer().getDeck().
                    setNumberOfUses( Game.getInstance().getFriendlyPlayer().getDeck().getNumberOfUses()+1);

            Game.getInstance().getEnemyPlayer().getDeck().
                    setNumberOfUses( Game.getInstance().getEnemyPlayer().getDeck().getNumberOfUses()+1);

            Game.getInstance().getFriendlyPlayer().getDeck().
                    setNumberOfWins( Game.getInstance().getFriendlyPlayer().getDeck().getNumberOfWins()+1);


            JOptionPane.showMessageDialog(MyMainFrame.getInstance(),
                    "Friendly Player wins!","End Match",JOptionPane.INFORMATION_MESSAGE);
        } else if (Game.getInstance().getEnemyPlayer().getHero().getHealthPower() <= 0) {

            Game.getInstance().getFriendlyPlayer().getDeck().
                    setNumberOfUses( Game.getInstance().getFriendlyPlayer().getDeck().getNumberOfUses()+1);

            Game.getInstance().getEnemyPlayer().getDeck().
                    setNumberOfUses( Game.getInstance().getEnemyPlayer().getDeck().getNumberOfUses()+1);

            Game.getInstance().getEnemyPlayer().getDeck().
                    setNumberOfWins( Game.getInstance().getEnemyPlayer().getDeck().getNumberOfWins()+1);




            JOptionPane.showMessageDialog(MyMainFrame.getInstance(),
                    "Enemy Player wins!","End Match",JOptionPane.INFORMATION_MESSAGE);
        }
        Game.getInstance().getFriendlyPlayer().getBattleGroundCards().removeIf(minion -> minion.getHealthPower() <= 0);
        Game.getInstance().getEnemyPlayer().getBattleGroundCards().removeIf(minion -> minion.getHealthPower() <= 0);
        Mapper.setCanBeAttacked(Game.getInstance().getFriendlyPlayer());
        Mapper.setCanBeAttacked(Game.getInstance().getEnemyPlayer());

    }

    public static Heroes getTargetOfSpellWitchIsHero() {//it actually doesnt use
        if (Game.getInstance().getAllianceOfSpellsTarget().equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getHero();
        } else if (Game.getInstance().getAllianceOfSpellsTarget().equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getHero();
        }

        return null;

    }


    public static JFrame getMyMainFrame() {
        return MyMainFrame.getInstance();
    }


    public static Heroes getTargetOfHeroPowerWitchIsHero() {
        if (Game.getInstance().getTargetOfHeroPower() == -2) {
            if (Game.getInstance().getTargetAllianceOfHeroPower().equals(Alliance.FRIENDLY)) {
                return Game.getInstance().getFriendlyPlayer().getHero();
            } else if (Game.getInstance().getTargetAllianceOfHeroPower().equals(Alliance.ENEMY)) {
                return Game.getInstance().getEnemyPlayer().getHero();
            }
        }

        return null;

    }


    public static Minion getTargetOfHeroPower() {

        if (Game.getInstance().getTargetAllianceOfHeroPower() == null) {
            return null;
        } else if (Game.getInstance().getTargetOfHeroPower() <= 0) {
            return null;
        }

        if (Game.getInstance().getTargetAllianceOfHeroPower().equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfHeroPower() - 1);
        } else if (Game.getInstance().getTargetAllianceOfHeroPower().equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfHeroPower() - 1);
        }
        return null;

    }

    public static Minion getTargetOfSpell() {

        if (Game.getInstance().getAllianceOfSpellsTarget() == null) {
            return null;
        } else if (Game.getInstance().getTargetOfSpell() <= 0) {
            return null;
        }
        if (Game.getInstance().getAllianceOfSpellsTarget().equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfSpell() - 1);
        } else if (Game.getInstance().getAllianceOfSpellsTarget().equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(Game.getInstance().getTargetOfSpell() - 1);
        }
        return null;
    }

    public static void setTargetOfSpell(int number, Alliance alliance) {
        Game.getInstance().setTargetOfSpell(number);
        Game.getInstance().setAllianceOfSpellsTarget(alliance);
    }

    public static void setTargetForHeroPower(int number, Alliance alliance) {
        Game.getInstance().setTargetOfHeroPower(number);
        Game.getInstance().setTargetAllianceOfHeroPower(alliance);
    }

    public static void setAttacker(int attacker) {
        Game.getInstance().setAttacker(attacker);
    }

    public static void setTarget(int target) {
        Game.getInstance().setTarget(target);
    }

    public static void setAllianceOfTarget(Alliance alliance) {
        Game.getInstance().setTargetAlliance(alliance);
    }

    public static void setAllianceAttacker(Alliance alliance) {
        Game.getInstance().setAttackerAlliance(alliance);
    }

    public static Alliance getAllianceOfTarget() {
        return Game.getInstance().getTargetAlliance();
    }

    public static Alliance getAllianceOfAttacker() {
        return Game.getInstance().getAttackerAlliance();
    }

    public static int getAttacker() {
        return Game.getInstance().getAttacker();
    }

    public static int getTarget() {
        return Game.getInstance().getTarget();
    }


    public static Cards getPlyingCardOfGameState() {
        return Game.getInstance().getPlayingCard();
    }

    public static HeroPower getHeroPower() {
        return Game.getInstance().getCurrentPlayer().getHero().getHeroPower();
    }

    public static void refreshPlayPanel() {
        PlayPanel.getInstance().setNeedsToRepaint(true);
        PlayPanel.getInstance().repaint();
        PlayPanel.getInstance().revalidate();
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

    public static void reStartDiscoverPageSetting() {
        DiscoverCardsPage.getInstance().reStartSetting();
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

    public static void reStartFirstThreeCardsSetting() {
        FirstThreeCardsPage.getInstance().reStartSetting();
    }

    public static void ChangeThisCardFromHands(String cardName) {
        System.out.println("First Three Cards: " + Game.getInstance().getFriendlyPlayer().getFirstThreeCards());
        System.out.println("Hand: " + Game.getInstance().getFriendlyPlayer().getHandsCards());
        System.out.println("Deck: " + Game.getInstance().getFriendlyPlayer().getDeckCards());
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

    public static void showEnemyHeroPower(JPanel panel, int widthOfHeroPowerImage, int heightOfHeroPowerImage, int xCoordinateOfHeroPower, int yCoordinateOfHeroPower) {


        CardImagePanel cardImagePanel = null;
        try {
            cardImagePanel = new CardImagePanel(Game.getInstance().getEnemyPlayer().getHero().getName() + "HeroPower",
                    widthOfHeroPowerImage, heightOfHeroPowerImage, "heroPower", Alliance.FRIENDLY);
        } catch (IOException e) {//todo .................
            e.printStackTrace();
        }

        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                xCoordinateOfHeroPower, yCoordinateOfHeroPower, widthOfHeroPowerImage, heightOfHeroPowerImage);
    }

    public static void showFriendlyHeroPower(JPanel panel, int widthOfHeroPowerImage, int heightOfHeroPowerImage, int xCoordinateOfHeroPower, int yCoordinateOfHeroPower) {


        CardImagePanel cardImagePanel = null;
        try {
            cardImagePanel = new CardImagePanel(Game.getInstance().getFriendlyPlayer().getHero().getName() + "HeroPower",
                    widthOfHeroPowerImage, heightOfHeroPowerImage, "heroPower", Alliance.FRIENDLY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                xCoordinateOfHeroPower, yCoordinateOfHeroPower, widthOfHeroPowerImage, heightOfHeroPowerImage);
    }

    public static void showFriendlyWeaponOfGameState(JPanel panel, int widthOfWeaponImage, int heightOfWeaponImage, int xCoordinateOfWeapon, int yCoordinateOfWeapon) {
        if (Game.getInstance().getFriendlyPlayer().getCurrentWeapon() != null) {
            try {
                CardImagePanel cardImagePanel = new CardImagePanel(Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getName(),
                        widthOfWeaponImage, heightOfWeaponImage, "weapon", Alliance.FRIENDLY);

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
                        widthOfWeaponImage, heightOfWeaponImage, "weapon", Alliance.ENEMY);

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
            MethodsOfShowCardsOnPanel.showHandsCards(Game.getInstance().getEnemyPlayer().getHandsCards(),
                    panel, numberOfCardsPerRowHandsCards, Alliance.ENEMY);
        }
    }

    public static void showFriendlyHandsCardInPlay(JPanel panel, int numberOfCardsPerRowHandsCards) throws IOException {
        MethodsOfShowCardsOnPanel.showHandsCards(Game.getInstance().getFriendlyPlayer().getHandsCards(),
                panel, numberOfCardsPerRowHandsCards, Alliance.FRIENDLY);
    }

    public static void showFriendlyBattleGroundCardsInPlay(JPanel panel, int numberOfCardsPerRowGamePanel) throws IOException {
        MethodsOfShowCardsOnPanel.showBattleGroundCards(Game.getInstance().getFriendlyPlayer().getBattleGroundCards(), panel, numberOfCardsPerRowGamePanel, Alliance.FRIENDLY);
    }

    public static void showEnemyBattleGroundCardsInPlay(JPanel panel, int numberOfCardsPerRowGamePanel) throws IOException {
        MethodsOfShowCardsOnPanel.showBattleGroundCards(Game.getInstance().getEnemyPlayer().getBattleGroundCards(),
                panel, numberOfCardsPerRowGamePanel, Alliance.ENEMY);
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
        Game.getInstance().getFriendlyPlayer().getInfoPassive().accept(new InfoPassiveVisitor(), Game.getInstance().getFriendlyPlayer(),
                Game.getInstance().getFriendlyPlayer().getBattleGroundCards(),
                Game.getInstance().getFriendlyPlayer().getHandsCards(),
                Game.getInstance().getFriendlyPlayer().getDeckCards());

        //todo for test
        Game.getInstance().getEnemyPlayer().setInfoPassive(Game.getInstance().getFriendlyPlayer().getInfoPassive());
        Game.getInstance().getEnemyPlayer().getInfoPassive().accept(new InfoPassiveVisitor(), Game.getInstance().getEnemyPlayer(),
                Game.getInstance().getEnemyPlayer().getBattleGroundCards(),
                Game.getInstance().getEnemyPlayer().getHandsCards(),
                Game.getInstance().getEnemyPlayer().getDeckCards());
    }

    public static void setEnemyInfoPassiveOfGameState(int numberOfPassive) {
        Game.getInstance().getEnemyPlayer().setInfoPassive(Game.getInstance().getEnemyPlayer().getPassivesToChoose().get(numberOfPassive));
        Game.getInstance().getEnemyPlayer().getInfoPassive().accept(new InfoPassiveVisitor(), Game.getInstance().getEnemyPlayer(),
                Game.getInstance().getEnemyPlayer().getBattleGroundCards(),
                Game.getInstance().getEnemyPlayer().getHandsCards(),
                Game.getInstance().getEnemyPlayer().getDeckCards());
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

    public static boolean canAddMinionToBattleGround() {
        return Game.getInstance().getCurrentPlayer().getBattleGroundCards().size() <= 7 - 1;
    }

    public static boolean canAddEnemyMinionToBattleGround() {
        return Game.getInstance().getFormerPlayer().getBattleGroundCards().size() <= 7 - 1;
    }

    public static void setPlayingCardOfGameState(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                Game.getInstance().setPlayingCard(cards.copy());
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


    public static int giveHeroHp(Alliance alliance) {
        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getHero().getHealthPower();
        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getHero().getHealthPower();
        }
        return -888888;
    }

    public static int giveHeroAttackPower(Alliance alliance) {
        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getHero().getAttackPower();
        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getHero().getAttackPower();
        }
        return -888888;
    }

    public static int giveWeaponDurability(Alliance alliance) {

        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getDurability();

        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getCurrentWeapon().getDurability();
        }
        return -555555;
    }

    public static int giveWeaponAttackPower(Alliance alliance) {
        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getAttackPower();

        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getCurrentWeapon().getAttackPower();
        }
        return -555555;
    }

    public static int giveMinionHpWithName(int numberOfCardInBattleGround, Alliance alliance) {
        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getHealthPower();

        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getHealthPower();
        }
        return -55555555;
    }

    public static int giveMinionAttackWithName(int numberOfCardInBattleGround, Alliance alliance) {

        if (alliance.equals(Alliance.FRIENDLY)) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getAttackPower();

        } else if (alliance.equals(Alliance.ENEMY)) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getAttackPower();
        }
        return -66666666;
    }

}
