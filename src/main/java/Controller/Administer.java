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

    public static void addGivenCardToCollectionDeck(String cardName, boolean isLock) throws IOException {
        Cards cards = null;
        for (Cards cards1 : Cards.getAllCards()) {
            if (cards1.getName().equals(cardName)) {
                cards = cards1.copy();

            }
        }
        for (int i = 0; i < DeckPage.getInstance().getListOfLittleCardsPanelOfDeckToChange().size(); i++) {
            assert cards != null;
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
