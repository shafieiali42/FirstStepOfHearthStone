package Gui.Panels.ShopPanel;


import Controller.Administer;
import Utility.LengthOfMessage;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelToShowCardInBuySellPanel extends JPanel {

    private static PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel = new PanelToShowCardInBuySellPanel();

    public static PanelToShowCardInBuySellPanel getInstance() {
        return panelToShowCardInBuySellPanel;
    }

    private PanelToShowCardInBuySellPanel() {

        setLayout(null);
//        setBackground(Color.orange);
        setSize(300, 500);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        if (Administer.isShopStateCardNull()) {

            int lenghtOfMessage = LengthOfMessage.lengthOfMessage("Click on your Intended Card!", graphics2D);
            graphics2D.drawString("Click on your Intended Card!", (300 - lenghtOfMessage) / 2, 250);
        } else {
            try {
                Administer.showShopStateCardInBuySellPanel(this);
//                CardImagePanel cardImagePanel = new CardImagePanel(BuySellPanel.getInstance().getCard());
//                MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, this, 0, 0,this.getWidth() , this.getHeight());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
