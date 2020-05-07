package Utility.JsonReaders;


import Models.Cards.Minion;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonReaderForMinions {
    public static void main(String args[]) {
        JsonReaderForMinions tester = new JsonReaderForMinions();


        try {
            Minion minion1 = tester.readJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private Minion readJSON() throws JsonParseException, JsonMappingException, IOException{
//        ObjectMapper mapper = new ObjectMapper();
//        Minion minion1=null;
//        for (int i=1;i<=Minion.NUMBER_OF_MINIONS;i++){
//            minion1 = mapper.readValue(new File("MinionSpells\\minion"+i+".json"), Minion.class);
//            Minion.minions.add(minion1);
//        }
//        return minion1;


    private Minion readJSON() throws IOException {
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
