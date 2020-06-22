package Logic.NonePlayLogics;

import Models.Deck.Deck;

public class StatusState {

    private static StatusState statusState=new StatusState();
    public static StatusState getInstance(){return statusState;}

    private Deck deckToShow;

    public Deck getDeckToShow() {
        return deckToShow;
    }

    public void setDeckToShow(Deck deckTosHOW) {
        this.deckToShow = deckTosHOW;
    }

    private StatusState(){

    }

}
