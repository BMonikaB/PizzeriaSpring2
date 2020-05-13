package com.example.kurs.domain;

import com.example.kurs.repository.ItemRepository;
import com.example.kurs.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class OrderItem {


    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;

    private Order order;

    OrderItem(){
        clear();
    }

    public void clear() {
        order = new Order();
        order.setStatus(OrderStatus.NEW);
    }

    public void addItemToRepository(Item item){
        order.getItemList().add(item);
    }

    public Order getOrder() {
        return order;
    }
}
