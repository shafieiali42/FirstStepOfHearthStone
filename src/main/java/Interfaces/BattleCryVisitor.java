package Interfaces;

import Models.Cards.GameCards.MinionCards.CurioCollector;
import Models.Cards.GameCards.MinionCards.Sathrovarr;
import Models.Cards.GameCards.MinionCards.SecurityRover;
import Models.Cards.GameCards.MinionCards.TombWarden;

public class BattleCryVisitor implements Visitor {

    @Override
    public void Visit(CurioCollector curioCollector) {} //dont have battleCry

    @Override
    public void visit(Sathrovarr sathrovarr) {}

    @Override
    public void visit(SecurityRover securityRover) {

    }

    @Override
    public void visit(TombWarden tombWarden) {

    }


}
