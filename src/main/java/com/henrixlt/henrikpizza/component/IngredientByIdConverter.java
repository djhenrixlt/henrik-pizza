package com.henrixlt.henrikpizza.component;

import com.henrixlt.henrikpizza.entity.Ingredient;
import com.henrixlt.henrikpizza.repository.IngredientRepository;
import com.henrixlt.henrikpizza.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@NoArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }


}
