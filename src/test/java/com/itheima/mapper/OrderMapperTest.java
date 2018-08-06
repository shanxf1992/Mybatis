package com.itheima.mapper;

import com.itheima.domain.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderMapperTest {

    private SqlSession sqlSession = null;

    @Before
    public void setUp() throws Exception {

        //  手动初始化SqlsessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //手动创建XMLConfigBuilder，并解析创建Configuration对象
//        XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null,null);
//        Configuration configuration=parse();
//        //使用Configuration对象创建SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//        //使用MyBatis
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        //  通过读取配置文件的方式初始化SqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        sqlSession = build.openSession(true);
    }

    @Test
    public void queryOrderById() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserInfo() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderWithUserInfo(1);
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserAndOrderItemsInfo() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderWithUserAndOrderItemsInfo(1);
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserAndOrderAndOrderItemsAndProductInfo() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderWithUserAndOrderAndOrderItemsAndProductInfo(1);
        System.out.println(order);
    }

}