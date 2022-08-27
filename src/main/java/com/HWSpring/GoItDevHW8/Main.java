package com.HWSpring.GoItDevHW8;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class Main {
    @GetMapping
    public ModelAndView mainPage() {
        return new ModelAndView("main");
    }
}
