package com.nero.mybatis.annotation.po;

import java.util.Date;

/**
 * idcard表对应的PO类
 */
public class IdcardPO {
    private long id;
    private long userId;
    private String cardNum;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"userId\":" + userId +
                ", \"cardNum\":\"" + cardNum + '\"' +
                ", \"date\":" + date +
                '}';
    }
}
