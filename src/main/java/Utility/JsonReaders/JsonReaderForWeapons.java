package Utility.JsonReaders;

import Models.Cards.Weapon;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReaderForWeapons {
    public static void main(String args[]) {

            JsonReaderForWeapons tester = new JsonReaderForWeapons();


            try {
                Weapon weapon1 = tester.readJSON();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
        private Weapon readJSON() throws FileNotFoundException {
            Gson gson = new Gson();
            Weapon weapon1 = null;
            // 1. JSON file to Java object
            for (int i = 1; i <= Weapon.NUMBER_OF_Weapons; i++) {
                weapon1 = gson.fromJson(new FileReader("MinionSpellsWeapons/Weapons\\Weapon" + i + ".json"), Weapon.class);
                Weapon.getWeapons().add(weapon1);
            }
            return weapon1;
        }
}
