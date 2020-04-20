package Cards;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CardImagePanel extends JPanel {

    private Image imageOfCard;
    private static final int WidthOfCardImage=150;    //TODO IT SHOULD CHANGE:))
    private static final int HEIGHTOfCardImage=170;    //TODO IT SHOULD CHANGE:))

    public  static int getWidthOfCardImage() {
        return WidthOfCardImage;
    }

    public static   int getHEIGHTOfCardImage() {
        return HEIGHTOfCardImage;
    }

    public CardImagePanel(Cards card) throws IOException {
        setLayout(null);
        card.setImageOfThisCard(ImageIO.read(new File("src/main/resources/Assets/CardsImage/"+card.getName()+".png")));
        imageOfCard=card.getImageOfThisCard();
    }

//    public  void addThisCardToAppropriatePanel(JPanel panel,int x, int y, int width , int height){
//        this.setBounds(x,y,width,height);
//        panel.add(this);
//    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageOfCard,0,0,this.getWidth(),this.getHeight(),null);
    }
}
