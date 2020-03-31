package com.nero.mybatis.annotation.provider;

import com.nero.mybatis.annotation.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 用于动态SQL注解的provider
 */
public class UserProvider {
    //新增用户
    public String addUserDynamic(final UserPO userPO) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if (userPO.getId() > 0) {
                    VALUES("id", "#{id}");
                }
                if (userPO.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (userPO.getSex() != null) {
                    VALUES("sex", "#{sex}");
                }
            }
        }.toString();
    }

    //更新用户
    public String updUserDynamic(final UserPO userPO) {
        return new SQL() {
            {
                UPDATE("user");
                if (userPO.getName() != null) {
                    SET("name = #{name}");
                }
                if (userPO.getSex() != null) {
                    SET("sex = #{sex}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //根据id获取用户
    public String getUserByIdDynamic(@Param("id") long id) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //删除用户
    public String delUserByIdDynamic(@Param("id") long id) {
        return new SQL() {
            {
                DELETE_FROM("user");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
