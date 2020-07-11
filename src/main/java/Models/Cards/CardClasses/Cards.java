package Models.Cards.CardClasses;


import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitable;
import Visitors.CardVisitors.Visitor;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public  class Cards implements Comparable<Cards> , Visitable, Cloneable {

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
    public int moneyCost;
    @Expose(serialize = false, deserialize = true)
    private String type;
    @Expose(serialize = false, deserialize = false)
    private  transient int rarityInt;
    @Expose(serialize = false,deserialize =false)
    private transient boolean isPlayed =false;

    public boolean isPlayed() {
        return isPlayed;
    }
    public void setIsPlayed(boolean played) {
        isPlayed = played;
    }

    @Expose(serialize = false, deserialize = false)
    private static ArrayList<Cards> allCards = new ArrayList<Cards>();

    public static ArrayList<Cards> getAllCards() {
        return allCards;
    }


    public Cards()  {

    }


    public static void setAllCards() {
        allCards.addAll(Minion.getMinions());
        allCards.addAll(Spell.getSpells());
        allCards.addAll(Weapon.getWeapons());
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
        return this.getName().equals(card.getName());
    }



    public Cards copy(){
        System.out.println("Copy in Cards:))");
        Cards copy =new Cards();
        copy.name=this.name;
        copy.manaCost=this.manaCost;
        copy.rarity=this.rarity;
        copy.description=this.description;
        copy.classOfCard=this.classOfCard;
        copy.type=this.type;
        copy.rarityInt=this.rarityInt;
        copy.isPlayed=this.isPlayed;
        return copy;
    }


//    @Override
//    public Cards clone() throws CloneNotSupportedException {
//        return (Cards) super.clone();
//    }

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

    //getter,setter
    //*************
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
        return moneyCost;
    }
    public void setMoneyCost(int moneyCost) {
        this.moneyCost = moneyCost;
    }



    public void accept(Visitor visitor,ArrayList<Minion>battleGround,ArrayList<Cards> handsCards,
                       ArrayList<Cards>deckCards,Minion target,Heroes targetHero,Minion summonedMinion,Cards playingCard,String alliance){

    }





}
