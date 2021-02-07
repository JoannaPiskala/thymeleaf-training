package com.joannap.thymeleafhelloworld.controller;

import com.joannap.thymeleafhelloworld.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// GUI - graficzny interfejs uzutkownika


@Controller // klasa ktora bedzie zwracala plik html lub plik nalezacy do silnika thymeleaf musi miec adnotacje controller!
public class CarController {

    // musimy zdefiniowac model
    @GetMapping("/car")
    public String getCar(Model model){
        Car car1 = new Car ("BMW", "i8");
        Car car2 = new Car ("Fiat", "126p");
        Car car3 = new Car ("Polonez", "Caro");
        Car car4 = new Car ("Hyundai", "i30");
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        model.addAttribute("name", "Joanna");
        model.addAttribute("cars", cars);
        return "car";
    }

}
