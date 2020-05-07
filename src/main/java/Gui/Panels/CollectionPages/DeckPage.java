package Gui.Panels.CollectionPages;


import Gui.MyMainFrame;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeckPage extends JPanel {

    private static DeckPage deckPage=new DeckPage();
    public static DeckPage getInstance(){return deckPage;}


    private ArrayList<LittleCardPanel> listOfLittleCardsPanelOfDeckToChange=new ArrayList<LittleCardPanel>();

    public ArrayList<LittleCardPanel> getListOfLittleCardsPanelOfDeckToChange() {
        return listOfLittleCardsPanelOfDeckToChange;
    }

    public void setListOfLittleCardsPanelOfDeckToChange(ArrayList<LittleCardPanel> listOfLittleCardsPanelOfDeckToChange) {
        this.listOfLittleCardsPanelOfDeckToChange = listOfLittleCardsPanelOfDeckToChange;
    }

    private String nameOfDeckToChange;

    public String getNameOfDeckToChange() {
        return nameOfDeckToChange;
    }

    public void setNameOfDeckToChange(String nameOfDeckToChange) {
        this.nameOfDeckToChange = nameOfDeckToChange;
    }


    private DeckPage(){

        nameOfDeckToChange="";

        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(CategoryPanelOfChangeDeck.getInstance(),0,0, Constant.WIDTH_OF_CATEGORY_PANEL_DECK_PAGE,
                Constant.HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE);

        this.addPanel(DeckViewer.getInstance(),Constant.WIDTH_OF_CATEGORY_PANEL_DECK_PAGE,0,
                DeckViewer.getInstance().getWidth(),DeckViewer.getInstance().getHeight());


        CardPanel.getInstanceOfDeckPage().setPreferredSize(new Dimension(1155,1600));
        CardPanel.getInstanceOfDeckPage().setFocusable(true);
        CardPanel.getInstanceOfDeckPage().requestFocus();

        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBounds(0,Constant.HEIGHT_OF_CATEGORY_PANEL,1155,620);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBorder(null);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstanceOfDeckPage().getJScrollPane());


        this.addPanel(ManaPanel.getInstanceOfDeckPage(),0,
                (Constant.HEIGHT_OF_CATEGORY_PANEL+620),
                Constant.WIDTH_OF_MANA_PANEL,Constant.HEIGHT_OF_MANA_PANEL);


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
