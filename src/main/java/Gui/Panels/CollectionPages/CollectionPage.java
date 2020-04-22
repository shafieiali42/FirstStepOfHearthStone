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

        this.addPanel(DeckPanel.getInstance(),CategoryPanel.getInstance().getWidthOfCategoryPanel(),0,
                      DeckPanel.getInstance().getWidthOfDeckPanel(),DeckPanel.getInstance().getHeightOfDeckPanel());
        //TODO I CHANGE THIS:)))))))))))))))))))))))))))))))))))))

//        this.addPanel(CardPanel.getInstance().getJScrollPane(),0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),
//                      CardPanel.getInstance().getWidthOfCardPanel(),CardPanel.getInstance().getHeightOfCardPanel());

        CardPanel.getInstance().setPreferredSize(new Dimension(1200,1600));
        CardPanel.getInstance().setFocusable(true);
        CardPanel.getInstance().requestFocus();
        CardPanel.getInstance().setJScrollPane(new JScrollPane(CardPanel.getInstance()));
        CardPanel.getInstance().getJScrollPane().setBounds(0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),1200,620);
        CardPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        CardPanel.getInstance().getJScrollPane().setBorder(null);
        CardPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(CardPanel.getInstance().getJScrollPane());


        this.addPanel(ManaPanel.getInstance(),0,
                (CategoryPanel.getInstance().getHeightOfCategoryPanel()+620/*CardPanel.getInstance().getJScrollPane().getHeight()*/),
                ManaPanel.getInstance().getWidthOfManaPanel(),ManaPanel.getInstance().getHeightOfManaPanel());


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
