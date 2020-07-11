package Visitors.PassiveVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.Passives.*;
import Models.Player.InGamePlayer;

import java.util.ArrayList;

public class InfoPassiveVisitor implements PassiveVisitor {


    @Override
    public void visit(FreePower freePower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {
        player.getHero().getHeroPower().setMana(player.getHero().getHeroPower().getMana() - 1);
        player.getHero().getHeroPower().setNumberOfPermitUse(player.getHero().getHeroPower().getNumberOfPermitUse() + 1);
    }

    @Override
    public void visit(OffCards offCards, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {
        for (Cards card : friendlyDeckCards) {
            card.setManaCost(card.getManaCost() - 1);
        }
        for (Cards card : friendlyHandCards) {
            card.setManaCost(card.getManaCost() - 1);
        }
    }


    @Override
    public void visit(TwiceDraw twiceDraw, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {
        player.setNumberOfDrawCard(2);
    }

    @Override
    public void visit(ManaJump manaJump, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {
        player.setMana(2);

    }

    @Override
    public void visit(Nurse nurse, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {

    }

}
