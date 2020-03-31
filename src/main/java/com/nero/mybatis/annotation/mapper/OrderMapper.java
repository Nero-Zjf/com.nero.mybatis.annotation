package com.nero.mybatis.annotation.mapper;

import com.nero.mybatis.annotation.po.OrderPO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from `order` where user_id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "orderNum",column = "order_num")
    })
    List<OrderPO> getOrderListByUserId(Long userId);
}