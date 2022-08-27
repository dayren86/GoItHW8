package com.HWSpring.GoItDevHW8.product;

import com.HWSpring.GoItDevHW8.manufacturer.Manufacturer;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "products")
@Entity
public class Products {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "products_name")
    private String productsName;

    @Column
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return  "Id=" + id +
                ", Name='" + productsName + '\'' +
                ", Price=" + price;
    }
}
