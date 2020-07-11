package Models.Heroes;


import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.HunterHeroPower;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.SpVisitor.SpVisitor;


import java.util.ArrayList;

public class Hunter extends Heroes {
    private static ArrayList<Cards> specialCardsOfHunter = new ArrayList<Cards>();



    public Hunter(){
        this.setName("Hunter");
        this.setHealthPower(30);
        this.setDescription("");//TODO needs to be initialize
        this.setIsLock(true);
        this.setHeroPower(new HunterHeroPower());
        setSpecialCardsOfHunter();
    }


    public static void setSpecialCardsOfHunter() {
        for (Cards card:Cards.getAllCards()){
            boolean isDuplicated=false;
            for (Cards cardInSpecialCardsOfHunter:specialCardsOfHunter){
                if (card.getName().equals(cardInSpecialCardsOfHunter.getName())){
                    isDuplicated=true;
                }
            }
            if (!isDuplicated){
                if (card.getClassOfCard().toLowerCase().trim().equals("hunter")){
                    specialCardsOfHunter.add(card);
                }
            }

        }
    }


    public static ArrayList<Cards> getSpecialCardsOfHunter() {
        return specialCardsOfHunter;
    }

    @Override
    public void accept(SpVisitor spVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                       ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                       ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                       ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {

        spVisitor.visit(this,player,friendlyBattleGround,enemyBattleGround,friendlyHandCards,
                enemyHandsCards,friendlyDeckCards,enemyDeckCards,target,targetHero,summoned);


    }


}
