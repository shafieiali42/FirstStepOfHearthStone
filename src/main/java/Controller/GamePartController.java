package Controller;

import Logic.PlayLogic.GameState;
import Models.Cards.Cards;
import Models.Cards.Minion;
import View.Gui.Mapper;

import java.util.ArrayList;

public class GamePartController {


    private static Cards giveCardWithName(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName)) {
                return cards;
            }
        }
        return null;
    }

    public static int giveMinionHpWithName(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
                Minion minion=(Minion)cards;
                return minion.getHealthPower();
            }
        }
        return -5;
    }

    public static int giveMinionAttackWithName(String cardName) {
        for (Cards cards : Cards.getAllCards()) {
            if (cards.getName().equals(cardName) && cards.getType().equalsIgnoreCase("minion")) {
                Minion minion=(Minion)cards;
                return minion.getAttackPower();
            }
        }
        return -6;
    }



}
