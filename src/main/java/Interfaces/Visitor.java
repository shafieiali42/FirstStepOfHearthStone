package Interfaces;

import Models.Cards.GameCards.MinionCards.CurioCollector;

public interface Visitor {

    void Visit(CurioCollector curioCollector);
}
