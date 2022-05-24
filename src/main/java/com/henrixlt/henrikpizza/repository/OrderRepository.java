package com.henrixlt.henrikpizza.repository;

import com.henrixlt.henrikpizza.modal.PizzaOrder;

public interface OrderRepository {

    PizzaOrder save(PizzaOrder order);
}
