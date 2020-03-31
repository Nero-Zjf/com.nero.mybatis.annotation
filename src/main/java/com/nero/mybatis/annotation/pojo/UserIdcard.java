package com.nero.mybatis.annotation.pojo;

import com.nero.mybatis.annotation.po.IdcardPO;

/**
 * 用户POJO类-以'对象引用'的形式关联'身份证信息'
 */
public class UserIdcard {
    private long id; // 主键
    private String name;
    private String sex;
    private IdcardPO idcard;

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

    public IdcardPO getIdcard() {
        return idcard;
    }

    public void setIdcard(IdcardPO idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"sex\":\"" + sex + '\"' +
                ", \"idcard\":" + idcard +
                '}';
    }
}
