package Models.Cards.CardClasses;

import java.io.IOException;
import java.util.ArrayList;

public class Weapon extends Cards {

    public static final int NUMBER_OF_Weapons =3;
    private int attackPower;
    private int useAmount;
    static ArrayList<Weapon> weapons=new ArrayList<Weapon>();

    public Weapon() throws IOException {
        super();
    }


    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getUseAmount() {
        return useAmount;
    }
    public void setUseAmount(int useAmount) {
        this.useAmount = useAmount;
    }
    public static ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    public static void setWeapons(ArrayList<Weapon> weapons) {
        Weapon.weapons = weapons;
    }





    @Override
    public String toString(){
        return "";
    }

}
