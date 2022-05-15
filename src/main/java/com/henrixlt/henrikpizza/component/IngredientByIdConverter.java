package com.henrixlt.henrikpizza.component;

import com.henrixlt.henrikpizza.modal.Ingredient;
import com.henrixlt.henrikpizza.modal.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;



@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap= new HashMap<>();

    public IngredientByIdConverter(){
        ingredientMap.put("NEAP",
                new Ingredient("NEAP","Neapolitan Pizza", Type.CRUST_TYPE));
        ingredientMap.put("NYSP",
                new Ingredient("NYSP","New York Style Pizza", Type.CRUST_TYPE));
        ingredientMap.put("TMT",
                new Ingredient("TMT", "Tomato sauce", Type.SAUCE));
        ingredientMap.put("TMT",
                new Ingredient("TMT", "Tomato sauce", Type.SAUCE));
        ingredientMap.put("WHT",
                new Ingredient("WHT", "White Sauce", Type.SAUCE));
        ingredientMap.put("MZRL",
                new Ingredient("MZRL","Mozzarella", Type.CHEESE));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("GOUD",
                new Ingredient("GOUD","Gouda", Type.CHEESE));
        ingredientMap.put("PEP",
                new Ingredient("PEP","Peperoni", Type.TOPPINGS));
        ingredientMap.put("MUSH",
                new Ingredient("MUSH", "Mushrooms", Type.TOPPINGS));
        ingredientMap.put("HAM",
                new Ingredient("HAM","Prosciutto", Type.TOPPINGS));
        ingredientMap.put("TOMB",
                new Ingredient("TOMB","Tomato and Basil", Type.TOPPINGS));
        ingredientMap.put("CHICK",
                new Ingredient("CHICK","Chicken", Type.TOPPINGS));
        ingredientMap.put("PAIN",
                new Ingredient("PAIN", "Pineapple", Type.EXTRA_TOPPINGS));
        ingredientMap.put("SPIN",
                new Ingredient("SPIN","Spinach", Type.EXTRA_TOPPINGS));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
