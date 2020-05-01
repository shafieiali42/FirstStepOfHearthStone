package Logic;

import Cards.Cards;
import CommandLineInterface.CLI;
import Deck.Deck;
import Player.Player;

import java.util.ArrayList;

public class GameState {

    private Player player;
    private Player opponentPlayer;
    private ArrayList<Cards> handsCards;
    private ArrayList<Cards> handsCardsOfOpponent;
    private Deck deck;
    private Deck deckOfOpponent;
    private ArrayList<Cards> battleGroundCards;
    private ArrayList<Cards> battleGroundCardsOfOpponent;
    private int mana;
    private int turn;

    public GameState(){
        player= CLI.currentPlayer;
        handsCards=new ArrayList<Cards>();
        deck=CLI.currentPlayer.getCurrentDeck();
        battleGroundCards=new ArrayList<Cards>();
        mana=0;
        turn=0;

    }










    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getOpponentPlayer() {
        return opponentPlayer;
    }
    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }
    public ArrayList<Cards> getHandsCards() {
        return handsCards;
    }
    public void setHandsCards(ArrayList<Cards> handsCards) {
        this.handsCards = handsCards;
    }
    public ArrayList<Cards> getHandsCardsOfOpponent() {
        return handsCardsOfOpponent;
    }
    public void setHandsCardsOfOpponent(ArrayList<Cards> handsCardsOfOpponent) {
        this.handsCardsOfOpponent = handsCardsOfOpponent;
    }
    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Deck getDeckOfOpponent() {
        return deckOfOpponent;
    }
    public void setDeckOfOpponent(Deck deckOfOpponent) {
        this.deckOfOpponent = deckOfOpponent;
    }
    public ArrayList<Cards> getBattleGroundCards() {
        return battleGroundCards;
    }
    public void setBattleGroundCards(ArrayList<Cards> battleGroundCards) {
        this.battleGroundCards = battleGroundCards;
    }
    public ArrayList<Cards> getBattleGroundCardsOfOpponent() {
        return battleGroundCardsOfOpponent;
    }
    public void setBattleGroundCardsOfOpponent(ArrayList<Cards> battleGroundCardsOfOpponent) {
        this.battleGroundCardsOfOpponent = battleGroundCardsOfOpponent;
    }


}
