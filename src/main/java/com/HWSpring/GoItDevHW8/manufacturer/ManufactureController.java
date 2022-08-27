package com.HWSpring.GoItDevHW8.manufacturer;

import com.HWSpring.GoItDevHW8.product.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/manufacturer")
@Controller
public class ManufactureController {

    private final ManufacturerService manufacturerService;
    private final ProductsService productsService;

    @GetMapping
    public ModelAndView getAllManufacturer() {
        ModelAndView modelAndView = new ModelAndView("manufacturer");
        modelAndView.addObject("manufacturerList", manufacturerService.getAllManufacturer());

        return modelAndView;
    }

    @PostMapping("/add")
    private void createManufacturer(@RequestParam(name = "manufacturerName") String name,
                                    HttpServletResponse response) {
        manufacturerService.createManufacturer(name);

        try {
            response.sendRedirect("/manufacturer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/delete")
    private void deleteManufacturer(@RequestParam(name = "deleteManufacturers") String delete,
                                    HttpServletResponse response) {
        manufacturerService.delete(delete);

        try {
            response.sendRedirect("/manufacturer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/update")
    private void updateManufacturer(@RequestParam(name = "updateUUID") UUID uuid,
                                    @RequestParam(name = "updateManufacturerName") String updateName,
                                    HttpServletResponse response) {
        manufacturerService.update(uuid, updateName);
        try {
            response.sendRedirect("/manufacturer");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


