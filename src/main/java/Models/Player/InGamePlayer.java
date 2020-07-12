package Models.Player;

import Models.Cards.CardClasses.*;
import Models.Deck.Deck;
import Models.Heroes.Heroes;

import java.util.ArrayList;
import java.util.Collections;

public class InGamePlayer {


    private Player player;
    private Heroes hero;
    private ArrayList<Cards> deckCards;
    private ArrayList<Cards> handsCards;
    private ArrayList<Minion> battleGroundCards;
    private Weapon currentWeapon;
    private int mana;
    private int turn;
    private Passive infoPassive;
    private ArrayList<Passive> passivesToChoose;
    private ArrayList<Cards> firstThreeCards;
    private int numberOfDrawCard;
    private int questImprovement;
    private Spell questCard;
    private Deck deck;



    public InGamePlayer(){
        this.handsCards = new ArrayList<>();
        this.battleGroundCards = new ArrayList<>();
        passivesToChoose=new ArrayList<>();
        deckCards=new ArrayList<>();
        firstThreeCards=new ArrayList<>();
        turn=1;
        mana=1;
    }

    public InGamePlayer(Player player) {
        this.player = player;
        deckCards=new ArrayList<>();
        for (Cards card:player.getCurrentDeck().getListOfCards()){
            deckCards.add(card.copy());
        }
        hero=player.getCurrentHero();
        Collections.shuffle(deckCards);
        this.handsCards = new ArrayList<>();
        this.battleGroundCards = new ArrayList<>();
        passivesToChoose=new ArrayList<>();
        firstThreeCards=new ArrayList<>();
        turn=1;
        mana=1;
        initHandsCards();
        initPassiveToChoose();


    }



    public void initPassiveToChoose() {
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        for (int i = 0; i < Passive.NUMBER_OF_PASSIVES; i++) {
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(0)));
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(1)));
        passivesToChoose.add(Passive.getPassives().get(randomNumber.get(2)));
    }

    public void initHandsCards() {
        handsCards.add(deckCards.get(0));
        firstThreeCards.add(deckCards.get(0));
        deckCards.remove(0);

        handsCards.add(deckCards.get(0));
        firstThreeCards.add(deckCards.get(0));
        deckCards.remove(0);

        handsCards.add(deckCards.get(0));
        firstThreeCards.add(deckCards.get(0));
        deckCards.remove(0);

    }



    //getter and setters
    //********************

    public Spell getQuestCard() {
        return questCard;
    }

    public void setQuestCard(Spell questCard) {
        this.questCard = questCard;
    }

    public int getQuestImprovement() {
        return questImprovement;
    }

    public void setQuestImprovement(int questImprovement) {
        this.questImprovement = questImprovement;
    }

    public int getNumberOfDrawCard() {
        return numberOfDrawCard;
    }

    public void setNumberOfDrawCard(int numberOfDrawCard) {
        this.numberOfDrawCard = numberOfDrawCard;
    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Cards> getDeckCards() {
        return deckCards;
    }

    public Heroes getHero() {
        return hero;
    }

    public void setHero(Heroes hero) {
        this.hero = hero;
    }

    public void setDeckCards(ArrayList<Cards> deckCards) {
        this.deckCards = deckCards;
    }

    public ArrayList<Cards> getHandsCards() {
        return handsCards;
    }
    public void setHandsCards(ArrayList<Cards> handsCards) {
        this.handsCards = handsCards;
    }

    public ArrayList<Minion> getBattleGroundCards() {
        return battleGroundCards;
    }
    public void setBattleGroundCards(ArrayList<Minion> battleGroundCards) {
        this.battleGroundCards = battleGroundCards;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
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

    public Passive getInfoPassive() {
        return infoPassive;
    }
    public void setInfoPassive(Passive infoPassive) {
        this.infoPassive = infoPassive;
    }

    public ArrayList<Passive> getPassivesToChoose() {
        return passivesToChoose;
    }
    public void setPassivesToChoose(ArrayList<Passive> passivesToChoose) {
        this.passivesToChoose = passivesToChoose;
    }

    public ArrayList<Cards> getFirstThreeCards() {
        return firstThreeCards;
    }
    public void setFirstThreeCards(ArrayList<Cards> firstThreeCards) {
        this.firstThreeCards = firstThreeCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

}
