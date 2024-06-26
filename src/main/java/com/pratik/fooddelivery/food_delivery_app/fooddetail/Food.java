package com.pratik.fooddelivery.food_delivery_app.fooddetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "food")
public class Food {


    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should be atleast 2 characters")
    private String name;

    private Integer price;

    public Food() {

    }


    public Food(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
