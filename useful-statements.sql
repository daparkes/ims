insert into customers(id, first_name, surname) values fred, durst;

update customers set first_name='', surname="" where id=;

delete from customers where id=;

select * from orders join order_items on orders.id=order_items.order_id join items on order_items.item_id=items.id;

insert into orders(customer_id) values (2), (3), (4);

insert into items(item_name, price) values ("fanta", 1.50), ("coke", 1.50), ("dr pepper", 1.50), ("water", 0.75);

insert into customers(first_name, surname) values ("bob", "smith"), ("jess", "parkes"), ("helen", "mirren"), ("brad", "pitt"), ("george", "clooney");

insert into order_items (order_id, item_id, quantity) values (4, 1, 5), (5, 2, 6), (6, 3, 2);
insert into order_items (order_id, item_id, quantity) values (4, 3, 6);
select * from order_items;

select * from order_items;

select sum(price) as Order_Cost from (select item_id from order_items where order_id =4) as items_in_order join items on items_in_order.item_id = items.id;

insert into orders(customer_id, total_price) values (4, (select sum(price) as Order_Cost from (select item_id from order_items where order_id =4) as items_in_order join items on items_in_order.item_id = items.id));
select * from orders;

update orders set customer_id=3, total_price=
	(select sum(price) as Order_Cost from (select item_id from order_items where order_id =4) as items_in_order
    join items on items_in_order.item_id = items.id where id=2)
    where id=4;
select * from orders where id=4;