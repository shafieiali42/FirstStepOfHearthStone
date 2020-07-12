package Models.Player;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class ParsePlayerObjectIntoJson {
        public static void serializePlayer(Player player) throws IOException {
            String jsonString = new Gson().toJson(player);
            PrintWriter pw = new PrintWriter(new File("MinionSpellsWeapons/"+"player"+player.getUserName()+"_"+player.getPassWord()+".json"));
            pw.write(jsonString);
            pw.flush();
            pw.close();
            Type type = new TypeToken<List<Player>>(){}.getType();
            List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpellsWeapons/"+"AllPlayers.json"),type);
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
          PrintWriter pw1 =new PrintWriter(new File("MinionSpellsWeapons/"+"AllPlayers.json"));
          pw1.write(json);
          pw1.flush();
          pw1.close();
        }

        public static void removePlayer(Player player) throws FileNotFoundException {

            Type type = new TypeToken<List<Player>>(){}.getType();
            List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpellsWeapons/"+"AllPlayers.json"),type);
            Iterator<Player> itr = playerList.iterator();
            while (itr.hasNext()){
                Player player1 = itr.next();
                if (player1.getUserName().equals(player.getUserName())){
                    itr.remove();
                }
            }
            String json =new Gson().toJson(playerList);
            PrintWriter pw1 =new PrintWriter(new File("MinionSpellsWeapons/"+"AllPlayers.json"));
            pw1.write(json);
            pw1.flush();
            pw1.close();
        }

}



