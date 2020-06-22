package Logic.NonePlayLogics;

import Models.Cards.Cards;

import java.io.IOException;

public class ShopState {

    private static ShopState shopState;
    public static ShopState getInstance(){return shopState;}

    static {
        try {
            shopState = new ShopState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cards cardsToBuyOrSell;
    public ShopState() throws IOException {

    }



    public Cards getCardsToBuyOrSell() {
        return cardsToBuyOrSell;
    }

    public void setCardsToBuyOrSell(Cards cardsToBuyOrSell) {
        this.cardsToBuyOrSell = cardsToBuyOrSell;
    }


}
