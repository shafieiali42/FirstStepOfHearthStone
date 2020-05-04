package Gui.Panels.GamePage;

import Gui.Loop;
import Gui.MyMainFrame;

public class GraphicLoop extends Loop {

    private static GraphicLoop graphicLoop = new GraphicLoop(60);
    public static GraphicLoop getInstance() {
        return graphicLoop;
    }


    public GraphicLoop(int fps) {
        super(fps);
    }

    @Override
    public void update() {
        PlayPanel.getInstance().repaint();
        PlayPanel.getInstance().revalidate();
        GamePage.getInstance().repaint();
        GamePage.getInstance().revalidate();
    }
}
