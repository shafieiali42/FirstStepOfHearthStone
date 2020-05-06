package Gui;

import Cards.Cards;
import Cards.*;
import CommandLineInterface.CLI;
import Gui.Panels.GamePage.GamePage;
import Gui.Panels.GamePage.LogPanel;
import Gui.Panels.GamePage.PlayPanel;
import Interfaces.Request;
import Logic.GameState;
import Utility.Sounds;
import jdk.nashorn.internal.scripts.JO;

import javax.sound.midi.Soundbank;
import javax.swing.*;
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
        if (playingCard.getManaCost() > GameState.getInstance().getMana()) {
            JOptionPane.showMessageDialog(null, "You don't have enough mana");
        } else if (playingCard.getManaCost() <= GameState.getInstance().getMana()) {
            GameState.getInstance().getHandsCards().remove(playingCard);
            if (playingCard.getType().equalsIgnoreCase("minion")) {
                GameState.getInstance().getBattleGroundCards().add(playingCard);

            } else if (playingCard.getType().equalsIgnoreCase("weapon")) {
                GameState.getInstance().setCurrentWeapon((Weapon)playingCard);

            }else if (playingCard.getType().contains("Spell")){
                //TODO PLAY SPELL
            }
            GameState.getInstance().setMana(GameState.getInstance().getMana() - playingCard.getManaCost());
        }

        StringBuilder addToLog = new StringBuilder(LogPanel.getInstance().getLog() + "Play");
        for (int i = 0; i < playingCard.getName().length(); i++) {
            char c = playingCard.getName().charAt(i);
            if (Character.isUpperCase(c)) {
                addToLog.append("\n");
                addToLog.append(c);
            } else {
                addToLog.append(c);
            }
        }
        LogPanel.getInstance().setLog(addToLog.toString() + "\n\n");
        LogPanel.getInstance().repaint();
        LogPanel.getInstance().revalidate();
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/PlayCards.wav");
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Play minion");
    }


    public static void endTurn() {
        GameState.getInstance().setTurn(GameState.getInstance().getTurn() + 1);
        GameState.getInstance().setMana((int) Math.min(GameState.getInstance().getTurn(), 10));
        Collections.shuffle(GameState.getInstance().getCardsOfDeckInGameState());
        if (GameState.getInstance().getHandsCards().size() < 12) {
            if (GameState.getInstance().getCardsOfDeckInGameState().size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Your deck is empty.\nContinue game with your hand's cards", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                GameState.getInstance().getHandsCards().add(GameState.getInstance().getCardsOfDeckInGameState().get(0));
                GameState.getInstance().getCardsOfDeckInGameState().remove(0);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "You can't have more than 12 cards in your hand", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/EndTurn.wav");
        CLI.currentPlayer.getLoggerOfMyPlayer().info("End turn");
    }


}
