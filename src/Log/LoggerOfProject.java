package Log;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public static void writeDeletePlayerInLog(String FilePath) throws IOException {
        File temp =new File("tem.log");
        FileReader fileReader =new FileReader(FilePath);
        BufferedReader bufferedReader =new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(temp);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        String st = new String();
        while ((st=bufferedReader.readLine()) !=null){
            bufferedWriter.write(st+"\n");
            if (st.startsWith("PASSWORD")){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                bufferedWriter.write("DELETED_AT: "+dateFormat.format(cal.getTime()));
            }
        }

        fileReader.close();fileWriter.flush();fileWriter.close();bufferedReader.close();bufferedWriter.flush();bufferedWriter.close();
        FileReader fileReader1 =new FileReader(temp);
        FileWriter fileWriter1 =new FileWriter(FilePath);
        BufferedReader bufferedReader1 =new BufferedReader(fileReader1);
        BufferedWriter bufferedWriter1 =new BufferedWriter(fileWriter1);
        String string =new String();
        while ((string=bufferedReader1.readLine()) != null){
            bufferedWriter1.write(string+"\n");
        }
        fileReader1.close();fileWriter1.flush();fileWriter1.close();bufferedReader1.close();bufferedWriter1.flush();bufferedWriter1.close();




    }

}

