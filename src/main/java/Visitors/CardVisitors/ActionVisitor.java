package Visitors.CardVisitors;

import Controller.Administer;
import Controller.ControllerOfMainComponents;
import Logic.Status;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;
import View.Gui.Mapper;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public class ActionVisitor implements Visitor {


    //Neutrals
    //**********

    @Override
    public void visit(CurioCollector curioCollector) {
//        System.out.println("Action of CurioCollector");


    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

    }



    @Override
    public void visit(SecurityRover securityRover) {

    }

    @Override
    public void visit(TombWarden tombWarden, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BookOfSpecters bookOfSpecters, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards) {

        for (int i = 0; i < 3; i++) {
            Cards card = Mapper.drawOneCard();
            assert card != null;
            if (!card.getType().equalsIgnoreCase("Spell")) {
                handsCards.add(card);
            }
        }


    }

    @Override
    public void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target, String alliance) {

    }


    @Override
    public void visit(Sprint sprint) {
        System.out.println("Sprint visit");
        for (int i = 0; i < 4; i++) {
            Mapper.drawCard();
            Administer.refreshPlayPanel();
        }
    }


    @Override
    public void visit(SwarmOfLocusts swarmOfLocusts, ArrayList<Minion> battleGround) {

        int battleGroundSize = battleGround.size();
        Locusts locusts = null;
        for (Cards card : Cards.getAllCards()) {
            if (card.getName().equalsIgnoreCase("Locusts")) {
                locusts = (Locusts) card;
            }
        }

        for (int i = 0; i < 7 - battleGroundSize; i++) {

            battleGround.add(locusts.copy());
        }


    }

    @Override
    public void visit(Locusts locusts, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Dragon dragon) {

    }

    @Override
    public void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target, String alliance) {

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


    //Specials
    //**********


    @Override
    public void visit(FriendlySmith friendlySmith, ArrayList<Cards> deckCards) {
        ControllerOfMainComponents.setStatus(Status.DISCOVER_THREE_WEAPONS);
        Administer.setThreeWeapon();
        Administer.setDiscoverPageContentPane();
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

    @Override
    public void visit(LearnDarconic learnDarconic, ArrayList<Minion> battleGround, Cards playingCard) {

    }

    @Override
    public void visit(StrengthInNumbers strengthInNumbers, ArrayList<Minion> battleGround, ArrayList<Cards> deckCards, Cards playingCard) {

    }




}
