package Cards;

import java.util.ArrayList;


public class Spell extends Cards {

    public static final int NUMBER_OF_SPELLS=10;
    static ArrayList<Spell> spells=new ArrayList<Spell>();


    public static ArrayList<Spell> getSpells() {
        return spells;
    }
    public static void setSpells(ArrayList<Spell> spells) {
        Spell.spells = spells;
    }


    @Override
    public String toString(){
        return "Minion [ name: "+getName()+", manaCost: "+ getManaCost()+ ",rarity"+getRarity()+
                ",description:"+getDescription()+",classOfCard"+getClassOfCard()+"]";
    }
}
