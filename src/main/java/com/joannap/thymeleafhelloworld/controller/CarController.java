package com.joannap.thymeleafhelloworld.controller;

import com.joannap.thymeleafhelloworld.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// GUI - graficzny interfejs uzutkownika


@Controller // klasa ktora bedzie zwracala plik html lub plik nalezacy do silnika thymeleaf musi miec adnotacje controller!
public class CarController {

    // musimy zdefiniowac model
    @GetMapping("/car")
    public String getCar(Model model){
        Car car = new Car ("BMW", "i8");
        model.addAttribute("name", "Joanna");
        model.addAttribute("car", car);
        return "car";
    }

}
