package com.henrixlt.henrikpizza.entity;

import com.henrixlt.henrikpizza.entity.Pizza;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class PizzaOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "Post code is required")
    private String deliveryPostCode;

    @NotBlank(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2]) ([\\/]) ([2-9] [0-9])$",message = "Format must be MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Wrong CVV number")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizzas(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public void  addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }
}
