package Visitors.CardVisitors;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;

import java.util.ArrayList;

public class DrawCardVisitor implements Visitor {


    @Override
    public void visit(CurioCollector curioCollector) {
        curioCollector.setHealthPower(curioCollector.getHealthPower()+1);
        curioCollector.setAttackPower(curioCollector.getAttackPower()+1);
    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

    }


    @Override
    public void visit(SecurityRover securityRover, ArrayList<Minion> battleGround, Minion target) {

    }

    @Override
    public void visit(TombWarden tombWarden, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BookOfSpecters bookOfSpecters, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards) {

    }

    @Override
    public void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target, String alliance) {

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
    public void visit(Dragon dragon) {

    }

    @Override
    public void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target, String alliance) {

    }



    @Override
    public void visit(FriendlySmith friendlySmith, ArrayList<Cards> deckCards) {

    }


    @Override
    public void visit(Dreadscale dreadscale) {

    }

    @Override
    public void visit(SwampKingDred swampKingDred, Minion playingCard) {

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

    @Override
    public void visit(Mech mech, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(CosmicAnomaly cosmicAnomaly) {

    }

    @Override
    public void visit(CrazedAlchemist crazedAlchemist) {

    }

    @Override
    public void visit(LeperGnome leperGnome) {

    }

    @Override
    public void visit(MaidenOfTheLake maidenOfTheLake) {

    }

    @Override
    public void visit(NoviceEngineer noviceEngineer) {

    }

    @Override
    public void visit(RiverCrocolisk riverCrocolisk) {

    }

    @Override
    public void visit(StormwindKnight stormwindKnight) {

    }

    @Override
    public void visit(TournamentMedic tournamentMedic) {

    }

    @Override
    public void visit(YoungPriestess youngPriestess) {

    }

    @Override
    public void visit(TreeOfLife treeOfLife, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Starfire starfire, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(SinisterStrike sinisterStrike, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Naturalize naturalize, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Moonfire moonfire, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Heal heal, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(Caltrops caltrops, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BloodfuryPotion bloodfuryPotion, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BlessingOfTheAncients blessingOfTheAncients, ArrayList<Minion> battleGround) {

    }

    @Override
    public void visit(BiologyProject biologyProject, ArrayList<Minion> battleGround) {

    }


}