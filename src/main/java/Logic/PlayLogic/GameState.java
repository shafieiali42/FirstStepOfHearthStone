package Logic.PlayLogic;

import Controller.ControllerOfMainComponents;
import Models.Cards.Cards;
import Models.Player.InGamePlayer;
import Models.Player.Player;

import java.io.IOException;

public class GameState {

    private InGamePlayer friendlyPlayer;
    private InGamePlayer enemyPlayer;
    private InGamePlayer currentPlayer;
    private Alliance currentAlliance;
    private Cards playingCard;


    private static GameState gameState;

    static {
        try {
            gameState = new GameState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameState getInstance() {
        return gameState;
    }


    public GameState() throws IOException {
        initGameState();
    }


    public void initGameState() throws IOException {
        friendlyPlayer = new InGamePlayer(ControllerOfMainComponents.currentPlayer);
        enemyPlayer = new InGamePlayer();
        playingCard = new Cards();
        currentPlayer=friendlyPlayer;
        currentAlliance=Alliance.ME;


    }


    public Cards getPlayingCard() {
        return playingCard;
    }
    public void setPlayingCard(Cards playingCard) {
        this.playingCard = playingCard;
    }

    public InGamePlayer getFriendlyPlayer() {
        return friendlyPlayer;
    }

    public void setFriendlyPlayer(InGamePlayer friendlyPlayer) {
        this.friendlyPlayer = friendlyPlayer;
    }

    public InGamePlayer getEnemyPlayer() {
        return enemyPlayer;
    }

    public void setEnemyPlayer(InGamePlayer enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
    }

    public InGamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(InGamePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Alliance getCurrentAlliance() {
        return currentAlliance;
    }

    public void setCurrentAlliance(Alliance currentAlliance) {
        this.currentAlliance = currentAlliance;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        GameState.gameState = gameState;
    }
}
