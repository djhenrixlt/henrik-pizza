package com.henrixlt.henrikpizza.modal;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "you mus choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
