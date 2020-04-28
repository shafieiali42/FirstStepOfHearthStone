package Utility;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LengthOfMessage {

public static int lengthOfMessage(String message,Graphics2D graphics2D){

    graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 20));
    Rectangle2D bounds = graphics2D.getFontMetrics().getStringBounds(message, graphics2D);
    return (int) bounds.getWidth();
}



}
