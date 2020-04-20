package Gui.Panels.ShopPanel;

import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Gui.Panels.CollectionPages.CardPanel;
import Utility.ShowCardsOnPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonPanel extends JPanel {

    private static final int NUMBER_OF_BTN=3;
    public static final int WIDTH_OF_BTN=90;
    public static final int HEIGHT_OF_BTN =90;

    private static final int WIDTH_OF_BUTTON_PANEL =1200;      //TODO NEEDS TO CHANGE

    public  int getWidthOfButtonPanel() {
        return WIDTH_OF_BUTTON_PANEL;
    }

    public  int getHeightOfButtonPanel() {
        return HEIGHT_OF_BUTTON_PANEL;
    }

    private static final int HEIGHT_OF_BUTTON_PANEL =80;     //TODO NEEDS TO CHANGE

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    private static ButtonPanel buttonPanel=new ButtonPanel();
    public static ButtonPanel getInstance(){return buttonPanel;}

    private JButton walletBtn;
    private JButton buyableCardsBtn;
    private JButton salableCardsBtn;




    private ButtonPanel(){
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();

    }

    private void initButtons() {
        initWalletBtn();
        initBuyableCardsBtn();
        initSalableCardsBtn();

    }

    public void designBtn(JButton btn){
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);

    }




    private void initSalableCardsBtn() {
        salableCardsBtn = new JButton("SalableCards");
        designBtn(salableCardsBtn);
        salableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showSalableCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        add(salableCardsBtn);
    }

    private void showSalableCards() throws IOException {
        CLI.setStatus(Status.SELL_PAGE);
        ShowCardsOnPanel.showCards(CLI.currentPlayer.getSalableCards(), CardPanel.getInstance(),ShopCardPanel.getInstance().getNumOfCardInEveryRow());
    }

    private void initBuyableCardsBtn() {
        buyableCardsBtn = new JButton("BuyableCards");
        designBtn(buyableCardsBtn);
        buyableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showBuyableCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(buyableCardsBtn);
    }

    private void showBuyableCards() throws IOException {
        CLI.setStatus(Status.BUY_PAGE);
        ShowCardsOnPanel.showCards(CLI.currentPlayer.getBuyableCards(),CardPanel.getInstance(),ShopCardPanel.getInstance().getNumOfCardInEveryRow());
    }

    private void initWalletBtn() {
        walletBtn = new JButton("Lock");
        designBtn(walletBtn);
        walletBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.WALLET_PAGE);
                JOptionPane.showConfirmDialog(null, "You have "+ CLI.currentPlayer.getMoney()+" Money!",
                        "Wallet", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(walletBtn);
    }


}
