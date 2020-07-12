package Controller;

import Logic.NonePlayLogics.CollectionState;
import Logic.Status;
import Models.Cards.CardClasses.Cards;
import Models.Deck.Deck;
import Models.Heroes.*;
import Utility.MethodsOfShowCardsOnPanel;
import View.Gui.Panels.CollectionPages.DeckPage;
import View.Gui.Panels.CollectionPages.LittleCardPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CollectionController {




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






}
