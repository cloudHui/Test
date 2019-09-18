package com.sc.test.playback;



import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cloud
 * @Date: 2019/5/17 18:39
 * @Version 1.0
 */
public class CardsBackBeen {

    /**第几手*/
    @Min(value = 1)
    private int hands;

    /**牌*/
    private List<Integer> cards = new ArrayList<>();

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards.addAll(cards);
    }
}
