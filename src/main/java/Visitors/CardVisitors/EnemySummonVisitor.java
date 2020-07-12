package Visitors.CardVisitors;

import Controller.Administer;
import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;

import java.util.ArrayList;

public class EnemySummonVisitor implements Visitor {

    @Override
    public void visit(CurioCollector curioCollector) {

    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

    }

    @Override
    public void visit(SecurityRover securityRover, ArrayList<Minion> battleGround, Minion target) {

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
    public void visit(SwampKingDred swampKingDred,Minion playingCard) {

        System.out.println(playingCard.getName());
        System.out.println(playingCard.getHealthPower());
        swampKingDred.setHealthPower(swampKingDred.getHealthPower()-playingCard.getAttackPower());
        playingCard.setHealthPower(playingCard.getHealthPower()-swampKingDred.getAttackPower());
        System.out.println("After: "+playingCard.getHealthPower());
        Administer.refreshPlayPanel();
        System.out.println(Game.getInstance().getEnemyPlayer().getBattleGroundCards());
        Administer.removeDeadCharacters();



    }

    @Override
    public void visit(HighPriestAmet highPriestAmet, Minion summonedMinion) {

    }

    @Override
    public void visit(LearnDarconic learnDarconic, ArrayList<Minion> battleGround, Cards playingCard) {

    }

    @Override
    public void visit(StrengthInNumbers strengthInNumbers, ArrayList<Minion> battleGround, ArrayList<Cards> deckCards, Cards playingCard) {

    }

    @Override
    public void visit(Mech mech, ArrayList<Minion> battleGround) {

    }
}
