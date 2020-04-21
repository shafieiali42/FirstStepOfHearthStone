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

        this.addPanel(CardPanel.getInstance().getJScrollPane(),0,CategoryPanel.getInstance().getHeightOfCategoryPanel(),
                      CardPanel.getInstance().getWidthOfCardPanel(),CardPanel.getInstance().getHeightOfCardPanel());

        this.addPanel(ManaPanel.getInstance(),0,
                (CategoryPanel.getInstance().getHeightOfCategoryPanel()+CardPanel.getInstance().getHeightOfCardPanel()),
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
