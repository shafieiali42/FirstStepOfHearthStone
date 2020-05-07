package Gui.Panels.SettingPanel;

import CommandLineInterface.CLI;
import Controller.Administer;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CardPanel;
import Gui.Panels.MenuPanel.MainMenuPage;
import Utility.Sounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingPage extends JPanel {

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 220;
    public static final int HEIGHT_OF_BTN = 90;
    private static final int X_COORDINATE_OF_BUTTONS = (MyMainFrame.getInstance().getWidth()-WIDTH_OF_BTN)/2;
    private static final int Y_COORDINATE_OF_INCREASE_BTN = 200;
    private static final int Y_COORDINATE_OF_DECREASE_BTN = 300;
    private static final int Y_COORDINATE_OF_MUTE_BTN = 400;
    private static final int Y_COORDINATE_OF_BACK_BTN = 500;
    private static int numberOfPushMuteBtn = 0;


    private static SettingPage settingPage = new SettingPage();

    public static SettingPage getInstance() {
        return settingPage;
    }

    private JButton increaseVolumeBtn;
    private JButton decreaseVolumeBtn;
    private JButton muteSoundsBtn;
    private JButton backBtn;

    private SettingPage() {
        setLayout(null);
        setBackground(Color.gray);
        initButtons();
    }

    private void initButtons() {
        initMuteSoundsBtn();
        initIncreaseBtn();
        initDecreaseBtn();
        initBackBtn();
    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.setBounds(X_COORDINATE_OF_BUTTONS, Y_COORDINATE_OF_BACK_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPanel.getInstanceOfCollectionPage().removeAll();
                CardPanel.getInstanceOfCollectionPage().repaint();
                CardPanel.getInstanceOfCollectionPage().revalidate();
                Administer.writeLog("Go back from setting page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Go back from setting page");
                MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
            }
        });
        this.add(backBtn);
    }


    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initMuteSoundsBtn() {
        muteSoundsBtn = new JButton("Mute/SoundsOn");
        designBtn(muteSoundsBtn);
        muteSoundsBtn.setBounds(X_COORDINATE_OF_BUTTONS, Y_COORDINATE_OF_MUTE_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        muteSoundsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.changeStatusOfSound(numberOfPushMuteBtn);
//                Sounds.changeStatus(numberOfPushMuteBtn);
                numberOfPushMuteBtn++;
            }
        });
        add(muteSoundsBtn);

    }

    private void initIncreaseBtn() {
        increaseVolumeBtn = new JButton("Increase Volume");
        designBtn(increaseVolumeBtn);
        increaseVolumeBtn.setBounds(X_COORDINATE_OF_BUTTONS, Y_COORDINATE_OF_INCREASE_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        increaseVolumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.increaseSound();
//                Sounds.increaseSound();
            }
        });
        add(increaseVolumeBtn);

    }

    private void initDecreaseBtn() {
        decreaseVolumeBtn = new JButton("Decrease Volume");
        designBtn(decreaseVolumeBtn);
        decreaseVolumeBtn.setBounds(X_COORDINATE_OF_BUTTONS, Y_COORDINATE_OF_DECREASE_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        decreaseVolumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administer.decreaseSound();
//                Sounds.decreaseSound();
            }
        });
        add(decreaseVolumeBtn);
    }


}
