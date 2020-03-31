package com.nero.mybatis.annotation;

import com.nero.mybatis.annotation.po.UserPO;
import com.nero.mybatis.annotation.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        try {
            //-------------------------使用 XML 构建 SqlSessionFactory-------------------------
            // 读取配置文件 mybatis-config.xml
            InputStream config = Resources
                    .getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(config);
            //--------------------------------------------------------

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();

            //获取Mapper
            UserMapper userMapper = ss.getMapper(UserMapper.class);

            //插入用户
            System.out.println("-------------------插入用户------------------");
            UserPO addUser = new UserPO();
            addUser.setId(3);
            addUser.setName("ico");
            addUser.setSex("0");
            userMapper.addUser(addUser);
            System.out.println("插入的用户id:" + addUser.getId());

            // 查询用户
            System.out.println("--------------查询用户--------------------------------");
            UserPO user = userMapper.getUserById(addUser.getId());
            System.out.println(user);

            //更新用户
            System.out.println("--------------更新用户--------------------------------");
            user.setName("hello");
            userMapper.updUser(user);

            //删除用户
            System.out.println("--------------删除用户--------------------------------");
            userMapper.delUserById(addUser.getId());

            //查询用户（包含身份证信息）
            System.out.println("---------------查询用户（包含身份证信息）---------------");
            System.out.println(userMapper.getUserIdcardById(1));

            //查询用户（包含订单信息）
            System.out.println("---------------查询用户（包含订单信息）---------------");
            System.out.println(userMapper.getUserOrderById(1));


            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
