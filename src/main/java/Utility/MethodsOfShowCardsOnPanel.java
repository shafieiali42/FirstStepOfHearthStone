package Utility;

import Models.Cards.Cards;
import View.CardView.CardImagePanel;
import View.Gui.Panels.CollectionPages.LittleCardPanel;
import View.Gui.Panels.GamePage.PlayPanel;
import Logic.PlayLogic.Alliance;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    //this method used to show cards in shop and collection pages :))
    public static void showCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow) throws IOException {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 10;
        int xSapce = 170;
        int ySpace = 10;

        for (Cards card : cards) {

            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card.getName());

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSapce;
            }
        }
    }


    public static void showBackOfEnemyHandsCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow, int typeOfBackOfCard) throws IOException {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSapce = 20;
        int ySpace = 10;


        yCoordinate = 10;
        for (Cards card : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(Alliance.OPPONENT, PlayPanel.getInstance().getWidthOfEachCardHandsCards(),
                    PlayPanel.getInstance().getHeightOfEachCardHandsCards(), typeOfBackOfCard);

            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSapce + PlayPanel.getInstance().getWidthOfEachCardHandsCards();
            }
        }

    }

    public static void showEnemyHandsCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow) throws IOException {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSpace = 20;
        int ySpace = 10;
        yCoordinate = 15;
        for (Cards card : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card.getName(), PlayPanel.getInstance().getWidthOfEachCardHandsCards(),
                    PlayPanel.getInstance().getHeightOfEachCardHandsCards());

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSpace + PlayPanel.getInstance().getWidthOfEachCardHandsCards();
            }
        }

    }
    public static void showFriendlyHandsCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow) throws IOException {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSpace = 20;
        int ySpace = 10;
        yCoordinate = 690;
        for (Cards card : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card.getName(), PlayPanel.getInstance().getWidthOfEachCardHandsCards(),
                    PlayPanel.getInstance().getHeightOfEachCardHandsCards());

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSpace + PlayPanel.getInstance().getWidthOfEachCardHandsCards();
            }
        }

    }




    public static void showBattleGroundCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow, Alliance alliance) throws IOException { //TODO init X and Y coordinate:((

        int counter = 0;
        int xCoordinate = 50;
        int yCoordinate = 0;
        if (alliance.equals(Alliance.ME)) {
            yCoordinate = 395;
        } else if (alliance.equals(Alliance.OPPONENT)) {
            yCoordinate = 385 - 10 - PlayPanel.getInstance().getHeightOfEachCardGamePanel();
        }
        int xSapce = 50;
        int ySpace = 10;

        for (Cards card : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card.getName(), PlayPanel.getInstance().getWidthOfEachCardGamePanel(),
                    PlayPanel.getInstance().getHeightOfEachCardGamePanel());
            cardImagePanel.repaint();
            cardImagePanel.revalidate();

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

//            System.out.println("X: "+xCoordinate+" Y: "+yCoordinate);

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 100;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSapce + PlayPanel.getInstance().getWidthOfEachCardGamePanel();
            }
        }
    }





    public static void addPanel(JPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }

    public static void addPanel(LittleCardPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }


}
