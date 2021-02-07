package com.joannap.thymeleafhelloworld.controller;

import com.joannap.thymeleafhelloworld.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// GUI - graficzny interfejs uzutkownika


@Controller // klasa ktora bedzie zwracala plik html lub plik nalezacy do silnika thymeleaf musi miec adnotacje controller!
public class CarController {


    private List<Car> cars;

    public CarController() {
        Car car1 = new Car("BMW", "i8");
        Car car2 = new Car("Polonez", "Caro");
        Car car3 = new Car("Hyundai", "i30");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @GetMapping("/car")
    public String getCar(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        return "redirect:/car";
    }

}
