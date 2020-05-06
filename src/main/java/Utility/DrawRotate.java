package Utility;

import java.awt.*;

public class DrawRotate {

    public static void drawRotate(Graphics2D g2d, double x, double y, int angle, String text) {
        g2d.setFont(new Font("serif", Font.ITALIC, 30));
        g2d.translate((float) x, (float) y);
        g2d.rotate(Math.toRadians(angle));
        g2d.drawString(text, 0, 0);
        g2d.rotate(-Math.toRadians(angle));
        g2d.translate(-(float) x, -(float) y);
    }

}
