package Utility.Config;

import java.util.Properties;

public class MyProperties extends Properties {

    public int readInteger(String configKey){
        return Integer.parseInt(this.getProperty(configKey));
    }
    public boolean readBoolean(String configKey){
        return Boolean.parseBoolean(this.getProperty(configKey));
    }

}
