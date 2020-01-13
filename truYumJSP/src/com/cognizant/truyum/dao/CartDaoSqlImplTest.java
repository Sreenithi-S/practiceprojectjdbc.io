package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(3L, 2);
	}
	public static void testGetCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
	    Cart cart =  cartDaoSqlImpl.getAllCartItems(2L);
	   
	    System.out.println(cart.getMenuItemList());
	    System.out.println("Total price= "+cart.getTotal());

		
	}
	public static void testRemoveCartItem() throws CartEmptyException{
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1L, 2);
	}

	public static void main(String[] args) throws CartEmptyException {
		//testAddCartItem();
		//testRemoveCartItem();
        testGetCartItems();
	}
}