package Gui.Panels.MenuPanel;


import CommandLineInterface.CLI;
import CommandLineInterface.Status;
import Controller.Administer;

import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CollectionPage;
import Gui.Panels.CollectionPages.DeckPanel;
import Gui.Panels.GamePage.GraphicLoop;
import Gui.Panels.GamePage.InfoPassivePage;
import Gui.Panels.SettingPanel.SettingPage;
import Gui.Panels.ShopPanel.ShopPage;
import Gui.Panels.StatusPanel.StatusPage;
import Utility.DrawRotate;
import Utility.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainMenuPage extends JPanel {

    private MarginPanels leftMarginPanel;
    private MarginPanels rightMarginPanel;
    private JPanel menuPanel;

    private JButton playBtn;
    private JButton collectionBtn;
    private JButton shopBtn;
    private JButton statusBtn;
    private JButton settingBtn;
    private JButton logOutBtn;
    private JButton deletePlayerBtn;
    private JButton exitBtn;


    private Color colorOfBtn = new Color(48, 48, 45);

    private Color colorOfTextOfBtn = new Color(255, 0, 0);

    private static MainMenuPage mainMenuPage = new MainMenuPage();

    public static MainMenuPage getInstance() {
        return mainMenuPage;
    }

    private MainMenuPage() {
        setSize(MyMainFrame.getInstance().getMyFrameWidth(), MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        initPanels();
        initButtons();
        add(leftMarginPanel);
        add(rightMarginPanel);
        add(menuPanel);
    }


    private void initButtons() {
        initPlayBtn();
        initCollectionBtn();
        initShopBtn();
        initStatusBtn();
        initSettingBtn();
        initLogOutBtn();
        initExitBtn();
        initDeleteBtn();
    }


    private void initDeleteBtn() {
        deletePlayerBtn = new JButton("DeletePlayer");
        deletePlayerBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        deletePlayerBtn.setForeground(colorOfTextOfBtn);
        deletePlayerBtn.setBackground(colorOfBtn);
        deletePlayerBtn.setSize(this.getWidth() / 4, this.getHeight() / 7);
        deletePlayerBtn.setBounds(menuPanel.getWidth() / 2, menuPanel.getHeight() * 5 / 7, deletePlayerBtn.getWidth(),
                deletePlayerBtn.getHeight());
        deletePlayerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String password =JOptionPane.showInputDialog("Please Enter your Password:");
                    Administer.deletePlayer(password);
//                    PlayerManagement.DeletePlayer(password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menuPanel.add(deletePlayerBtn);
    }

    private void initLogOutBtn() {
        logOutBtn = new JButton("LogOut");
        logOutBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        logOutBtn.setForeground(colorOfTextOfBtn);
        logOutBtn.setBackground(colorOfBtn);
        logOutBtn.setSize(this.getWidth() / 4, this.getHeight() / 7);
        logOutBtn.setBounds(0, menuPanel.getHeight() * 5 / 7, logOutBtn.getWidth(), logOutBtn.getHeight());
        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.logOut();
//                    PlayerManagement.logOut();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menuPanel.add(logOutBtn);

    }

    public void initExitBtn() {
        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        exitBtn.setForeground(colorOfTextOfBtn);
        exitBtn.setBackground(colorOfBtn);
        exitBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        exitBtn.setBounds(0, menuPanel.getHeight() * 6 / 7, exitBtn.getWidth(), exitBtn.getHeight() - 30);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.logOut();
//                    PlayerManagement.logOut();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                GraphicLoop.getInstance().stop();
                System.exit(0);
            }
        });
        menuPanel.add(exitBtn);
    }

    private void initStatusBtn() {
        statusBtn = new JButton("Status");
        statusBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        statusBtn.setForeground(colorOfTextOfBtn);
        statusBtn.setBackground(colorOfBtn);
        statusBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        statusBtn.setBounds(0, menuPanel.getHeight() * 3 / 7, statusBtn.getWidth(), statusBtn.getHeight());
        statusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.writeLog("Navigate into status page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate into status page");
                MyMainFrame.getInstance().setContentPane(StatusPage.getInstance());
            }
        });
        menuPanel.add(statusBtn);

    }

    private void initSettingBtn() {
        settingBtn = new JButton("Setting");
        settingBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        settingBtn.setForeground(colorOfTextOfBtn);
        settingBtn.setBackground(colorOfBtn);
        settingBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        settingBtn.setBounds(0, menuPanel.getHeight() * 4 / 7, settingBtn.getWidth(), settingBtn.getHeight());
        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.writeLog("Navigate into setting page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate into setting page");
                MyMainFrame.getInstance().setContentPane(SettingPage.getInstance());
            }
        });
        menuPanel.add(settingBtn);

    }

    private void initShopBtn() {
        shopBtn = new JButton("Shop");
        shopBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        shopBtn.setForeground(colorOfTextOfBtn);
        shopBtn.setBackground(colorOfBtn);
        shopBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        shopBtn.setBounds(0, menuPanel.getHeight() * 2 / 7, shopBtn.getWidth(), shopBtn.getHeight());
        shopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.SHOP_PAGE);
                Administer.writeLog("Navigate into shop page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate into shop page");
                MyMainFrame.getInstance().setContentPane(ShopPage.getInstance());
            }
        });
        menuPanel.add(shopBtn);


    }

    private void initCollectionBtn() {
        collectionBtn = new JButton("Collection");
        collectionBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        collectionBtn.setForeground(Color.RED);
        collectionBtn.setBackground(colorOfBtn);
        collectionBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        collectionBtn.setBounds(0, menuPanel.getHeight() / 7, collectionBtn.getWidth(), collectionBtn.getHeight());
        collectionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLI.setStatus(Status.COLLECTIONS_PAGE);
                Administer.writeLog("Navigate into collection page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate into collection page");
                DeckPanel.getInstance().showDeckButtons();
                MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
            }
        });
        menuPanel.add(collectionBtn);
    }

    private void initPlayBtn() {
        playBtn = new JButton("Play");
        playBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        playBtn.setForeground(Color.RED);
        playBtn.setBackground(colorOfBtn);
        playBtn.setSize(this.getWidth() / 2, this.getHeight() / 7);
        playBtn.setBounds(0, 0, playBtn.getWidth(), playBtn.getHeight());
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Administer.isCurrentPlayersCurrentDeckNull()) {
                    JOptionPane.showMessageDialog(null, "First you should select your deck",
                            "Eroor", JOptionPane.ERROR_MESSAGE);
                    CLI.setStatus(Status.COLLECTION_PAGE_FROM_PLAY);
                    MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());

                } else {
//                    Administer.playMainSound("src/main/resources/Sounds/SecondAudio.wav");
                    Administer.playMainSound("src/main/resources/Sounds/SecondAudio.wav");
                    CLI.setStatus(Status.PLAY_PAGE);
                    Administer.writeLog("Navigate into play page");
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate into play page");
//                GraphicLoop.getInstance().start();
                    InfoPassivePage.getInstance().repaint();
                    InfoPassivePage.getInstance().revalidate();
                    MyMainFrame.getInstance().setContentPane(InfoPassivePage.getInstance());
                }
            }
        });
        menuPanel.add(playBtn);

    }


    private void initPanels() {
        initMarginPanels();
        initMenuPanel();
    }

    private void initMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setSize(new Dimension(this.getWidth() / 2, this.getHeight()));
        menuPanel.setBounds(this.getWidth() / 4, 0, menuPanel.getWidth(), menuPanel.getHeight());
        menuPanel.setBackground(colorOfBtn);
    }

    private void initMarginPanels() {
        leftMarginPanel = MarginPanels.getInstanceOfLeftPanel();
        leftMarginPanel.setBounds(0, 0, leftMarginPanel.getWidth(), leftMarginPanel.getHeight());

        rightMarginPanel = MarginPanels.getInstanceOfRightPanel();
        rightMarginPanel.setBounds(this.getWidth() * 3 / 4, 0, rightMarginPanel.getWidth(), rightMarginPanel.getHeight());

    }


}

class MarginPanels extends JPanel {

    private static MarginPanels leftPanel = new MarginPanels(1);
    private static MarginPanels rightPanel = new MarginPanels(2);

    public static MarginPanels getInstanceOfLeftPanel() {
        return leftPanel;
    }

    public static MarginPanels getInstanceOfRightPanel() {
        return rightPanel;
    }

    private Color marginColor = new Color(255, 146, 56);
    private int witchPanel;

    private MarginPanels(int witchPanel) {
        setLayout(null);
        setSize(new Dimension(MyMainFrame.getInstance().getMyFrameWidth() / 4, MyMainFrame.getInstance().getMyFrameHeight()));
        setBackground(marginColor);
        this.witchPanel = witchPanel;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        if (witchPanel == 1) {
            String text = "The Best Card Game ever made in the World!";
            int length = LengthOfMessage.lengthOfMessage(text, graphics2D);
            DrawRotate.drawRotate(graphics2D, (double) this.getWidth() / 2, (double) (this.getHeight() + length) / 2 - 60, 270, text);
        } else if (witchPanel == 2) {
            String text = "Enjoy playing HearthStone!";
            int length = LengthOfMessage.lengthOfMessage(text, graphics2D);
            DrawRotate.drawRotate(graphics2D, (double) this.getWidth() / 2, (double) (this.getHeight() - length) / 2, 90, text);
        }


    }


}
