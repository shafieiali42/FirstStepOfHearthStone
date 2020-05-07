package Models.Heroes;

import Models.Cards.Cards;
import java.util.ArrayList;

public class Heroes {
     public Heroes(){

     }
     String name;
     int healthPower;
     String descrtiption;
     ArrayList<Cards> DeckOfHero = new ArrayList<Cards>();
     boolean isLock;

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
