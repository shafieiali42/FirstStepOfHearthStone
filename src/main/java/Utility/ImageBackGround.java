package Utility;

import javax.swing.*;
import java.awt.*;

public class ImageBackGround extends JPanel {

    private Image image;
    public void setImageBackGround(Image img) {
        this.image = img;
        setLayout(null);
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
    }

}