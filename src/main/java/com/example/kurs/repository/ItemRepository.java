package com.example.kurs.repository;

import com.example.kurs.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {


    Object findByNameIgnoreCase(String name);
}
