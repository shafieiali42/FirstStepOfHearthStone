package Gui.Panels.GamePage;

import Gui.Mapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckAndEndTurnBtnPanel extends JPanel {



    private static final int WIDTH_OF_END_TURN_PANEL=200;
    private static final int HEIGHT_OF_END_TURN_PANEL=810;
    public static final int WIDTH_OF_BTN=150;
    public static final int HEIGHT_OF_BTN =80;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    public static int getWidthOfEndTurnPanel() {
        return WIDTH_OF_END_TURN_PANEL;
    }
    public static int getHeightOfEndTurnPanel() {
        return HEIGHT_OF_END_TURN_PANEL;
    }

    private JButton endTurnBtn;
    private JLabel manaLabel;
    private static DeckAndEndTurnBtnPanel deckAndEndTurnBtnPanel=new DeckAndEndTurnBtnPanel();
    public static DeckAndEndTurnBtnPanel getInstance(){return deckAndEndTurnBtnPanel;}


    private DeckAndEndTurnBtnPanel(){
        setBackground(Color.gray);
        setLayout(null);
        setSize(WIDTH_OF_END_TURN_PANEL,HEIGHT_OF_END_TURN_PANEL);
        initEndTurnBtn();
        initFirstDeck();
        initSecondDeck();
        initManaLabel();


    }

    private void initManaLabel() {
        manaLabel=new JLabel();
        manaLabel.setForeground(Color.BLACK);
        manaLabel.setBackground(Color.BLUE);
        manaLabel.setText(""); //todo define text:))
        manaLabel.setSize(WIDTH_OF_END_TURN_PANEL,50);
        manaLabel.setBounds(0,0,manaLabel.getWidth(),manaLabel.getHeight());//init xCoordinate and yCoordinate
        add(manaLabel);
    }

    private void initSecondDeck() {
        DeckViewerInPlay.getInstanceOfSecondDeck().setBounds(60,50,DeckViewerInPlay.getWidthOfDeck(),DeckViewerInPlay.getHeightOfDeck());
        add(DeckViewerInPlay.getInstanceOfSecondDeck());
    }

    private void initFirstDeck() {
        DeckViewerInPlay.getInstanceOfFirstDeck().setBounds(60,460,DeckViewerInPlay.getWidthOfDeck(),DeckViewerInPlay.getHeightOfDeck());
        add(DeckViewerInPlay.getInstanceOfFirstDeck());
    }

    private void initEndTurnBtn() {
        endTurnBtn=new JButton("End Turn");
        endTurnBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        endTurnBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        endTurnBtn.setBounds((WIDTH_OF_END_TURN_PANEL-WIDTH_OF_BTN)/2,(HEIGHT_OF_END_TURN_PANEL-HEIGHT_OF_BTN)/2-20
                ,WIDTH_OF_BTN,HEIGHT_OF_BTN);//todo init yCoordinate:))
        endTurnBtn.setForeground(colorOfTextOfBtn);
        endTurnBtn.setBackground(colorOfBtn);
        endTurnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mapper.getInstance().addRequest(Mapper.RequestTypes.END_TURN);
                Mapper.getInstance().executeRequests();
            }
        });
        add(endTurnBtn);
    }


}

class DeckViewerInPlay extends JPanel{
    public static int getWidthOfDeck() {
        return WIDTH_OF_DECK;
    }

    public static int getHeightOfDeck() {
        return HEIGHT_OF_DECK;
    }

    private static final int WIDTH_OF_DECK=80;
    private static final int HEIGHT_OF_DECK=200;
    private static DeckViewerInPlay firstDeck=new DeckViewerInPlay();
    public static DeckViewerInPlay getInstanceOfFirstDeck(){return firstDeck;}

    private static DeckViewerInPlay secondDeck=new DeckViewerInPlay();
    public static DeckViewerInPlay getInstanceOfSecondDeck(){return secondDeck;}

    private DeckViewerInPlay(){
        setLayout(null);
        setBackground(Color.orange);
        setSize(WIDTH_OF_DECK,HEIGHT_OF_DECK);

    }

}








