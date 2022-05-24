create table if not exist Pizza_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_Post_Code varchar(50) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
);

create table if not exists Pizza (
    id identity,
    name varchar(50), not null,
    pizza_order bigint not null,
    pizza_order_key bigint not null,
    pizza_key bigint not null
);

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
    );I

    alert table Pizza
        add foreign key (pizza_order) references Pizza_Order(id);
    alert table Ingredient_Ref
        add foreign key (ingredient) references Ingredient(id);

delete  from Ingredient_Ref;
delete from Pizza;
delete from Pizza_Order;

delete from Ingredient;
delete from Ingredient;
insert into Ingredient (id, name, type)
values ('NEAP','Neapolitan Pizza','CRUST_TYPE');
insert into Ingredient (id, name, type)
values ('NYSP', 'New York Style Pizza', 'CRUST_TYPE');
insert into Ingredient (id, name, type)
values ('TMT', 'Tomato sauce', 'SAUCE');
insert into Ingredient (id, name, type)
values ('WHT', 'White Sauce', 'SAUCE');
insert into Ingredient (id, name, type)
values ('MZRL',"Mozzarella", Type.CHEESE));
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('GOUD', 'Gouda', 'CHEESE');
insert into Ingredient (id, name, type)
values ('PEP', 'Peperoni', 'TOPPINGS');
insert into Ingredient (id, name, type)
values ('HAM', 'Prosciutto', 'TOPPINGS');
insert into Ingredient (id, name, type)
values ('TOMB','Tomato and Basil', 'TOPPING');
insert into Ingredient (id, name, type)
values ('CHIC','Chicken', 'TOPPINGS');
insert into Ingredient (id, name, type)
values ('MUSH', 'Mushrooms', 'TOPPINGS');
insert into Ingredient (id, name, type)
values ('PAIN', 'Pineapple', 'EXTRA_TOPPINGS');
insert into Ingredient (id, name, type)
values ('SPIN','Spinach', 'EXTRA_TOPPINGS');
