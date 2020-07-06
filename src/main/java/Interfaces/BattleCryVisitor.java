package Interfaces;

import Controller.Administer;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;

import java.util.ArrayList;

public class BattleCryVisitor implements Visitor {


    //Neutrals
    //**********

    @Override
    public void visit(TombWarden tombWarden, ArrayList<Minion> battleGround) {

        if (battleGround.size() < 7) {
            Minion minion = tombWarden.copy();
            battleGround.add(minion);
            Administer.refreshPlayPanel();
        } else {
            System.out.println("Battlecry of TombWarden cant execute because we have 7 cards in battleGround:))");
        }


    }


    @Override
    public void visit(CurioCollector curioCollector){}

    @Override
    public void visit(Sathrovarr sathrovarr) {
    }

    @Override
    public void visit(SecurityRover securityRover) {
    }

    @Override
    public void visit(BookOfSpecters bookOfSpecters) {

    }

    @Override
    public void visit(PharaohsBlessing pharaohsBlessing) {

    }

    @Override
    public void visit(Sprint sprint) {

    }

    @Override
    public void visit(SwarmOfLocusts swarmOfLocusts) {

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


    //Specials
    //**********

    @Override
    public void visit(Polymorph polymorph) {

    }

    @Override
    public void visit(FriendlySmith friendlySmith) {

    }

    @Override
    public void visit(Dreadscale dreadscale) {

    }

    @Override
    public void visit(SwampKingDred swampKingDred) {

    }

    @Override
    public void visit(HighPriestAmet highPriestAmet) {

    }


}
