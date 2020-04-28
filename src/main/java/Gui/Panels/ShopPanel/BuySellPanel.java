package Gui.Panels.ShopPanel;

import Cards.CardImagePanel;
import Cards.Cards;
import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Utility.LengthOfMessage;
import Utility.MethodsOfShowCardsOnPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BuySellPanel extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 140;
    public static final int HEIGHT_OF_BTN = 60;


    private static final int WIDTH_OF_BUY_SELL_PANEL = 400;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_BUY_SELL_PANEL = 730;

    private JLabel coinLabel;
    private JLabel priceLabel;
    private JButton transactionBtn;

    private boolean isFirstTime = true;
    private Cards card;

    public boolean getIsFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }

    private static BuySellPanel buySellPanel;

    static {
        try {
            buySellPanel = new BuySellPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static BuySellPanel getInstance() {
        return buySellPanel;
    }

    private BuySellPanel() throws IOException {
//        setBackground(Color.cyan);
        setLayout(null);

//        initCoinLabel();
        initPriceLabel();
//        initCardImagePanel();
        initTransactionBtn();

        PanelToShowCardInBuySellPanel.getInstance().setBounds(
                (BuySellPanel.getWidthOfBuySellPanel() - PanelToShowCardInBuySellPanel.getInstance().getWidth()) / 2, 100,
                PanelToShowCardInBuySellPanel.getInstance().getWidth(),
                PanelToShowCardInBuySellPanel.getInstance().getHeight());

        add(PanelToShowCardInBuySellPanel.getInstance());
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }

    private void initPriceLabel() {
        priceLabel = new JLabel();
        priceLabel.setBounds(100, 75, 150, 30);
        add(priceLabel);

    }

    private void initTransactionBtn() {
        transactionBtn = new JButton("Transaction");
        transactionBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        transactionBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        transactionBtn.setForeground(colorOfTextOfBtn);
        transactionBtn.setBackground(colorOfBtn);
        transactionBtn.setBounds((400 - transactionBtn.getWidth()) / 2, 620, transactionBtn.getWidth(), transactionBtn.getHeight());
        transactionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BuySellPanel.getInstance().card == null) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a card!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    if (CLI.getStatus().equals(Status.BUY_PAGE)) {

                        int reply = JOptionPane.showConfirmDialog(null, "Are you sure that you want buy this card?\n" +
                                        "this card cost" + BuySellPanel.getInstance().card.getMoneyCost() + "$",
                                "Buy", JOptionPane.YES_NO_OPTION);

                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                CLI.currentPlayer.buy(BuySellPanel.getInstance().card);
                                BuySellPanel.getInstance().setCard(null);
                                PanelToShowCardInBuySellPanel.getInstance().removeAll();
                                PanelToShowCardInBuySellPanel.getInstance().repaint();
                                PanelToShowCardInBuySellPanel.getInstance().revalidate();
                                BuySellPanel.getInstance().getPriceLabel().setText("");
                                ButtonPanel.showBuyableCards();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                        }
                    } else if (CLI.getStatus().equals(Status.SELL_PAGE)) {
                        try {
                            if (BuySellPanel.getInstance().card == null) {
                                JOptionPane.showConfirmDialog(null, "Please select a card!",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                int reply = JOptionPane.showConfirmDialog(null,
                                        "Are you sure that you want sell this card?\n" +
                                                "this card cost" + BuySellPanel.getInstance().card.getMoneyCost() + "$",
                                        "Sell", JOptionPane.YES_NO_OPTION);

                                if (reply == JOptionPane.YES_OPTION) {
                                    CLI.currentPlayer.sell(BuySellPanel.getInstance().card);
                                    ButtonPanel.showSalableCards();
                                    BuySellPanel.getInstance().setCard(null);
                                    PanelToShowCardInBuySellPanel.getInstance().removeAll();
                                    PanelToShowCardInBuySellPanel.getInstance().repaint();
                                    PanelToShowCardInBuySellPanel.getInstance().revalidate();
                                    BuySellPanel.getInstance().getPriceLabel().setText("");
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        add(transactionBtn);
    }


    public static int getWidthOfBuySellPanel() {
        return WIDTH_OF_BUY_SELL_PANEL;
    }

    public static int getHeightOfBuySellPanel() {
        return HEIGHT_OF_BUY_SELL_PANEL;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

}



