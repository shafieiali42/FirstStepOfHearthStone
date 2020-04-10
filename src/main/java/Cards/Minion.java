package Cards;

import java.util.ArrayList;

public class Minion extends Cards {

    public static final int NUMBER_OF_MINIONS=10;
    private int attackPower;
    private int healthPower;
    static ArrayList<Minion> minions=new ArrayList<Minion>();

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower){
        this.attackPower=attackPower;
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

    @Override
    public String toString(){
        return "["+"Name: "+this.getName()+" ,  classOfCard: "+ this.getClassOfCard()+" , Money"+this.getMoneyCost()+" ]";
    }

}
