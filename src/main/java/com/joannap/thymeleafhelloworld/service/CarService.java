package com.joannap.thymeleafhelloworld.service;

import com.joannap.thymeleafhelloworld.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    private List<Car> cars;

    public CarService() {
        Car car1 = new Car(1L, "BMW", "i8");
        Car car2 = new Car(2L, "Polonez", "Caro");
        Car car3 = new Car(3L, "Hyundai", "i30");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    public List<Car> findAll() {
        return cars;

    }




    public Car addCar(Car car) {
        car.setId(getNextId());
        cars.add(car);
        return car;
    }


    public boolean removeCar(Long id) {
        Optional<Car> carToRemove = findById(id);
        if (carToRemove.isPresent()) {
            return cars.remove(carToRemove.get());
        }
        return false;
    }

    private Long getNextId() {
        if(cars.size() != 0) {
            return cars.stream()
                    .mapToLong(Car::getId)
                    .max()
                    .getAsLong() + 1;
        }
        return 1L;
    }

    public Optional<Car> findById(long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny();
    }

}
