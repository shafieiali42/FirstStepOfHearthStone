package View.Gui.Panels.CollectionPages;

import Controller.Administer;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CategoryPanelOfChangeDeck extends JPanel {


    public static final int NUMBER_OF_BTN = 9;
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);



    private JButton HeroCardsBtn;
    private JButton neutralBtn;
    private JButton changeNameBtn;
    private JButton changeHeroBtn;
    private JButton removeDeckBtn;
    private JButton selectDeckBtn;


    private static CategoryPanelOfChangeDeck categoryPanelOfChangeDeck = new CategoryPanelOfChangeDeck();

    public static CategoryPanelOfChangeDeck getInstance() {
        return categoryPanelOfChangeDeck;
    }

    private CategoryPanelOfChangeDeck() {
        setBackground(Color.cyan);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();
    }

    private void initButtons() {
        initHeroCardsBtn();
        initNeutralBtn();
        initChangeNameBtn();
        initChangeHeroBtn();
        initSelectDeckBtn();
        initRemoveDeckBtn();


    }


    private void initSelectDeckBtn() {
        selectDeckBtn = new JButton("Select Deck");
        designBtn(selectDeckBtn);
        selectDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDeck();
            }
        });
        add(selectDeckBtn);
    }

    private void selectDeck() {
//        CLI.currentPlayer.setCurrentDeck(DeckPage.getInstance().getDeckTOChange());
        Administer.selectMainDeck();
        JOptionPane.showMessageDialog(null, "Your Deck is:" + DeckPage.getInstance().getNameOfDeckToChange());
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("select " + DeckPage.getInstance().getDeckTOChange().getName() + " for main deck");
    }

    private void initChangeNameBtn() {
        changeNameBtn = new JButton("Change Name");
        designBtn(changeNameBtn);
        changeNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeName();
            }
        });
        add(changeNameBtn);
    }

    private void changeName() {
        String name=JOptionPane.showInputDialog("Enter your favorite name!");
        Administer.changeNameOfDeck(name);
//        DeckPage.getInstance().getDeckTOChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Change name of deck ");
    }


    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initChangeHeroBtn() {
        changeHeroBtn = new JButton("Change Hero");
        designBtn(changeHeroBtn);
        changeHeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeHero();
            }
        });
        add(changeHeroBtn);
    }

    private void changeHero() {
        Object[] possibilities = {"Mage", "Rogue", "Warlock", "Hunter", "Priest"};
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String s = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Hero:",
                "Select Hero",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                Administer.getHeroNameOfDeckToChange());

        Administer.changeHeroOfDeck(s);
//        switch (s){ // TODO needs changesssssssssssssssssssssssssss:(((((((((((
//            case ("Mage"):
//                DeckPage.getInstance().getDeckTOChange().setHero(Mage.getInstance());
//                break;
//            case ("Rogue"):
//                DeckPage.getInstance().getDeckTOChange().setHero(Rogue.getInstance());
//                break;
//            case ("Warlock"):
//                DeckPage.getInstance().getDeckTOChange().setHero(Warlock.getInstance());
//                break;
//            case ("Hunter"):
//                DeckPage.getInstance().getDeckTOChange().setHero(Hunter.getInstance());
//                break;
//            case ("Priest"):
//                DeckPage.getInstance().getDeckTOChange().setHero(Priest.getInstance());
//                break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + s);
//        }
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Changed hero to "+s);

    }

    private void initRemoveDeckBtn() {
        removeDeckBtn = new JButton("Remove Deck");
        designBtn(removeDeckBtn);
        removeDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeDeck();
            }
        });
        add(removeDeckBtn);
    }

    private void removeDeck() {
//        CLI.currentPlayer.getAllDecksOfPlayer().remove(DeckPage.getInstance().getDeckTOChange());
        Administer.removeDeck();
        DeckPanel.getInstance().showDeckButtons();
        CollectionPage.getInstance().repaint();
        CollectionPage.getInstance().revalidate();
        MyMainFrame.getInstance().setContentPane(CollectionPage.getInstance());
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Removed "+DeckPage.getInstance().getDeckTOChange().getName());
    }

    private void initNeutralBtn() {
        neutralBtn = new JButton("Neutral");
        designBtn(neutralBtn);
        neutralBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.showCardsOnCardPanelWithSpecifiedClass("Neutral",
                            CardPanel.getInstanceOfDeckPage(), CardPanel.getNumOfCardInEveryRow());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(neutralBtn);
    }

    private void initHeroCardsBtn() {
        HeroCardsBtn = new JButton("Hero Cards");
        designBtn(HeroCardsBtn);
        HeroCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Administer.showCardsOnCardPanelWithSpecifiedClass(Administer.getHeroNameOfDeckToChange(),
                            CardPanel.getInstanceOfDeckPage(), CardPanel.getNumOfCardInEveryRow());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(HeroCardsBtn);
    }

//    public void filterByClassOfCard(String className) throws IOException {
//        ArrayList<Cards> filteredCardsByClassOfCard =new ArrayList<Cards>();
//        for (Cards card:Cards.getAllCards()){
//            if (card.getClassOfCard().equalsIgnoreCase(className)){
//                filteredCardsByClassOfCard.add(card);
//            }
//        }
//        MethodsOfShowCardsOnPanel.showCards(filteredCardsByClassOfCard,CardPanel.getInstanceOfDeckPage(),CardPanel.getNumOfCardInEveryRow());
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show " +className+" cards");
//    } //TODO show unlock cards with gray:((


}
