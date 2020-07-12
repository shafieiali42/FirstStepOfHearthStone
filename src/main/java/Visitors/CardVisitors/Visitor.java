package Visitors.CardVisitors;

import Logic.PlayLogic.Alliance;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;


import java.util.ArrayList;

public interface Visitor {


    //Neutrals
    //**********
    void visit(CurioCollector curioCollector);
    void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,
               ArrayList<Cards>deckCards, Minion target);

    void visit(SecurityRover securityRover, ArrayList<Minion> battleGround, Minion target);

    void visit(TombWarden tombWarden, ArrayList<Minion> battleGround);
    void visit(BookOfSpecters bookOfSpecters, ArrayList<Minion>battleGround, ArrayList<Cards> handsCards);
    void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target, Alliance alliance);
    void visit(Sprint sprint);
    void visit(Ashbringer ashbringer);
    void visit(BattleAxe battleAxe);
    void visit(Gearblade gearblade);
    void visit(SwarmOfLocusts swarmOfLocusts, ArrayList<Minion>battleGround);
    void visit(Locusts locusts, ArrayList<Minion>battleGround);
    void visit(Dragon dragon);

    //Special
    //*********
    void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target,Alliance alliance);
    void visit(FriendlySmith friendlySmith,ArrayList<Cards>deckCards);
    void visit(Dreadscale dreadscale);
    void visit(SwampKingDred swampKingDred,Minion playingCard);

    void visit(HighPriestAmet highPriestAmet,Minion summonedMinion);

    //Quest And Reward

    //******************
    void visit(LearnDarconic learnDarconic, ArrayList<Minion> battleGround,Cards playingCard);

    void visit(StrengthInNumbers strengthInNumbers, ArrayList<Minion> battleGround,
               ArrayList<Cards> deckCards, Cards playingCard);

    void visit(Mech mech, ArrayList<Minion> battleGround);


    void visit(CosmicAnomaly cosmicAnomaly);

    void visit(CrazedAlchemist crazedAlchemist);

    void visit(LeperGnome leperGnome);

    void visit(MaidenOfTheLake maidenOfTheLake);

    void visit(NoviceEngineer noviceEngineer);

    void visit(RiverCrocolisk riverCrocolisk);

    void visit(StormwindKnight stormwindKnight);

    void visit(TournamentMedic tournamentMedic);

    void visit(YoungPriestess youngPriestess);

    void visit(TreeOfLife treeOfLife, ArrayList<Minion> battleGround);

    void visit(Starfire starfire, ArrayList<Minion> battleGround);

    void visit(SinisterStrike sinisterStrike, ArrayList<Minion> battleGround);

    void visit(Naturalize naturalize, ArrayList<Minion> battleGround);

    void visit(Moonfire moonfire, ArrayList<Minion> battleGround);

    void visit(Heal heal, ArrayList<Minion> battleGround);

    void visit(Caltrops caltrops, ArrayList<Minion> battleGround);

    void visit(BloodfuryPotion bloodfuryPotion, ArrayList<Minion> battleGround);

    void visit(BlessingOfTheAncients blessingOfTheAncients, ArrayList<Minion> battleGround);

    void visit(BiologyProject biologyProject, ArrayList<Minion> battleGround);
}

