package Interfaces;

import Models.Cards.GameCards.MinionCards.CurioCollector;
import Models.Cards.GameCards.MinionCards.Sathrovarr;
import Models.Cards.GameCards.MinionCards.SecurityRover;
import Models.Cards.GameCards.MinionCards.TombWarden;

public class ActionVisitor implements Visitor {


    @Override
    public void Visit(CurioCollector curioCollector) {
        System.out.println("Action of CurioCollector");



    }

    @Override
    public void visit(Sathrovarr sathrovarr) {

    }

    @Override
    public void visit(SecurityRover securityRover) {

    }

    @Override
    public void visit(TombWarden tombWarden) {

    }


}
