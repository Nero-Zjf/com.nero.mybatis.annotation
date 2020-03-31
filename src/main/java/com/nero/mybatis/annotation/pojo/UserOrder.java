package com.nero.mybatis.annotation.pojo;

import com.nero.mybatis.annotation.po.OrderPO;

import java.util.List;

/**
 * 用户POJO类-以'对象引用'的形式关联'订单信息'
 */
public class UserOrder {
    private long id; // 主键
    private String name;
    private String sex;
    private List<OrderPO> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<OrderPO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderPO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"sex\":\"" + sex + '\"' +
                ", \"orders\":" + orders +
                '}';
    }
}
