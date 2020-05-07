package Gui.Panels.GamePage;

import Gui.MyMainFrame;
import Logic.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPassivePage extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 200;
    public static final int HEIGHT_OF_BTN = 200;
    public static final int NUMBER_OF_BTN = 3;
    private static final int X_COORDINATE_OF_FIRST_BTN = (MyMainFrame.getInstance().getWidth() - 3 * WIDTH_OF_BTN) / 4;
    private static final int Y_COORDINATE_OF_FIRST_BTN = (MyMainFrame.getInstance().getHeight() - 40 - HEIGHT_OF_BTN) / 2;
    private static InfoPassivePage infoPassivePage = new InfoPassivePage();

    public static InfoPassivePage getInstance() {
        return infoPassivePage;
    }

    private JButton firstPassiveBtn;
    private JButton secondPassiveBtn;
    private JButton thirdPassiveBtn;


    private InfoPassivePage() {
        setLayout(null);
        setBackground(Color.gray);
        initButtons();


    }

    private void initButtons() {
        initFirstBtn();
        initSecondBtn();
        initThirdBtn();
    }

    public void designBtn(JButton btn) {
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initThirdBtn() {
        thirdPassiveBtn = new JButton(GameState.getInstance().getPassivesToChoose().get(2).getName());
        thirdPassiveBtn.setBounds(3 * X_COORDINATE_OF_FIRST_BTN + 2 * WIDTH_OF_BTN, Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);//////////
        designBtn(thirdPassiveBtn);
        thirdPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(2));
                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
            }
        });
        add(thirdPassiveBtn);
    }

    private void initSecondBtn() {
        secondPassiveBtn = new JButton(GameState.getInstance().getPassivesToChoose().get(1).getName());
        secondPassiveBtn.setBounds(2 * X_COORDINATE_OF_FIRST_BTN + WIDTH_OF_BTN, Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(secondPassiveBtn);
        secondPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(1));
                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
            }
        });
        add(secondPassiveBtn);

    }

    private void initFirstBtn() {
        firstPassiveBtn = new JButton(GameState.getInstance().getPassivesToChoose().get(0).getName());
        firstPassiveBtn.setBounds(X_COORDINATE_OF_FIRST_BTN, Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(firstPassiveBtn);
        firstPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(0));
                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
            }
        });
        add(firstPassiveBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        firstPassiveBtn.setText(GameState.getInstance().getPassivesToChoose().get(0).getName());
        secondPassiveBtn.setText(GameState.getInstance().getPassivesToChoose().get(1).getName());
        thirdPassiveBtn.setText(GameState.getInstance().getPassivesToChoose().get(2).getName());

    }
}
