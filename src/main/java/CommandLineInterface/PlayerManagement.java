package CommandLineInterface;

import Cards.Cards;
import Cards.Spell;
import Log.LoggerOfProject;
import Player.Player;
import Player.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class PlayerManagement {
    static Scanner myscanner = new Scanner(System.in);

    public void signIn() throws IOException {
        System.out.println("Username:");
        String userName = myscanner.nextLine();
        System.out.println("Password:");
        String passWord = myscanner.nextLine();
        Type type = new TypeToken<List<Player>>() {
        }.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpells\\AllPlayers.json"), type);
        boolean valiUserNameAndPassword = false;
        for (Player player : playerList) {
            System.out.println(player.getUserName());
            if (userName.equals(player.getUserName()) && passWord.equals(player.getPassWord())) {
                valiUserNameAndPassword = true;
                CLI.currentPlayer = player;
                CLI.currentPlayer.setSigninOrSignup("Signin");
                player.setSigninOrSignup("Signin");
//                player.setLoggerOfMyPlayer();
                CLI.currentPlayer.setLoggerOfMyPlayer();
                CLI.currentPlayer.getLoggerOfMyPlayer().info("sign_in " + CLI.currentPlayer.getUserName());
                CLI.secondPage();
            }
        }
        if (!valiUserNameAndPassword) {
            System.out.println("invalid username or password!");
        }
    }


    public void signUp() throws IOException {
        System.out.println("Username:");
        String userName = myscanner.nextLine();
        System.out.println("Password:");
        String passWord = myscanner.nextLine();
        Type type = new TypeToken<List<Player>>() {}.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpells\\AllPlayers.json"), type);
        boolean canSignUp = true;
        for (Player player : playerList) {
            if (userName.equals(player.getUserName())) {
                canSignUp = false;
            }
        }
        if (canSignUp) {
            Player player = new Player(userName, passWord);
            CLI.currentPlayer = player;
            CLI.currentPlayer.setSigninOrSignup("Signup");
            player.setSigninOrSignup("Signup");
//            FileWriter fileWriter =new FileWriter(CLI.currentPlayer.getUserName()+".log");
//            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
//            bufferedWriter.write("USER: "+CLI.currentPlayer.getUserName()+"\n");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
//            bufferedWriter.write("\nCREATED_AT: "+dateFormat.format(cal.getTime())+"\n");
//            bufferedWriter.write("\nPASSWORD: "+ CLI.currentPlayer.getPassWord()+"\n");
//            bufferedWriter.flush();
//            fileWriter.flush();
//            bufferedWriter.close();
//            fileWriter.close();
            CLI.currentPlayer.getLoggerOfMyPlayer().info("USER: " + CLI.currentPlayer.getUserName());
            CLI.currentPlayer.getLoggerOfMyPlayer().info("CREATED_AT:" + dateFormat.format(cal.getTime()));
            CLI.currentPlayer.getLoggerOfMyPlayer().info("PASSWORD: " + CLI.currentPlayer.getPassWord());
            CLI.currentPlayer.getLoggerOfMyPlayer().info("sign_up " + CLI.currentPlayer.getUserName());
            CLI.secondPage();
        } else {
            System.out.println("There is an account with this username!");
        }
    }

    public void logOut() throws IOException {
        ParsePlayerObjectIntoJson.serializePlayer(CLI.currentPlayer);
        CLI.currentPlayer.getLoggerOfMyPlayer().info("Log_out " + CLI.currentPlayer.getUserName());
        CLI.currentPlayer.getLoggerOfMyPlayer().getHandlers()[0].close();
        CLI.currentPlayer = null;
    }

    public void DeletePlayer() throws IOException {
        System.out.println("Password:");
        String password = myscanner.nextLine();
        if (password.equals(CLI.currentPlayer.getPassWord())) {
            File temp = new File("logs\\"+"temp.txt");
            FileReader fileReader = new FileReader("logs\\"+CLI.currentPlayer.getUserName() + ".log");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(temp);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String st = new String();
            while ((st = bufferedReader.readLine()) != null) {
                bufferedWriter.write(st + "\n");
                if (st.contains("PASSWORD")) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar cal = Calendar.getInstance();
                    bufferedWriter.write("DELETED_AT: " + dateFormat.format(cal.getTime())+"\n");
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("DELETED_AT: " + dateFormat.format(cal.getTime()));
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
            FileReader fileReader1 = new FileReader(temp);
            FileWriter fileWriter1 = new FileWriter("logs\\"+CLI.currentPlayer.getUserName() + ".log");
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            String string = new String();
            while ((string = bufferedReader1.readLine()) != null) {
                bufferedWriter1.write(string + "\n");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info(string);
            }
            bufferedWriter1.write("Deleted Account!");
            bufferedReader1.close();
            bufferedWriter1.flush();
            bufferedWriter1.close();
            fileReader1.close();
            fileWriter1.close();
            ParsePlayerObjectIntoJson.removePlayer(CLI.currentPlayer);
            System.exit(0);
        } else {
            System.out.println("your password is incorrect!");
        }
    }
}


