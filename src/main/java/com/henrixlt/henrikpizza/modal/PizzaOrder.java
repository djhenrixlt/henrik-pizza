package com.henrixlt.henrikpizza.modal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryPostCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizzas(Pizza pizza){
        this.pizzas.add(pizza);
    }
}
