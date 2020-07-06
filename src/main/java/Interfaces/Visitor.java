package Interfaces;

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
    void visit(Sathrovarr sathrovarr);
    void visit(SecurityRover securityRover);
    void visit(TombWarden tombWarden, ArrayList<Minion> battleGround);
    void visit(BookOfSpecters bookOfSpecters);
    void visit(PharaohsBlessing pharaohsBlessing);
    void visit(Sprint sprint);
    void visit(SwarmOfLocusts swarmOfLocusts);
    void visit(Ashbringer ashbringer);
    void visit(BattleAxe battleAxe);
    void visit(Gearblade gearblade);

    //Special
    //*********
    void visit(Polymorph polymorph);
    void visit(FriendlySmith friendlySmith);
    void visit(Dreadscale dreadscale);
    void visit(SwampKingDred swampKingDred);
    void visit(HighPriestAmet highPriestAmet);













}
