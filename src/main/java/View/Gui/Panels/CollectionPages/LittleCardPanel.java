package View.Gui.Panels.CollectionPages;

import Controller.Administer;
import Controller.CollectionController;
import Utility.Config2.ConfigLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;


public class LittleCardPanel extends JPanel implements MouseListener, Serializable {

    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/LittleCardPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int height=Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));

    int width=Integer.parseInt(properties.getProperty("WIDTH_OF_LITTLE_CARD"));


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
        setSize(width,height);
        manaLabel = new JLabel();
        manaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        manaLabel.setText(mana + "");
        manaLabel.setOpaque(true);
        manaLabel.setBackground(Color.RED);
        manaLabel.setBounds(0, 0, height, height);
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText(name);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.ORANGE);
        nameLabel.setBounds(height, 0,
                (width - 2 * height),
               height);
        nameLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    CollectionController.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
                    DeckViewer.getInstance().showCardsInDecK();

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
        usedLabel.setBounds((width - height), 0, height, height);
        add(manaLabel);
        add(nameLabel);
        add(usedLabel);
    }

    public static void setAllLittleCardPanels() {
        allLittleCardPanels.clear();
        CollectionController.initializeAllLittleCardPanels();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            CollectionController.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
            DeckViewer.getInstance().showCardsInDecK();

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
