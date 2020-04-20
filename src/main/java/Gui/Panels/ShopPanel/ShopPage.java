package Gui.Panels.ShopPanel;

import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CardPanel;
import Gui.Panels.CollectionPages.CategoryPanel;

import javax.swing.*;

public class ShopPage extends JPanel {

    private static ShopPage shopPage=new ShopPage();
    public static ShopPage getInstance(){return shopPage;}



    private ShopPage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(ButtonPanel.getInstance(),0,0,ButtonPanel.getInstance().getWidthOfButtonPanel(),
                ButtonPanel.getInstance().getHeightOfButtonPanel());

        this.addPanel(ShopCardPanel.getInstance(),0,ButtonPanel.getInstance().getHeightOfButtonPanel(),
                ShopCardPanel.getInstance().getWidthOfShopCardPanel(),ShopCardPanel.getInstance().getHeightOfShopCardPanel());

    }



    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}
