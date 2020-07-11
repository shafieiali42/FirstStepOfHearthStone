package Visitors.PassiveVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Player.InGamePlayer;

import java.util.ArrayList;

public interface PassiveVisitable {

    void accept(PassiveVisitor passiveVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                ArrayList<Cards>friendlyHandCards, ArrayList<Cards>friendlyDeckCards);

}
