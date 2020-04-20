package Utility;

import Cards.Cards;
import Cards.CardImagePanel;
import Gui.Panels.CollectionPages.CardPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    public static void showCards(ArrayList<Cards> cards, JPanel panel,int numOfCardInEveryRow) throws IOException { //TODO init X and Y coordinate:((
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 10;
        int xSapce = 170;
        int ySpace = 190;
        for (Cards card : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card);
            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidthOfCardImage(),
                    cardImagePanel.getHEIGHTOfCardImage());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += CardImagePanel.getHEIGHTOfCardImage() + ySpace;
            } else {
                xCoordinate += xSapce;
            }
        }
    }

//    public static void showCards(ArrayList<Cards> cards, JScrollPane scrollPane,int numOfCardInEveryRow) throws IOException { //TODO init X and Y coordinate:((
//        int counter = 0;
//        int xCoordinate = 10;
//        int yCoordinate = 10;
//        int xSapce = 170;
//        int ySpace = 190;
//        for (Cards card : cards) {
//            counter++;
//            CardImagePanel cardImagePanel = new CardImagePanel(card);
//            CardPanel.getInstance().setBackground(Color.white);
//            addPanel(cardImagePanel, scrollPane, xCoordinate, yCoordinate, cardImagePanel.getWidthOfCardImage(),
//                    cardImagePanel.getHEIGHTOfCardImage());
//
//            if (counter % numOfCardInEveryRow == 0) {
//                xCoordinate = 10;
//                yCoordinate += CardImagePanel.getHEIGHTOfCardImage() + ySpace;
//            } else {
//                xCoordinate += xSapce;
//            }
//        }
//    }
    public static void addPanel(JPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);

    }

//    public static void addPanel(JPanel originPanel, JScrollPane destinationsCROLPanel, int x, int y, int width, int height) {
//        originPanel.setBounds(x, y, width, height);
//        destinationsCROLPanel.add(originPanel);
//
//    }


}
