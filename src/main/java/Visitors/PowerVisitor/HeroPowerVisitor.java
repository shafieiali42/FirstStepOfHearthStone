package Visitors.PowerVisitor;

import Controller.Administer;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.*;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;

import java.util.ArrayList;
import java.util.Random;

public class HeroPowerVisitor implements VisitorOfPowers {


    @Override
    public void visit(MageHeroPower mageHeroPower) {

    }

    @Override
    public void visit(RogueHeroPower rogueHeroPower,
                      InGamePlayer player,
                      ArrayList<Minion> friendlyBattleGround,
                      ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                      ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                      ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {

        Random random=new Random();

        if (player.getCurrentWeapon()!=null){
            int randomIndexForDeck=random.nextInt(enemyDeckCards.size());
            int randomIndexForHand=random.nextInt(enemyHandsCards.size());
            Cards cardInDeck =enemyDeckCards.get(randomIndexForDeck);
            Cards cardsInHands=enemyHandsCards.get(randomIndexForHand);
            enemyDeckCards.remove(randomIndexForDeck);
            enemyHandsCards.remove(randomIndexForHand);
            friendlyHandCards.add(cardInDeck);
            friendlyHandCards.add(cardsInHands);
            Administer.refreshPlayPanel();
        }else{
            int randomIndex=random.nextInt(enemyDeckCards.size());
            Cards card =enemyDeckCards.get(randomIndex);
            enemyDeckCards.remove(randomIndex);
            friendlyHandCards.add(card);
            Administer.refreshPlayPanel();
        }


    }

    @Override
    public void visit(WarlockHeroPower warlockHeroPower) {

    }

    @Override
    public void visit(HunterHeroPower hunterHeroPower) {

    }

    @Override
    public void visit(PriestHeroPower priestHeroPower) {

    }
}
