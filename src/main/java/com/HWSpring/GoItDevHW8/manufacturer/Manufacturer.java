package com.HWSpring.GoItDevHW8.manufacturer;

import com.HWSpring.GoItDevHW8.product.Products;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "manufacturer")
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private List<Products> products;

    @Override
    public String toString() {
        return  "Id=" + id +
                ", Name='" + manufacturerName + '\'' +
                ", Products=" + products;
    }
}
