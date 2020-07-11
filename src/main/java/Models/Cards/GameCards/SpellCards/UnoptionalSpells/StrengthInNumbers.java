package Models.Cards.GameCards.SpellCards.UnoptionalSpells;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;
import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public class StrengthInNumbers extends Spell {

    public StrengthInNumbers() {
        setManaNeededForQuest(10);
    }


    @Override
    public StrengthInNumbers copy() {
        System.out.println("Copy of StrengthInNumbers:))");
        StrengthInNumbers copy = new StrengthInNumbers();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.setAbilities(this.getAbilities());
        copy.setManaNeededForQuest(this.getManaNeededForQuest());
        return copy;
    }


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,
                       ArrayList<Cards> deckCards, Minion target, Heroes targetHero,
                       Minion summonedMinion, Cards playingCard, String alliance) {

        visitor.visit(this, battleGround, deckCards, playingCard);
    }


}
