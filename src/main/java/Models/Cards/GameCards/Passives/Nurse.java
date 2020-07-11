package Models.Cards.GameCards.Passives;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Passive;
import Models.Player.InGamePlayer;
import Visitors.PassiveVisitor.PassiveVisitor;

import java.util.ArrayList;

public class Nurse extends Passive {


    @Override
    public void accept(PassiveVisitor passiveVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                       ArrayList<Cards>friendlyHandCards, ArrayList<Cards>friendlyDeckCards) {
            passiveVisitor.visit(this,player,friendlyBattleGround,friendlyHandCards,friendlyDeckCards);
    }
}
