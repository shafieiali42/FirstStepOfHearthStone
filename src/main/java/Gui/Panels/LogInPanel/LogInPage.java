package Gui.Panels.LogInPanel;


import Gui.MyMainFrame;
import Utility.ImageBackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogInPage extends JPanel {

    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImageBackGround imageBackGround = new ImageBackGround();
    private static LogInPage logInPage;




    static {
        try {
            logInPage = new LogInPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogInPage getInstance() {
        return logInPage;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        String welcome = "Welcome to HearthStone";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        Rectangle2D bounds = g.getFontMetrics().getStringBounds(welcome, g2d);
        int lengthOfMessage = (int) bounds.getWidth();
        g2d.drawString(welcome, MyMainFrame.getFrameWidth() / 2 + (MyMainFrame.getFrameWidth() / 2 - lengthOfMessage) / 2, 100);
        String message = "Enjoy your time";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        Rectangle2D bounds1 = g.getFontMetrics().getStringBounds(message, g2d);
        int lengthOfMessage1 = (int) bounds1.getWidth();
        g2d.drawString(message, MyMainFrame.getFrameWidth() / 2 + (MyMainFrame.getFrameWidth() / 2 - lengthOfMessage1) / 2, 150);
    }

    private LogInPage() throws IOException {
        setSize(MyMainFrame.getFrameWidth(), MyMainFrame.getFrameHeight());
        setLayout(null);
        setBackground(Color.GRAY);
        initImagePanel();
        initLabelsAndFields();
        initButtons();
        add(imageBackGround);
        add(userNameLabel);
        add(userNameTextField);
        add(passwordLabel);
        add(passwordField);
        add(logInBtn);
        add(signUpBtn);
        add(exitBtn);

    }

    private void initButtons() {
        initLogInSignUpButton();
        initExitButton();
    }

    private void initExitButton() {
        exitBtn = new JButton("Exit");
        exitBtn.setSize(100, 40);
        exitBtn.setBounds(MyMainFrame.getFrameWidth() / 2 + (MyMainFrame.getFrameWidth() / 2 - exitBtn.getWidth()) / 2,
                signUpBtn.getY() + 50,
                exitBtn.getWidth(), exitBtn.getHeight());
    }

    private void initLogInSignUpButton() {
        signUpBtn = new JButton("SignUp");
        logInBtn = new JButton("LogIn");
        logInBtn.setSize(100, 40);
        signUpBtn.setSize(100, 40);
        signUpBtn.setBounds(MyMainFrame.getFrameWidth() / 2 +
                           (MyMainFrame.getFrameWidth() / 2 - logInBtn.getWidth() - signUpBtn.getWidth()) / 2 +
                           logInBtn.getWidth() + 5,
                          passwordLabel.getY() + 50, logInBtn.getWidth(), logInBtn.getHeight());

        logInBtn.setBounds(MyMainFrame.getFrameWidth() / 2 + (MyMainFrame.getFrameWidth() / 2 -
                            logInBtn.getWidth() - signUpBtn.getWidth()) / 2,
                            passwordLabel.getY() + 50, logInBtn.getWidth(), logInBtn.getHeight());
    }



    private void initLabelsAndFields() {
        userNameLabel = new JLabel("UserName:");
        passwordLabel = new JLabel("Password:");
        passwordLabel.setText("Password:");
        userNameTextField = new JTextField();
        passwordField = new JPasswordField();
        userNameLabel.setSize(65, 20);
        passwordLabel.setSize(60, 20);
        userNameTextField.setSize(80, 20);
        passwordField.setSize(80, 20);
        userNameLabel.setBounds(MyMainFrame.getFrameWidth() / 2 +
                        (MyMainFrame.getFrameWidth() / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                350, userNameLabel.getWidth(), userNameLabel.getHeight());
        passwordLabel.setBounds(MyMainFrame.getFrameWidth() / 2 +
                        (MyMainFrame.getFrameWidth() / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                400, passwordLabel.getWidth(), passwordLabel.getHeight());

        userNameTextField.setBounds(MyMainFrame.getFrameWidth() / 2 +
                        (MyMainFrame.getFrameWidth() / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2+
                        userNameLabel.getWidth() + 5,
                350, userNameTextField.getWidth(), userNameTextField.getHeight());
        passwordField.setBounds(MyMainFrame.getFrameWidth() / 2 +
                        (MyMainFrame.getFrameWidth() / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2 + passwordLabel.getWidth() + 8,
                400, passwordField.getWidth(), passwordField.getHeight());
    }
    private void initImagePanel() throws IOException {
        BufferedImage image = ImageIO.read(new File("Assets/6.jpg"));
        imageBackGround.setSize(MyMainFrame.getFrameWidth() / 2, MyMainFrame.getFrameHeight());
        imageBackGround.setImageBackGround(image);
        imageBackGround.setBounds(0, 0, imageBackGround.getWidth(), imageBackGround.getHeight());
    }



}

