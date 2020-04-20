package Cards;


import Utility.ImageOfAllCards;
import com.google.gson.annotations.Expose;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Cards {

    @Expose(serialize = false, deserialize = true)
    private String name;
    @Expose(serialize = false, deserialize = true)
    private int manaCost;
    @Expose(serialize = false, deserialize = true)
    private String rarity;
    @Expose(serialize = false, deserialize = true)
    private String description;
    @Expose(serialize = false, deserialize = true)
    private String classOfCard;
    @Expose(serialize = false, deserialize = true)
    public int MoneyCost;
    @Expose(serialize = false, deserialize = true)
    private String type;
    @Expose(serialize = false, deserialize = false)
    private transient Image imageOfThisCard;
    @Expose(serialize = false, deserialize = false)
    private transient CardImagePanel thisCardImagePanel;
    @Expose(serialize = false, deserialize = false)
    private static ArrayList<Cards> allCards = new ArrayList<Cards>();

    public static ArrayList<Cards> getAllCards() {
        return allCards;
    }


    public Cards() throws IOException {


    }

    public void setImageOfThisCard(Image imageOfThisCard) {
        this.imageOfThisCard = imageOfThisCard;
    }

//    {
//        ImageOfAllCards.setImageOfAllCardsList();
////        imageOfThisCard = ImageOfAllCards.getImageOfAllCardsList().get(0);
//////        this.imageOfThisCard = ImageIO.read(new File("Assets/CardsImage/LogInImage.jpg"));//TODO need another check!
//        thisCardImagePanel = new CardImagePanel(this);
//    }

    public static void setAllCards() throws IOException {
        allCards.addAll(Minion.getMinions());
        allCards.addAll(Spell.getSpells());
        allCards.addAll(Weapon.getWeapons());
        ImageOfAllCards.setImageOfAllCardsList();
        System.out.println(ImageOfAllCards.getImageOfAllCardsList().size());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getClassOfCard() {
        return classOfCard;
    }

    public void setClassOfCard(String classOfCard) {
        this.classOfCard = classOfCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoneyCost() {
        return MoneyCost;
    }

    public void setMoneyCost(int moneyCost) {
        MoneyCost = moneyCost;
    }

    public Image getImageOfThisCard() {
        return imageOfThisCard;
    }

    @Override
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money: " + this.getMoneyCost() + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        Cards card = (Cards) obj;
        if (this.getName().equals(card.getName())) {
            return true;
        } else {
            return false;
        }
    }


}
