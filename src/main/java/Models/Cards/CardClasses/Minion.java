package Models.Cards.CardClasses;

//import Models.Cards;

import java.util.ArrayList;

public class Minion extends Cards {

    public static final int NUMBER_OF_MINIONS = 16;
    private static ArrayList<Minion> minions = new ArrayList<Minion>();


    private int attackPower;
    private int healthPower;
    private boolean active=true;
    private boolean canBeAttacked=true; // if we have taunt and it is not taunt then this field would be false:))
    private boolean taunt =false;
    private boolean hasAttackInThisTurn=false;

    public Minion() {
        super();
    }


    @Override
    public Minion copy(){
        System.out.println("Copy of Minion:))");
        Minion copy =new Minion();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.attackPower=this.attackPower;
        copy.healthPower=this.healthPower;
        copy.active=this.active;
        copy.canBeAttacked=this.canBeAttacked;
        copy.taunt=this.taunt;
        copy.hasAttackInThisTurn=this.hasAttackInThisTurn;
        return copy;
    }


    //Getter and Setter
    //*****************
    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getHealthPower() {
        return healthPower;
    }
    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }
    public static ArrayList<Minion> getMinions() {
        return minions;
    }
    public boolean getIsActive() {
        return active;
    }
    public void setIsActive(boolean active) {
        this.active = active;
    }
    public boolean getCanBeAttacked() {
        return canBeAttacked;
    }
    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }
    public boolean getIsTaunt() {
        return taunt;
    }
    public void setIsTaunt(boolean taunt) {
        this.taunt = taunt;
    }
    public boolean getHasAttackInThisTurn() {
        return hasAttackInThisTurn;
    }
    public void setHasAttackInThisTurn(boolean hasAttackInThisTurn) {
        this.hasAttackInThisTurn = hasAttackInThisTurn;
    }

    @Override
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money" + this.getMoneyCost() + " ]";
    }

//    @Override
//    public int getHp() {
//        return healthPower;
//    }
//
//    @Override
//    public int getAttack() {
//        return attackPower;
//    }
//
//    @Override
//    public void setHp(int hp) {
//        this.healthPower = hp;
//    }
//
//    @Override
//    public void setAttack(int attack) {
//        this.attackPower = attack;
//    }
}
