package Player;

import Cards.Cards;
import Heroes.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;


import java.util.ArrayList;

public class Player {

    @Expose(serialize = true,deserialize = true)
    private String userName;
    @Expose(serialize = true,deserialize = true)
    private String passWord;
    @Expose(serialize = true,deserialize = true)
    private boolean loginStatus = false;
    @Expose(serialize = true,deserialize = true)
    private int money;
    @Expose(serialize = true,deserialize = true)
    private Heroes currentHero = Mage.getInstance();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> availableCardsWithThisSituation = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> DeckOfPlayerForMage=new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> DeckOfPlayerForRogue=new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> DeckOfPlayerForWarlock=new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Heroes> availableHeroes = new ArrayList<Heroes>();



    @Expose(serialize = false,deserialize = false)
    private  transient ArrayList<Cards> SalableCards = new ArrayList<Cards>();
    @Expose(serialize = false,deserialize = false)
    private transient ArrayList<Cards> BuyableCards = new ArrayList<Cards>();
    @Expose(serialize = false,deserialize = false)
    private transient ArrayList<Cards> NeutralCards = new ArrayList<Cards>();
    @Expose(serialize = false,deserialize = false)
    private transient ArrayList<Cards> availableCardsThatWeCanAddIntoOurDeck=new ArrayList<Cards>();




    public void setAvailableCardsThatWeCanAddIntoOurDeck() {
        for (Cards card:availableCardsWithThisSituation){
            if (!getAvailableDeckWithThisSituation().contains(card)){
                availableCardsThatWeCanAddIntoOurDeck.add(card);
            }
        }
    }



    public void setBuyableCards(){
        for (Cards card :Cards.getAllCards()){
            if (!getAvailableCardsWithThisSituation().contains(card)){
                BuyableCards.add(card);
            }
        }
    };
    public void setSalableCards(){
        for (Cards card:availableCardsWithThisSituation){
//            System.out.println(card);
            if (getAvailableCardsThatWeCanAddIntoOurDeck().contains(card)){
                //TODO maybe it has some problem!
//                System.out.println(getAvailableDeckWithThisSituation());
                SalableCards.add(card);
            }
        }
    };




    public ArrayList<Cards> getAvailableCardsThatWeCanAddIntoOurDeck() {
        return availableCardsThatWeCanAddIntoOurDeck;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public boolean getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public ArrayList<Cards> getBuyableCards() {
        return BuyableCards;
    }
    public ArrayList<Cards> getSalableCards() {
        setSalableCards();
        return SalableCards;
    }
    public Heroes getCurrentHero() {
        return currentHero;
    }
    public ArrayList<Heroes> getAvailableHeroes() {
        return availableHeroes;
    }
    public void setAvailableHeroes(ArrayList<Heroes> availableHeroes) {
        this.availableHeroes = availableHeroes;
    }
    public ArrayList<Cards> getNeutralCards() {
        return NeutralCards;
    }
    public ArrayList<Cards> getAvailableCardsWithThisSituation() {
        return availableCardsWithThisSituation;
    }


    public Player(String userName, String passWord) {
        this.userName=userName;
        this.passWord=passWord;
        this.availableHeroes.add(Mage.getInstance());
        this.availableHeroes.add(Rogue.getInstance());
        this.availableHeroes.add(Warlock.getInstance());
        this.setNeutralCards();
        this.setAvailableCardsWithThisSituation();
        this.money=500;
    }



    public ArrayList<Cards> getAvailableDeckWithThisSituation(){
        switch (this.currentHero.getName()){
            case "Mage":
                return DeckOfPlayerForMage;
            case "Rogue":
                return DeckOfPlayerForRogue;
            case "Warlock":
                return DeckOfPlayerForWarlock;
        }
        return null;
    }

    public void setAvailableCardsWithThisSituation(){
        if (currentHero.getName().equals("Mage")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            mergedList=NeutralCards;
            mergedList.addAll(Mage.getSpecialCardsOfMage());
            availableCardsWithThisSituation=mergedList;

        }
        if (currentHero.getName().equals("Rogue")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            mergedList=NeutralCards;
            mergedList.addAll(Rogue.getSpecialCardsOfRogue());
            availableCardsWithThisSituation=mergedList;
        }
        if (currentHero.getName().equals("Warlock")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            mergedList=NeutralCards;
            mergedList.addAll(Warlock.getSpecialCardsOfWarlock());
            availableCardsWithThisSituation=mergedList;
        }
        setBuyableCards();
        setSalableCards();
    }

    public void buy(Cards card) {
        if (BuyableCards.contains(card)&& this.money>=card.getMoneyCost()){
            NeutralCards.add(card);
            setAvailableCardsWithThisSituation();
            this.money-=card.getMoneyCost();
        }
    }

    public void setNeutralCards() {//TODO needs to check!
        for (Cards card :Cards.getAllCards()){
            System.out.println(card.getClassOfCard());
            if (card.getClassOfCard().toLowerCase().trim().equals("neutral") && !NeutralCards.contains(card)){
                NeutralCards.add(card);
            }
        }
    }

    public void sell(Cards card) {
        if (SalableCards.contains(card)){
            NeutralCards.remove(card);
            setAvailableCardsWithThisSituation();
            this.money+=card.getMoneyCost();
        }
    }

    public void selectHero(Heroes hero) {
        this.currentHero=hero;
        setAvailableCardsWithThisSituation();
    }


    public void addToDeck(Cards card) {
        if (availableCardsWithThisSituation.contains(card)){
            System.out.println("yes");
            switch(currentHero.getName()){
                case "Mage":
                    System.out.println(card.getClassOfCard());
                    if (card.getClassOfCard().toLowerCase().trim().equals("mage")
                            ||card.getClassOfCard().toLowerCase().trim().equals("neutral")  ){
                        DeckOfPlayerForMage.add(card);
                        System.out.println("yestreeeee");
                    }
                    break;
                case "Rogue":
                    if (card.getClassOfCard().toLowerCase().trim().equals("Rogue")
                            ||card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                        DeckOfPlayerForRogue.add(card);
                    }
                    break;
                case "Warlock":
                    if (card.getClassOfCard().toLowerCase().trim().equals("Warlock")
                            ||card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                        DeckOfPlayerForWarlock.add(card);
                    }
                    break;

            }
        }
    }

    public void removeFromDeck(Cards card) {
        if (availableCardsWithThisSituation.contains(card)){
            switch(currentHero.getName()){
                case "Mage":
                    if (DeckOfPlayerForMage.contains(card)){
                        DeckOfPlayerForMage.remove(card);
                    }
                    break;
                case "Rogue":
                    if (DeckOfPlayerForRogue.contains(card)){
                        DeckOfPlayerForRogue.remove(card);
                    }
                    break;
                case "Warlock":
                    if (DeckOfPlayerForWarlock.contains(card)){
                        DeckOfPlayerForWarlock.remove(card);
                    }
                    break;
            }

        }
    }


}
