package View.Gui.Loop;

import View.Gui.Panels.MyMainFrame.MyMainFrame;


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

        MyMainFrame.getInstance().repaint();
        MyMainFrame.getInstance().revalidate();
//        GamePage.getInstance().repaint();
//        GamePage.getInstance().revalidate();
    }
}
