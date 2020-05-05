package Gui.Panels.StatusPanel;


import CommandLineInterface.CLI;
import Deck.Deck;
import Gui.MyMainFrame;
import Utility.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class RankedPanel extends JPanel {

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN=MyMainFrame.getInstance().getWidth()/2;
    public static final int HEIGHT_OF_BTN = 78;
    private static final int WIDE_OF_RANKED_PANEL =700;
    private static final int HEIGHT_OF_RANKED_PANEL=800;


    private static RankedPanel rankedPanel=new RankedPanel();
    public static RankedPanel getInstance(){return rankedPanel;}

    private JButton firstBtn;
    private JButton secondBtn;
    private JButton thirdBtn;
    private JButton fourthBtn;
    private JButton fifthBtn;
    private JButton sixthBtn;
    private JButton seventhBtn;
    private JButton eighthBtn;
    private JButton ninthBtn;
    private JButton tenthBtn;

    private RankedPanel(){
        setLayout(null);
        setSize(WIDE_OF_RANKED_PANEL,HEIGHT_OF_RANKED_PANEL);
        setBounds(700,0,WIDE_OF_RANKED_PANEL,HEIGHT_OF_RANKED_PANEL);
        initButtons();
    }

    public void designBtn(JButton btn){
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    public void initButtons(){
        initFirstBtn();
        initSecondBtn();
        initThirdBtn();
        initFourthBtn();
        initFifthBtn();
        initSixthBtn();
        initSeventhBtn();
        initEighthBtn();
        initNinthBtn();
        initTenthBtn();
    }

    private void initTenthBtn() {
        tenthBtn=new JButton("Tenth Deck");
        designBtn(tenthBtn);
        tenthBtn.setBounds(0,firstBtn.getHeight()*9,secondBtn.getWidth(),secondBtn.getHeight());
        tenthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(10);
            }
        });
        add(tenthBtn);
    }

    private void initNinthBtn() {
        ninthBtn=new JButton("Ninth Deck");
        designBtn(ninthBtn);
        ninthBtn.setBounds(0,firstBtn.getHeight()*8,secondBtn.getWidth(),secondBtn.getHeight());
        ninthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(9);
            }
        });
        add(ninthBtn);
    }

    private void initEighthBtn() {
        eighthBtn=new JButton("Eighth Deck");
        designBtn(eighthBtn);
        eighthBtn.setBounds(0,firstBtn.getHeight()*7,secondBtn.getWidth(),secondBtn.getHeight());
        eighthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(8);
            }
        });
        add(eighthBtn);
    }

    private void initSeventhBtn() {
        seventhBtn=new JButton("Seventh Deck");
        designBtn(seventhBtn);
        seventhBtn.setBounds(0,firstBtn.getHeight()*6,secondBtn.getWidth(),secondBtn.getHeight());
        seventhBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(7);
            }
        });
        add(seventhBtn);
    }

    private void initSixthBtn() {
        sixthBtn=new JButton("Sixth Deck");
        designBtn(sixthBtn);
        sixthBtn.setBounds(0,firstBtn.getHeight()*5,secondBtn.getWidth(),secondBtn.getHeight());
        sixthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(6);
            }
        });
        add(sixthBtn);
    }

    private void initFifthBtn() {
        fifthBtn=new JButton("Fifth Deck");
        designBtn(fifthBtn);
        fifthBtn.setBounds(0,firstBtn.getHeight()*4,secondBtn.getWidth(),secondBtn.getHeight());
        fifthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(5);
            }
        });
        add(fifthBtn);
    }

    private void initFourthBtn() {
        fourthBtn=new JButton("Fourth Deck");
        designBtn(fourthBtn);
        fourthBtn.setBounds(0,firstBtn.getHeight()*3,secondBtn.getWidth(),secondBtn.getHeight());
        fourthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(4);
            }
        });
        add(fourthBtn);
    }

    private void initThirdBtn() {
        thirdBtn=new JButton("Third Deck");
        designBtn(thirdBtn);
        thirdBtn.setBounds(0,firstBtn.getHeight()*2,secondBtn.getWidth(),secondBtn.getHeight());
        thirdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(3);
            }
        });
        add(thirdBtn);
    }

    private void initSecondBtn() {
        secondBtn=new JButton("Second Deck");
        designBtn(secondBtn);
        secondBtn.setBounds(0,firstBtn.getHeight(),secondBtn.getWidth(),secondBtn.getHeight());
        secondBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(2);
            }
        });
        add(secondBtn);
    }

    private void initFirstBtn() {
        firstBtn=new JButton("First Deck");
        designBtn(firstBtn);
        firstBtn.setBounds(0,0,firstBtn.getWidth(),firstBtn.getHeight());
        firstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeckNumber(1);
            }
        });
        add(firstBtn);
    }


    public void sortDecks(){
        Collections.sort(CLI.currentPlayer.getAllDecksOfPlayer());
    }


    private void showDeckNumber(int deckNumber) {
        sortDecks();
        ShowDeckInfoPanel.getInstance().setDeckToShow(CLI.currentPlayer.getAllDecksOfPlayer().get(deckNumber-1));
        ShowDeckInfoPanel.getInstance().setReadyToShow(true);
        ShowDeckInfoPanel.getInstance().repaint();
        ShowDeckInfoPanel.getInstance().revalidate();
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Show best deck, deck number: "+ deckNumber);
    }



}


 class ShowDeckInfoPanel extends JPanel {

    private static final int WIDE_OF_SHOW_INFO_PANEL =700;
    private static final int HEIGHT_OF_SHOW_INFO_PANEL=800;

    private static ShowDeckInfoPanel showDeckInfoPanel=new ShowDeckInfoPanel();
    public static ShowDeckInfoPanel getInstance(){return showDeckInfoPanel;}
    private Deck deckToShow;
    private boolean readyToShow=false;

     public Deck getDeckToShow() {
         return deckToShow;
     }

     public void setDeckToShow(Deck deckToShow) {
         this.deckToShow = deckToShow;
     }

     public boolean isReadyToShow() {
         return readyToShow;
     }

     public void setReadyToShow(boolean readyToShow) {
         this.readyToShow = readyToShow;
     }

     private ShowDeckInfoPanel(){
        setLayout(null);
        setSize(WIDE_OF_SHOW_INFO_PANEL,HEIGHT_OF_SHOW_INFO_PANEL);
        setBounds(0,0,WIDE_OF_SHOW_INFO_PANEL,HEIGHT_OF_SHOW_INFO_PANEL);
        setBackground(Color.orange);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D=(Graphics2D)g;
        if(readyToShow){
            deckToShow.defineMostUsedCard();
        String name = "Name: "+deckToShow.getName();int lengthOfName= LengthOfMessage.lengthOfMessage(name,graphics2D);
        String heroName="Hero: "+deckToShow.getHeroName();int lengthOfHeroName= LengthOfMessage.lengthOfMessage(heroName,graphics2D);
        String wins = "Wins:"+deckToShow.getNumberOfWins();int lengthOfWins= LengthOfMessage.lengthOfMessage(wins,graphics2D);
        String use= "Uses: "+deckToShow.getNumberOfUses();int lengthOfUse= LengthOfMessage.lengthOfMessage(use,graphics2D);
        String mostUsedCard ="Most Used Card: "+deckToShow.getMostUsedCard().getName();
        int lengthOfCard= LengthOfMessage.lengthOfMessage(mostUsedCard,graphics2D);
        String manaAvg="Average of Mana: "+deckToShow.getManaAvg();
        int lengthOfMana= LengthOfMessage.lengthOfMessage(manaAvg,graphics2D);
        if (deckToShow.getNumberOfUses()==0){
            deckToShow.setNumberOfUses(1);
        }
        String winsPerPlay = "Wins per Play: "+(deckToShow.getNumberOfWins()/deckToShow.getNumberOfUses())*100+" %";
        int lengthOfWinsPerPlay= LengthOfMessage.lengthOfMessage(winsPerPlay,graphics2D);
        graphics2D.drawString(name,(this.getWidth()-lengthOfName)/2,50);
        graphics2D.drawString(heroName,(this.getWidth()-lengthOfHeroName)/2,100);
        graphics2D.drawString(wins,(this.getWidth()-lengthOfWins)/2,150);
        graphics2D.drawString(use,(this.getWidth()-lengthOfUse)/2,200);
        graphics2D.drawString(mostUsedCard,(this.getWidth()-lengthOfCard)/2,250);
        graphics2D.drawString(manaAvg,(this.getWidth()-lengthOfMana)/2,300);
        graphics2D.drawString(winsPerPlay,(this.getWidth()-lengthOfWinsPerPlay)/2,350);
        }



    }

}

