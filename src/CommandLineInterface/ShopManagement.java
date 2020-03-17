package CommandLineInterface;

import Cards.Cards;

import javax.smartcardio.Card;
import java.io.IOException;
import java.util.Scanner;

import static CommandLineInterface.CLI.FirstPage;
import static CommandLineInterface.CLI.secondPage;

public class ShopManagement {

    public static void ShopPage() throws IOException {
        PlayerManagement playerManagement = new PlayerManagement();
        Scanner myscanner =new Scanner(System.in);
        boolean repeat = true;
        System.out.println("what can I do for you?\n1)Exit\n2)Exit_a\n3)Buy a card\n4)Wallet\n5)Sell a card\n6)Show cards\n7)return");
        while (repeat){
            String input=myscanner.nextLine().toLowerCase();
            if (input.length()>7&& input.substring(0,5).equals("buy [") && input.charAt(input.length()-1)==']'){
                String cardsNameToBuy=input.substring(5,input.length()-1);
                for (Cards card: Cards.getAllCards()){
                    if (card.getName().toLowerCase().trim().equals(cardsNameToBuy.toLowerCase().trim())){
                        CLI.currentPlayer.buy(card);
                        break;
                    }
                }

            }else {
                if (input.length()>8 && input.substring(0, 6).equals("sell [") && input.charAt(input.length() - 1) == ']') {
                    String cardsNameToSell =input.substring(6, input.length()-1);
                    for (Cards card: Cards.getAllCards()){
                        if (card.getName().toLowerCase().trim().equals(cardsNameToSell.toLowerCase().trim())){
                            CLI.currentPlayer.sell(card);
                            break;
                        }
                    }

                }else {
                    switch (input){
                        case "exit":
                            playerManagement.logOut();
                            repeat=false;
                            FirstPage();
                            break;
                        case "exit -a":
                            System.exit(0);
                            break;
                        case "wallet":
                            System.out.println(CLI.currentPlayer.getMoney());
                            break;
                        case "ls -s":
                            System.out.println(CLI.currentPlayer.getSalableCards());
                            break;

                        case "ls -b":
                            System.out.println(CLI.currentPlayer.getBuyableCards());
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
