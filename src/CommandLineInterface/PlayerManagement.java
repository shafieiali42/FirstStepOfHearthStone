package CommandLineInterface;

import Cards.Spell;
import Player.Player;
import Player.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class PlayerManagement {
    static Scanner myscanner = new Scanner(System.in);
    public void signIn() throws IOException {
        System.out.print("Username:");
        String userName = myscanner.nextLine();
        System.out.print("Password:");
        String passWord = myscanner.nextLine();
        Type type = new TypeToken<List<Player>>(){}.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("AllPlayers.json"),type);
        boolean valiUserNameAndPassword=false;
        for (Player player:playerList){
            System.out.println(player.getUserName());
            if (userName.equals(player.getUserName()) && passWord.equals(player.getPassWord())){
                System.out.println("salam chchchch"+player.getCurrentHero().getName());
                valiUserNameAndPassword=true;
                CLI.currentPlayer = player;
                CLI.currentPlayer.setSigninOrSignup("Signin");
                player.setSigninOrSignup("Signin");
                CLI.secondPage();
            }
        }
        if (!valiUserNameAndPassword){
            System.out.println("invalid username or password!");
        }
    }


    public void signUp() throws IOException {
        System.out.print("Username:");
        String userName = myscanner.nextLine();
        System.out.print("Password:");
        String passWord = myscanner.nextLine();
        Type type = new TypeToken<List<Player>>(){}.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("AllPlayers.json"),type);
        boolean canSignUp = true;
        for (Player player:playerList){
            if (userName.equals(player.getUserName())){
                canSignUp=false;
            }
        }
        if(canSignUp){
            System.out.println("you can sign up");
            Player player = new Player(userName,passWord);
            CLI.currentPlayer=player;
            CLI.currentPlayer.setSigninOrSignup("Signup");
            player.setSigninOrSignup("Signup");
            CLI.secondPage();
        }else{
            System.out.println("There is an account with this username!");
        }
    }

    public void logOut() throws IOException {
        ParsePlayerObjectIntoJson.serializePlayer(CLI.currentPlayer);
        CLI.currentPlayer=null;
    }

    public void DeletePlayer() throws IOException {
        System.out.print("Password:");
        String password = myscanner.nextLine();
        if (password.equals(CLI.currentPlayer.getPassWord())){
            //TODO remove player from AllPlayers.json
            logOut();
            System.exit(0);
        }else {
            System.out.println("your password is incorrect!");
        }
    }
}
