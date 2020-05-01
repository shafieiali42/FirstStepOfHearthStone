package Gui.Panels.GamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckAndEndTurnBtnPanel extends JPanel {

    private static final int WIDTH_OF_END_TURN_PANEL=100;
    private static final int HEIGHT_OF_END_TURN_PANEL=810;
    public static final int WIDTH_OF_BTN=70;
    public static final int HEIGHT_OF_BTN =90;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);





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

    }

    private void initFirstDeck() {

    }

    private void initEndTurnBtn() {
        endTurnBtn=new JButton("End Turn");
        endTurnBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        endTurnBtn.setBounds((WIDTH_OF_END_TURN_PANEL-WIDTH_OF_BTN)/2,400,WIDTH_OF_BTN,HEIGHT_OF_BTN);//todo init yCoordinate:))
        endTurnBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        endTurnBtn.setForeground(colorOfTextOfBtn);
        endTurnBtn.setBackground(colorOfBtn);
        endTurnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(endTurnBtn);
    }


}
