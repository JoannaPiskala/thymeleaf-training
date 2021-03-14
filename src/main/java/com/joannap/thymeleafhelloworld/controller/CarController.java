package com.joannap.thymeleafhelloworld.controller;

import com.joannap.thymeleafhelloworld.model.Car;
import com.joannap.thymeleafhelloworld.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


// GUI - graficzny interfejs uzutkownika


@Controller
public class CarController {


    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public String showCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("newCar", new Car());
        return "index";
    }

/*
    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

 */

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        Optional<Car> carToAdd = carService.addCar(car);
        if (carToAdd.isPresent()) {
            return "redirect:/cars";
        }
        return "Type car mark and model";
    }


    @GetMapping("/delete/{id}")
    public String deleteCarById (@PathVariable("id") Long id) {
        boolean deleted = carService.removeCar(id);
        if (deleted) {
            return "redirect:/cars";
        }
        return "car not found";
    }


    @GetMapping ("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
       Optional<Car> car = carService.findById(id);
        model.addAttribute("car", car);
        return "update-car";
    }


    @PostMapping ("/update/{id}")
    public String updateCar(@PathVariable("id") long id, @ModelAttribute Car car){
        carService.removeCar(id);
        carService.addCar(car);
        car.setId(id);
        return "redirect:/cars";

    }



}
