package com.henrixlt.henrikpizza.config;

import com.henrixlt.henrikpizza.modal.Ingredient;
import com.henrixlt.henrikpizza.modal.Pizza;
import com.henrixlt.henrikpizza.modal.PizzaOrder;
import com.henrixlt.henrikpizza.modal.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("NEAP","Neapolitan Pizza", Type.CRUST_TYPE),
                new Ingredient("NYSP","New York Style Pizza", Type.CRUST_TYPE),
                new Ingredient("TMT", "Tomato sauce", Type.SAUCE),
                new Ingredient("WHT", "White Sauce", Type.SAUCE),
                new Ingredient("MZRL","Mozzarella", Type.CHEESE),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("GOUD","Gouda", Type.CHEESE),
                new Ingredient("PEP","Peperoni", Type.TOPPINGS),
                new Ingredient("MUSH", "Mushrooms", Type.TOPPINGS),
                new Ingredient("HAM","Prosciutto", Type.TOPPINGS),
                new Ingredient("TOMB","Tomato and Basil", Type.TOPPINGS),
                new Ingredient("CHICK","Chicken", Type.TOPPINGS ),
                new Ingredient("PAIN", "Pineapple", Type.EXTRA_TOPPINGS),
                new Ingredient("SPIN","Spinach", Type.EXTRA_TOPPINGS)

        );
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
    public String processPizza(Pizza pizza, @ModelAttribute PizzaOrder pizzaOrder){
        pizzaOrder.addPizzas(pizza);
        log.info("Procesing pizza: {}", pizza);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(l-> l.getType().equals(type))
                .collect(Collectors.toList());
    }


}
