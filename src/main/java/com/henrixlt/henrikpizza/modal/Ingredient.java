package com.henrixlt.henrikpizza.modal;

import com.henrixlt.henrikpizza.enums.Type;
import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;
}
