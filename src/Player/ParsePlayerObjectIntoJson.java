package Player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.ObjectWriter;
//import org.codehaus.jackson.map.util.JSONPObject;
//import org.codehaus.jackson.node.ArrayNode;
//import org.codehaus.jackson.node.JsonNodeFactory;
//import org.codehaus.jackson.type.TypeReference;
//import org.codehaus.jackson.util.DefaultPrettyPrinter;
//
//
public class ParsePlayerObjectIntoJson {
        public static void serializePlayer(Player player) throws IOException {
            String jsonString = new Gson().toJson(player);
            PrintWriter pw = new PrintWriter(new File("player"+player.getUserName()+"_"+player.getPassWord()+".json"));
            pw.write(jsonString);
            pw.flush();
            pw.close();

            Type type = new TypeToken<List<Player>>(){}.getType();
            List<Player> playerList = new Gson().fromJson(new FileReader("AllPlayers.json"),type);
//          List<Player> playerList =new ArrayList<Player>();
            Iterator<Player> itr = playerList.iterator();
            boolean isDuplicated = false;
            while (itr.hasNext()){
                Player player1 = itr.next();
                if (player1.getUserName().equals(player.getUserName())){
                    itr.remove();
                }
            }

              playerList.add(player);

          String json =new Gson().toJson(playerList);
          PrintWriter pw1 =new PrintWriter(new File("AllPlayers.json"));
          pw1.write(json);
          pw1.flush();
          pw1.close();



        }

        public static void removePlayer(Player player) throws FileNotFoundException {

            Type type = new TypeToken<List<Player>>(){}.getType();
            List<Player> playerList = new Gson().fromJson(new FileReader("AllPlayers.json"),type);
//          List<Player> playerList =new ArrayList<Player>();
            Iterator<Player> itr = playerList.iterator();
            while (itr.hasNext()){
                Player player1 = itr.next();
                if (player1.getUserName().equals(player.getUserName())){
                    itr.remove();
                }
            }

            String json =new Gson().toJson(playerList);
            PrintWriter pw1 =new PrintWriter(new File("AllPlayers.json"));
            pw1.write(json);
            pw1.flush();
            pw1.close();

        }

        public static Player deserializePlayer(Player player) throws IOException {

            File f =new File("player"+player.getUserName()+"_"+player.getPassWord()+".json");
            Scanner sc =new Scanner(f);
            String jsonString="";
            while (sc.hasNext()){
                jsonString+=sc.nextLine();
            }

            Player player1 = new Gson().fromJson(jsonString,Player.class);

            return player1;

        }
}
//
//    public static void run(Player player) {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        //For testing
//
//
//        try {
//            //Convert object to JSON string and save into file directly
//            mapper.writeValue(new File("player"+player.getUserName()+"_"+player.getPassWord()+".json"), player);
//
//            //Convert object to JSON string
//            /*
//            String jsonInString = mapper.writeValueAsString(player);
//            JsonNode jsonObject = mapper.readTree(jsonInString);
//            */
//
///*
//            Player player1 =mapper.readValue(new File("player"+player.getUserName()+"_"+player.getPassWord()+".json"),Player.class);
//            System.out.println(player1.getUserName());
//            */
//
////            System.out.println(jsonObject.get("money"));
////
//            /*
//            List<JsonNode> playerLists = mapper.readValue(new File("AllPlayers.json"), new TypeReference<List<JsonNode>>(){});
//            playerLists.add(jsonObject);
//            ObjectWriter writer = mapper.writer();
//            writer.writeValue(new FileWriter("AllPlayers.json"),playerLists);
//            */
//
////            List<JsonNode> listOfAllPlayerObject =new ArrayList<JsonNode>();
////            listOfAllPlayerObject.add(jsonObject);
////            ObjectWriter writer = mapper.writer();
////            writer.writeValue(new FileWriter("playerssss.json",true),jsonObject);
//
//
//
//
//
//            //Convert object to JSON string and pretty print
////            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(player);
////            System.out.println(jsonInString);
//
//
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


