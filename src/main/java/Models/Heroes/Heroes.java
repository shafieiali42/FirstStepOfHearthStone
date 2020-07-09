package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.HeroPower.HeroPower;

import java.util.ArrayList;

public  class Heroes {

    public Heroes() {

    }

    public void print(){
        System.out.println("Heroes");
    }

    private String name;
    private int healthPower;
    private int attackPower;
    private int firstHealthPower;
    private String description;
    private ArrayList<Cards> DeckOfHero = new ArrayList<Cards>();
    private boolean isLock;
    private int shield;
    private boolean canBeAttacked = true;
    private HeroPower heroPower;


    public int getFirstHealthPower() {
        return firstHealthPower;
    }

    public void setFirstHealthPower(int firstHealthPower) {
        this.firstHealthPower = firstHealthPower;
    }

    public HeroPower getHeroPower() {
          return heroPower;
     }

     public void setHeroPower(HeroPower heroPower) {
          this.heroPower = heroPower;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public boolean isLock() {
          return isLock;
     }

     public void setLock(boolean lock) {
          isLock = lock;
     }

     public boolean isCanBeAttacked() {
          return canBeAttacked;
     }

     public boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(boolean lock) {
        isLock = lock;
    }

    public ArrayList<Cards> getDeckOfHero() {
        return DeckOfHero;
    }

    public void setDeckOfHero(ArrayList<Cards> deckOfHero) {
        DeckOfHero = deckOfHero;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ Name: " + this.getName() + ", healthPower: " + this.healthPower + "]";
    }

    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }


}
