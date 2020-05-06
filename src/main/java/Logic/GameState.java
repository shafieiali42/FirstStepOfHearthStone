package Logic;

import Cards.Cards;
import Cards.*;
import CommandLineInterface.CLI;
import Deck.Deck;
import Player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameState {

    private Player player;
    private Player opponentPlayer;
    private ArrayList<Cards> handsCards;
    private ArrayList<Cards> handsCardsOfOpponent;
    //    private Deck deck;
    private ArrayList<Cards> cardsOfDeckInGameState;
    private Deck deckOfOpponent;
    private ArrayList<Cards> battleGroundCards;
    private ArrayList<Cards> battleGroundCardsOfOpponent;
    private Weapon currentWeapon;
    private int mana;
    private int turn;
    private Alliance currentAlliance;
    private Cards playingCard;
    private Passive infoPassive;
    private ArrayList<Passive> passivesToChoose;

    public Passive getInfoPassive() {
        return infoPassive;
    }

    public void setInfoPassive(Passive infoPassive) {
        this.infoPassive = infoPassive;
    }

    public Cards getPlayingCard() {
        return playingCard;
    }

    public void setPlayingCard(Cards playingCard) {
        this.playingCard = playingCard;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    private static GameState gameState;

    static {
        try {
            gameState = new GameState();
        } catch (IOException e) {
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

    public static void setGameState(GameState gameState) {
        GameState.gameState = gameState;
    }

    public GameState() throws IOException {
        initGameState();
    }

    public ArrayList<Passive> getPassivesToChoose() {
        return passivesToChoose;
    }

    public void initGameState() throws IOException {
        player = CLI.currentPlayer;
        playingCard = new Cards();
        battleGroundCards = new ArrayList<Cards>();
        cardsOfDeckInGameState = (ArrayList<Cards>) CLI.currentPlayer.getCurrentDeck().getListOfCards().clone();

        handsCards = new ArrayList<Cards>();
        Collections.shuffle(cardsOfDeckInGameState);
        boolean hasQuestCard = false;
        a:
        for (Cards quest : Spell.getQuestAndRewardCards()) {
            for (Cards card : cardsOfDeckInGameState) {
                if (quest.equals(card)) {
                    hasQuestCard = true;
                    handsCards.add(quest);
                    cardsOfDeckInGameState.remove(card);
                    break a;
                }
            }
        }

        handsCards.add(cardsOfDeckInGameState.get(0));
        cardsOfDeckInGameState.remove(0);
        handsCards.add(cardsOfDeckInGameState.get(0));
        cardsOfDeckInGameState.remove(0);
        if (!hasQuestCard) {
            handsCards.add(cardsOfDeckInGameState.get(0));
            cardsOfDeckInGameState.remove(0);
        }


        currentAlliance = Alliance.ME;
        mana = 1;
        turn = 0;
        passivesToChoose = new ArrayList<Passive>();
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        for (int i = 0; i < Passive.NUMBER_OF_PASSIVES; i++) {
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(0)));
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(1)));
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(2)));
        System.out.println(randomNumber);


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

    public ArrayList<Cards> getCardsOfDeckInGameState() {
        return cardsOfDeckInGameState;
    }

    public void setCardsOfDeckInGameState(ArrayList<Cards> cardsOfDeckInGameState) {
        this.cardsOfDeckInGameState = cardsOfDeckInGameState;
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
