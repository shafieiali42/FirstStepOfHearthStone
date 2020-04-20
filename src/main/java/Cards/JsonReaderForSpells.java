package Cards;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderForSpells {
    public static void main(String args[]) {
        JsonReaderForSpells tester = new JsonReaderForSpells();


        try {
            Spell spell = tester.readJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Spell readJSON() throws IOException {
        Gson gson = new Gson();
        Spell spell1= null;
        // 1. JSON file to Java object

        for (int i = 1; i <= Spell.NUMBER_OF_SPELLS; i++) {
            spell1 = gson.fromJson(new FileReader("MinionSpellsWeapons/Spells\\Spell" + i + ".json"), Spell.class);
            Spell.spells.add(spell1);
        }
        return spell1;
    }
}
