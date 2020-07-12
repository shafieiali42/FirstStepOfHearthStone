package Utility.JsonReaders;

import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;
import Models.Cards.GameCards.WeaponCards.WeaponNames;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReaderForWeapons {

    private static HashMap<String,Class> map=new HashMap<>();

    private static void setMap(){
        map.put("Gearblade", Gearblade.class);
        map.put("Ashbringer", Ashbringer.class);
        map.put("BattleAxe", BattleAxe.class);
    }

    public static void main(String args[]) {
        setMap();
        JsonReaderForWeapons tester = new JsonReaderForWeapons();


        try {
            setWeaponCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//            try {
//                Weapon weapon1 = tester.readJSON();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


    }


    private static void setWeaponCards() throws FileNotFoundException {
        Gson gson=new Gson();
        for (WeaponNames weaponNames:WeaponNames.values()){
            Class classOfCard = map.get(weaponNames.name());
            Weapon weapon =(Weapon) gson.fromJson(new FileReader("MinionSpellsWeapons/WeaponCards/"+weaponNames.name()+".json"),classOfCard);
            Weapon.getWeapons().add(weapon);
        }

    }

    private Weapon readJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Weapon weapon1 = null;
        // 1. JSON file to Java object
        for (int i = 1; i <= Weapon.NUMBER_OF_Weapons; i++) {
            weapon1 = gson.fromJson(new FileReader("MinionSpellsWeapons/Weapons/Weapon" + i + ".json"), Weapon.class);
            Weapon.getWeapons().add(weapon1);
        }
        return weapon1;
    }
}
