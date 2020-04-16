package Utility.Config;

public class FrameConfig {

    private MyProperties myProperties;
    private int width,height;
    private String name;
    private int closeOperation;
    private boolean resizaable;

    public FrameConfig(String name){
        this.name=name;
        setMyProperties();
        init();
    }

    private void init() {
        width=myProperties.readInteger("width");
        height=myProperties.readInteger("height");
        closeOperation=myProperties.readInteger("CloseOperation");
        resizaable=myProperties.readBoolean("Resizable");
    }

    public void setMyProperties(){
        myProperties =LoadConfigFiles.getInstance().getFrameConfigs().get(this.name);
    }

    public MyProperties getMyProperties() {
        return myProperties;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getName() {
        return name;
    }
    public int getCloseOperation() {
        return closeOperation;
    }
    public boolean getResizaable() {
        return resizaable;
    }

}
