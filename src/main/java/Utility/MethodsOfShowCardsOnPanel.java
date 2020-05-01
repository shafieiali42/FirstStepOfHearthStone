package Utility;

import Cards.Cards;
import Gui.Panels.CardImagePanel;
import Gui.Panels.CollectionPages.LittleCardPanel;
import Gui.Panels.GamePage.HandsCardsPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    public static void showCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow) throws IOException { //TODO init X and Y coordinate:((
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
            CardImagePanel cardImagePanel = new CardImagePanel(card);

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

    public static void showHandsCards(ArrayList<Cards> cards, JPanel panel, int numOfCardInEveryRow) throws IOException { //TODO init X and Y coordinate:((
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
            CardImagePanel cardImagePanel = new CardImagePanel(card,HandsCardsPanel.getWidthOfEachCard(),
                                                                    HandsCardsPanel.getHeightOfEachCard());

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


    public static void addPanel(JPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }

    public static void addPanel(LittleCardPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }


}
