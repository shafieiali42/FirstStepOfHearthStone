package View.CardView;

import Controller.Administer;
import Controller.GamePartController;
import Logic.PlayLogic.Alliance;
import Controller.ControllerOfMainComponents;
import Logic.Status;
import View.Gui.Mapper;
import View.Gui.Panels.GamePage.PlayPanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

//import View.Gui.Loop.Loop.GraphicLoop;
import View.Gui.Panels.ShopPanel.BuySellPanel;
import View.Gui.Panels.ShopPanel.PanelToShowCardInBuySellPanel;
import View.Gui.Panels.ShopPanel.ShopPage;

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
    private int numberOfCardInBattleGround ;
    private String alliance = "";
    private boolean firstTime = true;
    boolean entered = false;
    static boolean clicked = false;
    static boolean doubleClick = false;
    private int hp;
    private int attackPower;
    private boolean isInited=false;
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
        imageOfCard = ImageIO.read(new File("src/main/resources/BackOfCards/BackOfCards" + typeOfBackOfCard + ".png"));


    }

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type, String alliance) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
//        this.card = card;
            this.alliance = alliance;
            this.cardName = cardName;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }

    }

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
//        this.card = card;
            this.cardName = cardName;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }

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

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type, String alliance,int numberOfCardInBattleGround) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
//        this.card = card;
            this.alliance = alliance;
            this.cardName = cardName;
            this.numberOfCardInBattleGround=numberOfCardInBattleGround;
            this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround,alliance);
            this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround,alliance);
            isInited=true;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

//        if (ControllerOfMainComponents.getStatus().equals(Status.CHOOSE_TARGET_FOR_SPELL)){
//            int xCoordinateOfCard = e.getComponent().getX();
//            int yCoordinateOfCard = e.getComponent().getY();
//            String allianceOfSpellTarget;
//            if (yCoordinateOfCard <= 385) {
//                allianceOfSpellTarget = "ENEMY";
//            } else {
//                allianceOfSpellTarget = "FRIENDLY";
//            }
//            int number = 0;
//            if (xCoordinateOfCard > 45 && xCoordinateOfCard < 150) {
//                number = 1;
//
//            } else if (xCoordinateOfCard > 190 && xCoordinateOfCard < 295) {
//                number = 2;
//
//            } else if (xCoordinateOfCard > 335 && xCoordinateOfCard < 440) {
//                number = 3;
//
//            } else if (xCoordinateOfCard > 480 && xCoordinateOfCard < 585) {
//                number = 4;
//
//            } else if (xCoordinateOfCard > 625 && xCoordinateOfCard < 730) {
//                number = 5;
//
//            } else if (xCoordinateOfCard > 770 && xCoordinateOfCard < 830) {
//                number = 6;
//
//            } else if (xCoordinateOfCard > 915 && xCoordinateOfCard < 1010) {
//                number = 7;
//
//            }
//
//            Administer.setTargetOfSpell(number,allianceOfSpellTarget);
//            Administer.getPlyingCardOfGameState().accept(new TargetVisitor(), Game.getInstance().getCurrentPlayer().getBattleGroundCards(),
//                    Administer.getTargetOfSpell());
//
//            Administer.setTargetOfSpell(0, null);
//        }


        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                int xCoordinateOfCard = e.getComponent().getX();
                int yCoordinateOfCard = e.getComponent().getY();
                firstTime = false;
                if (yCoordinateOfCard <= 385) {
                    alliance = "ENEMY";
                } else {
                    alliance = "FRIENDLY";
                }
                int number = 0;
                numberOfCardInBattleGround = 0;
                if (xCoordinateOfCard > 45 && xCoordinateOfCard < 150) {
                    number = 1;
                    numberOfCardInBattleGround = 1;
                } else if (xCoordinateOfCard > 190 && xCoordinateOfCard < 295) {
                    number = 2;
                    numberOfCardInBattleGround = 2;
                } else if (xCoordinateOfCard > 335 && xCoordinateOfCard < 440) {
                    number = 3;
                    numberOfCardInBattleGround = 3;
                } else if (xCoordinateOfCard > 480 && xCoordinateOfCard < 585) {
                    number = 4;
                    numberOfCardInBattleGround = 4;
                } else if (xCoordinateOfCard > 625 && xCoordinateOfCard < 730) {
                    number = 5;
                    numberOfCardInBattleGround = 5;
                } else if (xCoordinateOfCard > 770 && xCoordinateOfCard < 830) {
                    number = 6;
                    numberOfCardInBattleGround = 6;
                } else if (xCoordinateOfCard > 915 && xCoordinateOfCard < 1010) {
                    number = 7;
                    numberOfCardInBattleGround = 7;
                }


                if (clicked) {
                    doubleClick = true;
                    Administer.setTarget(number - 1);
                    Administer.attack(Administer.getAttacker(), Administer.getTarget());
                    this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                    this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
                    clicked = false;
                    doubleClick = false;
                    System.out.println("*********************" + hp);
                    Administer.setAttacker(-5);
                    Administer.setTarget(-5);
                } else {
                    clicked = true;
                    Administer.setAttacker(number - 1);
                }


            } else if (SwingUtilities.isRightMouseButton(e)) {
                clicked = false;
                doubleClick = false;
                Administer.setAttacker(-5);
                Administer.setTarget(-5);
            }
        } else {

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
//                System.out.println("Moused Clicked");
                if (ControllerOfMainComponents.getStatus().equals(Status.BUY_PAGE)) {
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

                } else if (ControllerOfMainComponents.getStatus().equals(Status.SELL_PAGE)) {
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


                } else if (ControllerOfMainComponents.getStatus().equals(Status.COLLECTIONS_PAGE)) {
                    if (this.isLock) {
                        ControllerOfMainComponents.setStatus(Status.BUY_PAGE_FROM_COLLECTION);
                        MyMainFrame.getInstance().setContentPane(ShopPage.getInstance());
                    } else {
                        JOptionPane.showMessageDialog(null, "You can't Buy this card:((");
                    }
                } else if (ControllerOfMainComponents.getStatus().equals(Status.MAKE_DECK) || ControllerOfMainComponents.getStatus().equals(Status.CHANGE_DECK)) {

                    try {
                        Administer.addGivenCardToCollectionDeck(cardName, isLock);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }

            }
        }

    }

    boolean canReleased = true;

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("Mouse Pressed");
        if (ControllerOfMainComponents.getStatus().equals(Status.FIRST_THREE_CARDS_PAGE)) {
//            System.out.println("Change Deck:))");
            Administer.ChangeThisCardFromHands(cardName);
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {
            if (Administer.canDragCard(e.getComponent().getY())) {
                x = e.getX();
                y = e.getY();
            } else {
                int xCoordinate = e.getComponent().getX();
                int yCoordinate = e.getComponent().getY();
                e.getComponent().setLocation(xCoordinate, yCoordinate);
                canReleased = false;
            }

        }

    }


    @Override

    public void mouseReleased(MouseEvent e) {//TODO can change better inorder to separate logic and GUI
        if (!canReleased) {
//            System.out.println("cant released");
            PlayPanel.getInstance().setNeedsToRepaint(true);
            PlayPanel.getInstance().repaint();
            PlayPanel.getInstance().revalidate();
            return;
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {

            if (!Administer.checkThatCanReleaseCard(e.getComponent().getX(), e.getComponent().getY())) {
                JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Its Not Your Turn:))", "Error", JOptionPane.ERROR_MESSAGE);
                PlayPanel.getInstance().setNeedsToRepaint(true);
                return;
            }
            Mapper.getInstance().setAddedBeforeForBeingBetween(false);

            if (!Administer.getTypeOfGivenCard(this.cardName).equalsIgnoreCase("minion")) {
//                GameState.getInstance().setPlayingCard(this.card);

                Administer.setPlayingCardOfGameState(this.cardName);
                Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                Mapper.getInstance().executeRequests();
                dragging = false;
            } else if (Administer.canAddFriendlyMinionToBattleGround()) {
//                if (!Administer.isPlayedBefore(this.cardName)) {
//                System.out.println("X: " + e.getComponent().getX() + " Y: " + e.getComponent().getY());
                if (e.getComponent().getX() < 50) {
//                    GamePartController.setFirstCard(cardName);
//                    System.out.println("50");
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_ONE);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 125 && e.getComponent().getX() < 220) {
//                    GamePartController.betweenOneAndTwo(cardName);
//                    System.out.println("145");
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_TWO);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 265 && e.getComponent().getX() < 365) {
//                    GamePartController.betweenTwoAndThree(cardName);
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_THREE);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 410 && e.getComponent().getX() < 510) {
//                    GamePartController.betweenThreeAndFour(cardName);
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_FOUR);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 555 && e.getComponent().getX() < 655) {
//                    GamePartController.betweenFourAndFive(cardName);
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_FIVE);
                    Mapper.getInstance().executeRequests();
                } else if (e.getComponent().getX() > 700 && e.getComponent().getX() < 800) {
//                    GamePartController.betweenFiveAndSix(cardName);
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_SIX);
                    Mapper.getInstance().executeRequests();
                }
                if (!Mapper.getInstance().isAddedBeforeForBeingBetween()) {
                    Administer.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                    Mapper.getInstance().executeRequests();
                }
                dragging = false;
//                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "It's illegal to have more than 7 cards in the battleGround.", "Error", JOptionPane.ERROR_MESSAGE);
            }

//            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {

            dragging = true;
            e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getY() + e.getComponent().getY() - y);
//            repaint();
//            revalidate();
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if (clicked) {
//            System.out.println("Entered");
            entered = true;
            repaint();
            revalidate();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("Exited");
        entered = false;
        repaint();
        revalidate();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("Moved");
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageOfCard, 0, 0, this.getWidth(), this.getHeight(), null);
        Graphics2D graphics2D = (Graphics2D) g;
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {
            graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 20));
            graphics2D.setColor(Color.red);
            if (isInited){
                this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
            }

            graphics2D.drawString(this.hp + "", 73, 98);
            graphics2D.drawString(this.attackPower + "", 10, 98);

            if (entered) {
                int r = this.getWidth() / 4;
                graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 50));
                graphics2D.setColor(Color.black);
                graphics2D.drawOval(this.getWidth() / 2 - r, this.getHeight() / 2 - r, 2 * r, 2 * r);

                graphics2D.drawLine(this.getWidth() / 2, this.getHeight() / 2 - 2 * r
                        , this.getWidth() / 2, this.getHeight() / 2 + 2 * r);

                graphics2D.drawLine(this.getWidth() / 2 - 2 * r, this.getHeight() / 2
                        , this.getWidth() / 2 + 3 * r, this.getHeight() / 2);
            }

        }
    }


}