import Cards.*;
import CommandLineInterface.CLI;
import Heroes.Mage;
import Heroes.Rogue;
import Heroes.Warlock;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        JsonReaderForSpells.main(args);
        JsonReaderForMinions.main(args);
        Cards.setAllCards();
        Mage.setSpecialCardsOfMage();
        Warlock.setSpecialCardsOfWarlock();
        Rogue.setSpecialCardsOfRogue();
        CLI cli = new CLI();
        cli.FirstPage();

    }
}
