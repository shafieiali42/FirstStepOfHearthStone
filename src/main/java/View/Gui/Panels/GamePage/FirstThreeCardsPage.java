package View.Gui.Panels.GamePage;

import Controller.Administer;
import Controller.ControllerOfMainComponents;
import Controller.GamePartController;
import Logic.Status;
import Utility.Config2.ConfigLoader;
import Utility.MethodsOfShowCardsOnPanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class FirstThreeCardsPage extends JPanel {



    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/FirstThreeCardsPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_OK_BTN =Integer.parseInt(properties.getProperty("WIDTH_OF_OK_BTN"));
    int HEIGHT_OF_OK_BTN =Integer.parseInt(properties.getProperty("HEIGHT_OF_OK_BTN"));


    private static FirstThreeCardsPage firstThreeCardsPage=new FirstThreeCardsPage();
    public static FirstThreeCardsPage getInstance(){return firstThreeCardsPage;}
    private String firstCard;
    private String secondCard;
    private String thirdCard;
    private boolean canChangeFirstCard=true;
    private boolean canChangeSecondCard=true;
    private boolean canChangeThirdCard=true;
    private JButton okButton;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);



    private FirstThreeCardsPage(){
        setLayout(null);
        setBackground(Color.gray);
        firstCard="";
        secondCard="";
        thirdCard="";
        initOkBtn();

    }


    public void reStartSetting(){
        firstCard="";
        secondCard="";
        thirdCard="";
        canChangeFirstCard=true;
        canChangeSecondCard=true;
        canChangeThirdCard=true;
    }

    private void initOkBtn() {
        okButton = new JButton("DONE");
        okButton.setSize(WIDTH_OF_OK_BTN, HEIGHT_OF_OK_BTN);
        okButton.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        okButton.setBounds((MyMainFrame.getInstance().getWidth()-WIDTH_OF_OK_BTN)/2,
                              (MyMainFrame.getInstance().getHeight()-200) ,
                              WIDTH_OF_OK_BTN,
                              HEIGHT_OF_OK_BTN);
        okButton.setForeground(colorOfTextOfBtn);
        okButton.setBackground(colorOfBtn);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());

            }
        });
        add(okButton);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            MethodsOfShowCardsOnPanel.showCards(GamePartController.getFirstFriendlyThreeCards(),this,3,200,300);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(okButton);
    }

    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getThirdCard() {
        return thirdCard;
    }

    public void setThirdCard(String thirdCard) {
        this.thirdCard = thirdCard;
    }

    public boolean getCanChangeFirstCard() {
        return canChangeFirstCard;
    }

    public void setCanChangeFirstCard(boolean canChangeFirstCard) {
        this.canChangeFirstCard = canChangeFirstCard;
    }

    public boolean getCanChangeSecondCard() {
        return canChangeSecondCard;
    }

    public void setCanChangeSecondCard(boolean canChangeSecondCard) {
        this.canChangeSecondCard = canChangeSecondCard;
    }

    public boolean getCanChangeThirdCard() {
        return canChangeThirdCard;
    }

    public void setCanChangeThirdCard(boolean canChangeThirdCard) {
        this.canChangeThirdCard = canChangeThirdCard;
    }
}
