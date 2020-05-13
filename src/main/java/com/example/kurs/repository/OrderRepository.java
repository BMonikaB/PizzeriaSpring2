package com.example.kurs.repository;

import com.example.kurs.domain.Order;
import com.example.kurs.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByStatus(OrderStatus orderStatus);
}
