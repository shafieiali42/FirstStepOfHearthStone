package Models.Cards;

import java.io.IOException;
import java.util.ArrayList;

public class Spell extends Cards {

    public static final int NUMBER_OF_SPELLS = 18;



     static ArrayList<Spell> spells = new ArrayList<Spell>();
     static ArrayList<Spell> questAndRewardCards = new ArrayList<Spell>();


    public static void defineQuestAndRewardCardList() {
        for (Spell spell : spells) {
            if (spell.getType().contains("QuestAndReward")) {
                questAndRewardCards.add(spell);
            }
        }
    }

    public static ArrayList<Spell> getQuestAndRewardCards() {
        return questAndRewardCards;
    }

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
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money" + this.getMoneyCost() + " ]";
    }
}
