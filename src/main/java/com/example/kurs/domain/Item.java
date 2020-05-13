package com.example.kurs.domain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    private String description;
    private String imgUrl;


    public Item() {
    }

    public Item(double price, String name, String shortDescription, String description, String imgUrl) {
        this.price = price;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", price=" + price + ", name='" + name + '\'' + ", shortDescription='" + shortDescription + '\'' + ", description='" + description + '\'' + ", imgUrl='" + imgUrl + '\'' + '}';
    }
}
