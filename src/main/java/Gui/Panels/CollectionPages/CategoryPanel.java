package Gui.Panels.CollectionPages;

import Cards.Cards;
import CommandLineInterface.CLI;
import Utility.MethodsOfShowCardsOnPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryPanel extends JPanel {

    public static final int NUMBER_OF_BTN = 9;
    public static final int WIDTH_OF_BTN=90;
    public static final int HEIGHT_OF_BTN =90;
    private static final int WIDTH_OF_CATEGORY_PANEL=1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_CATEGORY_PANEL=80;     //TODO NEEDS TO CHANGE

    public  int getWidthOfCategoryPanel() {
        return WIDTH_OF_CATEGORY_PANEL;
    }

    public  int getHeightOfCategoryPanel() {
        return HEIGHT_OF_CATEGORY_PANEL;
    }

    private JButton mageBtn;
    private JButton rogueBtn;
    private JButton warlockBtn;
    private JButton hunterBtn;
    private JButton priestBtn;
    private JButton neutralBtn;
    private JButton allCardBtn;
    private JButton unLockBtn;
    private JButton lockBtn;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    private static CategoryPanel categoryPanel = new CategoryPanel();

    public static CategoryPanel getInstance() {
        return categoryPanel;
    }

    private CategoryPanel() {
        setBackground(Color.gray);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();
    }

    private void initButtons() {
        initMageBtn();
        initRogueBtn();
        initWarlockBtn();
        initHunterBtn();
        initPriestBtn();
        initNeutralBtn();
        initAllCardsBtn();
        initUnlockBtn();
        initLockBtn();
    }


    public void designBtn(JButton btn){
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);

    }

    private void initLockBtn() {
        lockBtn = new JButton("Lock");
        designBtn(lockBtn);
        lockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showLockCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(lockBtn);

    }

    private void initUnlockBtn() {
        unLockBtn = new JButton("UnLock");
        designBtn(unLockBtn);
        unLockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showUnLockCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(unLockBtn);
    }

    private void initAllCardsBtn() {
        allCardBtn = new JButton("All");
        designBtn(allCardBtn);
        allCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showAllCards();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(allCardBtn);
    }

    private void initNeutralBtn() {
        neutralBtn = new JButton("Neutral");
        designBtn(neutralBtn);
        neutralBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Neutral");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(neutralBtn);
    }

    private void initPriestBtn() {
        priestBtn = new JButton("Priest");
        designBtn(priestBtn);
        priestBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Priest");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(priestBtn);
    }

    private void initHunterBtn() {
        hunterBtn = new JButton("Hunter");
        designBtn(hunterBtn);
        hunterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Hunter");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(hunterBtn);
    }

    private void initWarlockBtn() {
        warlockBtn = new JButton("Warlock");
        designBtn(warlockBtn);
        warlockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Warlock");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(warlockBtn);
    }

    private void initRogueBtn() {
        rogueBtn = new JButton("Rogue");
        designBtn(rogueBtn);
        rogueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Rogue");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(rogueBtn);
    }

    private void initMageBtn() {
        mageBtn = new JButton("Mage");
        designBtn(mageBtn);
        mageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filterByClassOfCard("Mage");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(mageBtn);
    }




    public void filterByClassOfCard(String className) throws IOException {
        ArrayList<Cards> filteredCardsByClassOfCard =new ArrayList<Cards>();
        for (Cards card:Cards.getAllCards()){
            if (card.getClassOfCard().equalsIgnoreCase(className)){
                filteredCardsByClassOfCard.add(card);
            }
        }
        MethodsOfShowCardsOnPanel.showCards(filteredCardsByClassOfCard,CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    } //TODO show unlock cards with gray:((



    private void showAllCards() throws IOException {
        MethodsOfShowCardsOnPanel.showCards(Cards.getAllCards(),CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    }//TODO show unlock cards with gray:((

    private void showLockCards() throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getLockCards(),CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    }//TODO show unlock cards with gray:((

    private void showUnLockCards() throws IOException {
        MethodsOfShowCardsOnPanel.showCards(CLI.currentPlayer.getUnLockCards(),CardPanel.getInstance(),CardPanel.getNumOfCardInEveryRow());
    }//TODO show unlock cards with gray:((

}
