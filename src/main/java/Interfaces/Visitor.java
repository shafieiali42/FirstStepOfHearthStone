package Interfaces;

import Models.Cards.GameCards.MinionCards.CurioCollector;
import Models.Cards.GameCards.MinionCards.Sathrovarr;
import Models.Cards.GameCards.MinionCards.SecurityRover;
import Models.Cards.GameCards.MinionCards.TombWarden;

public interface Visitor {

    void Visit(CurioCollector curioCollector);
    void visit(Sathrovarr sathrovarr);
    void visit(SecurityRover securityRover);
    void visit(TombWarden tombWarden);


}
