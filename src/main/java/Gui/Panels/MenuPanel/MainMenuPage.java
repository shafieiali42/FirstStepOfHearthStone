package Gui.Panels.MenuPanel;


import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class MainMenuPage extends JPanel {

    private JPanel leftMarginPanel;
    private JPanel rightMarginPanel;
    private JPanel menuPanel;

    private JButton playBtn;
    private JButton collectionBtn;
    private JButton shopBtn;
    private JButton statusBtn;
    private JButton settingBtn;
    private JButton backBtn;
    private JButton exitBtn;

//     private Color marginColor = Color.decode("#FFE042");
//    private Color colorOfBtn = Color.decode("#FFE042");
//    E71989

    private Color colorOfBtn = new Color(48, 48, 45);
    private Color marginColor = new Color(255, 146, 56);
    private Color colorOfTextOfBtn=new Color(255,0,0);

    private static MainMenuPage mainMenuPage = new MainMenuPage();

    public static MainMenuPage getInstance() {
        return mainMenuPage;
    }

    private MainMenuPage() {
        setSize(MyMainFrame.getFrameWidth(), MyMainFrame.getFrameHeight());
        setLayout(null);
        initPanels();
        initButtons();
        add(leftMarginPanel);
        add(rightMarginPanel);
        add(menuPanel);
    }



    private void initButtons() {
        initPalyBtn();
        initCollectionBtn();
        initShopBtn();
        initStatusBtn();
        initSettingBtn();
        initBackBtn();
        initExitBtn();
    }



    private void initExitBtn() {
        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        exitBtn.setForeground(colorOfTextOfBtn);
        exitBtn.setBackground(colorOfBtn);
        exitBtn.setSize(this.getWidth() / 4, this.getHeight() / 6);
        exitBtn.setBounds(menuPanel.getWidth() / 2, menuPanel.getHeight() * 5 / 6, exitBtn.getWidth(), exitBtn.getHeight() - 10);
        menuPanel.add(exitBtn);
    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        backBtn.setForeground(colorOfTextOfBtn);
        backBtn.setBackground(colorOfBtn);
        backBtn.setSize(this.getWidth() / 4, this.getHeight() / 6);
        backBtn.setBounds(0, menuPanel.getHeight() * 5 / 6, backBtn.getWidth(), backBtn.getHeight() - 10);
        menuPanel.add(backBtn);

    }

    private void initStatusBtn() {
        statusBtn = new JButton("Status");
        statusBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        statusBtn.setForeground(colorOfTextOfBtn);
        statusBtn.setBackground(colorOfBtn);
        statusBtn.setSize(this.getWidth() / 2, this.getHeight() / 6);
        statusBtn.setBounds(0, menuPanel.getHeight() * 3 / 6, statusBtn.getWidth(), statusBtn.getHeight());
        menuPanel.add(statusBtn);

    }

    private void initSettingBtn() {
        settingBtn = new JButton("Setting");
        settingBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        settingBtn.setForeground(colorOfTextOfBtn);
        settingBtn.setBackground(colorOfBtn);
        settingBtn.setSize(this.getWidth() / 2, this.getHeight() / 6);
        settingBtn.setBounds(0, menuPanel.getHeight() * 4 / 6, settingBtn.getWidth(), settingBtn.getHeight());
        menuPanel.add(settingBtn);

    }

    private void initShopBtn() {
        shopBtn = new JButton("Shop");
        shopBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        shopBtn.setForeground(colorOfTextOfBtn);
        shopBtn.setBackground(colorOfBtn);
        shopBtn.setSize(this.getWidth() / 2, this.getHeight() / 6);
        shopBtn.setBounds(0, menuPanel.getHeight() * 2 / 6, shopBtn.getWidth(), shopBtn.getHeight());
        menuPanel.add(shopBtn);


    }

    private void initCollectionBtn() {
        collectionBtn = new JButton("Collection");
        collectionBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        collectionBtn.setForeground(Color.RED);
        collectionBtn.setBackground(colorOfBtn);
        collectionBtn.setSize(this.getWidth() / 2, this.getHeight() / 6);
        collectionBtn.setBounds(0, menuPanel.getHeight() / 6, collectionBtn.getWidth(), collectionBtn.getHeight());
        menuPanel.add(collectionBtn);
    }

    private void initPalyBtn() {
        playBtn = new JButton("Play");
        playBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        playBtn.setForeground(Color.RED);
        playBtn.setBackground(colorOfBtn);
        playBtn.setSize(this.getWidth() / 2, this.getHeight() / 6);
        playBtn.setBounds(0, 0, playBtn.getWidth(), playBtn.getHeight());
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
        leftMarginPanel = new JPanel();
        leftMarginPanel.setSize(new Dimension(this.getWidth() / 4, this.getHeight()));
        leftMarginPanel.setBounds(0, 0, leftMarginPanel.getWidth(), leftMarginPanel.getHeight());
        leftMarginPanel.setBackground(marginColor);
        rightMarginPanel = new JPanel();
        rightMarginPanel.setSize(new Dimension(this.getWidth() / 4, this.getHeight()));
        rightMarginPanel.setBounds(this.getWidth() * 3 / 4, 0, rightMarginPanel.getWidth(), rightMarginPanel.getHeight());
        rightMarginPanel.setBackground(marginColor);

    }


}
