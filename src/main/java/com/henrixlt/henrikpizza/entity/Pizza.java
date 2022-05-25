package com.henrixlt.henrikpizza.entity;

import com.henrixlt.henrikpizza.entity.Ingredient;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pizza {

    @Id
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @ManyToMany
    @Size(min = 1, message = "you mus choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
