package Gui.Panels.CollectionPages;

import Cards.Cards;
import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Deck.Deck;
import Gui.MyMainFrame;
import Utility.MethodsOfShowCardsOnPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckViewer extends JPanel {

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN=90;
    public static final int HEIGHT_OF_BTN =90;
    private static final int WIDTH_OF_DECK_VIEWER=250;      //TODO NEEDS TO CHANGE

    public static int getWidthOfDeckViewer() {
        return WIDTH_OF_DECK_VIEWER;
    }

    public static int getHeightOfDeckViewer() {
        return HEIGHT_OF_DECK_VIEWER;
    }

    private static final int HEIGHT_OF_DECK_VIEWER=800;     //TODO NEEDS TO CHANGE

    private static DeckViewer deckViewer = new DeckViewer();

    public static DeckViewer getInstance() {
        return deckViewer;
    }

    private JButton doneBtn;


    private DeckViewer() {
        setLayout(null);
        setSize(WIDTH_OF_DECK_VIEWER,HEIGHT_OF_DECK_VIEWER);
        initDoneBtn();


    }


    public void designBtn(JButton btn){
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initDoneBtn() {
        doneBtn =new JButton("Done");
        designBtn(doneBtn);
        doneBtn.setBounds((DeckViewer.WIDTH_OF_DECK_VIEWER-doneBtn.getWidth())/2,
                Deck.getMaxCapacityOfDeck()*LittleCardPanel.getHeightOfLittleCard()+100,doneBtn.getWidth(),doneBtn.getHeight());
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done();
            }
        });
        add(doneBtn);
    }

    private void done() {
//        DeckPage.getInstance().setDeckTOChange(new Deck());
//        DeckViewer.getInstance().removeAll();
//        CardPanel.getInstanceOfDeckPage().removeAll();
//        DeckPage.getInstance().repaint();
//        DeckPage.getInstance().revalidate();
        if (CLI.getStatus().equals(Status.CHANGE_DECK)){
            DeckPage.getInstance().setDeckTOChange(new Deck());
            CLI.setStatus(Status.COLLECTIONS_PAGE);
            //TODO maybe we should update collection page:)))))
            MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
            DeckPanel.getInstance().showDeckButtons();
        }else if (CLI.getStatus().equals(Status.MAKE_DECK)){
            CLI.currentPlayer.getAllDecksOfPlayer().add(DeckPage.getInstance().getDeckTOChange());
            DeckPage.getInstance().setDeckTOChange(new Deck());
            CLI.setStatus(Status.COLLECTIONS_PAGE);
            //TODO maybe we should update collection page:)))))
            MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
            DeckPanel.getInstance().showDeckButtons();
        }
    }

    public void showCardsInDecK(){
        DeckViewer.getInstance().removeAll();
        DeckViewer.getInstance().repaint();
        DeckViewer.getInstance().revalidate();
        int yCoordinate=0;
        for (Cards card:DeckPage.getInstance().getDeckTOChange().getListOfCards()){
            for (LittleCardPanel littleCardPanel:DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck()){
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(card.getName())){
                    MethodsOfShowCardsOnPanel.addPanel(littleCardPanel,this,
                            (DeckViewer.WIDTH_OF_DECK_VIEWER-littleCardPanel.getWidth())/2,yCoordinate,
                            littleCardPanel.getWidth(),littleCardPanel.getHeight());

                    yCoordinate+=littleCardPanel.getHeight();
                    break;
                }
            }
        }
        add(doneBtn);
    }









}