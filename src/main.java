import Cards.*;
import CommandLineInterface.CLI;
import Heroes.Mage;
import Heroes.Rogue;
import Heroes.Warlock;
import Player.Player;

import javax.smartcardio.Card;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        JsonReaderForSpells.main(args);
        JsonReaderForMinions.main(args);
        Cards.setAllCards();
        Mage.setSpecialCardsOfMage();
        Warlock.setSpecialCardsOfWarlock();
        Rogue.setSpecialCardsOfRogue();
//            System.out.println(Mage.getSpecialCardsOfMage().size()+"    23");
//        System.out.println(Rogue.getSpecialCardsOfRogue());
//        System.out.println("Try for checking:");
//        System.out.println(Minion.getMinions().get(0));
//        System.out.println(Spell.getSpells().get(0));
//        System.out.println("End!");
        CLI cli = new CLI();
        cli.FirstPage();

    }
}
