package Interfaces;

import Controller.Administer;
import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;

import java.util.ArrayList;
import java.util.Iterator;

public class EndTurnVisitor implements Visitor {


    @Override
    public void visit(CurioCollector curioCollector) {

    }

    @Override
    public void visit(Sathrovarr sathrovarr) {

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
    public void visit(PharaohsBlessing pharaohsBlessing) {

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
    public void visit(Polymorph polymorph,ArrayList<Minion> battleGround,Minion target) {

    }

    @Override
    public void visit(FriendlySmith friendlySmith) {

    }

    @Override
    public void visit(Dreadscale dreadscale) {

        Iterator<Minion> itr = Game.getInstance().getFriendlyPlayer().getBattleGroundCards().iterator();

        while (itr.hasNext()){
            Minion minion = itr.next();
            if (!minion.equals(dreadscale)) {
                minion.setHealthPower(minion.getHealthPower() - 1);
            }
            Administer.removeDeadCharacters();
        }
//        for (Minion minion : Game.getInstance().getFriendlyPlayer().getBattleGroundCards()) {
//            if (!minion.equals(dreadscale)) {
//                minion.setHealthPower(minion.getHealthPower() - 1);
//                Administer.removeDeadCharacters();
//            }
//        }

        Iterator<Minion> itr2 = Game.getInstance().getEnemyPlayer().getBattleGroundCards().iterator();
        while (itr2.hasNext()){
            Minion minion = itr2.next();
            if (!minion.equals(dreadscale)) {
                minion.setHealthPower(minion.getHealthPower() - 1);
            }
            Administer.removeDeadCharacters();
        }
//        for (Minion minion : Game.getInstance().getEnemyPlayer().getBattleGroundCards()) {
//            if (!minion.equals(dreadscale)) {
//                minion.setHealthPower(minion.getHealthPower() - 1);
//                Administer.removeDeadCharacters();
//            }
//        }


    }

    @Override
    public void visit(SwampKingDred swampKingDred) {

    }

    @Override
    public void visit(HighPriestAmet highPriestAmet, Minion summonedMinion) {

    }


}
