package Gui;

public abstract class Loop implements Runnable {

    private int fps;
    private volatile boolean running = false;
    private Thread gameThread;

    public Loop(int fps) {
        this.fps = fps;
        gameThread = new Thread(this);

    }

    public abstract void update();

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfUpdate = 60.0;
        double nsPerUpdate = 1000000000 / amountOfUpdate;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (running) {
//            System.out.println("is running......................");
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;
            while (delta >= 1) {
                update(); //must take less than 16 million nano seconds
                delta--;
            }

        }
        stop();

    }


    public void start() {
        running = true;
        gameThread.start();
    }

    public void reStart() {

        gameThread=new Thread(this);
        running=true;
        gameThread.start();

    }


    public void stop() {

        running=false;
//            running=false;

    }


}
