package Gui.Panels.CollectionPages;

import Controller.Administer;
import Models.Cards.Cards;
import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckViewer extends JPanel {

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;
    private static final int WIDTH_OF_DECK_VIEWER = 250;      //TODO NEEDS TO CHANGE

    public static int getWidthOfDeckViewer() {
        return WIDTH_OF_DECK_VIEWER;
    }

    public static int getHeightOfDeckViewer() {
        return HEIGHT_OF_DECK_VIEWER;
    }

    private static final int HEIGHT_OF_DECK_VIEWER = 800;     //TODO NEEDS TO CHANGE

    private static DeckViewer deckViewer = new DeckViewer();

    public static DeckViewer getInstance() {
        return deckViewer;
    }

    private JButton doneBtn;


    private DeckViewer() {
        setLayout(null);
        setBackground(Color.gray);
        setSize(WIDTH_OF_DECK_VIEWER, HEIGHT_OF_DECK_VIEWER);
        initDoneBtn();
    }


    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initDoneBtn() {
        doneBtn = new JButton("Done");
        designBtn(doneBtn);
        doneBtn.setBounds((DeckViewer.WIDTH_OF_DECK_VIEWER - doneBtn.getWidth()) / 2,
                30* LittleCardPanel.getHeightOfLittleCard() + 100, doneBtn.getWidth(), doneBtn.getHeight());
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done();
            }
        });
        add(doneBtn);
    }

    private void done() {
        if (Administer.getListOfCardsOfCollectionStatesDeck().size() < 15) {

            JOptionPane.showMessageDialog(null,
                    "You must select at least 15 cards.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DeckViewer.getInstance().removeAll();
            DeckViewer.getInstance().repaint();
            DeckViewer.getInstance().revalidate();
            if (CLI.getStatus().equals(Status.CHANGE_DECK)) {
                CLI.currentPlayer.getLoggerOfMyPlayer().info("Changed deck " + DeckPage.getInstance().getNameOfDeckToChange());
                Administer.defineUsesHashMap();
                Administer.makeCollectionStatesDeckToNull();
                DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());
//                DeckPage.getInstance().getDeckTOChange().defineUsesHashMap();
//                DeckPage.getInstance().setDeckTOChange(new Deck());
//                CLI.setStatus(Status.COLLECTIONS_PAGE);
                CLI.setStatus(Status.COLLECTIONS_PAGE);
                MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
                DeckPanel.getInstance().showDeckButtons();
            } else if (CLI.getStatus().equals(Status.MAKE_DECK)) {
//                DeckPage.getInstance().getDeckTOChange().defineUsesHashMap();
                Administer.defineUsesHashMap();
                Administer.addCollectionStatesDeckToPlayersDecksList();
//                CLI.currentPlayer.getAllDecksOfPlayer().add(DeckPage.getInstance().getDeckTOChange());
                Administer.makeCollectionStatesDeckToNull();
                DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());
//                DeckPage.getInstance().setDeckTOChange(new Deck());
                CLI.setStatus(Status.COLLECTIONS_PAGE);
                MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
                DeckPanel.getInstance().showDeckButtons();
                Administer.writeLog("Make new Deck");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Make new deck");
            }
        }
    }

    public void showCardsInDecK() {
        DeckViewer.getInstance().removeAll();
        DeckViewer.getInstance().repaint();
        DeckViewer.getInstance().revalidate();
        int yCoordinate = 0;
        for ( LittleCardPanel littleCardPanel : Administer.getLittleCardPanelOfDeckToChangeFromDeckPage()) {
            for (Cards card : Administer.getListOfCardsOfCollectionStatesDeck()) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(card.getName())) {

                    Administer.showLittleCardPanelOnDeckViewer(littleCardPanel, this,
                            (DeckViewer.WIDTH_OF_DECK_VIEWER - littleCardPanel.getWidth()) / 2, yCoordinate);
//                    MethodsOfShowCardsOnPanel.addPanel(littleCardPanel, this,
//                            (DeckViewer.WIDTH_OF_DECK_VIEWER - littleCardPanel.getWidth()) / 2, yCoordinate,
//                            littleCardPanel.getWidth(), littleCardPanel.getHeight());

                    yCoordinate += littleCardPanel.getHeight() + 5;
                    break;
                }
            }
        }
        add(doneBtn);
    }


}
