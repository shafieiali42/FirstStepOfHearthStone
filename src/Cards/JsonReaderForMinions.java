package Cards;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderForMinions {


    public static void main(String args[]){

        JsonReaderForMinions tester = new JsonReaderForMinions();
        ObjectMapper mapper = new ObjectMapper();

        try{
            Minion minion1 = tester.readJSON();
//            minions.add(minion1);
//            System.out.println(minion1);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
//        System.out.println(Minion.minions);
    }
    private Minion readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Minion minion1=null;
        for (int i=1;i<=Minion.NUMBER_OF_MINIONS;i++){
            minion1 = mapper.readValue(new File("minion"+i+".json"), Minion.class);
            Minion.minions.add(minion1);
        }
        return minion1;
    }
}
