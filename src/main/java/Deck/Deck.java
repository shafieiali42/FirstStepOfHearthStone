package Deck;

import Cards.Cards;
import Gui.Panels.CollectionPages.LittleCardPanel;
import Heroes.Heroes;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck implements Comparable<Deck> {

    private String name;
    private String heroName;
    private Heroes hero;
    private int numberOfWins;
    private int numberOfUses;
    private static final int MAX_CAPACITY_OF_DECK = 30;
    private ArrayList<Cards> listOfCards;
    private Cards mostUsedCard;
    private int manaAvg;

    private transient ArrayList<LittleCardPanel> littleCardPanelsOfThisDeck=LittleCardPanel.getAllLittleCardPanels();
//    private HashMap<String, Integer> usesHashMap =new HashMap<String, Integer>();



    public ArrayList<LittleCardPanel> getLittleCardPanelsOfThisDeck() {
        return littleCardPanelsOfThisDeck;
    }
    public void setLittleCardPanelsOfThisDeck(ArrayList<LittleCardPanel> littleCardPanelsOfThisDeck) {
        this.littleCardPanelsOfThisDeck = littleCardPanelsOfThisDeck;
    }

    public static int getMaxCapacityOfDeck() {
        return MAX_CAPACITY_OF_DECK;
    }

    public int getManaAvg() {
        return manaAvg;
    }

    public void setManaAvg() {
        int sum = 0;
        for (Cards card : listOfCards) {
            sum += card.getManaCost();
        }
        manaAvg = sum / listOfCards.size();
    }



    public Deck(){

        this.listOfCards = new ArrayList<Cards>();
    }

    public Deck(String name, String heroName) {
        this.name = name;
        this.heroName = heroName;
        this.numberOfWins = 0;
        this.numberOfUses = 0;
        this.listOfCards = new ArrayList<Cards>();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Heroes getHero() {
        return hero;
    }

    public void setHero(Heroes hero) {
        this.hero = hero;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int wins) {
        this.numberOfWins = wins;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public ArrayList<Cards> getListOfCards() {
        return listOfCards;
    }

    public void setListOfCards(ArrayList<Cards> listOfCards) {
        this.listOfCards = listOfCards;
    }

    public Cards getMostUsedCard() {
        return mostUsedCard;
    }

    public void setMostUsedCard(Cards mostUsedCard) {
        this.mostUsedCard = mostUsedCard;
    }


    @Override
    public int compareTo(Deck deck) {
        double a = (double) this.numberOfWins / this.numberOfUses;
        double b = (double) deck.numberOfWins / deck.numberOfUses;
        if (a < b) {
            return 1;
        } else if (a > b) {
            return -1;
        } else if (a == b) {
            if (this.numberOfWins < deck.numberOfWins) {
                return 1;
            } else if (this.numberOfWins > deck.numberOfWins) {
                return -1;
            } else if (this.numberOfWins == this.numberOfUses) {
                if (this.numberOfUses < deck.numberOfUses) {
                    return 1;
                } else if (this.numberOfUses > deck.numberOfUses) {
                    return -1;
                } else if (this.numberOfUses == this.numberOfUses) {
                    if (this.manaAvg < deck.manaAvg) {
                        return 1;
                    } else if (this.manaAvg > deck.manaAvg) {
                        return -1;
                    } else if (this.manaAvg == deck.manaAvg) {
                        return 1; // todo every thing is equal:))
                    }
                }
            }
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        Deck deck =(Deck) obj;
        return this.name.equals(deck.name);
    }

    @Override
    public String toString() {
        return "Deck Name: "+this.name +"Deck Hero: "+this.hero+" cards: "+this.listOfCards;
    }
}
