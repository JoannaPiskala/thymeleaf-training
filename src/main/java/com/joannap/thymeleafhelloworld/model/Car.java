package com.joannap.thymeleafhelloworld.model;

import java.util.Objects;


public class Car {

    private Long id;
    private String mark;
    private String model;


    public Car(Long id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }

    public Car() {}

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model);
    }
}
