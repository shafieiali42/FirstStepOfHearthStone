package Gui.Panels.ShopPanel;

import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Controller.Administer;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CollectionPage;
import Gui.Panels.MenuPanel.MainMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonPanel extends JPanel {

    private static final int NUMBER_OF_BTN = 3;
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    private static ButtonPanel buttonPanel = new ButtonPanel();

    public static ButtonPanel getInstance() {
        return buttonPanel;
    }

    private JButton walletBtn;
    private JButton buyableCardsBtn;
    private JButton salableCardsBtn;
    private JButton backBtn;


    private ButtonPanel() {
        setBackground(Color.gray);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();

    }

    private void initButtons() {
        initBackBtn();
        initWalletBtn();
        initBuyableCardsBtn();
        initSalableCardsBtn();

    }

    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);

    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.writeLog("Back from shop page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Back from shop page");
                ShopCardPanel.getInstance().removeAll();
                ShopCardPanel.getInstance().repaint();
                ShopCardPanel.getInstance().revalidate();
                goBack();
            }
        });
        add(backBtn);
    }

    private void goBack() {

        if (CLI.getStatus().equals(Status.BUY_PAGE_FROM_COLLECTION)) {
            MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
        } else {
            MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
        }
    }

    private void initSalableCardsBtn() {
        salableCardsBtn = new JButton("SalableCards");
        designBtn(salableCardsBtn);
        salableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.writeLog("Show salable cards");
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Show salable cards");
                    showSalableCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        add(salableCardsBtn);
    }

    private void initBuyableCardsBtn() {
        buyableCardsBtn = new JButton("BuyableCards");
        designBtn(buyableCardsBtn);
        buyableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.writeLog("Show buyable cards");
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Show buyable cards");
                    showBuyableCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(buyableCardsBtn);
    }

    private void initWalletBtn() {
        walletBtn = new JButton("Wallet");
        designBtn(walletBtn);
        walletBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.writeLog("Show Wallet");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Show Wallet");
                CLI.setStatus(Status.WALLET_PAGE);
                JOptionPane.showConfirmDialog(null, "You have " + CLI.currentPlayer.getMoney() + " Money!",
                        "Wallet", JOptionPane.DEFAULT_OPTION);
                CLI.setStatus(Status.BUY_PAGE);//TODO needs to change
            }
        });
        add(walletBtn);
    }


    public static void showSalableCards() throws IOException {
        CLI.setStatus(Status.SELL_PAGE);
        Administer.showSalableCards(ShopCardPanel.getInstance(), ShopCardPanel.getInstance().getNumOfCardInEveryRow());

    }

    public static void showBuyableCards() throws IOException {
        CLI.setStatus(Status.BUY_PAGE);
        Administer.showBuyableCards(ShopCardPanel.getInstance(), ShopCardPanel.getInstance().getNumOfCardInEveryRow());

    }


}
