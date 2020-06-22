package View.Gui.Animation;


import View.CardView.CardImagePanel;
import View.Gui.Panels.GamePage.GamePage;
import View.Gui.Panels.GamePage.PlayPanel;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class RotatedPic {

    protected int originX, originY, destinationX, destinationY;
    private final CardImagePanel image;

    public RotatedPic(int originX, int originY, int destinationX, int destinationY, CardImagePanel image) {
        this.originX = originX;
        this.originY = originY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.image = image;
    }

    public void rotate(Graphics2D graphics2D, int frame) {
//        System.out.println(frame);
        double framePerSecond=60.0;
        frame %= framePerSecond;
        double x = originX + (destinationX - originX) * (frame / framePerSecond);
        double y = originY + (destinationY - originY) * (frame / framePerSecond);

        if ((x - destinationX) < 10 && (y - destinationY) < 10) {
            AnimationOfRotation.running=false;
            MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
            PlayPanel.getInstance().setNeedsToRepaint(true);
            GamePage.getInstance().repaint();
            GamePage.getInstance().revalidate();
            return;
        }
        AffineTransform backup = graphics2D.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(2 * Math.PI * (frame / framePerSecond),
                x+image.getWidth() / 2.0, y+image.getHeight() / 2.0);
        graphics2D.setTransform(a);
        graphics2D.drawImage(image.getImageOfCard(), (int) x, (int) y, null);
        graphics2D.setTransform(backup);
    }
}
