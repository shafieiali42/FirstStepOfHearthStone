package Logic;

import Models.Deck.Deck;

public class CollectionState {


    private static CollectionState collectionState=new CollectionState();
    public static CollectionState getInstance(){return collectionState;}

    private Deck DeckToChange;

    public Deck getDeckToChange() {
        return DeckToChange;
    }

    public void setDeckToChange(Deck deckToChange) {
        DeckToChange = deckToChange;
    }




}
