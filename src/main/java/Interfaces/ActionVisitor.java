package Interfaces;

import Models.Cards.GameCards.MinionCards.CurioCollector;

public class ActionVisitor implements Visitor {


    @Override
    public void Visit(CurioCollector curioCollector) {
        System.out.println("Action of CurioCollector");
    }




}
