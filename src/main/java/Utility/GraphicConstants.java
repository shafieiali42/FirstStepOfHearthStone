package Utility;

import Utility.Config.LoadConfigFiles;
import Utility.Config.MyProperties;

public class GraphicConstants {

    private MyProperties properties ;
    private String name;
    private static GraphicConstants constants;
    private GraphicConstants(){
        this("Constants");
    }

    private GraphicConstants(String name) {
        this.name = name;
        properties = LoadConfigFiles.getInstance().getGraphicConstantsProperties(name);
//        System.out.println(name);
    }
    public static GraphicConstants getInstance(String name){
        if(constants == null){
            constants = new GraphicConstants(name);
        }
        return constants;
    }
    public static GraphicConstants getInstance(){
        return GraphicConstants.getInstance("Constants");
    }

    public int getConstant(String name){
        return properties.readInteger(name);
    }
}
