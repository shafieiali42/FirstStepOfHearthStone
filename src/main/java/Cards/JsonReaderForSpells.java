package Cards;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderForSpells {


    public static void main(String args[]){

        JsonReaderForSpells tester = new JsonReaderForSpells();
        ObjectMapper mapper = new ObjectMapper();

        try{
            Spell spell1 = tester.readJSON();

        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
//        System.out.println(Spell.spells);
    }
    private Spell readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Spell spell1=null;
        for (int i=1;i<=Spell.NUMBER_OF_SPELLS;i++){
            spell1 = mapper.readValue(new File("MinionSpells\\Spell"+i+".json"), Spell.class);
            Spell.spells.add(spell1);
        }
        return spell1;
    }
}
