package Gui.Panels.CollectionPages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeckPanel extends JPanel {


    private static final int WIDTH_OF_DECK_PANEL=205;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_DECK_PANEL=800;     //TODO NEEDS TO CHANGE

    public  int getWidthOfDeckPanel() {
        return WIDTH_OF_DECK_PANEL;
    }

    public  int getHeightOfDeckPanel() {
        return HEIGHT_OF_DECK_PANEL;
    }

    private static final int WIDTH_OF_BTN=50;
    private static final int HEIGHT_OF_BTN=20;
    private Color colorOfTextOfNewDeckBtn = new Color(255, 0, 0);
    private Color colorOfNewDeckBtn = new Color(48, 48, 45);
    private Color colorOfDeckBtn = new Color(48, 48, 45);

    private JButton newDeckBtn;
    private ArrayList<JButton> listOfButtonsOfDecks=new ArrayList<JButton>();

    private static DeckPanel deckPanel =new DeckPanel();
    public static DeckPanel getInstance(){return deckPanel;}

    private DeckPanel(){
        setBackground(Color.gray);
        setLayout(new FlowLayout(1,20,20));
        initNewDeckBtn();
        showDecksOfDeckList();

    }

    public void designDeckBtn(JButton btn){
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfDeckBtn);
        btn.setBackground(colorOfNewDeckBtn);
    }

    private void initListOfButtonsOfDecks() {
        JButton mage1Btn =new JButton("Mage1");
        JButton rogue1Btn =new JButton("Rogue1");
        JButton warlock1Btn =new JButton("Warlock1");
        JButton hunter1Btn =new JButton("Hunter1");
        JButton priest1Btn =new JButton("Priest1");
        designDeckBtn(mage1Btn);
        designDeckBtn(rogue1Btn);
        designDeckBtn(warlock1Btn);
        designDeckBtn(hunter1Btn);
        designDeckBtn(priest1Btn);

    }

    public void showDecksOfDeckList(){}//TODO NEEDS TO DEFINE:))

    private void initNewDeckBtn() {
        newDeckBtn = new JButton("New Deck");
        newDeckBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        newDeckBtn.setForeground(colorOfTextOfNewDeckBtn);
        newDeckBtn.setBackground(colorOfNewDeckBtn);
        newDeckBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        newDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeNewDeck();
            }
        });
        this.add(newDeckBtn);
    }

    private void makeNewDeck() {
    }//TODO NEEDS TO DEFINE:))


}
