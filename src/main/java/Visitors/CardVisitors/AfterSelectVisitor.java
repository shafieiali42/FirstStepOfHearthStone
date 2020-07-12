package Visitors.CardVisitors;

import Controller.Administer;
import Controller.GamePartController;
import Logic.PlayLogic.Alliance;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Weapon;
import Models.Cards.GameCards.MinionCards.UnoptionalMinions.*;
import Models.Cards.GameCards.SpellCards.UnoptionalSpells.*;
import Models.Cards.GameCards.WeaponCards.Ashbringer;
import Models.Cards.GameCards.WeaponCards.BattleAxe;
import Models.Cards.GameCards.WeaponCards.Gearblade;
import View.Gui.Panels.GamePage.GamePage;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class AfterSelectVisitor implements Visitor {
    @Override
    public void visit(CurioCollector curioCollector) {

    }

    @Override
    public void visit(Sathrovarr sathrovarr, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards> deckCards, Minion target) {

        Minion minion = target.copy();
        minion.setHealthPower(minion.getFirstHealthPower());
        minion.setAttackPower(minion.getFirstAttackPower());
        deckCards.add(minion);

        Minion minion2 = target.copy();
        minion2.setHealthPower(minion2.getFirstHealthPower());
        minion2.setAttackPower(minion2.getFirstAttackPower());
        if (handsCards.size() < 12) {
            handsCards.add(minion2);
        }

        Minion minion3 = target.copy();
        minion3.setHealthPower(minion3.getFirstHealthPower());
        minion3.setAttackPower(minion3.getFirstAttackPower());
        if (battleGround.size() < 7) {
            battleGround.add(minion3);
        }

        GamePartController.refreshPlayPanel();

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
    public void visit(PharaohsBlessing pharaohsBlessing, ArrayList<Minion> battleGround, Minion target, Alliance alliance) {

        if (alliance.equals(Alliance.ENEMY)) {

            JOptionPane.showMessageDialog(GamePartController.getMyMainFrame(),
                    "you cant do it on enemy minions", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            target.setAttackPower(target.getAttackPower() + 4);
            target.setHealthPower(target.getHealthPower() + 4);
            target.setIsTaunt(true);
            target.setDivineShield(true);
        }

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
    public void visit(Polymorph polymorph, ArrayList<Minion> battleGround, Minion target, Alliance alliance) {

        if (alliance.equals(Alliance.FRIENDLY)) {

            JOptionPane.showMessageDialog(GamePartController.getMyMainFrame(),
                    "you cant do it on your friendly minion", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            target.setHealthPower(1);
            target.setAttackPower(1);
        }


    }

    @Override
    public void visit(FriendlySmith friendlySmith, ArrayList<Cards> deckCards) {

        Weapon weapon = (Weapon) (GamePartController.getSelectedWeapon().copy());
        weapon.setAttackPower(weapon.getAttackPower() + 2);
        weapon.setDurability(weapon.getDurability() + 2);
        deckCards.add(3, weapon);
        GamePartController.setGamePageContentPane();
        MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
        GamePartController.reStartDiscoverPageSetting();
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
