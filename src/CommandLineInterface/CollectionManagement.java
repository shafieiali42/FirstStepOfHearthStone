package CommandLineInterface;

import Cards.Cards;
import Heroes.Heroes;
import Heroes.*;
import Log.LoggerOfProject;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static CommandLineInterface.CLI.*;

public class CollectionManagement {
    public static void CollectionPage() throws IOException {

        PlayerManagement playerManagement = new PlayerManagement();
        Scanner myscanner =new Scanner(System.in);
        boolean repeat = true;
        System.out.println("what can I do for you?\n1)Exit\n2)Exit_a\n3)Show Heroes\n4)Choose Hero\n5)Show Cards\n6)Add/Remove Card\n7)return");
        while (repeat){
            String input=myscanner.nextLine().toLowerCase();
            if (input.length()>10 && input.substring(0,8).equals("select [") && input.charAt(input.length()-1)==']'){
                String herosNameToSelect=input.substring(8,input.length()-1);
                switch (herosNameToSelect){
                    case "mage":
                        currentPlayer.selectHero(Mage.getInstance());
                        break;
                    case "rogue":
                        currentPlayer.selectHero(Rogue.getInstance());
                        break;
                    case "warlock":
                        currentPlayer.selectHero(Warlock.getInstance());
                        break;
                }
            }else {
                if (input.length()>7 && input.substring(0, 5).equals("add [") && input.charAt(input.length() - 1) == ']') {
                    String cardsNameToAddToDeck = input.substring(5, input.length()-1).toLowerCase().trim();
                    for (Cards card: Cards.getAllCards()){
                        if (card.getName().toLowerCase().trim().equals(cardsNameToAddToDeck.toLowerCase().trim())){
                            CLI.currentPlayer.addToDeck(card);
                            System.out.println("added");
                            break;
                        }
                    }
                }else {
                    if (input.length()>10 && input.substring(0, 8).equals("remove [") && input.charAt(input.length() - 1) == ']'){
                        String cardsNameToRemoveFromDeck= input.substring(8, input.length()-1);
                        for (Cards card: Cards.getAllCards()){
                            if (card.getName().toLowerCase().trim().equals(cardsNameToRemoveFromDeck.toLowerCase().trim())){
                                CLI.currentPlayer.removeFromDeck(card);
                                break;
                            }
                        }
                    }else{
                        switch (input){
                            case "exit":
                                playerManagement.logOut();
                                repeat=false;
                                FirstPage();
                                break;
                            case "exit -a":
                                System.exit(0);
                                break;
                            case "ls -a -heroes":
                                currentPlayer.getLoggerOfMyPlayer().info("list:"+"heroes:all");
                                System.out.println(currentPlayer.getAvailableHeroes());
                                break;
                            case "ls -m -heroes":
                                currentPlayer.getLoggerOfMyPlayer().info("Show My Hero.");
                                Heroes hero1=currentPlayer.getCurrentHero();
                                System.out.println(hero1.getName());
                                break;
                            case "ls -a -cards":
                                currentPlayer.getLoggerOfMyPlayer().info("Show All of my cards.");
                                System.out.println(currentPlayer.getAllCardsOfPlayer());
                                break;
                            case "ls -m -cards":
                                currentPlayer.getLoggerOfMyPlayer().info("Show My Deck.");
                                System.out.println(currentPlayer.getAvailableDeckWithThisSituation());
                                break;
                            case "ls -n -cards":
                                currentPlayer.getLoggerOfMyPlayer().info("list cards:nit_in_deck");
                                currentPlayer.setAvailableCardsThatWeCanAddIntoOurDeck();
                                System.out.println(currentPlayer.getAvailableCardsThatWeCanAddIntoOurDeck());
                                break;

                            case "return":
                                secondPage();
                                break;
                            case  "hearthstone --help":
                                System.out.print("\tpress exit in order to logout\n\tpress exit -a in order to exit program\n\t" +
                                        "press ls -a -heroes in order to see all available heroes\n\t" +
                                        "press ls -m -heroes in order to see your hero\n\t" +
                                        "press ls -a -cards in order to see all of your cards\n\tpress ls -m -cards in order to see your deck\n\t" +
                                        "press ls -n -cards in order to see your cards that you can add into your deck\n\t" +
                                        "press add in order to add a card into your deck\n\t" +
                                        "press remove in prder to remove a card from your deck\n\t" +
                                        "press select in order to select your hero.\n");
                                break;

                            default:
                                System.out.println(" Please Enter a valid command!");
                        }
                    }
                }
            }
        }


    }
}
