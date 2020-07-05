package Models.Player;

import Models.Cards.CardClasses.*;
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

    public InGamePlayer(){
        this.handsCards = new ArrayList<>();
        this.battleGroundCards = new ArrayList<>();
        passivesToChoose=new ArrayList<>();
        deckCards=new ArrayList<>();
        firstThreeCards=new ArrayList<>();
        turn=1;
        mana=1;
//        deckCards= (ArrayList<Cards>) ControllerOfMainComponents.currentPlayer.getCurrentDeck().getListOfCards().clone();
//        initHandsCards();
    }

    public InGamePlayer(Player player) {
        this.player = player;
        deckCards=new ArrayList<>();
        for (Cards card:player.getCurrentDeck().getListOfCards()){
            deckCards.add(card.copy());
        }
//        this.deckCards = (ArrayList<Cards>) player.getCurrentDeck().getListOfCards().clone();
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

    public void reInitHandsCards(){
        this.handsCards.clear();
    }







    public void initHandsCards() {

        boolean hasQuestCard = false;
        a:
        for (Cards quest : Spell.getQuestAndRewardCards()) {
            for (Cards card : deckCards) {
                if (quest.equals(card)) {
                    hasQuestCard = true;
                    handsCards.add(quest);
                    firstThreeCards.add(deckCards.get(0));
                    deckCards.remove(card);
                    break a;
                }
            }
        }

        handsCards.add(deckCards.get(0));
        firstThreeCards.add(deckCards.get(0));
        deckCards.remove(0);
        handsCards.add(deckCards.get(0));
        firstThreeCards.add(deckCards.get(0));
        deckCards.remove(0);
        if (!hasQuestCard) {
            handsCards.add(deckCards.get(0));
            firstThreeCards.add(deckCards.get(0));
            deckCards.remove(0);
        }
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

}
