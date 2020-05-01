package Gui.Panels;

import Cards.Cards;
import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.DeckPage;
import Gui.Panels.CollectionPages.DeckViewer;
import Gui.Panels.ShopPanel.BuySellPanel;
import Gui.Panels.ShopPanel.PanelToShowCardInBuySellPanel;
import Gui.Panels.ShopPanel.ShopPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardImagePanel extends JPanel implements MouseListener {

    private BufferedImage imageOfCard;
    private boolean isLock;
    private Cards card; //TODO maybe it is wrong to define card for cardImagePanel:((

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Cards card) {
        for (Cards cards : Cards.getAllCards()) {
            if (CLI.currentPlayer.getAllCardsOfPlayer().contains(card)) {
                isLock = false;
            } else {
                isLock = true;
            }
        }
    }

    public BufferedImage getImageOfCard() {
        return imageOfCard;
    }


    private  int WidthOfCardImage;  //TODO IT SHOULD CHANGE:))
    private  int HeightOfCardImage;    //TODO IT SHOULD CHANGE:))

    public  void setWidthOfCardImage(int widthOfCardImage) {
        WidthOfCardImage = widthOfCardImage;
    }

    public  void setHeightOfCardImage(int heightOfCardImage) {
        HeightOfCardImage = heightOfCardImage;
    }

//    public  int getWidthOfCardImage() {
//        return WidthOfCardImage;
//    }

//    public  int getHeightOfCardImage() {
//        return HeightOfCardImage;
//    }


    public CardImagePanel(Cards card,int width,int height) throws IOException {

        setLayout(null);
        setSize(width,height);
        this.card = card;
        setIsLock(card);
        if (this.isLock) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + card.getName() + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + card.getName() + ".png"));
        }
        addMouseListener(this);
    }

    public CardImagePanel(Cards card) throws IOException {

        setLayout(null);
        setSize(150,170);
        this.card = card;
        setIsLock(card);
        if (this.isLock) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + card.getName() + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + card.getName() + ".png"));
        }
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageOfCard, 0, 0, this.getWidth(), this.getHeight(), null);
//        Graphics2D graphics2D =(Graphics2D)g;
//        makeItGrey(this.isLock,graphics2D);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.cyan);
            UI.put("Panel.background", Color.cyan);
            UIManager.put("OptionPane.minimumSize", new Dimension(WidthOfCardImage * 3, HeightOfCardImage * 3));
            JOptionPane.showMessageDialog(null, this, "Information", JOptionPane.INFORMATION_MESSAGE);
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            UIManager.put("OptionPane.minimumSize", new Dimension(200, 80));
            UIManager.put("OptionPane.minimumSize", UIManager.getDefaults().getDimension("OptionPane.minimumSize"));
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            if (CLI.getStatus().equals(Status.BUY_PAGE)) {
                PanelToShowCardInBuySellPanel.getInstance().removeAll();
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();
                BuySellPanel.getInstance().getPriceLabel().setText("");
                BuySellPanel.getInstance().setCard(this.card);
                BuySellPanel.getInstance().getPriceLabel().setText("Price " + this.card.getMoneyCost() + " $");
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();

            } else if (CLI.getStatus().equals(Status.SELL_PAGE)) {
                PanelToShowCardInBuySellPanel.getInstance().removeAll();
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();
                BuySellPanel.getInstance().getPriceLabel().setText("");
                BuySellPanel.getInstance().setCard(this.card);
                BuySellPanel.getInstance().getPriceLabel().setText("Price " + this.card.getMoneyCost() + " $");
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();


            } else if (CLI.getStatus().equals(Status.COLLECTIONS_PAGE)) {
                if (this.isLock) {
                    CLI.setStatus(Status.BUY_PAGE_FROM_COLLECTION);
                    MyMainFrame.getInstance().setContentPane(ShopPage.getInstance());
                } else {
                    JOptionPane.showMessageDialog(null, "You can't Buy this card:((");
                }
            } else if (CLI.getStatus().equals(Status.MAKE_DECK) || CLI.getStatus().equals(Status.CHANGE_DECK)) {
                for (int i = 0; i < DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck().size(); i++) {
                    if (this.card.getName().equalsIgnoreCase(DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck().get(i).getNameLabel().getText())) {
                        if (Integer.parseInt(DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck().get(i).getUsedLabel().getText()) < 2) {
//                            System.out.println(DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOftHISdECK().get(i).getUsedLabel().getText());
                            if (!DeckPage.getInstance().getDeckTOChange().getListOfCards().contains(this.card) && !this.isLock) {
                                DeckPage.getInstance().getDeckTOChange().getListOfCards().add(this.card);
                            }
                            DeckViewer.getInstance().showCardsInDecK();
                            int k = Integer.parseInt(DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck().get(i).getUsedLabel().getText()) + 1;
                            DeckPage.getInstance().getDeckTOChange().getLittleCardPanelsOfThisDeck().get(i).getUsedLabel().setText(k + "");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "You have two card of this card in your Deck!", "Add To Deck Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//    private void makeItGrey(boolean isLock,Graphics2D graphics2D) {
//        if (isLock){
//            graphics2D.setColor(new Color(50,50,50,150));
//            graphics2D.fillRect(7,15,this.getWidth()-10,this.getHeight()-15);
//        }
//    }


}
