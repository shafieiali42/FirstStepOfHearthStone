package Gui.Panels.CollectionPages;

import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Controller.Administer;
import Logic.CollectionState;
import Models.Deck.Deck;
import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Heroes.*;
import Utility.Constant;

public class DeckPanel extends JPanel {

    private static final int WIDTH_OF_BTN = 180;
    private static final int HEIGHT_OF_BTN = 40;
    private Color colorOfTextOfNewDeckBtn = new Color(255, 0, 0);
    private Color colorOfNewDeckBtn = new Color(48, 48, 45);
    private Color colorOfDeckBtn = new Color(48, 48, 45);
    private static DeckPanel deckPanel = new DeckPanel();

    public static DeckPanel getInstance() {
        return deckPanel;
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
        setBounds(0, 0, Constant.WIDTH_OF_DECK_PANEL, Constant.HEIGHT_OF_DECK_PANEL);
        initNewDeckBtn();
    }

    public void designDeckBtn(JButton btn) {
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
//        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setPreferredSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setMaximumSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setMinimumSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setForeground(colorOfTextOfNewDeckBtn);
        btn.setBackground(colorOfNewDeckBtn);
    }

    public void initButtonForDeck(String deckName) {
        JButton button = new JButton(deckName);
        designDeckBtn(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.CHANGE_DECK);
                LittleCardPanel.setAllLittleCardPanels();
                Administer.setCollectionDeck(deckName);
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
        Administer.makeCollectionStatesDeckToNull();
        DeckPage.getInstance().setNameOfDeckToChange("");

        String name = JOptionPane.showInputDialog("Enter your favorite name!");
        Object[] possibilities = {"Mage", "Rogue", "Warlock", "Hunter", "Priest"};
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String heroName = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Hero:",
                "Select Hero",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                "Mage");

        Administer.makeNewDeck(name, heroName);
        DeckPage.getInstance().setNameOfDeckToChange(name);

        MyMainFrame.getInstance().setContentPane(DeckPage.getInstance());
    }

    public void showDeckButtons() {
        DeckPanel.getInstance().removeAll();
        DeckPanel.getInstance().repaint();
        DeckPanel.getInstance().revalidate();
        this.add(newDeckBtn);
        if (Administer.getListOfPlayersDeckNames().size()!=0) {
            for (String deckName : Administer.getListOfPlayersDeckNames()) {
                initButtonForDeck(deckName);
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





