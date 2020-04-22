package Utility;

import Cards.Cards;
import Cards.CardImagePanel;
import CommandLineInterface.CLI;
import Gui.Panels.CollectionPages.CardPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    public static void showCards(ArrayList<Cards> cards, JPanel panel,int numOfCardInEveryRow) throws IOException { //TODO init X and Y coordinate:((
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 10;
        int xSapce = 170;
        int ySpace = 10;

        for (Cards card : cards) {
            boolean isLockForPlayer=true;
            if (CLI.currentPlayer.getAllCardsOfPlayer().contains(card)){
                isLockForPlayer=false;
            }


            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(card);
            cardImagePanel.setIsLock(isLockForPlayer);
            if (isLockForPlayer){
                convertor(cardImagePanel);
            }
//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, isLockForPlayer,xCoordinate, yCoordinate, cardImagePanel.getWidthOfCardImage(),
                    cardImagePanel.getHEIGHTOfCardImage());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += CardImagePanel.getHEIGHTOfCardImage() + ySpace;
            } else {
                xCoordinate += xSapce;
            }
        }
    }

    public static void addPanel(JPanel originPanel, JPanel destinationPanel,boolean isLock, int x, int y, int width, int height) {

        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }

    public static void convertor(CardImagePanel cardImagePanel) throws IOException {
        BufferedImage original =cardImagePanel.getImageOfCard();
        BufferedImage grayScale = cardImagePanel.getImageOfCard();
        ColorConvertOp op =new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null);
        op.filter(grayScale,grayScale);
        BufferedImage blackWhite=new BufferedImage(original.getWidth(),original.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g2d = blackWhite.createGraphics();
        g2d.drawImage(original,0,0,cardImagePanel);
        g2d.dispose();

    }




}
