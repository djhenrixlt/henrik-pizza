package com.henrixlt.henrikpizza.repository;

import com.henrixlt.henrikpizza.entity.PizzaOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository  extends CrudRepository<PizzaOrder, Long> {

    PizzaOrder save(PizzaOrder order);

    List<PizzaOrder> findByDeliveryPostCode(String postCode);
}
