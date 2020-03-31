package com.nero.mybatis.annotation.mapper;

import com.nero.mybatis.annotation.po.UserPO;
import com.nero.mybatis.annotation.pojo.UserIdcard;
import com.nero.mybatis.annotation.pojo.UserOrder;
import com.nero.mybatis.annotation.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user(id,name,sex) values(#{id},#{name},#{sex})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    int addUser(UserPO userPO);

    @Update("update user set name = #{name},sex = #{sex} where id = #{id}")
    int updUser(UserPO userPO);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex")
    })
    UserPO getUserById(@Param("id") long id);

    @Delete("delete from user where id = #{id}")
    int delUserById(@Param("id") long id);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "idcard", column = "id",
                    one = @One(fetchType = FetchType.LAZY, select = "com.nero.mybatis.annotation.mapper.IdcardMapper.getIdcardByUserId"))
    })
    UserIdcard getUserIdcardById(long id);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "orders", column = "id",
                    many = @Many(fetchType = FetchType.LAZY, select = "com.nero.mybatis.annotation.mapper.OrderMapper.getOrderListByUserId"))
    })
    List<UserOrder> getUserOrderById(long id);

    @InsertProvider(type = UserProvider.class, method = "addUserDynamic")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    int addUserDynamic(UserPO userPO);

    @UpdateProvider(type = UserProvider.class, method = "updUserDynamic")
    int updUserDynamic(UserPO userPO);

    @SelectProvider(type = UserProvider.class, method = "getUserByIdDynamic")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex")
    })
    UserPO getUserByIdDynamic(@Param("id") long id);

    @DeleteProvider(type = UserProvider.class, method = "delUserByIdDynamic")
    int delUserByIdDynamic(@Param("id") long id);
}
