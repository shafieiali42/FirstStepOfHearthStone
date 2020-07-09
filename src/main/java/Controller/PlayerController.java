package Controller;


import Models.Heroes.*;
import Models.Player.Player;
import Models.Player.*;

import View.Gui.Panels.LogInPanel.LogInPage;
import View.Gui.Panels.MenuPanel.MainMenuPage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PlayerController {

    public static void signIn(String userName,String passWord) throws IOException {
        Type type = new TypeToken<List<Player>>() { }.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpellsWeapons/AllPlayers.json"), type);
        boolean valiUserNameAndPassword = false;
        for (Player player : playerList) {
            if (userName.equals(player.getUserName()) && passWord.equals(player.getPassWord())) {
                valiUserNameAndPassword = true;
                ControllerOfMainComponents.currentPlayer = player;
                switch (ControllerOfMainComponents.currentPlayer.getCurrentHero().getName()){
                    case "Mage":
                        Mage mage=new Mage();
                        ControllerOfMainComponents.currentPlayer.setMage(mage);
                        ControllerOfMainComponents.currentPlayer.getAvailableHeroes().add(mage);
                        ControllerOfMainComponents.currentPlayer.setCurrentHero(mage);
                        break;
                    case "Rogue":
                        Rogue rogue=new Rogue();
                        ControllerOfMainComponents.currentPlayer.setRogue(rogue);
                        ControllerOfMainComponents.currentPlayer.getAvailableHeroes().add(rogue);
                        ControllerOfMainComponents.currentPlayer.setCurrentHero(rogue);
                        break;
                    case "Warlock":
                        Warlock warlock=new Warlock();
                        ControllerOfMainComponents.currentPlayer.setWarlock(warlock);
                        ControllerOfMainComponents.currentPlayer.getAvailableHeroes().add(warlock);
                        ControllerOfMainComponents.currentPlayer.setCurrentHero(warlock);
                        break;
                    case "Hunter":
                        Hunter hunter=new Hunter();
                        ControllerOfMainComponents.currentPlayer.setHunter(hunter);
                        ControllerOfMainComponents.currentPlayer.getAvailableHeroes().add(hunter);
                        ControllerOfMainComponents.currentPlayer.setCurrentHero(hunter);
                        break;
                    case "Priest":
                        Priest priest=new Priest();
                        ControllerOfMainComponents.currentPlayer.setPriest(priest);
                        ControllerOfMainComponents.currentPlayer.getAvailableHeroes().add(priest);
                        ControllerOfMainComponents.currentPlayer.setCurrentHero(priest);
                        break;
                }

                ControllerOfMainComponents.currentPlayer.setSigninOrSignup("Signin");
                player.setSigninOrSignup("Signin");
                ControllerOfMainComponents.currentPlayer.setLoggerOfMyPlayer();
                ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("sign_in " + ControllerOfMainComponents.currentPlayer.getUserName());
                ControllerOfMainComponents.secondPage();
            }
        }
        if (!valiUserNameAndPassword) {
            PlayerController.showJOptionPaneOfLogInError();
        }
    }

    public static void signUp(String userName,String passWord) throws IOException {

        Type type = new TypeToken<List<Player>>() {}.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("MinionSpellsWeapons/AllPlayers.json"), type);
        boolean canSignUp = true;
        for (Player player : playerList) {
            if (userName.equals(player.getUserName())) {
                canSignUp = false;
            }
        }
        if (canSignUp) {
            Player player = new Player(userName, passWord);
            ControllerOfMainComponents.currentPlayer = player;
            ControllerOfMainComponents.currentPlayer.setSigninOrSignup("Signup");
            player.setSigninOrSignup("Signup");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("USER: " + ControllerOfMainComponents.currentPlayer.getUserName());
            ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("CREATED_AT:" + dateFormat.format(cal.getTime()));
            ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("PASSWORD: " + ControllerOfMainComponents.currentPlayer.getPassWord());
            ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("sign_up " + ControllerOfMainComponents.currentPlayer.getUserName());
            ControllerOfMainComponents.secondPage();
        } else {
            PlayerController.signUpErrorJOptionPane();
        }
    }

    public static void logOut() throws IOException {
        ParsePlayerObjectIntoJson.serializePlayer(ControllerOfMainComponents.currentPlayer);
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Log_out " + ControllerOfMainComponents.currentPlayer.getUserName());
        ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().getHandlers()[0].close();
        ControllerOfMainComponents.currentPlayer = null;
        ControllerOfMainComponents.FirstPage();
    }

    public static void deletePlayer(String password) throws IOException {
        if (password.equals(ControllerOfMainComponents.currentPlayer.getPassWord())) {
            File temp = new File("logs\\"+"temp.txt");
            FileReader fileReader = new FileReader("logs\\"+ ControllerOfMainComponents.currentPlayer.getUserName() + ".log");
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
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
            FileReader fileReader1 = new FileReader(temp);
            FileWriter fileWriter1 = new FileWriter("logs\\"+ ControllerOfMainComponents.currentPlayer.getUserName() + ".log");
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            String string = new String();
            while ((string = bufferedReader1.readLine()) != null) {
                bufferedWriter1.write(string + "\n");
            }
            bufferedWriter1.write("Deleted Account!");
            bufferedReader1.close();
            bufferedWriter1.flush();
            bufferedWriter1.close();
            fileReader1.close();
            fileWriter1.close();
            ParsePlayerObjectIntoJson.removePlayer(ControllerOfMainComponents.currentPlayer);
            System.exit(0);
        } else {
            PlayerController.showJOptionPaneWrongPassWordErrorForDeletePlayer();
        }
    }



    public static void showJOptionPaneWrongPassWordErrorForDeletePlayer() {
        JOptionPane.showMessageDialog(MainMenuPage.getInstance(), "Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showJOptionPaneOfLogInError() {
        JOptionPane.showMessageDialog(LogInPage.getInstance(),
                "Please Enter a Valid UserName or Password!", "LogIn Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void signUpErrorJOptionPane() {
        JOptionPane.showMessageDialog(LogInPage.getInstance(),
                "There is an account with this username!", "SignUp Error", JOptionPane.ERROR_MESSAGE);
    }
}


