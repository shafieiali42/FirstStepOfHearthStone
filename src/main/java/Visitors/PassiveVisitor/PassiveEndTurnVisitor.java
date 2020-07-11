package Visitors.PassiveVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.Passives.*;
import Models.Player.InGamePlayer;
import View.Gui.Mapper;

import java.util.ArrayList;
import java.util.Random;

public class PassiveEndTurnVisitor implements PassiveVisitor {
    @Override
    public void visit(FreePower freePower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {

    }

    @Override
    public void visit(OffCards offCards, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {

    }

    @Override
    public void visit(TwiceDraw twiceDraw, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {

    }

    @Override
    public void visit(ManaJump manaJump, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {
        player.setMana(Math.min(player.getMana() + 1, 10));
    }

    @Override
    public void visit(Nurse nurse, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> friendlyDeckCards) {

        ArrayList<Minion> minions = new ArrayList<>();
        for (Minion minion : friendlyBattleGround) {
            if (minion.getHealthPower() < minion.getFirstHealthPower()) {
                minions.add(minion);
            }
        }
        Random random = new Random();
        if (minions.size() > 0) {
            int randomIndex = random.nextInt(minions.size());
            minions.get(randomIndex).setHealthPower(minions.get(randomIndex).getFirstHealthPower());
        }
    }
}
