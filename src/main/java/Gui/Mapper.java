package Gui;

import Cards.Cards;
import Gui.Panels.GamePage.PlayPanel;
import Interfaces.Request;
import Logic.GameState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Mapper {

    private static Mapper mapper = new Mapper();

    public static Mapper getInstance() {
        return mapper;
    }

    private ArrayList<Request> requests;


    private Mapper() {
        requests = new ArrayList<Request>();
    }

    public void addRequest(RequestTypes requestType) {
        if (requestType != null)
            requests.add(requestType);
    }

    public void executeRequests() {
        for (Iterator<Request> requestIterator = requests.iterator(); requestIterator.hasNext(); ) {
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
            PlayPanel.getInstance().setNeedsToRepaint(true);
        }
    }

    public enum RequestTypes implements Request {

        PLAY_CARDS {
            @Override
            public void execute() {
                playCard(GameState.getInstance().getPlayingCard());
            }
        },
        END_TURN {
            @Override
            public void execute() {
                endTurn();
            }
        };

    }

    public static void playCard(Cards playingCard) {
        GameState.getInstance().getHandsCards().remove(playingCard);
        GameState.getInstance().getBattleGroundCards().add(playingCard);
        GameState.getInstance().setMana(GameState.getInstance().getMana() - playingCard.getManaCost());
    }


    public static void endTurn() {
        GameState.getInstance().setTurn(GameState.getInstance().getTurn() + 1);
        GameState.getInstance().setMana((int) Math.min(GameState.getInstance().getTurn(), 10));
        Collections.shuffle(GameState.getInstance().getDeck().getListOfCards());
        GameState.getInstance().getHandsCards().add(GameState.getInstance().getDeck().getListOfCards().get(0));
        if (GameState.getInstance().getDeck().getUsesHashMap().get(GameState.getInstance().getDeck().getListOfCards().get(0).getName()) == 2) {
            GameState.getInstance().getDeck().getUsesHashMap().replace(GameState.getInstance().getDeck().getListOfCards().get(0).getName(), 1);
        } else {
            GameState.getInstance().getDeck().getListOfCards().remove(GameState.getInstance().getDeck().getListOfCards().get(0));
        }

    }


}
