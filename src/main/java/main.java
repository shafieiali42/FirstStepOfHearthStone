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

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {


        JsonReaderHandler minionJsonReaderHandler =new JsonReaderHandler(new JsonReaderForMinions());
        JsonReaderHandler spellJsonReaderHandler =new JsonReaderHandler(new JsonReaderForSpells());
        JsonReaderHandler weaponJsonReaderHandler =new JsonReaderHandler(new JsonReaderForWeapons());
        JsonReaderHandler passiveJsonReaderHandler=new JsonReaderHandler(new JsonReaderForPassives());
        minionJsonReaderHandler.serialize();
        spellJsonReaderHandler.serialize();
        weaponJsonReaderHandler.serialize();
        passiveJsonReaderHandler.serialize();
//        JsonReaderForSpells.main(args);
//        JsonReaderForMinions.main(args);
//        JsonReaderForWeapons.main(args);
//        JsonReaderForPassives.main(args);
        Cards.setAllCards();
        Minion.initFirstAttackAndHp();
        Spell.defineQuestAndRewardCardList();
        for (Spell spell:Spell.getSpells()){
            System.out.println(spell.getManaNeededForQuest());
        }
        Mage.initSpecialCardsOfMage();
        Warlock.initSpecialCardsOfWarlock();
        Rogue.initSpecialCardsOfRogue();
        LittleCardPanel.setAllLittleCardPanels();
//        Constant.getInstance().defineHeroImagesHashMap();
//        Constant.getInstance().defineHeroPowerImagesHashMap();
        ControllerOfMainComponents controllerOfMainComponents = new ControllerOfMainComponents();
        GraphicLoop.getInstance().start();
        controllerOfMainComponents.FirstPage();

    }
}
