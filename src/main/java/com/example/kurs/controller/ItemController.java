package com.example.kurs.controller;

import com.example.kurs.domain.Item;
import com.example.kurs.domain.Order;
import com.example.kurs.domain.OrderItem;
import com.example.kurs.repository.ItemRepository;
import com.example.kurs.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItem orderItem;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/")
    public String zamowienie(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @GetMapping("/find/{name}")
    public String getByName(@PathVariable String name, Model model) {
        model.addAttribute("item", itemRepository.findByNameIgnoreCase(name.replaceAll("-", " ")));

        return "itemByName";
    }




    @GetMapping("/order/add/{id}")
    public String addToOrder(@PathVariable Long id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        orderItem.addItemToRepository(item.get());
        return "message";
    }

    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("order", orderItem.getOrder());
        model.addAttribute("price", orderItem.getOrder().getItemList().stream().mapToDouble(s -> s.getPrice()).sum());
        return "orders";
    }


    @PostMapping("/order/save")
    public String makeOrder(@RequestParam String address, @RequestParam String telephone, Model model) {

        Order order =orderItem.getOrder();
        order.setAddress(address);
        order.setTelephone(telephone);
        orderRepository.save(order);
        orderItem.clear();

        return "message";
    }


}
