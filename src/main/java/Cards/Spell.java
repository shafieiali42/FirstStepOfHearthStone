package Cards;

import java.io.IOException;
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

    public Spell() throws IOException {
        super();
    }



    @Override
    public String toString(){
        return "["+"Name: "+this.getName()+" ,  classOfCard: "+ this.getClassOfCard()+" , Money"+this.getMoneyCost()+" ]";
    }
}
