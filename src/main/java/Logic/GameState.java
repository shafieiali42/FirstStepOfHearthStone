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
    private Alliance currentAlliance;
    private Cards playingCard;


    public Cards getPlayingCard() {
        return playingCard;
    }
    public void setPlayingCard(Cards playingCard) {
        this.playingCard = playingCard;
    }

    private static GameState gameState;

    static {
        try {
            gameState = new GameState();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public Alliance getCurrentAlliance() {
        return currentAlliance;
    }

    public void setCurrentAlliance(Alliance currentAlliance) {
        this.currentAlliance = currentAlliance;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public static GameState getInstance() {
        return gameState;
    }

    public GameState() throws CloneNotSupportedException {
        player = CLI.currentPlayer;
        handsCards = new ArrayList<Cards>();
        deck = (Deck) CLI.currentPlayer.getCurrentDeck().clone();
        battleGroundCards = new ArrayList<Cards>();
        currentAlliance=Alliance.ME;
        mana = 0;
        turn = 0;

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
