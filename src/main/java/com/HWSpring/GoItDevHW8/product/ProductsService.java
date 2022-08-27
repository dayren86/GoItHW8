package com.HWSpring.GoItDevHW8.product;

import com.HWSpring.GoItDevHW8.manufacturer.Manufacturer;
import com.HWSpring.GoItDevHW8.manufacturer.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ManufacturerService manufacturerService;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public void create(String name, int salary, UUID uuid) {
        Products products = new Products();
        products.setProductsName(name);
        products.setPrice(salary);
        products.setManufacturer(manufacturerService.getByUUID(uuid));
        productsRepository.save(products);
    }

    public Products getByUUID(UUID uuid) {
        return productsRepository.getReferenceById(uuid);
    }

    public void deleteByUUID(UUID uuid) {
        productsRepository.deleteById(uuid);
    }

    public void update(UUID uuid, String updateName, String updateSalary, UUID uuidManufacturer) {
        Products products = getByUUID(uuid);
        products.setProductsName(updateName);
        products.setPrice(Integer.parseInt(updateSalary));
        products.setManufacturer(manufacturerService.getByUUID(uuidManufacturer));
        productsRepository.save(products);
    }
}
