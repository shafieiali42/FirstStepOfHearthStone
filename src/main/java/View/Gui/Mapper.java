package View.Gui;

import Logic.PlayLogic.Alliance;
import Models.Cards.CardClasses.Cards;
import Controller.ControllerOfMainComponents;

import Models.Cards.CardClasses.Minion;
import View.Gui.Panels.GamePage.LogPanel;
import View.Gui.Panels.GamePage.PlayPanel;
import Interfaces.Request;
import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Weapon;
import Utility.Sounds;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Mapper {

    private static Mapper mapper = new Mapper();
    private boolean AddedBeforeForBeingBetween = false;

    public boolean isAddedBeforeForBeingBetween() {
        return AddedBeforeForBeingBetween;
    }

    public void setAddedBeforeForBeingBetween(boolean addedBeforeForBeingBetween) {
        AddedBeforeForBeingBetween = addedBeforeForBeingBetween;
    }

    public static Mapper getInstance() {
        return mapper;
    }

    private ArrayList<Request> requests;
    private Cards cards;

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

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
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 7);
            }
        },
        PLAY_CARDS_ONE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 1);
            }
        },
        PLAY_CARDS_TWO {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 2);
            }
        },
        PLAY_CARDS_THREE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 3);
            }
        },
        PLAY_CARDS_FOUR {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 4);
            }
        },
        PLAY_CARDS_FIVE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 5);
            }
        },
        PLAY_CARDS_SIX {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(Game.getInstance().getPlayingCard(), 6);
            }
        },
        END_TURN {
            @Override
            public void execute() {
                endTurn();
            }
        };


    }


    private static void writeOnLogPanel(String playingCardName) {
        StringBuilder addToLog = new StringBuilder(LogPanel.getInstance().getLog() + "Play");
        for (int i = 0; i < playingCardName.length(); i++) {
            char c = playingCardName.charAt(i);
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
    }

    public static void playCard(Cards playingCard) {
        Game.getInstance().getCurrentPlayer().setMana(Game.getInstance().getCurrentPlayer().getMana() - playingCard.getManaCost());
        PlayPanel.getInstance().setNeedAnimation(true);
        PlayPanel.getInstance().repaint();
        PlayPanel.getInstance().revalidate();
        Game.getInstance().getCurrentPlayer().getHandsCards().remove(playingCard);
        writeOnLogPanel(playingCard.getName());
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/PlayCards.wav");
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Play" + playingCard.getType());
    }

    public void playCard(Cards playingCard, int k) {
        if (playingCard.getManaCost() > Game.getInstance().getCurrentPlayer().getMana()) {
            JOptionPane.showMessageDialog(null, "You don't have enough mana");
        } else if (playingCard.getManaCost() <= Game.getInstance().getCurrentPlayer().getMana()) {
            if (playingCard.getType().equalsIgnoreCase("minion")) {
                playMinion((Minion) playingCard, k);
            } else if (playingCard.getType().equalsIgnoreCase("weapon")) {
                playWeapon(playingCard);
            } else if (playingCard.getType().contains("Spell")) {
                playSpell(playingCard);
            }
        }
    }


    public static void drawCard() {
        if (Game.getInstance().getCurrentPlayer().getHandsCards().size() < 12) {
            if (Game.getInstance().getCurrentPlayer().getDeckCards().size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Your deck is empty.\nContinue game with your hand's cards", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Game.getInstance().getCurrentPlayer().getHandsCards().add(Game.getInstance().getCurrentPlayer().getDeckCards().get(0));

                Game.getInstance().getCurrentPlayer().getDeckCards().remove(0);
            }
        } else {
            Game.getInstance().getCurrentPlayer().getDeckCards().remove(0);
            JOptionPane.showMessageDialog(null,
                    "You can't have more than 12 cards in your hand", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void nextTurn() {
        Game.getInstance().getMyTimer().reStart();
        Game.getInstance().getCurrentPlayer().setTurn(Game.getInstance().getCurrentPlayer().getTurn() + 1);
        Game.getInstance().getCurrentPlayer().setMana((int) Math.min(Game.getInstance().getCurrentPlayer().getTurn(), 10));
        if (Game.getInstance().getCurrentAlliance().equals(Alliance.ME)) {
            Game.getInstance().setCurrentPlayer(Game.getInstance().getEnemyPlayer());
            Game.getInstance().setCurrentAlliance(Alliance.OPPONENT);
        } else if (Game.getInstance().getCurrentAlliance().equals(Alliance.OPPONENT)) {
            Game.getInstance().setCurrentPlayer(Game.getInstance().getFriendlyPlayer());
            Game.getInstance().setCurrentAlliance(Alliance.ME);
        }
    }

    public static void endTurn() {
        nextTurn();
        drawCard();
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/EndTurn.wav");
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("End turn");
    }


    public static void playMinion(Minion playingCard, int k) {
        boolean minionPlayed = false;
        if (k != 7) {
            if (Game.getInstance().getCurrentPlayer().getBattleGroundCards().size() >= k) {
                ArrayList<Minion> copy = new ArrayList<>(Game.getInstance().getCurrentPlayer().getBattleGroundCards());
                Game.getInstance().getCurrentPlayer().getBattleGroundCards().clear();
                boolean isAdded = false;
                for (int j = 0; j < copy.size(); j++) {
                    if (j == (k - 1) && !isAdded) {
                        Game.getInstance().getCurrentPlayer().getBattleGroundCards().add(playingCard);
                        isAdded = true;
                        j--;
                    } else {
                        Game.getInstance().getCurrentPlayer().getBattleGroundCards().add(copy.get(j));
                    }
                }
                Mapper.getInstance().setAddedBeforeForBeingBetween(true);
                minionPlayed = true;
            }
        } else {
            Game.getInstance().getCurrentPlayer().getBattleGroundCards().add(playingCard);
            Mapper.getInstance().setAddedBeforeForBeingBetween(false);
            minionPlayed = true;
        }
        if (minionPlayed) {
            playCard(playingCard);
        }
    }

    public static void playSpell(Cards playingCard) {
        playCard(playingCard);
    }

    public static void playWeapon(Cards playingCard) {
        Game.getInstance().getCurrentPlayer().setCurrentWeapon((Weapon) playingCard);
        playCard(playingCard);
    }


}
