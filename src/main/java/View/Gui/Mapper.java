package View.Gui;

import Logic.PlayLogic.Alliance;
import Models.Cards.Cards;
import Controller.ControllerOfMainComponents;

import View.Gui.Panels.GamePage.GamePage;
import View.Gui.Panels.GamePage.LogPanel;
import View.Gui.Panels.GamePage.PlayPanel;
import Interfaces.Request;
import Logic.PlayLogic.GameState;
import Models.Cards.Weapon;
import Utility.Sounds;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
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
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 7);
            }
        },
        PLAY_CARDS_ONE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 1);
            }
        },
        PLAY_CARDS_TWO {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 2);
            }
        },
        PLAY_CARDS_THREE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 3);
            }
        },
        PLAY_CARDS_FOUR {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 4);
            }
        },
        PLAY_CARDS_FIVE {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 5);
            }
        },
        PLAY_CARDS_SIX {
            @Override
            public void execute() {
                Mapper.getInstance().playCard(GameState.getInstance().getPlayingCard(), 6);
            }
        },
        END_TURN {
            @Override
            public void execute() {
                endTurn();
            }
        };


    }


    public void playCard(Cards playingCard, int k) {
        boolean played = false;
        if (playingCard.getManaCost() > GameState.getInstance().getCurrentPlayer().getMana()) {
            JOptionPane.showMessageDialog(null, "You don't have enough mana");
        } else if (playingCard.getManaCost() <= GameState.getInstance().getCurrentPlayer().getMana()) {


            if (playingCard.getType().equalsIgnoreCase("minion")) {
                if (k != 7) {
                    if (GameState.getInstance().getCurrentPlayer().getBattleGroundCards().size() >= k) {
                        System.out.println(playingCard.getName());
                        ArrayList<Cards> copy = new ArrayList<>(GameState.getInstance().getCurrentPlayer().getBattleGroundCards());
                        GameState.getInstance().getCurrentPlayer().getBattleGroundCards().clear();
                        boolean isAdded = false;
                        for (int j = 0; j < copy.size(); j++) {
                            if (j == (k - 1) && !isAdded) {
                                GameState.getInstance().getCurrentPlayer().getBattleGroundCards().add(playingCard);
                                isAdded = true;
                                j--;
                            } else {
                                GameState.getInstance().getCurrentPlayer().getBattleGroundCards().add(copy.get(j));
                            }
                        }
                        Mapper.getInstance().setAddedBeforeForBeingBetween(true);
                        played = true;
                    }
                } else {
                    GameState.getInstance().getCurrentPlayer().getBattleGroundCards().add(playingCard);
                    Mapper.getInstance().setAddedBeforeForBeingBetween(false);
                    played = true;
                }
//                if (!this.AddedBeforeForBeingBetween) {
//                    GameState.getInstance().getBattleGroundCards().add(playingCard);
//                }
//                this.AddedBeforeForBeingBetween=false;


            } else if (playingCard.getType().equalsIgnoreCase("weapon")) {
                GameState.getInstance().getCurrentPlayer().setCurrentWeapon((Weapon) playingCard);

            } else if (playingCard.getType().contains("Spell")) {
                //TODO PLAY SPELL
            }
            if (played) {
                PlayPanel.getInstance().setNeedAnimation(true);
                PlayPanel.getInstance().repaint();
                PlayPanel.getInstance().revalidate();
                GameState.getInstance().getCurrentPlayer().getHandsCards().remove(playingCard);
                GameState.getInstance().getCurrentPlayer().setMana(GameState.getInstance().getCurrentPlayer().getMana() - playingCard.getManaCost());
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
                ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Play minion");
            }
        }

    }


    public static void endTurn() {
        GameState.getInstance().getCurrentPlayer().setTurn(GameState.getInstance().getCurrentPlayer().getTurn() + 1);
        GameState.getInstance().getCurrentPlayer().setMana((int) Math.min(GameState.getInstance().getCurrentPlayer().getTurn(), 10));
        if(GameState.getInstance().getCurrentAlliance().equals(Alliance.ME)){
            GameState.getInstance().setCurrentPlayer(GameState.getGameState().getEnemyPlayer());
            GameState.getInstance().setCurrentAlliance(Alliance.OPPONENT);
        }else if (GameState.getInstance().getCurrentAlliance().equals(Alliance.OPPONENT)){
            GameState.getInstance().setCurrentPlayer(GameState.getGameState().getFriendlyPlayer());
            GameState.getInstance().setCurrentAlliance(Alliance.ME);
        }
        Collections.shuffle(GameState.getInstance().getCurrentPlayer().getDeckCards());
        if (GameState.getInstance().getCurrentPlayer().getHandsCards().size() < 12) {
            if (GameState.getInstance().getCurrentPlayer().getDeckCards().size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Your deck is empty.\nContinue game with your hand's cards", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                GameState.getInstance().getCurrentPlayer().getHandsCards().add(GameState.getInstance().getCurrentPlayer().getDeckCards().get(0));

//                GameState.getInstance().getEnemyPlayer().getHandsCards().
//                        add(GameState.getInstance().getEnemyPlayer().getDeckCards().get(0));//TODO just for show back of cards
                GameState.getInstance().getCurrentPlayer().getDeckCards().remove(0);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "You can't have more than 12 cards in your hand", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/EndTurn.wav");
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("End turn");
    }


}
