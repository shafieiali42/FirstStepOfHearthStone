package Gui.Panels.CollectionPages;

import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Deck.Deck;
import Gui.MyMainFrame;
import Heroes.Heroes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Heroes.*;

public class DeckPanel extends JPanel {


    private static final int WIDTH_OF_DECK_PANEL = 250;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_DECK_PANEL = 1600;     //TODO NEEDS TO CHANGE
    private static final int WIDTH_OF_BTN = 180;
    private static final int HEIGHT_OF_BTN = 40;
    private Color colorOfTextOfNewDeckBtn = new Color(255, 0, 0);
    private Color colorOfNewDeckBtn = new Color(48, 48, 45);
    private Color colorOfDeckBtn = new Color(48, 48, 45);
    private static DeckPanel deckPanel = new DeckPanel();

    public static DeckPanel getInstance() {
        return deckPanel;
    }


    public int getWidthOfDeckPanel() {
        return WIDTH_OF_DECK_PANEL;
    }

    public int getHeightOfDeckPanel() {
        return HEIGHT_OF_DECK_PANEL;
    }


    private JButton newDeckBtn;
    private JScrollPane jScrollPane;

    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    private DeckPanel() {
        setBackground(Color.blue);
        setLayout(new FlowLayout(1, 20, 20));
        setJScrollPane(new JScrollPane(this));
        setBounds(0, 0, WIDTH_OF_DECK_PANEL, HEIGHT_OF_DECK_PANEL);
        initNewDeckBtn();
    }

    public void designDeckBtn(JButton btn) {
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
//        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setPreferredSize(new Dimension(WIDTH_OF_BTN,HEIGHT_OF_BTN));
        btn.setMaximumSize(new Dimension(WIDTH_OF_BTN,HEIGHT_OF_BTN));
        btn.setMinimumSize(new Dimension(WIDTH_OF_BTN,HEIGHT_OF_BTN));
        btn.setForeground(colorOfTextOfNewDeckBtn);
        btn.setBackground(colorOfNewDeckBtn);
    }
    public void initButtonForDeck(Deck deck) {
        JButton button = new JButton(deck.getName());
        designDeckBtn(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.CHANGE_DECK);
                LittleCardPanel.setAllLittleCardPanels();
                DeckPage.getInstance().setDeckTOChange(deck);
                DeckPage.getInstance().getDeckTOChange().setLittleCardsListFromHashMap();
                showDeck();
            }
        });
        this.add(button);
    }
    private void initNewDeckBtn() {
        newDeckBtn = new JButton("New Deck");
        newDeckBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        newDeckBtn.setForeground(colorOfTextOfNewDeckBtn);
        newDeckBtn.setBackground(colorOfNewDeckBtn);
        newDeckBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        newDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.MAKE_DECK);
                makeNewDeck();
            }
        });
        this.add(newDeckBtn);
    }

    private void makeNewDeck() {
        DeckViewer.getInstance().removeAll();
        DeckViewer.getInstance().repaint();
        DeckViewer.getInstance().revalidate();
        LittleCardPanel.setAllLittleCardPanels();
        DeckPage.getInstance().setDeckTOChange(new Deck());
        DeckPage.getInstance().getDeckTOChange().setLittleCardsListFromHashMap();
        DeckPage.getInstance().getDeckTOChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));

        Object[] possibilities = {"Mage", "Rogue", "Warlock", "Hunter", "Priest"};
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String s = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Hero:",
                "Select Hero",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                "Mage");


        switch (s) { // TODO needs changesssssssssssssssssssssssssss:(((((((((((
            case ("Mage"):
                DeckPage.getInstance().getDeckTOChange().setHero(Mage.getInstance());
                break;
            case ("Rogue"):
                DeckPage.getInstance().getDeckTOChange().setHero(Rogue.getInstance());
                break;
            case ("Warlock"):
                DeckPage.getInstance().getDeckTOChange().setHero(Warlock.getInstance());
                break;
            case ("Hunter"):
                DeckPage.getInstance().getDeckTOChange().setHero(Hunter.getInstance());
                break;
            case ("Priest"):
                DeckPage.getInstance().getDeckTOChange().setHero(Priest.getInstance());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        //define deck;s name and hero then go to deck page then press done:
        MyMainFrame.getInstance().setContentPane(DeckPage.getInstance());
    }

    public void showDeckButtons() {
        DeckPanel.getInstance().removeAll();
        DeckPanel.getInstance().repaint();
        DeckPanel.getInstance().revalidate();
        this.add(newDeckBtn);
        if (CLI.currentPlayer.getAllDecksOfPlayer() != null) {
            for (Deck deck : CLI.currentPlayer.getAllDecksOfPlayer()) {
                initButtonForDeck(deck);
            }
        }
    }



    private void showDeck() {
        MyMainFrame.getInstance().setContentPane(DeckPage.getInstance());
        DeckViewer.getInstance().removeAll();
        DeckViewer.getInstance().repaint();
        DeckViewer.getInstance().revalidate();
        DeckViewer.getInstance().showCardsInDecK();

    }


}
















