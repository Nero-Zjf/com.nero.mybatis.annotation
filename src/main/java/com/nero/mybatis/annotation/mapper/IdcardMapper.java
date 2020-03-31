package com.nero.mybatis.annotation.mapper;

import com.nero.mybatis.annotation.po.IdcardPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IdcardMapper {
    @Select("select * from id_card where user_id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "cardNum",column = "card_num"),
            @Result(property = "date",column = "date")
    })
    IdcardPO getIdcardByUserId(@Param("userId") long userId);

}
