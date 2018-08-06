package com.itheima.mapper;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    public Order queryOrderById(@Param("id")Integer id);

    //1 根据订单号 查询订单的同时，查询出订单所属用户
    public Order queryOrderWithUserInfo(@Param("orderId") Integer orderId);

    // 2 根据订单号 查询订单，并且查询出所有订单详情及所属用户
    public Order queryOrderWithUserAndOrderItemsInfo(@Param("orderId") Integer orderId);

    //3  根据订单号 查询订单，查询出所属用户，并且查询出订单的详情，及订单详情中的对应的商品信息
    public Order queryOrderWithUserAndOrderAndOrderItemsAndProductInfo(@Param("orderId") Integer orderId);
}
