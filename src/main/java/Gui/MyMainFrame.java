package Gui;

import Utility.Config.FrameConfig;

import javax.swing.*;

public class MyMainFrame extends JFrame {

    private FrameConfig frameConfig;
    private static int  width;
    private static int height;
    private static MyMainFrame myFrame =new MyMainFrame();
    public static MyMainFrame getInstance(){return myFrame;}


    public  int getMyFrameHeight() {
        return height;
    }
    public  int getMyFrameWidth(){return width;}


    public static void switchPanel(JPanel firstPanel,JPanel secondPanel){
        getInstance().remove(firstPanel);
        getInstance().setContentPane(secondPanel);
        getInstance().setVisible(true);
    }

    private MyMainFrame(){

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
