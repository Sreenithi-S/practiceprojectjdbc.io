INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', 'Yes', '2019-04-23', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', 'Yes', '2019-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', 'Yes', '2020-01-10', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', 'No', '2021-02-04', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', 'Yes', '2022-02-17', 'Dessert', 'Yes');  


INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Surya');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'Karthik');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('3', 'Sona');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('4', 'Sylviya');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('5', 'Shradha');

/*--1.	View Menu Item List Admin (TYUC001)*/

select * from menu_item;

/*2.	View Menu Item List Customer (TYUC002)*/

select me_name ,me_price, me_date_of_launch, me_category, me_free_delivery from menu_item where me_active='yes' and me_date_of_launch>(select curdate());

/*update SQL menu_items table to update all the columns values based on Menu Item Id*/

update menu_item
set
me_name='Pasta',
me_price='90.00',
me_active='no',
me_date_of_launch='2020-2-10',
me_category='starter',
me_free_delivery='no'
where 
me_id='1'
/*add to cart*/
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('1', '1', '1');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('2', '1', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('3', '1', '5');

/*to get total particular user,s cart*/
select sum(me_price) as Total from truyum.menu_item 
inner join truyum.cart on ct_me_id=me_id;
where ct_us_id=1 

select * from cart
/*SQL query to remove a menu items from Cart based on User Id and Menu Item Id*/
delete from truyum.cart where ct_us_id=1 and ct_me_id=3;
select * from truyum.cart; 