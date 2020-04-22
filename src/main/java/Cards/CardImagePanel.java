package Cards;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardImagePanel extends JPanel {

    private BufferedImage imageOfCard;
    private boolean isLock;

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(boolean islock) {
        isLock = islock;
    }

    public BufferedImage getImageOfCard() {
        return imageOfCard;
    }

    private static final int WidthOfCardImage = 150;    //TODO IT SHOULD CHANGE:))
    private static final int HEIGHTOfCardImage = 170;    //TODO IT SHOULD CHANGE:))

    public static int getWidthOfCardImage() {
        return WidthOfCardImage;
    }

    public static int getHEIGHTOfCardImage() {
        return HEIGHTOfCardImage;
    }

    public CardImagePanel(Cards card) throws IOException {
        setLayout(null);
//        card.setImageOfThisCard(ImageIO.read(new File("src/main/resources/Assets/CardsImage/"+card.getName()+".png")));
//        imageOfCard=card.getImageOfThisCard();
//        imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/"+card.getName()+".png"));

        imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/"+card.getName()+".png"));
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageOfCard, 0, 0, this.getWidth(), this.getHeight(), null);
//        Graphics2D graphics2D =(Graphics2D)g;
//        makeItGrey(this.isLock,graphics2D);
    }

//    private void makeItGrey(boolean isLock,Graphics2D graphics2D) {
//        if (isLock){
//            graphics2D.setColor(new Color(50,50,50,150));
//            graphics2D.fillRect(7,15,this.getWidth()-10,this.getHeight()-15);
//        }
//    }


}
