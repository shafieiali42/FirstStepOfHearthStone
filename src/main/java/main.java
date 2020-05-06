import Cards.*;
import CommandLineInterface.CLI;
import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.LittleCardPanel;
import Gui.Panels.GamePage.GraphicLoop;
import Heroes.Mage;
import Heroes.Rogue;
import Heroes.Warlock;
import Utility.Constant;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        JsonReaderForSpells.main(args);
        JsonReaderForMinions.main(args);
        JsonReaderForPassives.main(args);
        Cards.setAllCards();
        Spell.defineQuestAndRewardCardList();
        Mage.setSpecialCardsOfMage();
        Warlock.setSpecialCardsOfWarlock();
        Rogue.setSpecialCardsOfRogue();
        LittleCardPanel.setAllLittleCardPanels();
        Constant.getInstance().defineHeroImagesHashMap();
        Constant.getInstance().defineHeroPowerImagesHashMap();
        CLI cli = new CLI();
        GraphicLoop.getInstance().start();
        cli.FirstPage();

    }
}
