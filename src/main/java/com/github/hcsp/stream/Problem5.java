package com.github.hcsp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem5 {
    // 使用流的方法，把订单处理成ID->订单的映射
    // 例如，传入参数[{id=1,name='肥皂'},{id=2,name='牙刷'}]
    // 返回一个映射{1->Order(1,'肥皂'),2->Order(2,'牙刷')}
    public static Map<Integer, Order> toMap(List<Order> orders) {
        return orders.stream().collect(Collectors.toMap(Order::getId, order -> new Order(order.getId(), order.getName())));
    }

    public static void main(String[] args) {
        System.out.println(toMap(Arrays.asList(new Order(1, "肥皂"), new Order(2, "牙刷"))));
    }

    public static class Order {
        private final Integer id;
        private final String name;

        Order(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }
}
