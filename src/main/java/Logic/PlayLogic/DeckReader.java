package Logic.PlayLogic;

import Models.Cards.CardClasses.Cards;

import Models.Cards.GameCards.SpellCards.UnoptionalSpells.StrengthInNumbers;
import Utility.Config2.ConfigLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class DeckReader {

    String path;
    Properties properties;

    public DeckReader(String path) {
        this.path = path;
        try {
            properties = ConfigLoader.getInstance().readProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Cards> getDeck(String alliance) {
        ArrayList<String> cardNames = new ArrayList<>(Arrays.asList(properties.getProperty(alliance).toString().split(",")));
        ArrayList<Cards> deckCards = new ArrayList<>();
        for (String cardName : cardNames) {


            if (cardName.contains(">")){

                int index = cardName.indexOf(">");
//                String questName=cardName.substring(0,index-2).trim();
                String rewardName=cardName.substring(index+1).trim();
                Cards reward = null;
                for (Cards cards:Cards.getAllCards()){
                    if (cards.getName().equalsIgnoreCase(rewardName)){
                        reward=cards;
                    }
                }

                for (Cards card:Cards.getAllCards()){
                    if (card.getName().equalsIgnoreCase("StrengthInNumbers")){
                        StrengthInNumbers strengthInNumbers=(StrengthInNumbers)card;
                        strengthInNumbers.setReward(reward);
                        deckCards.add(strengthInNumbers.copy());
                    }
                }
            }

            for (Cards cards : Cards.getAllCards()) {
                if (cards.getName().equalsIgnoreCase(cardName)) {
                    deckCards.add(cards.copy());
                }
            }
        }
//        System.out.println("*******************************");
        System.out.println("DeckReader: "+deckCards);
        return deckCards;
    }


}
