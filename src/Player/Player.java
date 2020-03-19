package Player;

import Cards.Cards;
import CommandLineInterface.CLI;
import Heroes.*;
import Log.LoggerOfProject;
import com.google.gson.annotations.Expose;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Player {

    @Expose(serialize = true,deserialize = true)
    private String userName;
    @Expose(serialize = true,deserialize = true)
    private String passWord;
    @Expose(serialize = true,deserialize = true)
    private String SigninOrSignup ;
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
    private transient Logger loggerOfMyPlayer;




    public TreeSet<Cards> getAllCardsOfPlayer() {
        return allCardsOfPlayer;
    }
    public void setAllCardsOfPlayer() {
        allCardsOfPlayer.addAll(availableCardsWithThisSituation);
        allCardsOfPlayer.addAll(Mage.getSpecialCardsOfMage());
        allCardsOfPlayer.addAll(Rogue.getSpecialCardsOfRogue());
        allCardsOfPlayer.addAll(Warlock.getSpecialCardsOfWarlock());
    }

    public Logger getLoggerOfMyPlayer() {
        return loggerOfMyPlayer;
    }
    public void setLoggerOfMyPlayer() throws IOException {
        this.loggerOfMyPlayer=LoggerOfProject.getMyLogger(this.getUserName()+".log");
    }

    @Expose(serialize = true,deserialize = true)
    private TreeSet<Cards> allCardsOfPlayer = new TreeSet<Cards>();


    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> SalableCards = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> BuyableCards = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> NeutralCards = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> availableCardsThatWeCanAddIntoOurDeck=new ArrayList<Cards>();




    public void setAvailableCardsThatWeCanAddIntoOurDeck() {
        for (Cards card:availableCardsWithThisSituation){
            boolean canAddIntoDeck=true;
            for (Cards cardThatIsInOurDeck:getAvailableDeckWithThisSituation()){
                if (card.getName().equals(cardThatIsInOurDeck.getName())){
                    canAddIntoDeck=false;
                }
            }
            if (canAddIntoDeck){
                this.availableCardsThatWeCanAddIntoOurDeck.add(card);
            }
        }
    }



    public void setBuyableCards(){
        for (Cards card :Cards.getAllCards()){
            boolean isDuplicated =false;
            for (Cards cardInBuyableCards:BuyableCards){
                if (card.getName().equals(cardInBuyableCards.getName())){
                    isDuplicated=true;
                }
            }
            boolean isInAvailableCardsWithThisSituation=false;
            if (!isDuplicated){
                for (Cards cardInAvailableCardsWithThisSituation:availableCardsWithThisSituation){
                    if (card.getName().equals(cardInAvailableCardsWithThisSituation.getName())){
                        isInAvailableCardsWithThisSituation=true;
                    }
                }
                if (!isInAvailableCardsWithThisSituation){
                    BuyableCards.add(card);
                }
            }

        }
    };
    public void setSalableCards(){
        for (Cards card:availableCardsWithThisSituation){
            for (Cards cardsAvailableToAddIntoOurDeck:availableCardsThatWeCanAddIntoOurDeck){
                if (card.getName().equals(cardsAvailableToAddIntoOurDeck.getName())){
                    SalableCards.add(card);
                }
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
    public String getSigninOrSignup() {
        return SigninOrSignup;
    }
    public void setSigninOrSignup(String signinOrSignup) {
        this.SigninOrSignup = signinOrSignup;
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


    public Player(String userName, String passWord) throws IOException {
        this.userName=userName;
        this.passWord=passWord;
        this.availableHeroes.add(Mage.getInstance());
        this.availableHeroes.add(Rogue.getInstance());
        this.availableHeroes.add(Warlock.getInstance());
        System.out.println(NeutralCards.size());
        this.setNeutralCards();
        this.setAvailableCardsWithThisSituation();
        this.setAvailableCardsThatWeCanAddIntoOurDeck();
        setBuyableCards();
        setSalableCards();
        setLoggerOfMyPlayer();
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
            for (Cards cards:NeutralCards){
                mergedList.add(cards);
            }
            mergedList.addAll(Mage.getSpecialCardsOfMage());//Todo problemmmmmmmmmmmmmmmmm
            availableCardsWithThisSituation=mergedList;

        }
        if (currentHero.getName().equals("Rogue")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            for (Cards cards:NeutralCards){
                mergedList.add(cards);
            }
            mergedList.addAll(Rogue.getSpecialCardsOfRogue());
            availableCardsWithThisSituation=mergedList;
        }
        if (currentHero.getName().equals("Warlock")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            for (Cards cards:NeutralCards){
                mergedList.add(cards);
            }
            mergedList.addAll(Warlock.getSpecialCardsOfWarlock());
            availableCardsWithThisSituation=mergedList;
        }
        setBuyableCards();
        setSalableCards();
    }

    public void buy(Cards card) throws IOException {
        for (Cards cardInBuyableCards:BuyableCards){
            if (card.getName().equals(cardInBuyableCards.getName())&&this.money>=card.getMoneyCost()){
                allCardsOfPlayer.add(card);
                setAvailableCardsWithThisSituation();
                this.money-=card.getMoneyCost();
                CLI.currentPlayer.getLoggerOfMyPlayer().info("Buy: "+card.getName());
            }
        }
    }

    public void setNeutralCards() {//TODO needs to check!
        for (Cards card :Cards.getAllCards()){
            if (card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                NeutralCards.add(card);

            }
        }
    }

    public void sell(Cards card) throws IOException {
        for (Cards cardInSalableCards:SalableCards){
            if (card.getName().equals(cardInSalableCards.getName())){
                allCardsOfPlayer.remove(card);
                setAvailableCardsWithThisSituation();
                this.money+=card.getMoneyCost();
                CLI.currentPlayer.getLoggerOfMyPlayer().info("Sell: "+card.getName());
            }
        }
    }

    public void selectHero(Heroes hero) throws IOException {
        this.currentHero=hero;
        setAvailableCardsWithThisSituation();
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Select :" +hero.getName());
    }


    public void addToDeck(Cards card) throws IOException {
        for (Cards cardsInAvailableCardInThisSituation:availableCardsWithThisSituation){
            if (cardsInAvailableCardInThisSituation.getName().equals(card.getName())){
                System.out.println("yes");
                switch(currentHero.getName()){
                    case "Mage":
                        System.out.println(card.getClassOfCard());
                        if (card.getClassOfCard().toLowerCase().trim().equals("mage")
                                ||card.getClassOfCard().toLowerCase().trim().equals("neutral")  ){
                            DeckOfPlayerForMage.add(card);
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Add: "+card.getName()+"Heroe Name: Mage");
                        break;
                    case "Rogue":
                        if (card.getClassOfCard().toLowerCase().trim().equals("Rogue")
                                ||card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                            DeckOfPlayerForRogue.add(card);
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Add: "+card.getName()+"Heroe Name: Rogue");
                        break;
                    case "Warlock":
                        if (card.getClassOfCard().toLowerCase().trim().equals("Warlock")
                                ||card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                            DeckOfPlayerForWarlock.add(card);
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Add: "+card.getName()+"Heroe Name: Warlock");
                        break;

                }
            }
        }

    }

    public void removeFromDeck(Cards card) throws IOException {
        System.out.println("Deck");
        System.out.println(getAvailableDeckWithThisSituation());
                switch (currentHero.getName()) {
                    case "Mage":
                        Iterator<Cards> itr = DeckOfPlayerForMage.iterator();
                        while (itr.hasNext()){
                            Cards cardsInDeckForMage = itr.next();
                            if (cardsInDeckForMage.getName().equals(card.getName())){
                                itr.remove();
                            }
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Remove: "+card.getName()+"Heroe Name:Mage");
                        break;
                    case "Rogue":
                        Iterator<Cards> itr2 = DeckOfPlayerForRogue.iterator();
                        while (itr2.hasNext()){
                            Cards cardsInDeckForRogue = itr2.next();
                            if (cardsInDeckForRogue.getName().equals(card.getName())){
                                itr2.remove();
                            }
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Remove: "+card.getName()+"Heroe Name: Rogue");
                        break;
                    case "Warlock":
                        Iterator<Cards> itr3 = DeckOfPlayerForWarlock.iterator();
                        while (itr3.hasNext()){
                            Cards cardsInDeckForWarlock = itr3.next();
                            if (cardsInDeckForWarlock.getName().equals(card.getName())){
                                itr3.remove();
                            }
                        }
                        CLI.currentPlayer.getLoggerOfMyPlayer().info("Remove: "+card.getName()+"Heroe Name: Warlock");
                        break;
                }
    }
}
