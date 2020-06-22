package Models.Cards;


//import Utility.ImageOfAllCards;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;

public class Cards implements Comparable<Cards> {

    @Expose(serialize = false, deserialize = true)
    private String name;
    @Expose(serialize = false, deserialize = true)
    private int manaCost;
    @Expose(serialize = false, deserialize = true)
    private String rarity;
    @Expose(serialize = false, deserialize = true)
    private String description;
    @Expose(serialize = false, deserialize = true)
    private String classOfCard;
    @Expose(serialize = false, deserialize = true)
    public int MoneyCost;
    @Expose(serialize = false, deserialize = true)
    private String type;
    @Expose(serialize = false, deserialize = false)
    private  transient int rarityInt;

    @Expose(serialize = false, deserialize = false)
    private static ArrayList<Cards> allCards = new ArrayList<Cards>();

    public static ArrayList<Cards> getAllCards() {
        return allCards;
    }


    public Cards() throws IOException {

    }


    public static void setAllCards() throws IOException {
        allCards.addAll(Minion.getMinions());
        allCards.addAll(Spell.getSpells());
        allCards.addAll(Weapon.getWeapons());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getClassOfCard() {
        return classOfCard;
    }

    public void setClassOfCard(String classOfCard) {
        this.classOfCard = classOfCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoneyCost() {
        return MoneyCost;
    }

    public void setMoneyCost(int moneyCost) {
        MoneyCost = moneyCost;
    }


    public void defineRarityInt(){
        if (rarity.equalsIgnoreCase("common")){
            rarityInt=0;
        }else if (rarity.equalsIgnoreCase("rare")){
            rarityInt=1;
        }else if (rarity.equalsIgnoreCase("epic")) {
            rarityInt =2;
        }else if (rarity.equalsIgnoreCase("legendary")) {
            rarityInt =3;
        }
    }

    @Override
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money: " + this.getMoneyCost() + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        Cards card = (Cards) obj;
        if (this.getName().equals(card.getName())) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public int compareTo(Cards card) {
        defineRarityInt();
        if (this.rarityInt<card.rarityInt){
            return 1;
        }else if (this.rarityInt>card.rarityInt){
            return -1;
        }else if (this.manaCost<card.manaCost){
            return 1;
        }else if (this.manaCost>card.manaCost){
            return -1;
        }else if (card.type.equalsIgnoreCase("minion")&& !this.type.equalsIgnoreCase("minion")){
            return 1;
        }else if (!card.type.equalsIgnoreCase("minion")&& this.type.equalsIgnoreCase("minion")){
            return -1;
        }else {
            return 1;// todo every thing is equal:))
        }
    }
}
