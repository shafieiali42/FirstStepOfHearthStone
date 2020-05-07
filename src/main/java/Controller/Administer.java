package Controller;

import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Gui.Panels.CollectionPages.CardPanel;
import Gui.Panels.CollectionPages.DeckPage;
import Gui.Panels.CollectionPages.DeckViewer;
import Gui.Panels.CollectionPages.LittleCardPanel;
import Gui.Panels.ShopPanel.ShopCardPanel;
import Logic.CollectionState;
import Models.Cards.Cards;
import Models.Deck.Deck;
import Models.Heroes.*;
import Utility.MethodsOfShowCardsOnPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Administer {

    private static Administer administer = new Administer();

    public static Administer getInstance() {
        return administer;
    }







    public static void showSalableCards(JPanel panel,int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getSalableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showBuyableCards(JPanel panel,int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getBuyableCards(),
                panel, numberOfCardsPerRow);
    }

    public static void showCardsWithSpecifiedManaCost(int mana,JPanel cardPanelOfCollectionPage,
                                                      JPanel cardPanelOfDeckPage,int numberOfCardsPerRow) throws IOException {
        ArrayList<Cards> filteredByManaCards = new ArrayList<Cards>();
        for (Cards card : Cards.getAllCards()) {
            if (card.getManaCost() == mana) {
                filteredByManaCards.add(card);
            }
        }
        if (CLI.getStatus().equals(Status.COLLECTIONS_PAGE)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfCollectionPage, numberOfCardsPerRow);
        } else if (CLI.getStatus().equals(Status.MAKE_DECK) || CLI.getStatus().equals(Status.CHANGE_DECK)) {
            MethodsOfShowCardsOnPanel.showCards(filteredByManaCards, cardPanelOfDeckPage,numberOfCardsPerRow);
        }
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show cards with mana: "+mana);
    }

    public static void showSearchedCards(String searchFieldText,JPanel cardPanelOfCollectionPage,
                                         JPanel cardPanelOfDeckPage,int numberOfCardsPerRow ) throws IOException {
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

    public static boolean isCurrentPlayersCurrentDeckNull(){
       return CLI.currentPlayer.getCurrentDeck().getHero()==null;
    }

    public static void showLittleCardPanelOnDeckViewer(LittleCardPanel littleCardPanel, JPanel panel, int xCoordinate, int yCoordinate) {
        MethodsOfShowCardsOnPanel.addPanel(littleCardPanel, panel,
                xCoordinate, yCoordinate, littleCardPanel.getWidth(), littleCardPanel.getHeight());
    }

    public static ArrayList<LittleCardPanel> getLittleCardPanelOfCollectionStatesDeck() {
        return CollectionState.getInstance().getDeckToChange().getLittleCardPanelsOfThisDeck();
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
        CollectionState.getInstance().getDeckToChange().setLittleCardsListFromHashMap();

    }

    public static void makeNewDeck(String name, String heroName) {
        CollectionState.getInstance().setDeckToChange(new Deck());
        CollectionState.getInstance().getDeckToChange().setName(name);
        CollectionState.getInstance().getDeckToChange().setLittleCardsListFromHashMap();
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
    }

    public static String getHeroNameOfDeckToChange() {
        return CollectionState.getInstance().getDeckToChange().getHeroName();
    }

    public static void showAllCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(Cards.getAllCards(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show all cards ");
    }

    public static void showLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getLockCards(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show lock cards ");
    }

    public static void showUnLockCards(JPanel panel, int numberOfCardsPerRow) throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getUnLockCards(), panel, numberOfCardsPerRow);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show unlock cards ");

    }

    public static void defineUsesHashMap() {
        CollectionState.getInstance().getDeckToChange().defineUsesHashMap();

    }

    public static void makeCollectionStatesDeckToNull() {
        CollectionState.getInstance().setDeckToChange(new Deck());
        CLI.setStatus(Status.COLLECTIONS_PAGE);
    }

    public static void addCollectionStatesDeckToPlayersDecksList() {
        CLI.currentPlayer.getAllDecksOfPlayer().add(CollectionState.getInstance().getDeckToChange());
    }

    public static void writeLog(String log){
        CLI.currentPlayer.getLoggerOfMyPlayer().info(log);
    }


}
