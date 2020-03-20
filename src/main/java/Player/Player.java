package Player;

import Cards.Cards;
import CommandLineInterface.CLI;
import Heroes.*;
import Log.LoggerOfProject;
import com.google.gson.annotations.Expose;


import javax.smartcardio.Card;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> allCardsOfPlayer = new ArrayList<Cards>();

    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> SalableCards = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> BuyableCards = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> NeutralCardsOfPlayer = new ArrayList<Cards>();
    @Expose(serialize = true,deserialize = true)
    private ArrayList<Cards> availableCardsThatWeCanAddIntoOurDeck=new ArrayList<Cards>();

    public ArrayList<Cards> getAllCardsOfPlayer() {
        return allCardsOfPlayer;
    }
    public void setAllCardsOfPlayer() {
        int i=0;
            for (Cards card: Cards.getAllCards()){
                if (i<9){
                    if (card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                        allCardsOfPlayer.add(card);
                        i++;
                    }
                }else{
                    break;
                }
            }

        allCardsOfPlayer.add(Mage.getSpecialCardsOfMage().get(0));
    }

    public Logger getLoggerOfMyPlayer() {
        return loggerOfMyPlayer;
    }
    public void setLoggerOfMyPlayer() throws IOException {
        this.loggerOfMyPlayer=LoggerOfProject.getMyLogger("logs\\"+this.getUserName()+".log");
    }









    public void setAvailableCardsThatWeCanAddIntoOurDeck() {
        availableCardsThatWeCanAddIntoOurDeck.clear();
        for (Cards card:availableCardsWithThisSituation){
            boolean canAddIntoDeck=true;
            for (Cards cardThatIsInOurDeck:getAvailableDeckWithThisSituation()){
                if (card.getName().trim().equalsIgnoreCase(cardThatIsInOurDeck.getName())){
                    canAddIntoDeck=false;
                }
            }
            boolean isDuplicated=false;
            for (Cards cardInAvailableCardsThatWeCanAddIntoOurDeck:availableCardsThatWeCanAddIntoOurDeck){
                if (card.getName().equals(cardInAvailableCardsThatWeCanAddIntoOurDeck.getName())){
                    isDuplicated =true;
                }
            }
            if (canAddIntoDeck && !isDuplicated){
                this.availableCardsThatWeCanAddIntoOurDeck.add(card);
            }
        }
    }



    public void setBuyableCards(){
        BuyableCards.clear();
        for (Cards card :Cards.getAllCards()){
            boolean isDuplicated =false;
            for (Cards cardInBuyableCards:BuyableCards){
                if (card.getName().equals(cardInBuyableCards.getName())){
                    isDuplicated=true;
                }
            }
            boolean isInAllCardsOfPlayer=false;
            if (!isDuplicated){
                for (Cards cardInAvailableCardsWithThisSituation:allCardsOfPlayer){
                    if (card.getName().equals(cardInAvailableCardsWithThisSituation.getName())){
                        isInAllCardsOfPlayer=true;
                    }
                }
                if (!isInAllCardsOfPlayer){
                    BuyableCards.add(card);
                }
            }

        }
    };

    public void setSalableCards(){
        SalableCards.clear();
        HashSet<Cards> mergedSetOfAllDeck = new HashSet<Cards>();
        mergedSetOfAllDeck.addAll(DeckOfPlayerForMage);
        mergedSetOfAllDeck.addAll(DeckOfPlayerForRogue);
        mergedSetOfAllDeck.addAll(DeckOfPlayerForWarlock);
        for (Cards card:allCardsOfPlayer){
            boolean isInMyDecks = false;
            for (Cards cardsInMyDecks:mergedSetOfAllDeck){
                if (card.getName().equals(cardsInMyDecks.getName())){
                    isInMyDecks=true;
                }
            }
            if (!isInMyDecks){
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
    public ArrayList<Cards> getNeutralCardsOfPlayer() {
        return NeutralCardsOfPlayer;
    }
    public ArrayList<Cards> getAvailableCardsWithThisSituation() {
        return availableCardsWithThisSituation;
    }


    public Player(String userName, String passWord) throws IOException {
        this.userName=userName;
        this.passWord=passWord;
        this.availableHeroes.add(Mage.getInstance());
        this.setAllCardsOfPlayer();
        this.setNeutralCardsOfPlayer();
//        this.availableHeroes.add(Rogue.getInstance());//TODO this hero is lock!
//        this.availableHeroes.add(Warlock.getInstance());//TODO this hero is lock!

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
            for (Cards cards: NeutralCardsOfPlayer){
                mergedList.add(cards);
            }
            mergedList.add(Mage.getSpecialCardsOfMage().get(0));//Todo problemmmmmmmmmmmmmmmmm
            availableCardsWithThisSituation=mergedList;

        }
        if (currentHero.getName().equals("Rogue")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            for (Cards cards: NeutralCardsOfPlayer){
                mergedList.add(cards);
            }
            mergedList.add(Rogue.getSpecialCardsOfRogue().get(0));
            availableCardsWithThisSituation=mergedList;
        }
        if (currentHero.getName().equals("Warlock")){
            ArrayList<Cards> mergedList = new ArrayList<Cards>();
            for (Cards cards: NeutralCardsOfPlayer){
                mergedList.add(cards);
            }
            mergedList.add(Warlock.getSpecialCardsOfWarlock().get(0));
            availableCardsWithThisSituation=mergedList;
        }
        setBuyableCards();
        setSalableCards();
    }

    public void buy(Cards card) throws IOException {
        boolean canBuyThisCard= false;
        for (Cards cardInBuyableCards:BuyableCards){
            if (card.getName().equals(cardInBuyableCards.getName())&&this.money>=card.getMoneyCost()){
//                allCardsOfPlayer.add(card);
                this.money-=card.getMoneyCost();
                CLI.currentPlayer.getLoggerOfMyPlayer().info("Buy: "+card.getName());
                canBuyThisCard=true;

            }
        }
        if (canBuyThisCard){
            Iterator<Cards> itr =BuyableCards.iterator();
            while (itr.hasNext()){
                Cards card1 =itr.next();
                if (card.getName().equalsIgnoreCase(card1.getName())){
                    itr.remove();
                }
            }
        }

        if (canBuyThisCard){
            allCardsOfPlayer.add(card);
        }
        if (!canBuyThisCard){
            System.out.println("you cant buy this cart");
        }
        setAvailableCardsWithThisSituation();
        setBuyableCards();
    }


    public void setNeutralCardsOfPlayer() {//TODO needs to check!
        for (Cards card :this.allCardsOfPlayer){
            if (card.getClassOfCard().toLowerCase().trim().equals("neutral")){
                NeutralCardsOfPlayer.add(card);

            }
        }
    }

    public void sell(Cards card) throws IOException {
        System.out.println("in sell founc!");
        boolean canSellThisCard=false;
        for (Cards cardInSalableCards:SalableCards){
            if (card.getName().equals(cardInSalableCards.getName())){
                this.money+=card.getMoneyCost();
                CLI.currentPlayer.getLoggerOfMyPlayer().info("Sell: "+card.getName());
                canSellThisCard=true;
                Iterator<Cards> itr =allCardsOfPlayer.iterator();
                while (itr.hasNext()){
                    Cards card1 =itr.next();
                    if (card.getName().equalsIgnoreCase(card1.getName())){
                        itr.remove();
                    }
                }
            }
        }
        if (!canSellThisCard){
            System.out.println("you dont have this card!");
        }
        setAvailableCardsWithThisSituation();
        setSalableCards();
    }

    public void selectHero(Heroes hero) throws IOException {
        if (!hero.getIsLock()){
            this.currentHero=hero;
            setAvailableCardsWithThisSituation();
            CLI.currentPlayer.getLoggerOfMyPlayer().info("Select :" +hero.getName());
        }else {
            System.out.println("Unfortunately this hero is lock for you!");
        }

    }


    public void addToDeck(Cards card) throws IOException {
        int numberOfThisCardInMyDeck=0;
        for (Cards cardsInAvailableDeck:getAvailableDeckWithThisSituation()){
            if (cardsInAvailableDeck.getName().toLowerCase().trim().equalsIgnoreCase(card.getName())){
                numberOfThisCardInMyDeck++;
            }
        }
        if (numberOfThisCardInMyDeck<=1){
            for (Cards cardsInAvailableCardInThisSituation:availableCardsWithThisSituation){
                if (cardsInAvailableCardInThisSituation.getName().equals(card.getName())){
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
            setAvailableCardsThatWeCanAddIntoOurDeck();

        }else {
            System.out.println("You can not have more than 2 same cards!");
        }

    }

    public void removeFromDeck(Cards card) throws IOException {
        boolean isThisCardInMyDeck=false;
        for (Cards cardsInAvailableDeck:getAvailableDeckWithThisSituation()){
            if (cardsInAvailableDeck.getName().toLowerCase().trim().equalsIgnoreCase(card.getName())){
                isThisCardInMyDeck=true;
            }
        }
        if (isThisCardInMyDeck){
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
            setAvailableCardsThatWeCanAddIntoOurDeck();
        }else {
            System.out.println("You don have this card in your deck!");
        }

    }


}