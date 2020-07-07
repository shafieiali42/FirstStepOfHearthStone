package Interfaces;

import Controller.Administer;
import Logic.PlayLogic.Game;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;
import View.Gui.Panels.GamePage.GamePage;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import java.util.ArrayList;

public class AfterSelectVisitor implements Visitor {
    @Override
    public void visit(CurioCollector curioCollector) {

    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

        Minion minion =target.copy();
        minion.setHealthPower(minion.getFirstHealthPower());
        minion.setAttackPower(minion.getFirstAttackPower());
        deckCards.add(minion);

        Minion minion2 =target.copy();
        minion2.setHealthPower(minion2.getFirstHealthPower());
        minion2.setAttackPower(minion2.getFirstAttackPower());
        if (handsCards.size()<12){
            handsCards.add(minion2);
        }

        Minion minion3 =target.copy();
        minion3.setHealthPower(minion3.getFirstHealthPower());
        minion3.setAttackPower(minion3.getFirstAttackPower());
        if (battleGround.size()<7){
            battleGround.add(minion3);
        }

        Administer.refreshPlayPanel();

    }


    @Override
    public void visit(SecurityRover securityRover) {

    }

    @Override
    public void visit(TombWarden tombWarden, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BookOfSpecters bookOfSpecters, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards) {

    }

    @Override
    public void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target) {

        System.out.println("PharaohsBlessing Visitor");
        target.setAttackPower(target.getAttackPower()+4);
        target.setHealthPower(target.getHealthPower()+4);
        target.setIsTaunt(true);
        target.setDivineShield(true);

    }



    @Override
    public void visit(Sprint sprint) {

    }

    @Override
    public void visit(Ashbringer ashbringer) {

    }

    @Override
    public void visit(BattleAxe battleAxe) {

    }

    @Override
    public void visit(Gearblade gearblade) {

    }

    @Override
    public void visit(SwarmOfLocusts swarmOfLocusts, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Locusts locusts, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target) {

        target.setHealthPower(1);
        target.setAttackPower(1);


    }

    @Override
    public void visit(FriendlySmith friendlySmith, ArrayList<Cards> deckCards) {
        System.out.println("in afterSelecteVisitor");
        Weapon weapon= (Weapon) (Administer.getSelectedWeapon().copy());
        System.out.println(weapon);
        weapon.setAttackPower(weapon.getAttackPower()+2);
        weapon.setDurability(weapon.getDurability()+2);
        deckCards.add(3,weapon);
        System.out.println(weapon);
        System.out.println("durability: "+weapon.getDurability()+"\n attack: "+weapon.getAttackPower());
        Administer.setGamePageContentPane();
        MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
        Administer.reStartDiscoverPageSetting();
        System.out.println(Game.getInstance().getCurrentPlayer().getDeckCards());
    }

    @Override
    public void visit(Dreadscale dreadscale) {

    }

    @Override
    public void visit(SwampKingDred swampKingDred) {

    }

    @Override
    public void visit(HighPriestAmet highPriestAmet, Minion summonedMinion) {

    }
}
