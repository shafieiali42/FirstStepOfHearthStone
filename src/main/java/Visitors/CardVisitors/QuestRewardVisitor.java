package Visitors.CardVisitors;

import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;
import Models.Heroes.Heroes;

import java.util.ArrayList;
import java.util.Random;

public class QuestRewardVisitor implements Visitor {

    @Override
    public void visit(CurioCollector curioCollector) {

    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

    }

    @Override
    public void visit(SecurityRover securityRover) {

    }

    @Override
    public void visit(TombWarden tombWarden, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BookOfSpecters bookOfSpecters, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards) {

    }

    @Override
    public void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target, String alliance) {

    }

    @Override
    public void visit(Sprint sprint) {

    }

    @Override
    public void visit(Ashbringer ashbringer) {

    }

    @Override
    public void visit(BattleAxe battleAxe) {

    }

    @Override
    public void visit(Gearblade gearblade) {

    }

    @Override
    public void visit(SwarmOfLocusts swarmOfLocusts, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Locusts locusts, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Dragon dragon) {

    }

    @Override
    public void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target, String alliance) {

    }

    @Override
    public void visit(FriendlySmith friendlySmith, ArrayList<Cards> deckCards) {

    }

    @Override
    public void visit(Dreadscale dreadscale) {

    }

    @Override
    public void visit(SwampKingDred swampKingDred) {

    }

    @Override
    public void visit(HighPriestAmet highPriestAmet, Minion summonedMinion) {

    }

    @Override
    public void visit(LearnDarconic learnDarconic, ArrayList<Minion> battleGround,Cards playingCard) {

        Game.getInstance().getCurrentPlayer().setQuestCard(learnDarconic);

        if (playingCard.getType().equalsIgnoreCase("Spell")) {
            learnDarconic.setManaSpendForQuest(learnDarconic.getManaSpendForQuest() + playingCard.getManaCost());
        }

        if (learnDarconic.getManaSpendForQuest() >= 8) {
            Dragon dragon = null;
            for (Cards card : Cards.getAllCards()) {
                if (card.getName().equalsIgnoreCase("Dragon")) {
                    dragon = (Dragon) card;
                }
            }
            battleGround.add(dragon.copy());
        }


    }

    @Override
    public void visit(StrengthInNumbers strengthInNumbers, ArrayList<Minion> battleGround,
                      ArrayList<Cards> deckCards, Cards playingCard) {


        if (playingCard.getType().equalsIgnoreCase("Minion")) {
            strengthInNumbers.setManaSpendForQuest(strengthInNumbers.getManaSpendForQuest() + playingCard.getManaCost());
        }

        if (strengthInNumbers.getManaSpendForQuest() >= 10) {
            if (deckCards.size()>0){
                ArrayList<Minion>minions=new ArrayList<>();
                for (Cards card:deckCards){
                    if (card.getType().equalsIgnoreCase("Minion")){
                        minions.add((Minion)card);
                    }
                }

                Random random=new Random();
                int randomIndex=random.nextInt(battleGround.size());
                Minion minion=minions.get(randomIndex);
                battleGround.add(minion);
                deckCards.remove(minion);
            }

        }
    }


}