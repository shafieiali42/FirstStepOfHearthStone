package Gui.Panels.CollectionPages;

import Controller.Administer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;


public class LittleCardPanel extends JPanel implements MouseListener, Serializable {


    private static final int WIDTH_OF_LITTLE_CARD = 225;
    private static final int HEIGHT_OF_LITTLE_CARD = 20;

    public static int getWidthOfLittleCard() {
        return WIDTH_OF_LITTLE_CARD;
    }

    public static int getHeightOfLittleCard() {
        return HEIGHT_OF_LITTLE_CARD;
    }

    public JLabel getManaLabel() {
        return manaLabel;
    }

    public JLabel getUsedLabel() {
        return usedLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public static ArrayList<LittleCardPanel> getAllLittleCardPanels() {
        return allLittleCardPanels;
    }

    private JLabel manaLabel;
    private JLabel usedLabel;
    private JLabel nameLabel;

    private static ArrayList<LittleCardPanel> allLittleCardPanels = new ArrayList<LittleCardPanel>();

    public LittleCardPanel(int mana, String name, int used) {
        setLayout(null);
        setSize(WIDTH_OF_LITTLE_CARD, HEIGHT_OF_LITTLE_CARD);
        manaLabel = new JLabel();
        manaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        manaLabel.setText(mana + "");
        manaLabel.setOpaque(true);
        manaLabel.setBackground(Color.RED);
        manaLabel.setBounds(0, 0, HEIGHT_OF_LITTLE_CARD, HEIGHT_OF_LITTLE_CARD);
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText(name);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.ORANGE);
        nameLabel.setBounds(HEIGHT_OF_LITTLE_CARD, 0, (WIDTH_OF_LITTLE_CARD - 2 * HEIGHT_OF_LITTLE_CARD), HEIGHT_OF_LITTLE_CARD);
        nameLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Administer.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
                    DeckViewer.getInstance().showCardsInDecK();
//                    Iterator<Cards> itr = DeckPage.getInstance().getDeckTOChange().getListOfCards().iterator();
//                    while (itr.hasNext()) {
//                        Cards card = itr.next();
//                        if (card.getName().equalsIgnoreCase(nameLabel.getText())) {
//                            if (Integer.parseInt(usedLabel.getText()) == 1) {
//                                itr.remove();
//                                DeckViewer.getInstance().showCardsInDecK();
//                                break;
//                            } else if (Integer.parseInt(usedLabel.getText()) == 2) {
//                                usedLabel.setText(1 + "");
//                                break;
//                            }
//                            DeckViewer.getInstance().showCardsInDecK();
////                    DeckPage.getInstance().getDeckTOChange().defineUsesHashMap();
////                    DeckPage.getInstance().getDeckTOChange().setLittleCardsListFromHashMap();
//                        }
//                    }


                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        usedLabel = new JLabel();
        usedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usedLabel.setText(used + "");
        usedLabel.setOpaque(true);
        usedLabel.setBackground(Color.RED);
        usedLabel.setBounds((WIDTH_OF_LITTLE_CARD - HEIGHT_OF_LITTLE_CARD), 0, HEIGHT_OF_LITTLE_CARD, HEIGHT_OF_LITTLE_CARD);
        add(manaLabel);
        add(nameLabel);
        add(usedLabel);
    }

    public static void setAllLittleCardPanels() {
        allLittleCardPanels.clear();
        Administer.initializeAllLittleCardPanels();
//        for (Cards card : Cards.getAllCards()) {
//            allLittleCardPanels.add(new LittleCardPanel(card.getManaCost(), card.getName(), 0));
//        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Administer.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
            DeckViewer.getInstance().showCardsInDecK();
//            Iterator<Cards> itr = DeckPage.getInstance().getDeckTOChange().getListOfCards().iterator();
//            while (itr.hasNext()) {
//                Cards card = itr.next();
//                if (card.getName().equalsIgnoreCase(this.nameLabel.getText())) {
//                    if (Integer.parseInt(this.usedLabel.getText()) == 1) {
//                        itr.remove();
//                        break;
//                    } else if (Integer.parseInt(this.usedLabel.getText()) == 2) {
//                        this.usedLabel.setText(1 + "");
//                        break;
//                    }
//                    DeckViewer.getInstance().showCardsInDecK();
//                    DeckPage.getInstance().getDeckTOChange().defineUsesHashMap();
//                    DeckPage.getInstance().getDeckTOChange().setLittleCardsListFromHashMap();
//                }
//            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
