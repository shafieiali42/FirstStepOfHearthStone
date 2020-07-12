package Models.Player;

import Models.Cards.CardClasses.Cards;
import Models.Deck.Deck;
import Models.Heroes.*;
import Utility.Log.*;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Player {

    @Expose(serialize = true, deserialize = true)
    private String userName;
    @Expose(serialize = true, deserialize = true)
    private String passWord;
    @Expose(serialize = true, deserialize = true)
    private String SignInOrSignup;
    @Expose(serialize = true, deserialize = true)
    private int money;
    @Expose(serialize = true, deserialize = true)
    private  Mage mage;
    @Expose(serialize = true, deserialize = true)
    private  Rogue rogue;
    @Expose(serialize = true, deserialize = true)
    private   Warlock warlock;
    @Expose(serialize = true, deserialize = true)
    private  Hunter hunter;
    @Expose(serialize = true, deserialize = true)
    private  Priest priest;
    @Expose(serialize = true, deserialize = true)
    private Heroes currentHero;
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Heroes> availableHeroes = new ArrayList<Heroes>();
    @Expose(serialize = false, deserialize = false)
    private transient Logger loggerOfMyPlayer;
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Cards> allCardsOfPlayer = new ArrayList<Cards>();
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Cards> SalableCards = new ArrayList<Cards>();
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Cards> BuyableCards = new ArrayList<Cards>();
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Cards> lockCards = new ArrayList<Cards>();//TODO needs to be init:))
    @Expose(serialize = true, deserialize = true)
    private ArrayList<Deck> allDecksOfPlayer = new ArrayList<Deck>();
    @Expose(serialize = true, deserialize = true)
    private Deck currentDeck;


    public Player(String userName, String passWord) throws IOException {
        this.userName = userName;
        this.passWord = passWord;
        this.mage=new Mage();
        this.rogue=new Rogue();
        this.warlock=new Warlock();
        this.hunter=new Hunter();
        this.priest=new Priest();
        this.currentHero=this.mage;
        this.availableHeroes.add(mage);
        this.availableHeroes.add(rogue);
        this.availableHeroes.add(warlock);
        this.availableHeroes.add(hunter);
        this.availableHeroes.add(priest);
        this.defineFirstCardsForPlayer();
        setLoggerOfMyPlayer();
        this.money = 500;
        currentDeck = new Deck();
    }


    public void defineFirstCardsForPlayer() {
        int i = 0;
        for (Cards card : Cards.getAllCards()) {
            if (i < 9) {
                if (card.getClassOfCard().toLowerCase().trim().equals("neutral")) {
                    allCardsOfPlayer.add(card);
                    i++;
                }
            } else {
                break;
            }
        }

        if (Mage.getSpecialCardsOfMage().size() != 0) {
            allCardsOfPlayer.add(Mage.getSpecialCardsOfMage().get(0));
        }
    }


    //getter and setters
    //**********************


    public ArrayList<Cards> getSalableCards() {
        return SalableCards;
    }

    public Deck getCurrentDeck() {
        return currentDeck;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getSignInOrSignup() {
        return SignInOrSignup;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Cards> getBuyableCards() {
        return BuyableCards;
    }

    public ArrayList<Deck> getAllDecksOfPlayer() {
        return allDecksOfPlayer;
    }

    public ArrayList<Cards> getLockCards() {
        return lockCards;
    }

    public ArrayList<Cards> getAllCardsOfPlayer() {
        return allCardsOfPlayer;
    }

    public Logger getLoggerOfMyPlayer() {
        return loggerOfMyPlayer;
    }

    public Heroes getCurrentHero() {
        return currentHero;
    }

    public ArrayList<Heroes> getAvailableHeroes() {
        return availableHeroes;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvailableHeroes(ArrayList<Heroes> availableHeroes) {
        this.availableHeroes = availableHeroes;
    }
    public void setSignInOrSignup(String signInOrSignup) {
        this.SignInOrSignup = signInOrSignup;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setLoggerOfMyPlayer() throws IOException {
        this.loggerOfMyPlayer = LoggerOfProject.getMyLogger("logs/" + this.getUserName() + ".log");
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }

    public Mage getMage() {
        return mage;
    }

    public void setMage(Mage mage) {
        this.mage = mage;
    }

    public Rogue getRogue() {
        return rogue;
    }

    public void setRogue(Rogue rogue) {
        this.rogue = rogue;
    }

    public Warlock getWarlock() {
        return warlock;
    }

    public void setWarlock(Warlock warlock) {
        this.warlock = warlock;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public void setHunter(Hunter hunter) {
        this.hunter = hunter;
    }

    public Priest getPriest() {
        return priest;
    }

    public void setPriest(Priest priest) {
        this.priest = priest;
    }

    public void setCurrentHero(Heroes currentHero) {
        this.currentHero = currentHero;
    }
}
