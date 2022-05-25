package com.henrixlt.henrikpizza.repository;

import com.henrixlt.henrikpizza.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);


}
