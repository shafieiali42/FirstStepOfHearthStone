package View.Gui.Panels.CollectionPages;


import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class DeckPage extends JPanel {

    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_CATEGORY_PANEL_DECK_PAGE=Integer.parseInt(properties.getProperty("WIDTH_OF_CATEGORY_PANEL_DECK_PAGE"));
    int HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE"));
    int WIDTH_OF_MANA_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_MANA_PANEL"));
    int HEIGHT_OF_MANA_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_MANA_PANEL"));
    int HEIGHT_OF_CATEGORY_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));

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
        this.addPanel(CategoryPanelOfChangeDeck.getInstance(),0,0, WIDTH_OF_CATEGORY_PANEL_DECK_PAGE,
                HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE);

        this.addPanel(DeckViewer.getInstance(),WIDTH_OF_CATEGORY_PANEL_DECK_PAGE,0,
                DeckViewer.getInstance().getWidth(),DeckViewer.getInstance().getHeight());


        CardPanel.getInstanceOfDeckPage().setPreferredSize(new Dimension(1155,1600));
        CardPanel.getInstanceOfDeckPage().setFocusable(true);
        CardPanel.getInstanceOfDeckPage().requestFocus();

        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBounds(0,HEIGHT_OF_CATEGORY_PANEL,1155,620);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setBorder(null);
        CardPanel.getInstanceOfDeckPage().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstanceOfDeckPage().getJScrollPane());


        this.addPanel(ManaPanel.getInstanceOfDeckPage(),0,
                (HEIGHT_OF_CATEGORY_PANEL+620),
                WIDTH_OF_MANA_PANEL,HEIGHT_OF_MANA_PANEL);


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
