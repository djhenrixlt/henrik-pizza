package com.henrixlt.henrikpizza.repository;

import com.henrixlt.henrikpizza.modal.Ingredient;
import com.henrixlt.henrikpizza.modal.IngredientRef;
import com.henrixlt.henrikpizza.modal.Pizza;
import com.henrixlt.henrikpizza.modal.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.asm.Type;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public PizzaOrder save(PizzaOrder order) {
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Pizza_Order"
                        + "(delivery_name, delivery_street, delivery_city, "
                        +"delivery_post_code, cc_number, "
                        +"cc_expiration, cc_cvv, placed_at)"
                        +"values (?,?,?,?,?,?,?,?)",
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
                );
        pscf.setReturnGeneratedKeys(true);
        order.setPlacedAt(new Date());
        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                order.getDeliveryName(),
                                order.getDeliveryStreet(),
                                order.getDeliveryCity(),
                                order.getDeliveryPostCode(),
                                order.getCcNumber(),
                                order.getCcExpiration(),
                                order.getCcCVV(),
                                order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Pizza> pizzas = order.getPizzas();
        int i = 0;
        for (Pizza pizza : pizzas){
            savePizza(orderId, i++, pizza);
        }
        return order;
    }
    private long savePizza(Long orderId, int orderKey, Pizza pizza){
        pizza.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Pizza"
                                + "(name, created_at, pizza_order, pizza_order_key) "
                                +"values (?,?,?,?)",
                        Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
                );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                pizza.getName(),
                                pizza.getCreatedAt(),
                                orderId,
                                orderKey
                        ));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long pizzaId = keyHolder.getKey().longValue();
        pizza.setId(pizzaId);
        List<IngredientRef> ingredientRefs = new ArrayList<>();
        ingredientRefs.add((IngredientRef) pizza.getIngredients());

        saveIngredientRefs(pizzaId, ingredientRefs);
        return  pizzaId;
    }

    private void saveIngredientRefs(long pizzaId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, pizza, pizza_key)"
                            + "values (?, ?, ?)",
                    ingredientRef.getIngredient(), pizzaId, key++);

        }
    }

}
