package com.nero.mybatis.annotation.po;

/**
 * order表对应的PO类
 */
public class OrderPO {
    private Long id;

    private String orderNum;

    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"orderNum\":\"" + orderNum + '\"' +
                ", \"userId\":\"" + userId + '\"' +
                '}';
    }
}