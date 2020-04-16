package Gui;

import Utility.Config.FrameConfig;

import javax.swing.*;

public class MyMainFrame extends JFrame {

    private FrameConfig frameConfig;
    private static int  width;
    private static int height;


    public static int getFrameHeight() {
        return height;
    }
    public static int getFrameWidth(){return width;}

    public MyMainFrame(){

        this.initFrame();

    }

    private void initFrame() {
        frameConfig=new FrameConfig("Main_Frame_Config_File");
        this.configFrame();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void configFrame() {
        width=frameConfig.getWidth();
        height =frameConfig.getHeight();
        setSize(width, height);
        setResizable(frameConfig.getResizaable());
        setDefaultCloseOperation(frameConfig.getCloseOperation());
    }


}
