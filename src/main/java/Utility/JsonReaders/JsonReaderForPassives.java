package Utility.JsonReaders;

import Interfaces.Serializer;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Passive;
import Models.Cards.GameCards.MinionCards.MinionNames;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.Passives.*;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReaderForPassives implements Serializer {


    @Override
    public void serialize() {
        setMap();
        JsonReaderForPassives tester = new JsonReaderForPassives();

        try {
            setPassiveCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String,Class> map=new HashMap<>();

    private static void setMap() {
        map.put("FreePower", FreePower.class);
        map.put("ManaJump", ManaJump.class);
        map.put("Nurse", Nurse.class);
        map.put("OffCards", OffCards.class);
        map.put("TwiceDraw", TwiceDraw.class);
    }

//    public static void main(String args[]) {
//        setMap();
//        JsonReaderForPassives tester = new JsonReaderForPassives();
//
//
//        try {
//            setPassiveCards();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            Passive passive1 = tester.readJSON();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//
//
//    }


    private static void setPassiveCards() throws FileNotFoundException {
        Gson gson=new Gson();
        for (PassiveNames passiveNames:PassiveNames.values()){
            Class classOfCard = map.get(passiveNames.name());
            System.out.println(passiveNames.name());
            Passive passive =(Passive) gson.fromJson(new FileReader("MinionSpellsWeapons/PassiveCards/"+passiveNames.name()+".json"),classOfCard);
            Passive.getPassives().add(passive);
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
