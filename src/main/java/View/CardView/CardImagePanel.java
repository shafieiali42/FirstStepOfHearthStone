package View.CardView;

import Controller.Administer;
import Logic.Alliance;
import Models.Cards.Cards;
import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Gui.Mapper;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.DeckPage;
import Gui.Panels.CollectionPages.DeckViewer;

//import Gui.Panels.GamePage.GraphicLoop;
import Gui.Panels.ShopPanel.BuySellPanel;
import Gui.Panels.ShopPanel.PanelToShowCardInBuySellPanel;
import Gui.Panels.ShopPanel.ShopPage;
import Logic.GameState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardImagePanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage imageOfCard;
    private boolean isLock;
    private String cardName;
    boolean dragging = false;
    int x, y;

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(String cardName) throws IOException {
        isLock = Administer.isThisCardLock(cardName);
    }

    public BufferedImage getImageOfCard() {
        return imageOfCard;
    }


    public CardImagePanel(Alliance alliance, int width, int height, int typeOfBackOfCard) throws IOException {
        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);


        imageOfCard = ImageIO.read(new File("src/main/resources/BackOfCards/BackOfCards" + typeOfBackOfCard+ ".png"));


    }

    public CardImagePanel(String cardName, int width, int height) throws IOException {

        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
//        this.card = card;
        this.cardName = cardName;
        setIsLock(this.cardName);
        if (this.isLock) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
        }
    }

    public CardImagePanel(String cardName) throws IOException {

        setLayout(null);
        setSize(150, 170);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.cardName = cardName;
        setIsLock(cardName);
        if (this.isLock) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
        }

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
            UIManager.put("OptionPane.minimumSize", new Dimension(this.getWidth() * 3, this.getHeight() * 3));
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
//                BuySellPanel.getInstance().setCard(this.card);
                Administer.defineShopStateCard(cardName);
//                BuySellPanel.getInstance().getPriceLabel().setText("Price " + this.card.getMoneyCost() + " $");
                BuySellPanel.getInstance().getPriceLabel().setText("Price " + Administer.getMoneyOfShopStatesCard() + " $");
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();

            } else if (CLI.getStatus().equals(Status.SELL_PAGE)) {
                PanelToShowCardInBuySellPanel.getInstance().removeAll();
                PanelToShowCardInBuySellPanel.getInstance().repaint();
                PanelToShowCardInBuySellPanel.getInstance().revalidate();
                BuySellPanel.getInstance().getPriceLabel().setText("");
//                BuySellPanel.getInstance().setCard(this.card);
                Administer.defineShopStateCard(cardName);
//                BuySellPanel.getInstance().getPriceLabel().setText("Price " + this.card.getMoneyCost() + " $");
                BuySellPanel.getInstance().getPriceLabel().setText("Price " + Administer.getMoneyOfShopStatesCard() + " $");
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

                try {
                    Administer.addGivenCardToCollectionDeck(cardName, isLock);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        }

    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (CLI.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || CLI.getStatus().equals(Status.PLAY_PAGE)) {
//            GraphicLoop.getInstance().stop();
            x = e.getX();
            y = e.getY();
        }

    }


    @Override

    public void mouseReleased(MouseEvent e) {//TODO can change better inorder to separate logic and GUI
        if (CLI.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || CLI.getStatus().equals(Status.PLAY_PAGE)) {
//            if (e.getComponent().getX() >= PlayPanel.getMinXForPutCards() &&
//                    e.getComponent().getX() <= PlayPanel.getMaxXForPutCards() &&
//                    e.getComponent().getY() >= PlayPanel.getMinYForPutCards() &&
//                    e.getComponent().getY() <= PlayPanel.getMaxYForPutCards()) {


            if (!Administer.getTypeOfGivenCard(this.cardName).equalsIgnoreCase("minion")) {
//                GameState.getInstance().setPlayingCard(this.card);
                Administer.setPlayingCardOfGameState(this.cardName);
                Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                Mapper.getInstance().executeRequests();
                dragging = false;
            } else if (Administer.canAddMinionToBattleGround()) {

//                GameState.getInstance().setPlayingCard(this.card);
                Administer.setPlayingCardOfGameState(this.cardName);
                Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                Mapper.getInstance().executeRequests();
                dragging = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "It's illegal to have more than 7 cards in the battleGround.", "Error", JOptionPane.ERROR_MESSAGE);
            }

//            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (CLI.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || CLI.getStatus().equals(Status.PLAY_PAGE)) {
            dragging = true;
            e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getY() + e.getComponent().getY() - y);
//            repaint();
//            revalidate();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }


}