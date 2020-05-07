package Logic;

import Models.Deck.Deck;

public class StatusState {

    private static StatusState statusState=new StatusState();
    public static StatusState getInstance(){return statusState;}

    private Deck deckTosHOW;

    public Deck getDeckTosHOW() {
        return deckTosHOW;
    }

    public void setDeckToShow(Deck deckTosHOW) {
        this.deckTosHOW = deckTosHOW;
    }

    private StatusState(){

    }

}
