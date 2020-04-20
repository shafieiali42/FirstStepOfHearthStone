package Gui.Panels.CollectionPages;

import Cards.Cards;
import Gui.MyMainFrame;
import Gui.Panels.MenuPanel.MainMenuPage;
import Utility.ShowCardsOnPanel;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ManaPanel extends JPanel {

    private static final int WIDTH_OF_MANA_PANEL = 1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_MANA_PANEL = 100;     //TODO NEEDS TO CHANGE

    public int getWidthOfManaPanel() {
        return WIDTH_OF_MANA_PANEL;
    }

    public int getHeightOfManaPanel() {
        return HEIGHT_OF_MANA_PANEL;
    }

    private static final int NUM_OF_COMPONENT = 13;
    private static final int WIDTH_OF_MANA_BTN = 20;
    private static final int HEIGHT_OF_MANA_BTN = 8;
    private static final int WIDTH_OF_BACK_BTN = 20;
    private static final int HEIGHT_OF_BACK_BTN = 20;
    private Color colorOfManaBtn = new Color(255, 0, 0);
    private Color colorOfTextOfBtn = new Color(48, 48, 45);
    private Color colorOfBackBtn = new Color(255, 0, 0);

    private JTextField searchField;
    private JButton searchBtn;
    private JButton backBtn;
    private JButton oneManaBtn;
    private JButton twoManaBtn;
    private JButton threeManaBtn;
    private JButton fourManaBtn;
    private JButton fiveManaBtn;
    private JButton sixManaBtn;
    private JButton sevenManaBtn;
    private JButton eightManaBtn;
    private JButton nineManaBtn;
    private JButton tenManaBtn;

    private static ManaPanel manaPanel = new ManaPanel();

    public static ManaPanel getInstance() {
        return manaPanel;
    }


    private ManaPanel() {
        setBackground(Color.gray);
        setLayout(new FlowLayout(NUM_OF_COMPONENT, 20, 20));
        initButtons();
        initSearchTools();
    }

    private void initButtons() {
        initBackBtn();
        initOneManaBtn();
        initTwoManaBtn();
        initThreeManaBtn();
        initFourManaBtn();
        initFiveManaBtn();
        initSixManaBtn();
        initSevenManaBtn();
        initEightManaBtn();
        initNineManaBtn();
        initTenManaBtn();
    }

    private void initSearchTools() {
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");
        searchBtn.setSize(40, 20);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchInCards(searchField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(searchField);
        add(searchBtn);
    }

    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_MANA_BTN, HEIGHT_OF_MANA_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfManaBtn);
    }


    private void initTenManaBtn() {
        tenManaBtn = new JButton("10");
        designBtn(tenManaBtn);
        tenManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(tenManaBtn);
    }

    private void initNineManaBtn() {
        nineManaBtn = new JButton("9");
        designBtn(nineManaBtn);
        nineManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(9);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(nineManaBtn);
    }

    private void initEightManaBtn() {
        eightManaBtn = new JButton("8");
        designBtn(eightManaBtn);
        eightManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(8);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(eightManaBtn);
    }

    private void initSevenManaBtn() {
        sevenManaBtn = new JButton("7");
        designBtn(sevenManaBtn);
        sevenManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(7);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(sevenManaBtn);
    }

    private void initSixManaBtn() {
        sixManaBtn = new JButton("6");
        designBtn(sixManaBtn);
        sixManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(6);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(sixManaBtn);
    }

    private void initFiveManaBtn() {
        fiveManaBtn = new JButton("5");
        designBtn(fiveManaBtn);
        fiveManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(fiveManaBtn);
    }

    private void initFourManaBtn() {
        fourManaBtn = new JButton("4");
        designBtn(fourManaBtn);
        fourManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(4);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(fourManaBtn);
    }

    private void initThreeManaBtn() {
        threeManaBtn = new JButton("3");
        designBtn(threeManaBtn);
        threeManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(3);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(threeManaBtn);
    }

    private void initTwoManaBtn() {
        twoManaBtn = new JButton("2");
        designBtn(twoManaBtn);
        twoManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(twoManaBtn);
    }

    private void initOneManaBtn() {
        oneManaBtn = new JButton("1");
        designBtn(oneManaBtn);
        oneManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByMana(1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(oneManaBtn);
    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        backBtn.setForeground(colorOfTextOfBtn);
        backBtn.setBackground(colorOfBackBtn);
        backBtn.setSize(WIDTH_OF_BACK_BTN, HEIGHT_OF_BACK_BTN);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
        this.add(backBtn);
    }

    private void goBack() {
        MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
    }

    private void searchInCards(String searchFieldText) throws IOException {
        ArrayList<Cards> foundCards =new ArrayList<Cards>();
        for (Cards card:Cards.getAllCards()){
            if (card.getName().toLowerCase().contains(searchFieldText)){
                foundCards.add(card);
            }
        }
        ShowCardsOnPanel.showCards(foundCards,CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    }//TODO make unlock cards gray:((

    public void filterByMana(int mana) throws IOException {
        ArrayList<Cards> filteredByManaCards=new ArrayList<Cards>();
        for (Cards card:Cards.getAllCards()){
            if (card.getManaCost()==mana){
                filteredByManaCards.add(card);
            }
        }
        ShowCardsOnPanel.showCards(filteredByManaCards,CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    }//TODO make unlock cards gray:((

}
