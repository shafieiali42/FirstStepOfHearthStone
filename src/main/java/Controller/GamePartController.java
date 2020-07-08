package Controller;

import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;

public class GamePartController {


    private static Cards giveCardWithName(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                return cards;
            }
        }
        return null;
    }


    public static int giveWeaponDurability(String alliance) {

        if (alliance.equalsIgnoreCase("FRIENDLY")) {
            return Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getDurability();

        } else if (alliance.equalsIgnoreCase("ENEMY")) {
            return Game.getInstance().getEnemyPlayer().getCurrentWeapon().getDurability();
        }
        return -555555;
    }

    public static int giveWeaponAttackPower(String alliance) {
        if (alliance.equalsIgnoreCase("FRIENDLY")) {
            return Game.getInstance().getFriendlyPlayer().getCurrentWeapon().getAttackPower();

        } else if (alliance.equalsIgnoreCase("ENEMY")) {
            return Game.getInstance().getEnemyPlayer().getCurrentWeapon().getAttackPower();
        }
        return -555555;
    }

    public static int giveMinionHpWithName(int numberOfCardInBattleGround, String alliance) {
        if (alliance.equalsIgnoreCase("FRIENDLY")) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getHealthPower();

        } else if (alliance.equalsIgnoreCase("ENEMY")) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getHealthPower();
        }

//        for (Cards cards : Game.getInstance().getFriendlyPlayer().getBattleGroundCards()) {
//            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
//                Minion minion=(Minion)cards;
//                return minion.getHealthPower();
//            }
//        }
        return -55555555;
    }

    public static int giveMinionAttackWithName(int numberOfCardInBattleGround, String alliance) {

        if (alliance.equalsIgnoreCase("FRIENDLY")) {
            return Game.getInstance().getFriendlyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getAttackPower();

        } else if (alliance.equalsIgnoreCase("ENEMY")) {
            return Game.getInstance().getEnemyPlayer().getBattleGroundCards().get(numberOfCardInBattleGround - 1).getAttackPower();
        }

//        for (Cards cards : Cards.getAllCards()) {
//            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
//                Minion minion=(Minion)cards;
//                return minion.getAttackPower();
//            }
//        }
        return -66666666;
    }

    public static int giveMinionHpWithName(String cardName) {


        for (Cards cards : Game.getInstance().getFriendlyPlayer().getBattleGroundCards()) {
            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
                Minion minion = (Minion) cards;
                return minion.getHealthPower();
            }
        }
        return -5555555;
    }

    public static int giveMinionAttackWithName(String cardName) {

        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
                Minion minion = (Minion) cards;
                return minion.getAttackPower();
            }
        }
        return -66666666;
    }


}
