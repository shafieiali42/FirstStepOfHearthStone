package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import java.util.ArrayList;

public class Heroes {
     public Heroes(){

     }
     String name;
     int healthPower;
     String description;
     ArrayList<Cards> DeckOfHero = new ArrayList<Cards>();
     boolean isLock;
     int attackPower;
     int shield;
     boolean canBeAttacked=true;






     public boolean getCanBeAttacked() {
          return canBeAttacked;
     }
     public void setCanBeAttacked(boolean canBeAttacked) {
          this.canBeAttacked = canBeAttacked;
     }
     public int getAttackPower() {
          return attackPower;
     }
     public void setAttackPower(int attackPower) {
          this.attackPower = attackPower;
     }
     public int getShield() {
          return shield;
     }
     public void setShield(int shield) {
          this.shield = shield;
     }
     public boolean getIsLock() {
          return isLock;
     }
     public void setIsLock(boolean lock) {
          isLock = lock;
     }
     public ArrayList<Cards> getDeckOfHero() {
          return DeckOfHero;
     }
     public void setDeckOfHero(ArrayList<Cards> deckOfHero) {
          DeckOfHero = deckOfHero;
     }
     public String getName(){
         return name;
     }

     @Override
     public String toString(){
          return "[ Name: "+this.getName()+", healthPower: "+this.healthPower+"]";
     }

     public int getHealthPower() {
          return healthPower;
     }

     public void setHealthPower(int healthPower) {
          this.healthPower = healthPower;
     }


}
