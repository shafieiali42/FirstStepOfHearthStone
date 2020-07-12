package View.CardView;

import Controller.Administer;
import Controller.GamePartController;
import Logic.PlayLogic.Alliance;
import Controller.ControllerOfMainComponents;
import Logic.PlayLogic.Game;
import Logic.Status;
import Models.Cards.CardClasses.Minion;
import View.Gui.Mapper;
import View.Gui.Panels.GamePage.DiscoverCardsPage;
import View.Gui.Panels.GamePage.PlayPanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

//import View.Gui.Loop.Loop.GraphicLoop;
import View.Gui.Panels.ShopPanel.BuySellPanel;
import View.Gui.Panels.ShopPanel.PanelToShowCardInBuySellPanel;
import View.Gui.Panels.ShopPanel.ShopPage;
import Visitors.CardVisitors.AfterSelectVisitor;
import Visitors.PowerVisitor.HeroPowerVisitor.AfterSelectPowerVisitor;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CardImagePanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage imageOfCard;
    private boolean isLock;
    private String cardName;
    boolean dragging = false;
    private int numberOfCardInBattleGround;
    private Alliance alliance;
    private boolean firstTime = true;
    boolean entered = false;
    static boolean clicked = false;
    static boolean doubleClick = false;
    private int hp;
    private int attackPower;
    private boolean isInited = false;
    private String typeOfCard = "minionOrSpell";
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


    public CardImagePanel(String cardName) throws IOException {
        setLayout(null);
        setSize(150, 170);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.cardName = cardName;
        setIsLock(cardName);
        if (this.isLock) {
//            System.out.println(cardName);
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
        }
    }

    public CardImagePanel(int width, int height, int typeOfBackOfCard) throws IOException {
        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        imageOfCard = ImageIO.read(new File("src/main/resources/BackOfCards/BackOfCards" + typeOfBackOfCard + ".png"));


    }

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type, Alliance alliance) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
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

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type, Alliance alliance, int numberOfCardInBattleGround) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.alliance = alliance;
            this.cardName = cardName;
            this.numberOfCardInBattleGround = numberOfCardInBattleGround;
            this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
            this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
            isInited = true;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }
    }

    public CardImagePanel(String cardName, int width, int height, String typeOfCard, Alliance alliance) throws IOException {
        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
//        this.card = card;
        this.typeOfCard = typeOfCard;
        this.cardName = cardName;
        this.alliance = alliance;
        if (typeOfCard.equalsIgnoreCase("weapon")) {
            this.hp = GamePartController.giveWeaponDurability(alliance);
            this.attackPower = GamePartController.giveWeaponAttackPower(alliance);
        }

        if (typeOfCard.equalsIgnoreCase("hero")) {
            this.hp = GamePartController.giveHeroHp(alliance);
            this.attackPower = GamePartController.giveHeroAttackPower(alliance);
        }

        setIsLock(this.cardName);
        if (typeOfCard.equalsIgnoreCase("heroPower")) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/HeroPowerImages/" + cardName + ".png"));
        } else if (typeOfCard.equalsIgnoreCase("hero")) {

            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/HeroImages/" + cardName + ".png"));
        } else {

            if (this.isLock) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
            } else {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            }
        }
    }


    public Alliance getAlliance(int yCoordinateOfCard) {

        Alliance allianceOfSpellTarget;
        if (yCoordinateOfCard <= 385) {
            allianceOfSpellTarget = Alliance.ENEMY;
        } else {
            allianceOfSpellTarget = Alliance.FRIENDLY;
        }
        return allianceOfSpellTarget;
    }

    public int getNumber(int xCoordinateOfCard) {
        int number = 0;

        if (xCoordinateOfCard > 45 && xCoordinateOfCard < 150) {
            number = 1;

        } else if (xCoordinateOfCard > 190 && xCoordinateOfCard < 295) {
            number = 2;

        } else if (xCoordinateOfCard > 335 && xCoordinateOfCard < 440) {
            number = 3;

        } else if (xCoordinateOfCard > 480 && xCoordinateOfCard < 585) {
            number = 4;

        } else if (xCoordinateOfCard > 625 && xCoordinateOfCard < 730) {
            number = 5;

        } else if (xCoordinateOfCard > 770 && xCoordinateOfCard < 830) {
            number = 6;

        } else if (xCoordinateOfCard > 915 && xCoordinateOfCard < 1010) {
            number = 7;

        }
        return number;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (ControllerOfMainComponents.getStatus().equals(Status.CHOOSE_TARGET_FOR_SPELL)) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                int xCoordinateOfCard = e.getComponent().getX();
                int yCoordinateOfCard = e.getComponent().getY();
                GamePartController.setTargetOfSpell(getNumber(xCoordinateOfCard), alliance);

                GamePartController.getPlyingCardOfGameState().accept(new AfterSelectVisitor(),
                        GamePartController.getBattleGround(),
                        GamePartController.getHandCards(), GamePartController.getDeckCards(),
                        GamePartController.getTargetOfSpell(),
                        GamePartController.getTargetOfSpellWitchIsHero(),
                        new Minion(), null, alliance);

                ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
            }
        }


        if (ControllerOfMainComponents.getStatus().equals(Status.CHOOSE_TARGET_FOR_HERO_POWERS)) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                int xCoordinateOfCard = e.getComponent().getX();
                int yCoordinateOfCard = e.getComponent().getY();


                int number = 0;

                if (this.typeOfCard.equalsIgnoreCase("hero")) {
                    number = -2;
                    numberOfCardInBattleGround = -2;

                } else {
                    number = getNumber(xCoordinateOfCard);
                }

                GamePartController.setTargetForHeroPower(number, alliance);

                GamePartController.getHeroPower().accept(new AfterSelectPowerVisitor(), Game.getInstance().getCurrentPlayer(),
                        Game.getInstance().getCurrentPlayer().getBattleGroundCards(),
                        Game.getInstance().getFormerPlayer().getBattleGroundCards(),
                        Game.getInstance().getCurrentPlayer().getHandsCards(),
                        Game.getInstance().getFormerPlayer().getHandsCards(),
                        Game.getInstance().getCurrentPlayer().getDeckCards(),
                        Game.getInstance().getFormerPlayer().getDeckCards(),
                        GamePartController.getTargetOfHeroPower(),
                        GamePartController.getTargetOfHeroPowerWitchIsHero(), null);

                ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
            }
        }

        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                int xCoordinateOfCard = e.getComponent().getX();
                int yCoordinateOfCard = e.getComponent().getY();
                firstTime = false;
                alliance = getAlliance(yCoordinateOfCard);

                int number = 0;
                numberOfCardInBattleGround = 0;


                if (this.typeOfCard.equalsIgnoreCase("heroPower")) {
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_HERO_POWER);
                    Mapper.getInstance().executeRequests();
                    number = -3;
                    numberOfCardInBattleGround = -3;
                } else {


                    if (this.typeOfCard.equalsIgnoreCase("hero")) {
                        number = -2;
                        numberOfCardInBattleGround = -2;
                        if (clicked) {
                            doubleClick = true;
                            GamePartController.setTarget(number - 1);
                            GamePartController.setAllianceOfTarget(alliance);
                            GamePartController.attack(GamePartController.getAttacker(), GamePartController.getTarget(),
                                    GamePartController.getAllianceOfAttacker(), GamePartController.getAllianceOfTarget());

                            this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                            this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
                            clicked = false;
                            doubleClick = false;
                            GamePartController.setAttacker(-5);
                            GamePartController.setTarget(-5);
                        }
                    } else if (this.typeOfCard.equalsIgnoreCase("weapon")) {
                        number = -1;
                        numberOfCardInBattleGround = -1;
                    } else {

                        number = getNumber(xCoordinateOfCard);
                        numberOfCardInBattleGround = number;

                        if (clicked) {
                            doubleClick = true;
                            GamePartController.setTarget(number - 1);
                            GamePartController.setAllianceOfTarget(alliance);
                            GamePartController.attack(GamePartController.getAttacker(), GamePartController.getTarget(),
                                    GamePartController.getAllianceOfAttacker(), GamePartController.getAllianceOfTarget());

                            this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                            this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
                            clicked = false;
                            doubleClick = false;
                            GamePartController.setAttacker(-5);
                            GamePartController.setTarget(-5);
                        }
                    }


                    if (!clicked) {
                        clicked = true;
                        GamePartController.setAttacker(number - 1);
                        GamePartController.setAllianceAttacker(alliance);
                    }

                }

            } else if (SwingUtilities.isRightMouseButton(e)) {
                clicked = false;
                doubleClick = false;
                GamePartController.setAttacker(-5);
                GamePartController.setTarget(-5);
                GamePartController.setAllianceAttacker(null);
                GamePartController.setAllianceOfTarget(null);
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
                if (ControllerOfMainComponents.getStatus().equals(Status.BUY_PAGE)) {
                    PanelToShowCardInBuySellPanel.getInstance().removeAll();
                    PanelToShowCardInBuySellPanel.getInstance().repaint();
                    PanelToShowCardInBuySellPanel.getInstance().revalidate();
                    BuySellPanel.getInstance().getPriceLabel().setText("");
                    Administer.defineShopStateCard(cardName);
                    BuySellPanel.getInstance().getPriceLabel().setText("Price " + Administer.getMoneyOfShopStatesCard() + " $");
                    PanelToShowCardInBuySellPanel.getInstance().repaint();
                    PanelToShowCardInBuySellPanel.getInstance().revalidate();
                } else if (ControllerOfMainComponents.getStatus().equals(Status.SELL_PAGE)) {
                    PanelToShowCardInBuySellPanel.getInstance().removeAll();
                    PanelToShowCardInBuySellPanel.getInstance().repaint();
                    PanelToShowCardInBuySellPanel.getInstance().revalidate();
                    BuySellPanel.getInstance().getPriceLabel().setText("");
                    Administer.defineShopStateCard(cardName);
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

        if (ControllerOfMainComponents.getStatus().equals(Status.DISCOVER_THREE_WEAPONS)) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                DiscoverCardsPage.getInstance().setSelectedWeapon(this.cardName);
                DiscoverCardsPage.getInstance().setWaiting(false);

                GamePartController.getPlyingCardOfGameState().accept(new AfterSelectVisitor(),
                        GamePartController.getBattleGround(),
                        GamePartController.getHandCards(), GamePartController.getDeckCards(),
                        new Minion(), null, new Minion(), null, alliance);
            }
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.FIRST_THREE_CARDS_PAGE)) {
            GamePartController.ChangeThisCardFromHands(cardName);
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {
            if (GamePartController.canDragCard(e.getComponent().getY())) {
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

    public void mouseReleased(MouseEvent e) {
        if (!canReleased) {
//            System.out.println("cant released");
            PlayPanel.getInstance().setNeedsToRepaint(true);
            PlayPanel.getInstance().repaint();
            PlayPanel.getInstance().revalidate();
            return;
        }
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {

            if (!GamePartController.checkThatCanReleaseCard(e.getComponent().getX(), e.getComponent().getY())) {
                JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Its Not Your Turn:))", "Error", JOptionPane.ERROR_MESSAGE);
                PlayPanel.getInstance().setNeedsToRepaint(true);
                return;
            }
            Mapper.getInstance().setAddedBeforeForBeingBetween(false);

            if (!Objects.requireNonNull(Administer.getTypeOfGivenCard(this.cardName)).equalsIgnoreCase("minion")) {

                GamePartController.setPlayingCardOfGameState(this.cardName);
                Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                Mapper.getInstance().executeRequests();
                dragging = false;
            } else if (GamePartController.canAddMinionToBattleGround()) {

                if (e.getComponent().getX() < 50) {
                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_ONE);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 125 && e.getComponent().getX() < 220) {

                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_TWO);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 265 && e.getComponent().getX() < 365) {

                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_THREE);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 410 && e.getComponent().getX() < 510) {

                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_FOUR);
                    Mapper.getInstance().executeRequests();

                } else if (e.getComponent().getX() > 555 && e.getComponent().getX() < 655) {
                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_FIVE);
                    Mapper.getInstance().executeRequests();
                } else if (e.getComponent().getX() > 700 && e.getComponent().getX() < 800) {
                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS_SIX);
                    Mapper.getInstance().executeRequests();
                }
                if (!Mapper.getInstance().isAddedBeforeForBeingBetween()) {
                    GamePartController.setPlayingCardOfGameState(this.cardName);
                    Mapper.getInstance().addRequest(Mapper.RequestTypes.PLAY_CARDS);
                    Mapper.getInstance().executeRequests();
                }
                dragging = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "It's illegal to have more than 7 cards in the battleGround.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE_MY_TURN) || ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)) {

            dragging = true;
            e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getY() + e.getComponent().getY() - y);
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
        if (ControllerOfMainComponents.getStatus().equals(Status.PLAY_PAGE)
                || ControllerOfMainComponents.getStatus().equals(Status.CHOOSE_TARGET_FOR_SPELL)) {
            graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 20));
            graphics2D.setColor(Color.red);
            if (isInited) {
                if (this.typeOfCard.equalsIgnoreCase("weapon")) {
                    this.hp = GamePartController.giveWeaponDurability(alliance);
                    this.attackPower = GamePartController.giveWeaponAttackPower(alliance);
                } else {
                    this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                    this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
                }
            }

            if (this.typeOfCard.equalsIgnoreCase("weapon")) {
                graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 15));
                graphics2D.drawString(this.hp + "", 68, 93);
                graphics2D.drawString(this.attackPower + "", 7, 93);

            } else if (this.typeOfCard.equalsIgnoreCase("hero")) {
                graphics2D.drawString(this.hp + "", 115, 98);
                graphics2D.drawString(this.attackPower + "", 12, 98);

            } else if (typeOfCard.equalsIgnoreCase("heroPower")) {
                //doesnt show eny Thing
            } else {
                graphics2D.drawString(this.hp + "", 73, 98);
                graphics2D.drawString(this.attackPower + "", 10, 98);
            }


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