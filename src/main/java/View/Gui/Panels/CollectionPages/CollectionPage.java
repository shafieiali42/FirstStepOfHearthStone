package View.Gui.Panels.CollectionPages;

import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class CollectionPage extends JPanel {


    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/CollectionPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_CATEGORY_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_CATEGORY_PANEL"));
    int HEIGHT_OF_CATEGORY_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));
    int HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE"));
//    int HEIGHT_OF_CATEGORY_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));
    int WIDTH_OF_MANA_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_MANA_PANEL"));
    int HEIGHT_OF_MANA_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));

    private static CollectionPage collectionPage=new CollectionPage();
    public static CollectionPage getInstance(){return collectionPage;}

    private CollectionPage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(CategoryPanel.getInstance(),0,0, WIDTH_OF_CATEGORY_PANEL,HEIGHT_OF_CATEGORY_PANEL);


        DeckPanel.getInstance().setPreferredSize(new Dimension(250,1600));
        DeckPanel.getInstance().setFocusable(true);
        DeckPanel.getInstance().requestFocus();
        DeckPanel.getInstance().setJScrollPane(new JScrollPane(DeckPanel.getInstance()));
        DeckPanel.getInstance().getJScrollPane().setBounds(WIDTH_OF_CATEGORY_PANEL,
                0,250,800);
        DeckPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        DeckPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        DeckPanel.getInstance().getJScrollPane().setBorder(null);
        DeckPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(DeckPanel.getInstance().getJScrollPane());


        CardPanel.getInstanceOfCollectionPage().setPreferredSize(new Dimension(1155,1600));
        CardPanel.getInstanceOfCollectionPage().setFocusable(true);
        CardPanel.getInstanceOfCollectionPage().requestFocus();

        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setBounds(0,HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE,1155,620);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setBorder(null);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstanceOfCollectionPage().getJScrollPane());


        this.addPanel(ManaPanel.getInstanceOfCollectionPage(),0,
                (HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE+620/*CardPanel.getInstance().getJScrollPane().getHeight()*/),
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
