package Utility.Log;

import java.io.*;
import java.util.logging.*;

public class LoggerOfProject implements Serializable {
    static FileHandler fileTxt;
    static SimpleFormatter formatterTxt;
//    public static final Logger logger = Logger.getLogger("");

    public static Logger getMyLogger(String FilePath) throws IOException {

        Logger logger = Logger.getLogger("");
        logger.removeHandler(logger.getHandlers()[0]);
//        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler(FilePath, true);
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        return logger;
    }

}

