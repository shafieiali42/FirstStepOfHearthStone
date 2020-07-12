package Controller;

import Models.Cards.CardClasses.Cards;
import Models.Deck.Deck;
import Models.Player.*;
import java.util.HashSet;


public class ShopController {


    public static void setBuyableCardsOfPlayer(Player player) {
        player.getBuyableCards().clear();
        for (Cards card : Cards.getAllCards()) {
            boolean isDuplicated = false;
            for (Cards cardInBuyableCards : player.getBuyableCards()) {
                if (card.getName().equals(cardInBuyableCards.getName())) {
                    isDuplicated = true;
                    break;
                }
            }
            boolean isInAllCardsOfPlayer = false;
            if (!isDuplicated) {
                for (Cards cardInAvailableCardsWithThisSituation : player.getAllCardsOfPlayer()) {
                    if (card.getName().equals(cardInAvailableCardsWithThisSituation.getName())) {
                        isInAllCardsOfPlayer = true;
                        break;
                    }
                }
                if (!isInAllCardsOfPlayer) {
                    player.getBuyableCards().add(card);
                }
            }
        }

    }


    public static void setSellableCardsOfPlayer(Player player) {
        player.getSalableCards().clear();
        HashSet<Cards> mergedSetOfAllDeck = new HashSet<Cards>();
        for (Deck deck : player.getAllDecksOfPlayer()) {
            mergedSetOfAllDeck.addAll(deck.getListOfCards());
        }
        for (Cards card : player.getAllCardsOfPlayer()) {
            boolean isInMyDecks = false;
            for (Cards cardsInMyDecks : mergedSetOfAllDeck) {
                if (card.getName().equals(cardsInMyDecks.getName())) {
                    isInMyDecks = true;
                    break;
                }
            }
            if (!isInMyDecks) {
                player.getSalableCards().add(card);
            }
        }
    }


    public static void buyCard(Player player, Cards card) {
        boolean canBuyThisCard = false;
        for (Cards cardInBuyableCards : player.getBuyableCards()) {
            if (card.getName().equals(cardInBuyableCards.getName()) && player.getMoney() >= card.getMoneyCost()) {
                player.setMoney(player.getMoney() - card.getMoneyCost());
                player.getLoggerOfMyPlayer().info("Buy: " + card.getName());
                Administer.showPurchaseSuccessfully();
                canBuyThisCard = true;
            }
        }
        if (canBuyThisCard) {
            player.getBuyableCards().removeIf(card1 -> card.getName().equalsIgnoreCase(card1.getName()));
        }

        if (canBuyThisCard) {
            player.getAllCardsOfPlayer().add(card);
        }
        if (!canBuyThisCard) {
            Administer.showDontHaveMoney();
        }
        player.getLoggerOfMyPlayer().info("Buy " + card.getName());
        setBuyableCardsOfPlayer(player);
    }


    public static void sellCard(Player player, Cards card) {
        boolean canSellThisCard = false;
        for (Cards cardInSalableCards : player.getSalableCards()) {
            if (card.getName().equals(cardInSalableCards.getName())) {
                player.setMoney(player.getMoney() + card.getMoneyCost());
                Administer.showSellSuccessfully();
                player.getLoggerOfMyPlayer().info("Sell: " + card.getName());
                canSellThisCard = true;
                player.getAllCardsOfPlayer().removeIf(card1 -> card.getName().equalsIgnoreCase(card1.getName()));
            }
        }
        if (!canSellThisCard) {
            Administer.showCantSellThisCard();
        }
        player.getLoggerOfMyPlayer().info("Sell " + card.getName());
        setSellableCardsOfPlayer(player);
    }


    public  static void setLockCards(Player player){
        player.getLockCards().clear();
        for (Cards cards : Cards.getAllCards()) {
            if (!player.getAllCardsOfPlayer().contains(cards)) {
                player.getLockCards().add(cards);
            }
        }
    }


}
