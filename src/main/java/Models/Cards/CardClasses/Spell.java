package Models.Cards.CardClasses;

import java.util.ArrayList;

public class Spell extends Cards {

    public static final int NUMBER_OF_SPELLS = 18;
    static ArrayList<Spell> spells = new ArrayList<Spell>();
    static ArrayList<Spell> questAndRewardCards = new ArrayList<Spell>();


    private int manaSpendForQuest=0;
    private int manaNeededForQuest=0;
    private int increaseHp=0;

    public int getIncreaseHp() {
        return increaseHp;
    }

    public void setIncreaseHp(int increaseHp) {
        this.increaseHp = increaseHp;
    }

    public int getManaNeededForQuest() {
        return manaNeededForQuest;
    }

    public void setManaNeededForQuest(int manaNeededForQuest) {
        this.manaNeededForQuest = manaNeededForQuest;
    }

    public int getManaSpendForQuest() {
        return manaSpendForQuest;
    }
    public void setManaSpendForQuest(int manaSpendForQuest) {
        this.manaSpendForQuest = manaSpendForQuest;
    }

    private ArrayList<SpellAbility> abilities=new ArrayList<>();

    public ArrayList<SpellAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<SpellAbility> abilities) {
        this.abilities = abilities;
    }

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

    public Spell() {
        super();
    }


    @Override
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money" + this.getMoneyCost() + " ]";
    }


}
