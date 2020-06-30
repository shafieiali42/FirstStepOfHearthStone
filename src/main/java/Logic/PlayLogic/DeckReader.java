package Logic.PlayLogic;

import Models.Cards.Cards;

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
            for (Cards cards : Cards.getAllCards()) {
                if (cards.getName().equalsIgnoreCase(cardName)) {
                    deckCards.add(cards);
                }
            }
        }
        return deckCards;
    }


}
