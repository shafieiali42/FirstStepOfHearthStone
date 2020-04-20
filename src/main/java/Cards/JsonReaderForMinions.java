package Cards;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
             minion1 = gson.fromJson(new FileReader("MinionSpells\\minion" + i + ".json"), Minion.class);
            Minion.minions.add(minion1);
        }
        return minion1;
    }
}
