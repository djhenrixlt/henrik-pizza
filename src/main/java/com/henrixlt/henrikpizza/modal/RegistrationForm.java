package com.henrixlt.henrikpizza.modal;

import com.henrixlt.henrikpizza.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String postCode;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(
                username, passwordEncoder.encode(password),
                fullname,street,city,postCode,phone
        );
    }
}
