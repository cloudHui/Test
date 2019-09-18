package com.sc.test.playback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cloud
 * @Date: 2019/5/17 18:34
 * @Version 1.0
 */
public class PlayerCardsBack {

    /**玩家ID*/
    private long playerId;

    /**姓名*/
    private String name;

    /**头像*/
    private String head;

    /**是否投降(0,没投降,1,投降)*/
    private int surround;

    /**当前总分*/
    private int currScore;

    /**当前轮的分*/
    private int currRoundScore;

    /**是否是全关(0,不是全关,1,是全关)*/
    private int allClose;

    /**玩家在桌子上的位置*/
    private int tablePos;

    private List<CardsBackBeen> cardsList = new ArrayList<>();

    public long getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public String getHead() {
        return head;
    }

    public int getSurround() {
        return surround;
    }

    public int getCurrScore() {
        return currScore;
    }

    public int getCurrRoundScore() {
        return currRoundScore;
    }

    public int getAllClose() {
        return allClose;
    }

    public void setAllClose(int allClose) {
        this.allClose = allClose;
    }

    public int getTablePos() {
        return tablePos;
    }

    public List<CardsBackBeen> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<CardsBackBeen> cardsList) {
        this.cardsList = cardsList;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setSurround(int surround) {
        this.surround = surround;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public void setCurrRoundScore(int currRoundScore) {
        this.currRoundScore = currRoundScore;
    }

    public void setTablePos(int tablePos) {
        this.tablePos = tablePos;
    }

    public void addCardsList(CardsBackBeen cardsBackBeen) {
        this.cardsList.add(cardsBackBeen);
    }
}
