import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;
import Utility.JsonReaders.*;
import Controller.ControllerOfMainComponents;
import View.Gui.Loop.GraphicLoop;
import View.Gui.Panels.CollectionPages.LittleCardPanel;
import Models.Heroes.Mage;
import Models.Heroes.Rogue;
import Models.Heroes.Warlock;
import Utility.Constant;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        JsonReaderForSpells.main(args);
        JsonReaderForMinions.main(args);
        JsonReaderForWeapons.main(args);
        JsonReaderForPassives.main(args);
        Cards.setAllCards();
        Minion.initFirstAttackAndHp();
        Spell.defineQuestAndRewardCardList();
        System.out.println(Spell.getSpells());
        Mage.setSpecialCardsOfMage();
        Warlock.setSpecialCardsOfWarlock();
        Rogue.setSpecialCardsOfRogue();
        LittleCardPanel.setAllLittleCardPanels();
        Constant.getInstance().defineHeroImagesHashMap();
        Constant.getInstance().defineHeroPowerImagesHashMap();
        ControllerOfMainComponents controllerOfMainComponents = new ControllerOfMainComponents();
        GraphicLoop.getInstance().start();
        controllerOfMainComponents.FirstPage();

    }
}
