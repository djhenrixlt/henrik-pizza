package com.henrixlt.henrikpizza.entity;

import com.henrixlt.henrikpizza.enums.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient {

    @Id
    private String id;

    private String name;
    private Type type;
}

