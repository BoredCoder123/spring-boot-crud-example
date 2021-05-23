package spring.boot.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;
    private String name;
    private int quantity;
    private double price;
}