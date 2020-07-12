package View.Gui.Panels.CollectionPages;

import Controller.Administer;
import Controller.CollectionController;
import Models.Cards.CardClasses.Cards;
import Controller.ControllerOfMainComponents;
import Logic.Status;
import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class DeckViewer extends JPanel {

    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckViewer.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_DECK_VIEWER=Integer.parseInt(properties.getProperty("WIDTH_OF_DECK_VIEWER"));
    int HEIGHT_OF_DECK_VIEWER=Integer.parseInt(properties.getProperty("HEIGHT_OF_DECK_VIEWER"));
    int HEIGHT_OF_LITTLE_CARD=Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;


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
        doneBtn.setBounds((WIDTH_OF_DECK_VIEWER - doneBtn.getWidth()) / 2,
                30* HEIGHT_OF_LITTLE_CARD + 100, doneBtn.getWidth(), doneBtn.getHeight());
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done();
            }
        });
        add(doneBtn);
    }

    private void done() {
        if (CollectionController.getListOfCardsOfCollectionStatesDeck().size() < 15) {

            JOptionPane.showMessageDialog(null,
                    "You must select at least 15 cards.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DeckViewer.getInstance().removeAll();
            DeckViewer.getInstance().repaint();
            DeckViewer.getInstance().revalidate();
            if (ControllerOfMainComponents.getStatus().equals(Status.CHANGE_DECK)) {
                ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Changed deck " + DeckPage.getInstance().getNameOfDeckToChange());
                CollectionController.defineUsesHashMap();
                CollectionController.makeCollectionStatesDeckToNull();
                DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());

                ControllerOfMainComponents.setStatus(Status.COLLECTIONS_PAGE);
                MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
                DeckPanel.getInstance().showDeckButtons();
            } else if (ControllerOfMainComponents.getStatus().equals(Status.MAKE_DECK)) {
                CollectionController.defineUsesHashMap();
                CollectionController.addCollectionStatesDeckToPlayersDecksList();
                CollectionController.makeCollectionStatesDeckToNull();
                DeckPage.getInstance().setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());

                ControllerOfMainComponents.setStatus(Status.COLLECTIONS_PAGE);
                MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
                DeckPanel.getInstance().showDeckButtons();
                Administer.writeLog("Make new Deck");
            }
        }
    }

    public void showCardsInDecK() {
        DeckViewer.getInstance().removeAll();
        DeckViewer.getInstance().repaint();
        DeckViewer.getInstance().revalidate();
        int yCoordinate = 0;
        for ( LittleCardPanel littleCardPanel : CollectionController.getLittleCardPanelOfDeckToChangeFromDeckPage()) {
            for (Cards card : CollectionController.getListOfCardsOfCollectionStatesDeck()) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(card.getName())) {

                    CollectionController.showLittleCardPanelOnDeckViewer(littleCardPanel, this,
                            (WIDTH_OF_DECK_VIEWER - littleCardPanel.getWidth()) / 2, yCoordinate);

                    yCoordinate += littleCardPanel.getHeight() + 5;
                    break;
                }
            }
        }
        add(doneBtn);
    }


}
