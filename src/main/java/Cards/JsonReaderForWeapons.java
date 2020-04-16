package Cards;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderForWeapons {
    public static void main(String args[]){
        JsonReaderForWeapons tester = new JsonReaderForWeapons();
        ObjectMapper mapper = new ObjectMapper();

        try{
            Weapon weapon1 = tester.readJSON();
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
    private Weapon readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Weapon weapon1 =null;
        for (int i=1;i<=Weapon.NUMBER_OF_Weapons;i++){
            weapon1 = mapper.readValue(new File("MinionSpells\\weapon"+i+".json"), Weapon.class);
            Weapon.weapons.add(weapon1);
        }
        return weapon1;
    }
}
