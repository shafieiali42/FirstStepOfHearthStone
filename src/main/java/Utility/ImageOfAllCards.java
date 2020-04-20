package Utility;

import Cards.Cards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageOfAllCards {

    public static ArrayList<BufferedImage> getImageOfAllCardsList() {
        return imageOfAllCardsList;
    }

    private static ArrayList<BufferedImage> imageOfAllCardsList =new ArrayList<BufferedImage>();

    public static void setImageOfAllCardsList() throws IOException {
        for (Cards card : Cards.getAllCards()) {
            System.out.println(Cards.getAllCards().size());
            imageOfAllCardsList.add(ImageIO.read(new File("src/main/resources/Assets/CardsImage/PlaguedKnife.png")));
        }
    }


}
