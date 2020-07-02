package Logic.PlayLogic;

import Controller.ControllerOfMainComponents;
import Logic.MyTimer;
import Models.Cards.CardClasses.Cards;
import Models.Heroes.Mage;
import Models.Player.InGamePlayer;

import java.io.IOException;

public class Game {

    private InGamePlayer friendlyPlayer;
    private InGamePlayer enemyPlayer;
    private InGamePlayer currentPlayer;
    private Alliance currentAlliance;
    private Cards playingCard;
    private int gameMode;
    private MyTimer myTimer;



    private static Game game;

    static {
        try {
            game = new Game();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game getInstance() {
        return game;
    }


    public Game() throws IOException {
        myTimer=new MyTimer();
        myTimer.start();
//        initGameState();

    }



    public void initGameState() throws IOException {

        if (gameMode==1){//Normal Game //TODO for next Phase
            DeckReader deckReader =new DeckReader("src/main/resources/DeckReader/DeckReader.properties");
            friendlyPlayer = new InGamePlayer(ControllerOfMainComponents.currentPlayer);
            enemyPlayer = new InGamePlayer();
            enemyPlayer.setHero(Mage.getInstance());
            enemyPlayer.setDeckCards(deckReader.getDeck("ENEMY"));
            enemyPlayer.initHandsCards();
            playingCard = new Cards();
            currentPlayer=friendlyPlayer;
            currentAlliance=Alliance.ME;

        }else if (gameMode==2){//Training Game //TODO has positive point
            DeckReader deckReader =new DeckReader("src/main/resources/DeckReader/DeckReader.properties");
            friendlyPlayer = new InGamePlayer(ControllerOfMainComponents.currentPlayer);
            enemyPlayer = new InGamePlayer();
            enemyPlayer.setHero(Mage.getInstance());
            enemyPlayer.setDeckCards(deckReader.getDeck("ENEMY"));
            playingCard = new Cards();
            currentPlayer=friendlyPlayer;
            currentAlliance=Alliance.ME;

        } else if (gameMode == 3) {//DeckReader
            DeckReader deckReader =new DeckReader("src/main/resources/DeckReader/DeckReader.properties");
            friendlyPlayer =new InGamePlayer();
            friendlyPlayer.setDeckCards(deckReader.getDeck("FRIEND"));
            friendlyPlayer.setHero(Mage.getInstance());
            friendlyPlayer.initPassiveToChoose();
            friendlyPlayer.initHandsCards();
            enemyPlayer = new InGamePlayer();
            enemyPlayer.setDeckCards(deckReader.getDeck("ENEMY"));
            enemyPlayer.setHero(Mage.getInstance());
            enemyPlayer.initHandsCards();
            playingCard = new Cards();
            currentPlayer=friendlyPlayer;
            currentAlliance=Alliance.ME;

        }else if (gameMode==4){//Two Player Game
            friendlyPlayer = new InGamePlayer(ControllerOfMainComponents.currentPlayer);
            enemyPlayer = new InGamePlayer();
            enemyPlayer.setHero(Mage.getInstance());
            DeckReader deckReader =new DeckReader("src/main/resources/DeckReader/DeckReader.properties");
            enemyPlayer.setDeckCards(deckReader.getDeck("ENEMY"));
            enemyPlayer.initHandsCards();
            playingCard = new Cards();
            currentPlayer=friendlyPlayer;
            currentAlliance=Alliance.ME;
        }

    }

    public void changeAlliance(){
        if (currentAlliance.equals(Alliance.ME)) {
            currentAlliance=Alliance.OPPONENT;
        }else{
            currentAlliance=Alliance.ME;
        }
    }


    public int getGameMode() {
        return gameMode;
    }
    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
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

    public MyTimer getMyTimer() {
        return myTimer;
    }

    public void setMyTimer(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

}
