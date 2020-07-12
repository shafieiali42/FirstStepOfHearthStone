package Utility.JsonReaders;


import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReaderForMinions {


    private static HashMap<String,Class> map=new HashMap<>();

    private static void setMap(){
        map.put("CurioCollector", CurioCollector.class);
        map.put("Dreadscale", Dreadscale.class);
        map.put("HighPriestAmet", HighPriestAmet.class);
        map.put("Sathrovarr", Sathrovarr.class);
        map.put("SecurityRover", SecurityRover.class);
        map.put("SwampKingDred", SwampKingDred.class);
        map.put("TombWarden", TombWarden.class);
        map.put("Locusts",Locusts.class);
        map.put("Dragon",Dragon.class);
        map.put("Mech",Mech.class);
    }

    public static void main(String args[]) {
        setMap();
        JsonReaderForMinions tester = new JsonReaderForMinions();

        try {
            setMinionCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            Minion minion1 = tester.readJson();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


    private static void setMinionCards() throws FileNotFoundException {
        Gson gson=new Gson();
        for (MinionNames minionNames:MinionNames.values()){
            Class classOfCard = map.get(minionNames.name());
//            System.out.println(minionNames.name());
            Minion minion =(Minion) gson.fromJson(new FileReader("MinionSpellsWeapons/MinionCards/"+minionNames.name()+".json"),classOfCard);
            Minion.getMinions().add(minion);
        }

    }


    private Minion readJson() throws IOException {
        Gson gson = new Gson();
        Minion minion1 = null;
        // 1. JSON file to Java object

        for (int i = 1; i <= Minion.NUMBER_OF_MINIONS; i++) {
             minion1 = gson.fromJson(new FileReader("MinionSpellsWeapons/Minions\\minion" + i + ".json"), Minion.class);
            Minion.getMinions().add(minion1);
        }
        return minion1;
    }

}
