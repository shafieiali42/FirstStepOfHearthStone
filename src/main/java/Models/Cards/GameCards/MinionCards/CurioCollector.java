package Models.Cards.GameCards.MinionCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Minion;


public class CurioCollector extends Minion {


    public CurioCollector() {

    }

    @Override
    public void accept(Visitor visitor){
        visitor.Visit(this);
    }


}
