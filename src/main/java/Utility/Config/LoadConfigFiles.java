package Utility.Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LoadConfigFiles {

    private static LoadConfigFiles loadConfigFiles=new LoadConfigFiles();
    private String mainConfigFilesAdress ="src/main/resources/LogicConfigFiles/MainConfigFiles.properties";
    private HashMap<String,MyProperties> frameConfigs;
    private HashMap<String,MyProperties> panelConfigs;
    MyProperties properties;

    public  static LoadConfigFiles getInstance(){return loadConfigFiles;}

    private LoadConfigFiles()  {
        init();
    }


    private void init(){
        frameConfigs = new HashMap<>();
        panelConfigs = new HashMap<>();
        FileReader fileReader = null;
         properties = new MyProperties();
        try {
            fileReader = new FileReader(mainConfigFilesAdress);
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadProperies();
    }



    private void loadProperies() {
        Set<Map.Entry<Object,Object>> mainConfigSet = properties.entrySet();
        for (Map.Entry<Object,Object>config:mainConfigSet){
            String nameOfConfig =(String) config.getKey();
            String adress = (String) config.getValue();
            MyProperties myProperties =new MyProperties();
            try {
                FileReader reader =new FileReader(adress);
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (adress.toLowerCase().contains("frame")){
                frameConfigs.put(nameOfConfig,properties);
            }else if (adress.toLowerCase().contains("panel")){
                panelConfigs.put(nameOfConfig,properties);
            }

        }

    }

    public HashMap<String, MyProperties> getFrameConfigs() {
        return frameConfigs;
    }

    public HashMap<String, MyProperties> getPanelConfigs() {
        return panelConfigs;
    }
}
