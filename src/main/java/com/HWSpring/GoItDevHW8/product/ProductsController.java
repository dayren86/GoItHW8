package com.HWSpring.GoItDevHW8.product;

import com.HWSpring.GoItDevHW8.manufacturer.Manufacturer;
import com.HWSpring.GoItDevHW8.manufacturer.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/products")
@Controller
public class ProductsController {
    private final ProductsService productsService;
    private final ManufacturerService manufacturerService;

    @GetMapping
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productsList", productsService.getAllProducts());
        modelAndView.addObject("listManufacturer", manufacturerService.getAllManufacturer());
        return modelAndView;
    }

    @PostMapping("/add")
    public void createProducts(@RequestParam(name = "productsName") String name,
                               @RequestParam(name = "productsSalary") int salary,
                               @RequestParam(name = "listManufacturer") UUID uuid,
                               HttpServletResponse response) {

        productsService.create(name, salary, uuid);

        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/delete")
    public void deleteProducts(@RequestParam(name = "deleteProducts") UUID uuid,
                               HttpServletResponse response) {

        productsService.deleteByUUID(uuid);

        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/update")
    public void updateProducts(@RequestParam(name = "updateProductsUUID") UUID uuid,
                               @RequestParam(name = "updateProductsName") String updateName,
                               @RequestParam(name = "updateProductsSalary", required = false) String updateSalary,
                               @RequestParam(name = "updateListManufacturer", required = false) UUID uuidManufacturer,
                               HttpServletResponse response) {
        productsService.update(uuid, updateName, updateSalary, uuidManufacturer);

        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
