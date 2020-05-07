package Gui.Panels.SettingPanel;

import Controller.Administer;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CardPanel;
import Gui.Panels.GamePage.PlayPanel;
import Gui.Panels.MenuPanel.MainMenuPage;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Utility.Constant.*;

public class SettingPage extends JPanel {

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    private static int numberOfPushMuteBtn = 0;


    private static SettingPage settingPage = new SettingPage();

    public static SettingPage getInstance() {
        return settingPage;
    }

    private JButton changeBackOfCardsBtn;
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
        initChangeBackOfCards();
        initMuteSoundsBtn();
        initIncreaseBtn();
        initDecreaseBtn();
        initBackBtn();
    }

    private void initChangeBackOfCards() {
        changeBackOfCardsBtn = new JButton("Change card design");
        designBtn(changeBackOfCardsBtn);
        changeBackOfCardsBtn.setBounds(X_COORDINATE_OF_BUTTONS_IN_SETTING, Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN, Constant.WIDTH_OF_BTN_IN_SETTING,
                Constant.HEIGHT_OF_BTN_IN_SETTING);
        changeBackOfCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = PlayPanel.getInstance().getTypeOfBackOfCards() + 1;
                if (a == 3) {
                    a = 3;
                }else{
                    a=a%3;
                }

                Administer.changeBackOfCards(a);
                JOptionPane.showMessageDialog(null,
                        "Type of Back of cards changed to " + PlayPanel.getInstance().getTypeOfBackOfCards(), "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(changeBackOfCardsBtn);

    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.setBounds(X_COORDINATE_OF_BUTTONS_IN_SETTING, Y_COORDINATE_OF_BACK_BTN, Constant.WIDTH_OF_BTN_IN_SETTING,
                Constant.HEIGHT_OF_BTN_IN_SETTING);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CardPanel.getInstanceOfCollectionPage().removeAll();
//                CardPanel.getInstanceOfCollectionPage().repaint();
//                CardPanel.getInstanceOfCollectionPage().revalidate();
                Administer.writeLog("Go back from setting page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Go back from setting page");
                MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
            }
        });
        this.add(backBtn);
    }


    public void designBtn(JButton btn) {
        btn.setSize(Constant.WIDTH_OF_BTN_IN_SETTING, Constant.WIDTH_OF_BTN_IN_SETTING);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initMuteSoundsBtn() {
        muteSoundsBtn = new JButton("Mute/SoundsOn");
        designBtn(muteSoundsBtn);
        muteSoundsBtn.setBounds(X_COORDINATE_OF_BUTTONS_IN_SETTING, Y_COORDINATE_OF_MUTE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, HEIGHT_OF_BTN_IN_SETTING);
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
        increaseVolumeBtn.setBounds(X_COORDINATE_OF_BUTTONS_IN_SETTING, Y_COORDINATE_OF_INCREASE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, HEIGHT_OF_BTN_IN_SETTING);
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
        decreaseVolumeBtn.setBounds(X_COORDINATE_OF_BUTTONS_IN_SETTING, Y_COORDINATE_OF_DECREASE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, HEIGHT_OF_BTN_IN_SETTING);
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
