package com.sc.test.playback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cloud
 * @Date: 2019/5/17 18:28
 * @Version 1.0
 */
public class GameBackCards {

    /**房间号*/
    private int roomId;

    /**轮数*/
    private int roundNum;

    /**游戏规则*/
    private String rule;

    /**开始时间*/
    private long startTime;

    public int getRoomId() {
        return roomId;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public String getRule() {
        return rule;
    }

    public long getStartTime() {
        return startTime;
    }

    public List<PlayerCardsBack> getPlayerBack() {
        return playerBack;
    }

    public void setPlayerBack(List<PlayerCardsBack> playerBack) {
        this.playerBack = playerBack;
    }

    /**玩家牌的回放*/
    private List<PlayerCardsBack> playerBack = new ArrayList<>();

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void addPlayerBack(PlayerCardsBack playerBack) {
        this.playerBack.add(playerBack);
    }
}
