package Utility.JsonReaders;

import Models.Cards.CardClasses.Spell;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReaderForSpells {

    private static HashMap<String,Class> map=new HashMap<>();

    private static void setMap(){
        map.put("BookOfSpecters", BookOfSpecters.class);
        map.put("FriendlySmith", FriendlySmith.class);
        map.put("PharaohsBlessing", PharaohsBlessing.class);
        map.put("Polymorph", Polymorph.class);
        map.put("Sprint", Sprint.class);
        map.put("SwarmOfLocusts", SwarmOfLocusts.class);
        map.put("LearnDarconic", LearnDarconic.class);
        map.put("StrengthInNumbers", StrengthInNumbers.class);
        map.put("BiologyProject", BiologyProject.class);
        map.put("BlessingOfTheAncients", BlessingOfTheAncients.class);
        map.put("BloodfuryPotion", BloodfuryPotion.class);
        map.put("Caltrops", Caltrops.class);
        map.put("Heal", Heal.class);
        map.put("Moonfire", Moonfire.class);
        map.put("Naturalize", Naturalize.class);
        map.put("SinisterStrike", SinisterStrike.class);
        map.put("Starfire", Starfire.class);
        map.put("TreeOfLife", TreeOfLife.class);
    }

    public static void main(String args[]) {
        setMap();
        JsonReaderForSpells tester = new JsonReaderForSpells();

        try {
            setSpellCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            Spell spell = tester.readJSON();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void setSpellCards() throws FileNotFoundException {
        Gson gson=new Gson();
        for (SpellNames spellNames:SpellNames.values()){
            Class classOfCard = map.get(spellNames.name());
//            System.out.println(spellNames.name()+"nnnnnnnnnnnnn");
            Spell spell =(Spell)gson.fromJson(new FileReader("MinionSpellsWeapons/SpellCards/"+spellNames.name()+".json"),classOfCard);
            Spell.getSpells().add(spell);
        }
    }


    private Spell readJSON() throws IOException {
        Gson gson = new Gson();
        Spell spell1= null;
        // 1. JSON file to Java object

        for (int i = 1; i <= Spell.NUMBER_OF_SPELLS; i++) {
            spell1 = gson.fromJson(new FileReader("MinionSpellsWeapons/Spells\\Spell" + i + ".json"), Spell.class);
            Spell.getSpells().add(spell1);
        }
        return spell1;
    }


}
