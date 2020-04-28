package Gui.Panels.CollectionPages;

import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;

public class CollectionPage extends JPanel {


    private static CollectionPage collectionPage=new CollectionPage();
    public static CollectionPage getInstance(){return collectionPage;}

    private CollectionPage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(CategoryPanel.getInstance(),0,0,CategoryPanel.getInstance().getWidthOfCategoryPanel(),
                                                            CategoryPanel.getInstance().getHeightOfCategoryPanel());

//        this.addPanel(DeckPage.getInstance(),CategoryPanel.getInstance().getWidthOfCategoryPanel(),0,
//                      DeckPage.getInstance().getWidthOfDeckPanel(),DeckPage.getInstance().getHeightOfDeckPanel());
        DeckPanel.getInstance().setPreferredSize(new Dimension(250,1600));
        DeckPanel.getInstance().setFocusable(true);
        DeckPanel.getInstance().requestFocus();
        DeckPanel.getInstance().setJScrollPane(new JScrollPane(DeckPanel.getInstance()));
        DeckPanel.getInstance().getJScrollPane().setBounds(CategoryPanel.getInstance().getWidthOfCategoryPanel(),
                0,250,800);
        DeckPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        DeckPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        DeckPanel.getInstance().getJScrollPane().setBorder(null);
        DeckPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(DeckPanel.getInstance().getJScrollPane());
        //TODO I CHANGE THIS:)))))))))))))))))))))))))))))))))))))

//        this.addPanel(CardPanel.getInstance().getJScrollPane(),0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),
//                      CardPanel.getInstance().getWidthOfCardPanel(),CardPanel.getInstance().getHeightOfCardPanel());

        CardPanel.getInstanceOfCollectionPage().setPreferredSize(new Dimension(1155,1600));
        CardPanel.getInstanceOfCollectionPage().setFocusable(true);
        CardPanel.getInstanceOfCollectionPage().requestFocus();
//        CardPanel.getInstance().setJScrollPane(new JScrollPane(CardPanel.getInstance()));
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setBounds(0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),1155,620);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setBorder(null);
        CardPanel.getInstanceOfCollectionPage().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstanceOfCollectionPage().getJScrollPane());


        this.addPanel(ManaPanel.getInstanceOfCollectionPage(),0,
                (CategoryPanel.getInstance().getHeightOfCategoryPanel()+620/*CardPanel.getInstance().getJScrollPane().getHeight()*/),
                ManaPanel.getInstanceOfCollectionPage().getWidthOfManaPanel(),ManaPanel.getInstanceOfCollectionPage().getHeightOfManaPanel());


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
