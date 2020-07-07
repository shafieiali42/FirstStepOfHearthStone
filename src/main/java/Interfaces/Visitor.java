package Interfaces;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.*;
import Models.Cards.GameCards.SpellCards.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;

import java.util.ArrayList;

public interface Visitor {


    //Neutrals
    //**********
    void visit(CurioCollector curioCollector);
    void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,ArrayList<Cards>deckCards,Minion target);
    void visit(SecurityRover securityRover);
    void visit(TombWarden tombWarden, ArrayList<Minion> battleGround);
    void visit(BookOfSpecters bookOfSpecters,ArrayList<Minion>battleGround,ArrayList<Cards> handsCards);
    void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target);
    void visit(Sprint sprint);
    void visit(Ashbringer ashbringer);
    void visit(BattleAxe battleAxe);
    void visit(Gearblade gearblade);
    void visit(SwarmOfLocusts swarmOfLocusts,ArrayList<Minion>battleGround);
    void visit(Locusts locusts,ArrayList<Minion>battleGround);

    //Special
    //*********
    void visit(Polymorph polymorph,ArrayList<Minion> battleGround,Minion target);
    void visit(FriendlySmith friendlySmith,ArrayList<Cards>deckCards);
    void visit(Dreadscale dreadscale);
    void visit(SwampKingDred swampKingDred);
    void visit(HighPriestAmet highPriestAmet,Minion summonedMinion);













}
