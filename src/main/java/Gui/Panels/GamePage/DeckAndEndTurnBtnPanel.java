package Gui.Panels.GamePage;

import Controller.Administer;
import Gui.Mapper;
import Gui.MyMainFrame;
import Gui.Panels.MenuPanel.MainMenuPage;

import Utility.DrawRotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static Utility.Constant.*;

public class DeckAndEndTurnBtnPanel extends JPanel {


//    private static final int WIDTH_OF_END_TURN_PANEL = 200;
//    private static final int HEIGHT_OF_END_TURN_PANEL = 810;
    private static final int WIDTH_OF_BTN = 150;
    private static final int HEIGHT_OF_BTN = 80;
//    private static final int WIDTH_OF_QIT_BTN = 100;
//    private static final int HEIGHT_OF_QUIT_BTN = 50;


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

//    public static int getWidthOfEndTurnPanel() {
//        return WIDTH_OF_END_TURN_PANEL;
//    }
//
//    public static int getHeightOfEndTurnPanel() {
//        return HEIGHT_OF_END_TURN_PANEL;
//    }

    private JButton endTurnBtn;
    private JButton quitGameBtn;
    private static DeckAndEndTurnBtnPanel deckAndEndTurnBtnPanel = new DeckAndEndTurnBtnPanel();

    public static DeckAndEndTurnBtnPanel getInstance() {
        return deckAndEndTurnBtnPanel;
    }


    private DeckAndEndTurnBtnPanel() {
        setBackground(Color.gray);
        setLayout(null);
        setSize(WIDTH_OF_END_TURN_PANEL, HEIGHT_OF_END_TURN_PANEL);
        initEndTurnBtn();
        initFirstDeck();
        initSecondDeck();
        initQuitGameBtn();
    }

    private void initQuitGameBtn() {
        quitGameBtn = new JButton("Quit");
        quitGameBtn.setSize(WIDTH_OF_QIT_BTN, HEIGHT_OF_QUIT_BTN);
        quitGameBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        quitGameBtn.setBounds((WIDTH_OF_END_TURN_PANEL - WIDTH_OF_QIT_BTN) / 2, 720, WIDTH_OF_QIT_BTN, HEIGHT_OF_QUIT_BTN);
        quitGameBtn.setForeground(colorOfTextOfBtn);
        quitGameBtn.setBackground(colorOfBtn);
        quitGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure to leave game?\n" + "This will make you lose",
                        "Warning", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    try {
                        Administer.initializeGameState();
//                        GameState.getInstance().initGameState();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    PlayPanel.getInstance().removeAll();
                    PlayPanel.getInstance().setNeedsToRepaint(true);
                    PlayPanel.getInstance().repaint();
                    PlayPanel.getInstance().revalidate();
                    LogPanel.getInstance().removeAll();
                    LogPanel.getInstance().setLog("");
                    LogPanel.getInstance().repaint();
                    LogPanel.getInstance().revalidate();
//                    DeckAndEndTurnBtnPanel.getInstance().removeAll();
//                    DeckAndEndTurnBtnPanel.getInstance().repaint();
//                    DeckAndEndTurnBtnPanel.getInstance().revalidate();

                    MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());

                }
            }
        });
        add(quitGameBtn);
    }


    private void initSecondDeck() {
        DeckViewerInPlay.getInstanceOfSecondDeck().setBounds(60, 50, DeckViewerInPlay.getWidthOfDeck(), DeckViewerInPlay.getHeightOfDeck());

        DeckViewerInPlay.getInstanceOfSecondDeck().setToolTipText("There are 0 cards in this Models.Deck");//TODO needs to change in next phase:))
        add(DeckViewerInPlay.getInstanceOfSecondDeck());
    }

    private void initFirstDeck() {
        DeckViewerInPlay.getInstanceOfFirstDeck().setBounds(60, 460, DeckViewerInPlay.getWidthOfDeck(), DeckViewerInPlay.getHeightOfDeck());

        DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have "+
                Administer.getNumberOfCardsOfDeckInGameState()+ "cards in your deck");
        add(DeckViewerInPlay.getInstanceOfFirstDeck());
    }

    private void initEndTurnBtn() {
        endTurnBtn = new JButton("End Turn");
        endTurnBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        endTurnBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        endTurnBtn.setBounds((WIDTH_OF_END_TURN_PANEL - WIDTH_OF_BTN) / 2, (HEIGHT_OF_END_TURN_PANEL - HEIGHT_OF_BTN) / 2 - 20
                , WIDTH_OF_BTN, HEIGHT_OF_BTN);//todo init yCoordinate:))
        endTurnBtn.setForeground(colorOfTextOfBtn);
        endTurnBtn.setBackground(colorOfBtn);
        endTurnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mapper.getInstance().addRequest(Mapper.RequestTypes.END_TURN);
                Mapper.getInstance().executeRequests();
                DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have "+
                        Administer.getNumberOfCardsOfDeckInGameState()+ "cards in your deck");
//                DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have " +
//                        GameState.getInstance().getCardsOfDeckInGameState().size() + "cards in your deck");
            }
        });
        add(endTurnBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        g.drawString(Administer.getManaOfGameState() + "/" + "10", 60, 700);//todo maybe its better to do it in Administer

        DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have "+
                Administer.getNumberOfCardsOfDeckInGameState()+ "cards in your deck");
//        DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have "+
//                GameState.getInstance().getCardsOfDeckInGameState().size()+ "cards in your deck");
        DeckViewerInPlay.getInstanceOfSecondDeck().setToolTipText("There are 0 cards in this Models.Deck");//TODO needs to change in next phase:))
    }

}


class DeckViewerInPlay extends JPanel {
    public static int getWidthOfDeck() {
        return WIDTH_OF_DECK;
    }

    public static int getHeightOfDeck() {
        return HEIGHT_OF_DECK;
    }

    private static final int WIDTH_OF_DECK = 80;
    private static final int HEIGHT_OF_DECK = 200;
    private int witchPanel;
    private static DeckViewerInPlay firstDeck = new DeckViewerInPlay(1);

    public static DeckViewerInPlay getInstanceOfFirstDeck() {
        return firstDeck;
    }

    private static DeckViewerInPlay secondDeck = new DeckViewerInPlay(2);

    public static DeckViewerInPlay getInstanceOfSecondDeck() {
        return secondDeck;
    }

    private DeckViewerInPlay(int witchPanel) {
        setLayout(null);
        setBackground(Color.orange);
        setSize(WIDTH_OF_DECK, HEIGHT_OF_DECK);
        this.witchPanel = witchPanel;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if (witchPanel == 1) {
            DrawRotate.drawRotate(graphics2D, WIDTH_OF_DECK / 2 - 10, 15, 90, "Player's Deck");


        } else if (witchPanel == 2) {
            DrawRotate.drawRotate(graphics2D, WIDTH_OF_DECK / 2 - 10, 15, 90, "Enemy's Deck");
        }
    }


}








