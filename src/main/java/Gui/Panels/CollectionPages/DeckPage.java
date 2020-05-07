package Gui.Panels.CollectionPages;

import Models.Deck.Deck;
import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;

public class DeckPage extends JPanel {

    private static DeckPage deckPage=new DeckPage();
    public static DeckPage getInstance(){return deckPage;}

    private String nameOfDeckToChange;

    public String getNameOfDeckToChange() {
        return nameOfDeckToChange;
    }

    public void setNameOfDeckToChange(String nameOfDeckToChange) {
        this.nameOfDeckToChange = nameOfDeckToChange;
    }
    //    public Deck getDeckTOChange() {
//        return deckTOChange;
//    }

//    public void setDeckTOChange(Deck deckTOChange) {
//        this.deckTOChange = deckTOChange;
//    }

//    private Deck deckTOChange;

    private DeckPage(){

        nameOfDeckToChange="";
//        deckTOChange=new Deck();
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(CategoryPanelOfChangeDeck.getInstance(),0,0,CategoryPanelOfChangeDeck.getInstance().getWidthOfCategoryPanelDeckPage(),
                CategoryPanelOfChangeDeck.getInstance().getHeightOfCategoryPanelDeckPage());

        this.addPanel(DeckViewer.getInstance(),CategoryPanelOfChangeDeck.getInstance().getWidthOfCategoryPanelDeckPage(),0,
                DeckViewer.getInstance().getWidth(),DeckViewer.getInstance().getHeight());

        //TODO I CHANGE THIS:)))))))))))))))))))))))))))))))))))))

//        this.addPanel(CardPanel.getInstance().getJScrollPane(),0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),
//                      CardPanel.getInstance().getWidthOfCardPanel(),CardPanel.getInstance().getHeightOfCardPanel());

        CardPanel.getInstanceOfDeckPage().setPreferredSize(new Dimension(1155,1600));
        CardPanel.getInstanceOfDeckPage().setFocusable(true);
        CardPanel.getInstanceOfDeckPage().requestFocus();
//        CardPanel.getInstance().setJScrollPane(new JScrollPane(CardPanel.getInstance()));
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBounds(0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),1155,620);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBorder(null);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstanceOfDeckPage().getJScrollPane());


        this.addPanel(ManaPanel.getInstanceOfDeckPage(),0,
                (CategoryPanel.getInstance().getHeightOfCategoryPanel()+620/*CardPanel.getInstance().getJScrollPane().getHeight()*/),
                ManaPanel.getInstanceOfDeckPage().getWidthOfManaPanel(),ManaPanel.getInstanceOfDeckPage().getHeightOfManaPanel());


    }

    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

    public void addPanel(JScrollPane jScrollPane,int x, int y, int width,int height){
        jScrollPane.setBounds(x,y,width,height);
        add(jScrollPane);
    }

}
