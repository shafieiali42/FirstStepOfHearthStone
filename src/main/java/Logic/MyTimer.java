package Logic;

import Controller.Administer;
import View.Gui.Mapper;
import View.Gui.Panels.GamePage.PlayPanel;

public class MyTimer extends Thread {

    private long time1;
    private long time2;
    private int secondPassed = 0;
    private volatile boolean isRunning = true;


    @Override
    public void run() {
        time1 = System.currentTimeMillis();
        time2 = System.currentTimeMillis();

        while (true) {
            while (isRunning) {
                time2 = System.currentTimeMillis();
                while ((time2 - time1) >= 1000) {
                    time1 = System.currentTimeMillis();
                    time2 = System.currentTimeMillis();
                    secondPassed++;
//                    System.out.println(secondPassed);
                    if (secondPassed >=40 && secondPassed<60) {
                        PlayPanel.getInstance().setTime((60-secondPassed)+"");
                        Administer.setNeedTimer(true);
//                        System.out.println("You Have Only 20 seconds:))");
                    }

                    if (secondPassed == 60) {
                        Administer.setNeedTimer(false);
                        Mapper.endTurn();
//                        PlayPanel.getInstance().setEndTurn(true);
                        Administer.refreshPlayPanel();
//                        System.out.println("End Turn:))");
                        isRunning = false;
                    }
                }
            }
        }
    }

    public int getSecondPassed() {
        return secondPassed;
    }

    public void pause() {
        isRunning = false;
    }

    public void reStart() {
//        System.out.println("reStart");
        isRunning = false;
        time1 = System.currentTimeMillis();
        time2 = System.currentTimeMillis();
        secondPassed = 0;
        isRunning = true;
    }
}
