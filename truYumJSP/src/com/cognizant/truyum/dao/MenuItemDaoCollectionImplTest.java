package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.copy.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {

		List<MenuItem> menuItemList = new MenuItemDaoColletcionImpl().getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {

			System.out.println(menuItem);

		}
	}

	public static void testGetMenuItemListCustomer() {

		System.out.println("Item List for Customer");

		@SuppressWarnings("unused")
		MenuItemDao menuItemDao = new MenuItemDaoColletcionImpl();

		List<MenuItem> menuItemList = new MenuItemDaoColletcionImpl().getMenuItemListCustomer();

		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	public static void testModifyMenuItem() {
		// 1. Create an instance for Menu Item with id matching with one of the menu
		// item already added to the menuItemList
		MenuItem item = new MenuItem(5L, "Chocolate Brownie", 52.00f, true, new DateUtil().convertToDate("02/12/2022"),
				"Main Course", true);
		// 2. Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoColletcionImpl();
		// 3. Invoke MenuItemDao.modifyMenuItem(menuItem) by passing the menu item
		// created in the first step
		menuItemDao.modifyMenuItem(item);
		System.out.println("***Modified List***");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		System.out.println("Modified item detail\n" + modified_item);
	}

	public static void main(String[] args) {

		testGetMenuItemListAdmin();

	}

}
