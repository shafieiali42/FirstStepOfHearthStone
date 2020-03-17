package CommandLineInterface;

import Cards.Cards;
import Heroes.Heroes;
import Heroes.*;

import java.io.IOException;
import java.util.Scanner;

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
                                System.out.println(currentPlayer.getAvailableHeroes());
                                break;
                            case "ls -m -heroes":
                                Heroes hero1=currentPlayer.getCurrentHero();
                                System.out.println(hero1.getName());
                                break;
                            case "ls -a -cards":
                                System.out.println(currentPlayer.getAvailableCardsWithThisSituation());
                                break;
                            case "ls -m -cards":
                                System.out.println(currentPlayer.getAvailableDeckWithThisSituation());
                                break;
                            case "ls -n -cards":
                                currentPlayer.setAvailableCardsThatWeCanAddIntoOurDeck();
                                System.out.println(currentPlayer.getAvailableCardsThatWeCanAddIntoOurDeck());
                                break;

                            case "return":
                                secondPage();

                            default:
                                System.out.println(" Please Enter a valid command!");
                        }
                    }
                }
            }
        }


    }
}
