package Gui.Panels.ShopPanel;

import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CardPanel;
import Gui.Panels.CollectionPages.CategoryPanel;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;

public class ShopPage extends JPanel {

    private static ShopPage shopPage=new ShopPage();
    public static ShopPage getInstance(){return shopPage;}



    private ShopPage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(ButtonPanel.getInstance(),0,0, Constant.WIDTH_OF_BUTTON_PANEL_IN_SHOP,
                Constant.HEIGHT_OF_BUTTON_PANEL_IN_SHOP);

//        this.addPanel(ShopCardPanel.getInstance(),0,ButtonPanel.getInstance().getHeightOfButtonPanel(),
//                ShopCardPanel.getInstance().getWidthOfShopCardPanel(),ShopCardPanel.getInstance().getHeightOfShopCardPanel());

        ShopCardPanel.getInstance().setPreferredSize(new Dimension(1000,1800));
        ShopCardPanel.getInstance().setFocusable(true);
        ShopCardPanel.getInstance().requestFocus();
        ShopCardPanel.getInstance().setJScrollPane(new JScrollPane(ShopCardPanel.getInstance()));
        ShopCardPanel.getInstance().getJScrollPane().setBounds(0,Constant.HEIGHT_OF_BUTTON_PANEL_IN_SHOP,1000,720);
        ShopCardPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ShopCardPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ShopCardPanel.getInstance().getJScrollPane().setBorder(null);
        ShopCardPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(ShopCardPanel.getInstance().getJScrollPane());

        this.addPanel(BuySellPanel.getInstance(),1000,ButtonPanel.getInstance().getHeight(),
                Constant.WIDTH_OF_BUY_SELL_PANEL,Constant.HEIGHT_OF_BUY_SELL_PANEL);


    }



    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}
