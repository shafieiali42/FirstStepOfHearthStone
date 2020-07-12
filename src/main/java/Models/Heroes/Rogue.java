package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.RogueHeroPower;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.SpVisitor.SpVisitor;

import java.util.ArrayList;

public class Rogue extends Heroes {

    private static final ArrayList<Cards> specialCardsOfRogue = new ArrayList<Cards>();


    public Rogue() {
        this.setName("Rogue");
        this.setHealthPower(30);
        this.setDescription("He is a thief and most of his abilities are in stealing from the enemy!");
        this.setIsLock(false);
        this.setHeroPower(new RogueHeroPower());
        initSpecialCardsOfRogue();
    }


    public static void initSpecialCardsOfRogue() {
        for (Cards card : Cards.getAllCards()) {
            boolean isDuplicated = false;
            for (Cards cardInSpecialCardsOfRogue : specialCardsOfRogue) {
                if (card.getName().equals(cardInSpecialCardsOfRogue.getName())) {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                if (card.getClassOfCard().toLowerCase().trim().equals("rogue")) {
                    specialCardsOfRogue.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfRogue() {
        return specialCardsOfRogue;
    }

    @Override
    public void accept(SpVisitor spVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {
        spVisitor.visit(this, player, friendlyBattleGround, enemyBattleGround, friendlyHandCards,
                enemyHandsCards, friendlyDeckCards, enemyDeckCards, target, targetHero, summoned);
    }
}
