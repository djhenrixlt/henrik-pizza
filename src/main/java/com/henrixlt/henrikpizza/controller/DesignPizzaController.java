package com.henrixlt.henrikpizza.controller;

import com.henrixlt.henrikpizza.modal.Ingredient;
import com.henrixlt.henrikpizza.modal.Pizza;
import com.henrixlt.henrikpizza.modal.PizzaOrder;
import com.henrixlt.henrikpizza.enums.Type;
import com.henrixlt.henrikpizza.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepository;
    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients,type));
        }
    }
    @ModelAttribute(name = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @ModelAttribute(name ="pizzaOrder")
    public PizzaOrder pizzaOrder(){
        return new PizzaOrder();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid Pizza pizza, @ModelAttribute PizzaOrder pizzaOrder){
        pizzaOrder.addPizzas(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(l-> l.getType().equals(type))
                .collect(Collectors.toList());
    }


}
