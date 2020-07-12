package Controller;

import Logic.NonePlayLogics.CollectionState;
import Logic.NonePlayLogics.ShopState;
import Logic.NonePlayLogics.StatusState;
import Logic.PlayLogic.Alliance;
import Logic.PlayLogic.Game;
import Logic.Status;

import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import Models.HeroPower.HeroPower;
import View.Gui.Panels.CollectionPages.DeckPage;
import View.Gui.Panels.CollectionPages.DeckViewer;
import View.Gui.Panels.CollectionPages.LittleCardPanel;
import View.Gui.Panels.GamePage.DiscoverCardsPage;
import View.Gui.Panels.GamePage.FirstThreeCardsPage;
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
import Visitors.CardVisitors.GetDamageVisitor;
import Visitors.PassiveVisitor.InfoPassiveVisitor;
import Visitors.PowerVisitor.HeroPowerVisitor.HeroPowerVisitor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class Administer {

    private static final Administer administer = new Administer();
    public static Administer getInstance() {
        return administer;
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
        StatusState.getInstance().getDeckToShow().defineManaAvg();
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




    //collectionState
    public static void defineUsesHashMap() {
        CollectionState.getInstance().getDeckToChange().initUsesHashMapFromArrayList();

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
                Mage mage = new Mage();
                ControllerOfMainComponents.currentPlayer.setMage(mage);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(mage);
                CollectionState.getInstance().getDeckToChange().setHero(mage);
                break;
            case ("Rogue"):
                Rogue rogue = new Rogue();
                ControllerOfMainComponents.currentPlayer.setRogue(rogue);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(rogue);
                CollectionState.getInstance().getDeckToChange().setHero(rogue);
                break;
            case ("Warlock"):
                Warlock warlock = new Warlock();
                ControllerOfMainComponents.currentPlayer.setWarlock(warlock);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(warlock);
                CollectionState.getInstance().getDeckToChange().setHero(warlock);
                break;
            case ("Hunter"):
                Hunter hunter = new Hunter();
                ControllerOfMainComponents.currentPlayer.setHunter(hunter);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(hunter);
                CollectionState.getInstance().getDeckToChange().setHero(hunter);
                break;
            case ("Priest"):
                Priest priest = new Priest();
                ControllerOfMainComponents.currentPlayer.setPriest(priest);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(priest);
                CollectionState.getInstance().getDeckToChange().setHero(priest);
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
        ShopController.setLockCards(ControllerOfMainComponents.currentPlayer);
        MethodsOfShowCardsOnPanel.showCards(ControllerOfMainComponents.currentPlayer.getLockCards(), panel, numberOfCardsPerRow);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Show lock cards ");
    }

    public static void showUnLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        ControllerOfMainComponents.currentPlayer.defineFirstCardsForPlayer();
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
        switch (CollectionState.getInstance().getDeckToChange().getHero().getName()) {
            case ("Mage"):
                Mage mage = new Mage();
                ControllerOfMainComponents.currentPlayer.setMage(mage);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(mage);
                CollectionState.getInstance().getDeckToChange().setHero(mage);
                break;
            case ("Rogue"):
                Rogue rogue = new Rogue();
                ControllerOfMainComponents.currentPlayer.setRogue(rogue);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(rogue);
                CollectionState.getInstance().getDeckToChange().setHero(rogue);
                break;
            case ("Warlock"):
                Warlock warlock = new Warlock();
                ControllerOfMainComponents.currentPlayer.setWarlock(warlock);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(warlock);
                CollectionState.getInstance().getDeckToChange().setHero(warlock);
                break;
            case ("Hunter"):
                Hunter hunter = new Hunter();
                ControllerOfMainComponents.currentPlayer.setHunter(hunter);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(hunter);
                CollectionState.getInstance().getDeckToChange().setHero(hunter);
                break;
            case ("Priest"):
                Priest priest = new Priest();
                ControllerOfMainComponents.currentPlayer.setPriest(priest);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(priest);
                CollectionState.getInstance().getDeckToChange().setHero(priest);
                break;
        }
        ControllerOfMainComponents.currentPlayer.setCurrentDeck(CollectionState.getInstance().getDeckToChange());

        ArrayList<Cards> cards=new ArrayList<>();
        for (Cards cards1:ControllerOfMainComponents.currentPlayer.getCurrentDeck().getListOfCards()){
            for (Cards cards2:Cards.getAllCards()){
                if (cards1.getName().equalsIgnoreCase(cards2.getName())){
                    cards.add(cards2);
                }
            }
        }

        ControllerOfMainComponents.currentPlayer.getCurrentDeck().setListOfCards(cards);
//        ControllerOfMainComponents.currentPlayer.setCurrentHero(CollectionState.getInstance().getDeckToChange().getHero());
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("select " + CollectionState.getInstance().getDeckToChange().getName() + " for main deck");
    }

    public static void changeNameOfDeck(String name) {
        CollectionState.getInstance().getDeckToChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Change name of deck ");
    }

    public static void changeHeroOfDeck(String heroName) {
        switch (heroName) {
            case ("Mage"):
                Mage mage = new Mage();
                ControllerOfMainComponents.currentPlayer.setMage(mage);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(mage);
                CollectionState.getInstance().getDeckToChange().setHero(mage);
                break;
            case ("Rogue"):
                Rogue rogue = new Rogue();
                ControllerOfMainComponents.currentPlayer.setRogue(rogue);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(rogue);
                CollectionState.getInstance().getDeckToChange().setHero(rogue);
                break;
            case ("Warlock"):
                Warlock warlock = new Warlock();
                ControllerOfMainComponents.currentPlayer.setWarlock(warlock);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(warlock);
                CollectionState.getInstance().getDeckToChange().setHero(warlock);
                break;
            case ("Hunter"):
                Hunter hunter = new Hunter();
                ControllerOfMainComponents.currentPlayer.setHunter(hunter);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(hunter);
                CollectionState.getInstance().getDeckToChange().setHero(hunter);
                break;
            case ("Priest"):
                Priest priest = new Priest();
                ControllerOfMainComponents.currentPlayer.setPriest(priest);
                ControllerOfMainComponents.currentPlayer.setCurrentHero(priest);
                CollectionState.getInstance().getDeckToChange().setHero(priest);
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
//                    DeckViewer.getInstance().showCardsInDecK();
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


    public static void showCantSellThisCard() {
        JOptionPane.showMessageDialog(null, "You can't sell this card:((");
    }

    public static void showDontHaveMoney() {
        JOptionPane.showMessageDialog(null, "You don't have enough money!");
    }

    public static void showSellSuccessfully() {
        JOptionPane.showMessageDialog(null, "The sell was completed successfully");
    }

    public static void showPurchaseSuccessfully() {
        JOptionPane.showMessageDialog(null, "The purchase was completed successfully");
    }

    public static void setBuyableCard() {
        ShopController.setBuyableCardsOfPlayer(ControllerOfMainComponents.currentPlayer);
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

    public static void buyShopStateCard() {
        ShopController.buyCard(ControllerOfMainComponents.currentPlayer, ShopState.getInstance().getCardsToBuyOrSell());
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

    public static void sellShopStateCard() {
        ShopController.sellCard(ControllerOfMainComponents.currentPlayer, ShopState.getInstance().getCardsToBuyOrSell());
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
            if (cards.getName().equalsIgnoreCase
                    (DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().get(i).getNameLabel().getText())) {
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
