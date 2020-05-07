package Utility.JsonReaders;

import Models.Cards.Passive;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonReaderForPassives {

    public static void main(String args[]) {
        JsonReaderForPassives tester = new JsonReaderForPassives();


        try {
            Passive passive1 = tester.readJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Passive readJSON() throws IOException {
        Gson gson = new Gson();
        Passive passive1 = null;
        // 1. JSON file to Java object

        for (int i = 1; i <= Passive.NUMBER_OF_PASSIVES; i++) {
            passive1 = gson.fromJson(new FileReader("MinionSpellsWeapons/InfoPassive/Passive" + i + ".json"), Passive.class);
            Passive.getPassives().add(passive1);
        }
        return passive1;
    }


}
