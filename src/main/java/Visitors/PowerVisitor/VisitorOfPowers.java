package Visitors.PowerVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.*;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;

import java.util.ArrayList;

public interface VisitorOfPowers {

    void visit(MageHeroPower mageHeroPower);
    void visit(RogueHeroPower rogueHeroPower,
               InGamePlayer player,
               ArrayList<Minion>friendlyBattleGround,
               ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
               ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
               ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero);
    void visit(WarlockHeroPower warlockHeroPower);
    void visit(HunterHeroPower hunterHeroPower);
    void visit(PriestHeroPower priestHeroPower);


}
