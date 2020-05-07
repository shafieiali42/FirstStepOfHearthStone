package Controller;

import CommandLineInterface.CLI;
import CommandLineInterface.PlayerManagement;
import CommandLineInterface.Status;

import Gui.Panels.CollectionPages.DeckPage;
import Gui.Panels.CollectionPages.DeckViewer;
import Gui.Panels.CollectionPages.LittleCardPanel;
import Gui.Panels.LogInPanel.LogInPage;
import Gui.Panels.MenuPanel.MainMenuPage;


import Logic.*;
import Models.Cards.Cards;
import Models.Deck.Deck;
import Models.Heroes.*;


import Utility.LengthOfMessage;
import Utility.MethodsOfShowCardsOnPanel;
import Utility.Sounds;
import View.CardView.CardImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Administer {

    private static Administer administer = new Administer();

    public static Administer getInstance() {
        return administer;
    }


    public static int getHealthOfCurrentHeroInGameState() {
        return GameState.getInstance().getPlayer().getCurrentHero().getHealthPower();
    }

    public static void showWeaponOfGameState(JPanel panel, int widthOfWeaponImage, int heightOfWeaponImage, int xCoordinateOfWeapon, int yCoordinateOfWeapon) {
        if (GameState.getInstance().getCurrentWeapon() != null) {
            try {
                CardImagePanel cardImagePanel = new CardImagePanel(GameState.getInstance().getCurrentWeapon().getName(),
                        widthOfWeaponImage, heightOfWeaponImage);

                MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                        xCoordinateOfWeapon, yCoordinateOfWeapon, widthOfWeaponImage, heightOfWeaponImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showHandsCardOfMeAllianceInPlay(JPanel panel, int numberOfCardsPerRowHandsCards) throws IOException {
        MethodsOfShowCardsOnPanel.showHandsCards(GameState.getInstance().getHandsCards(), panel, numberOfCardsPerRowHandsCards, Alliance.ME);
    }

    public static void showBattleGroundCardsOfMeAllianceInPlay(JPanel panel, int numberOfCardsPerRowGamePanel) throws IOException {
        MethodsOfShowCardsOnPanel.showBattleGroundCards(GameState.getInstance().getBattleGroundCards(), panel, numberOfCardsPerRowGamePanel, Alliance.ME);
    }


    public static String getNameOfCurrentHeroOfGameState() {
        return GameState.getInstance().getPlayer().getCurrentHero().getName();
    }


    public static String getNameOfPassive(int numberOfPassive) {
        return GameState.getInstance().getPassivesToChoose().get(numberOfPassive).getName();
    }


    public static void setInfoPassiveOfGameState(int numberOfPassive) {
        GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(numberOfPassive));
    }


    public static int getManaOfGameState() {
        return GameState.getInstance().getMana();
    }

    public static int getNumberOfCardsOfDeckInGameState() {
        return GameState.getInstance().getCardsOfDeckInGameState().size();
    }


    public static void initializeGameState() throws IOException {
        GameState.getInstance().initGameState();
    }


    public static void setDeckToShowOFStatusState(int deckNumber) {
        StatusState.getInstance().setDeckToShow(CLI.currentPlayer.getAllDecksOfPlayer().get(deckNumber - 1));
    }


    public static void showDeckOfStatusState(JPanel panel, Graphics2D graphics2D) {
        String name = "Name: " + StatusState.getInstance().getDeckTosHOW().getName();
        int lengthOfName = LengthOfMessage.lengthOfMessage(name, graphics2D);
        String heroName = "Hero: " + StatusState.getInstance().getDeckTosHOW().getHero().getName();
        int lengthOfHeroName = LengthOfMessage.lengthOfMessage(heroName, graphics2D);
        String wins = "Wins:" + StatusState.getInstance().getDeckTosHOW().getNumberOfWins();
        int lengthOfWins = LengthOfMessage.lengthOfMessage(wins, graphics2D);
        String use = "Uses: " + StatusState.getInstance().getDeckTosHOW().getNumberOfUses();
        int lengthOfUse = LengthOfMessage.lengthOfMessage(use, graphics2D);
        String mostUsedCard = "Most Used Card: " + StatusState.getInstance().getDeckTosHOW().getMostUsedCard().getName();
        int lengthOfCard = LengthOfMessage.lengthOfMessage(mostUsedCard, graphics2D);
        String manaAvg = "Average of Mana: " + StatusState.getInstance().getDeckTosHOW().getManaAvg();
        int lengthOfMana = LengthOfMessage.lengthOfMessage(manaAvg, graphics2D);
        if (StatusState.getInstance().getDeckTosHOW().getNumberOfUses() == 0) {
            StatusState.getInstance().getDeckTosHOW().setNumberOfUses(1);
        }
        String winsPerPlay = "Wins per Play: " +
                (StatusState.getInstance().getDeckTosHOW().getNumberOfWins() / StatusState.getInstance().getDeckTosHOW().getNumberOfUses()) * 100 + " %";
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
        for (Deck deck : CLI.currentPlayer.getAllDecksOfPlayer()) {
            if (deck.getName().equals(deckName)) {
                deck.defineMostUsedCard();
            }
        }
    }

    public static void changeStatusOfSound(int numberOfPushMuteBtn) {
        Sounds.changeStatus(numberOfPushMuteBtn);
    }

    public static void increaseSound() {
        Sounds.increaseSound();
    }

    public static void decreaseSound() {
        Sounds.decreaseSound();
    }

    public static void showJOptionPaneWrongPassWordErrorForDeletePlayer() {
        JOptionPane.showMessageDialog(MainMenuPage.getInstance(), "Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showJOptionPaneOfLogInError() {
        JOptionPane.showMessageDialog(LogInPage.getInstance(),
                "Please Enter a Valid UserName or Password!", "LogIn Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void signUpErrorJOptionPane() {
        JOptionPane.showMessageDialog(LogInPage.getInstance(),
                "There is an account with this username!", "SignUp Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void deletePlayer(String passWord) throws IOException {
        PlayerManagement.DeletePlayer(passWord);
    }

    public static void logOut() throws IOException {
        PlayerManagement.logOut();
    }

    public static void signUp(String userName, String passWord) throws IOException {
        PlayerManagement.signUp(userName, passWord);
    }

    public static void signIn(String userName, String passWord) throws IOException {
        PlayerManagement.signIn(userName, passWord);
    }

    public static void addGivenCardToCollectionDeck(String cardName, boolean isLock) throws IOException {//todo maybe needs to changeee
        Cards cards = null;
        for (Cards cards1 : Cards.getAllCards()) {
            if (cards1.getName().equals(cardName)) {
                cards = cards1;
            }
        }


        for (int i = 0; i < DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().size(); i++) {
            if (cards.getName().equalsIgnoreCase(DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getNameLabel().getText())) {
                if (Integer.parseInt(DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getUsedLabel().getText()) < 2) {
                    System.out.println(cards.getName() + " kjjjjjjjjj");
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


    public static boolean canAddMinionToBattleGround() {
        return GameState.getInstance().getBattleGroundCards().size() <= 7 - 1;
    }

    public static String getTypeOfGivenCard(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                return cards.getType();
            }
        }
        return null;
    }


    public static void setPlayingCardOfGameState(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                GameState.getInstance().setPlayingCard(cards);
            }
        }
    }

    public static void defineShopStateCard(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                ShopState.getInstance().setCardsToBuyOrSell(cards);
            }
        }
    }


    public static boolean isThisCardLock(String cardName) throws IOException {
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().equals(cardName)) {
                return !CLI.currentPlayer.getAllCardsOfPlayer().contains(card);
            }
        }
        return true;
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

    public static void showShopStateCardInBuySellPanel(JPanel panel) throws IOException {//todo check.....
        CardImagePanel cardImagePanel = new CardImagePanel(ShopState.getInstance().getCardsToBuyOrSell().getName());
        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel, 0, 0, panel.getWidth(), panel.getHeight());
    }

    public static void sellShopStateCard() throws IOException {
        CLI.currentPlayer.sell(ShopState.getInstance().getCardsToBuyOrSell());
    }

    public static boolean isShopStateCardInMyDecks() {
        for (Deck deck : CLI.currentPlayer.getAllDecksOfPlayer()) {
            if (deck.getListOfCards().contains(ShopState.getInstance().getCardsToBuyOrSell())) {
                return true;
            }
        }
        return false;
    }

    public static void playMainSound() {
        Sounds.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
    }

    public static void playActionSounds(String action) {
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/" + action + ".wav");
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
        CLI.currentPlayer.buy(ShopState.getInstance().getCardsToBuyOrSell());
    }

    public static void showSalableCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getSalableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showBuyableCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getBuyableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showCardsWithSpecifiedManaCost(int mana, JPanel cardPanelOfCollectionPage,
                                                      JPanel cardPanelOfDeckPage, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> filteredByManaCards = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getManaCost() == mana) {
                filteredByManaCards.add(card);
            }
        }
        if (CLI.getStatus().equals(Status.COLLECTIONS_PAGE)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfCollectionPage, numberOfCardsPerRow);
        } else if (CLI.getStatus().equals(Status.MAKE_DECK) || CLI.getStatus().equals(Status.CHANGE_DECK)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfDeckPage, numberOfCardsPerRow);
        }
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show cards with mana: " + mana);
    }

    public static void showSearchedCards(String searchFieldText, JPanel cardPanelOfCollectionPage,
                                         JPanel cardPanelOfDeckPage, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> foundCards = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().toLowerCase().contains(searchFieldText)) {
                foundCards.add(card);
            }
        }
        if (CLI.getStatus().equals(Status.COLLECTIONS_PAGE)) {
            MethodsOfShowCardsOnPanel.showCards(foundCards, cardPanelOfCollectionPage, numberOfCardsPerRow);
        } else if (CLI.getStatus().equals(Status.CHANGE_DECK) || CLI.getStatus().equals(Status.MAKE_DECK)) {
            MethodsOfShowCardsOnPanel.showCards(foundCards, cardPanelOfDeckPage, numberOfCardsPerRow);
        }
    }

    public static boolean isCurrentPlayersCurrentDeckNull() {
        return CLI.currentPlayer.getCurrentDeck().getHero() == null;
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
        CLI.currentPlayer.setCurrentDeck(CollectionState.getInstance().getDeckToChange());
        CLI.currentPlayer.getLoggerOfMyPlayer().info("select " + CollectionState.getInstance().getDeckToChange().getName() + " for main deck");
    }

    public static void changeNameOfDeck(String name) {
        CollectionState.getInstance().getDeckToChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Change name of deck ");
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
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Changed hero to " + heroName);

    }

    public static void removeDeck() {
        CLI.currentPlayer.getAllDecksOfPlayer().remove(CollectionState.getInstance().getDeckToChange());
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Removed " + CollectionState.getInstance().getDeckToChange().getName());
    }

    public static void showCardsOnCardPanelWithSpecifiedClass(String className, JPanel panel, int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> filteredCardsByClassOfCard = new ArrayList<Cards>();
        System.out.println(className);
        for (Cards card : Cards.getAllCards()) {
            if (card.getClassOfCard().equalsIgnoreCase(className)) {
                filteredCardsByClassOfCard.add(card);
            }
        }
        MethodsOfShowCardsOnPanel.showCards(filteredCardsByClassOfCard, panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show " + className + " cards");
    }

    public static Deck getDeckThatIsInPlayersDeck(String deckName) {
        if (CLI.currentPlayer.getAllDecksOfPlayer() != null) {
            for (Deck deck : CLI.currentPlayer.getAllDecksOfPlayer()) {
                if (deck.getName().equals(deckName)) {
                    return deck;
                }
            }
        }
        return null;
    }

    public static ArrayList<String> getListOfPlayersDeckNames() {
        ArrayList<String> listOfPlayersDeckNames = new ArrayList<String>();
        for (Deck deck : CLI.currentPlayer.getAllDecksOfPlayer()) {
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

    public static void showAllCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(Cards.getAllCards(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show all cards ");
    }

    public static void showLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        CLI.currentPlayer.setLockCardsList();
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getLockCards(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show lock cards ");
    }

    public static void showUnLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        CLI.currentPlayer.setAllCardsOfPlayer();
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getAllCardsOfPlayer(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show unlock cards ");

    }

    public static void defineUsesHashMap() {
        CollectionState.getInstance().getDeckToChange().defineUsesHashMapFromArrayList();

    }

    public static void makeCollectionStatesDeckToNull() {
        CollectionState.getInstance().setDeckToChange(new Deck());

    }

    public static void addCollectionStatesDeckToPlayersDecksList() {
        CLI.currentPlayer.getAllDecksOfPlayer().add(CollectionState.getInstance().getDeckToChange());
    }

    public static void writeLog(String log) {
        CLI.currentPlayer.getLoggerOfMyPlayer().info(log);
    }

    public static void sortDecksOfCurrentPlayer() {
        Collections.sort(CLI.currentPlayer.getAllDecksOfPlayer());
    }
}
