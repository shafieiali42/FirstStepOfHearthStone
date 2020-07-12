package Models.Cards.CardClasses;

import java.util.ArrayList;

public class Weapon extends Cards {

    public static final int NUMBER_OF_Weapons =3;
    private int attackPower;
    private int durability;
    private boolean hasAttackInThisTurn = false;
    static ArrayList<Weapon> weapons=new ArrayList<Weapon>();

    public Weapon()  {
        super();
    }


    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public static ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    public static void setWeapons(ArrayList<Weapon> weapons) {
        Weapon.weapons = weapons;
    }
    public boolean isHasAttackInThisTurn() {
        return hasAttackInThisTurn;
    }
    public void setHasAttackInThisTurn(boolean hasAttackInThisTurn) {
        this.hasAttackInThisTurn = hasAttackInThisTurn;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+"Durability: "+durability+" attack: "+attackPower;
    }

}
