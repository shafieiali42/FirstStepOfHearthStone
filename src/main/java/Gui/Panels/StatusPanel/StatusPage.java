package Gui.Panels.StatusPanel;

import Gui.MyMainFrame;

import javax.swing.*;

public class StatusPage extends JPanel {


    private static StatusPage statusPage=new StatusPage();
    public static StatusPage getInstance(){return statusPage;}


    private StatusPage(){
        setLayout(null);
        setSize(MyMainFrame.getInstance().getMyFrameWidth(), MyMainFrame.getInstance().getMyFrameHeight());
        add(RankedPanel.getInstance());
        add(ShowDeckInfoPanel.getInstance());
    }



}
