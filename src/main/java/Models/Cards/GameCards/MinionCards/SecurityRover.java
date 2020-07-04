package Models.Cards.GameCards.MinionCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Minion;

public class SecurityRover extends Minion {


    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }


}
