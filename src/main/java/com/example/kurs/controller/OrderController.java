package com.example.kurs.controller;

import com.example.kurs.domain.Order;
import com.example.kurs.domain.OrderItem;
import com.example.kurs.domain.OrderStatus;
import com.example.kurs.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    OrderItem orderItem;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/panel/zamowienia")
    public String getOrder(@RequestParam(required = false) OrderStatus status, Model model) {
        if (status == null) {
            model.addAttribute("orders", orderRepository.findAll());
        } else {
            model.addAttribute("orders", orderRepository.findAllByStatus(status));
        }
        return "ordersstatus";
    }

    @GetMapping("/panel/zamowienia/{id}")
    public String showOneOrderAndStatus(@PathVariable Long id, Model model) {
        Optional<Order> order = orderRepository.findById(id);
        model.addAttribute("order", order.get());
        model.addAttribute("suma", order.get().getItemList().stream().mapToDouble(s -> s.getPrice()).sum());
        return "changeorderstatus";
    }

    @PostMapping("/panel/zamowienie/{id}")
    public String changeOrderStatus(@PathVariable Long id, Model model) {

        Optional<Order> order = orderRepository.findById(id);
        order.get().setStatus(OrderStatus.changeOrderStatus(order.get().getStatus()));

        model.addAttribute("order", order.get());
        model.addAttribute("suma", order.get().getItemList().stream().mapToDouble(s -> s.getPrice()).sum());
        orderRepository.save(order.get());
        return "changeorderstatus";
    }


}
