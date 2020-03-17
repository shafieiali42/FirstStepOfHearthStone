package Cards;

import java.util.ArrayList;

public class Cards {

    private String name;
    private int manaCost;
    private String rarity;
    private String description;
    private String classOfCard;
    public int MoneyCost;
    private String type;



    private static ArrayList<Cards> allCards = new ArrayList<Cards>();

    public static ArrayList<Cards> getAllCards() {
        return allCards;
    }
    public static void setAllCards() {
        allCards.addAll(Minion.getMinions());
        allCards.addAll(Spell.getSpells());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getManaCost(){
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


}
