package View.Gui.Panels.MyMainFrame;

import Utility.Config2.ConfigLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class MyMainFrame extends JFrame {

//    private FrameConfig frameConfig;
    private static int  width;
    private static int height;
    private static MyMainFrame myFrame =new MyMainFrame();
    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/MyMainFrame/MainFrameConfigFiles.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyMainFrame getInstance(){return myFrame;}


    public  int getMyFrameHeight() {
        return height;
    }
    public  int getMyFrameWidth(){return width;}



    private MyMainFrame(){

        this.initFrame();

    }

    private void initFrame() {
//        frameConfig=new FrameConfig("Main_Frame_Config_File");
        this.loadFrame();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void loadFrame() {
        width=Integer.parseInt(properties.getProperty("width"));
        height=Integer.parseInt(properties.getProperty("height"));
        setDefaultCloseOperation(Integer.parseInt(properties.getProperty("CloseOperation")));
        setResizable(Boolean.parseBoolean(properties.getProperty("Resizable")));
        setSize(width, height);
//        width=frameConfig.getWidth();
//        height =frameConfig.getHeight();
//        setResizable(frameConfig.getResizaable());
//        setDefaultCloseOperation(frameConfig.getCloseOperation());
    }


}
