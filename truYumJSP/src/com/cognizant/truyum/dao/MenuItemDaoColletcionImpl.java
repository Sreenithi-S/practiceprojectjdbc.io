package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.copy.DateUtil;

public class MenuItemDaoColletcionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoColletcionImpl() {

		super();

		if (menuItemList == null) {

			menuItemList = new ArrayList<MenuItem>();
			MenuItem itemOne = new MenuItem(1L, "sandwitch", 99.00f, true, new DateUtil().convertToDate("15/03/2017"),
					"Main Course", true);
			MenuItem itemTwo = new MenuItem(2L, "Burger", 129.00f, true, new DateUtil().convertToDate("23/03/2017"),
					"Main Course", false);
			MenuItem itemThree = new MenuItem(3L, "Pizza", 149.00f, true, new DateUtil().convertToDate("21/08/2018"),
					"Main Course", false);
			MenuItem itemFour = new MenuItem(4L, "French Fries", 57.00f, false,
					new DateUtil().convertToDate("12/12/2019"), "Starter", true);
			MenuItem itemFive = new MenuItem(5L, "Chocolate Brownie", 32.00f, true,
					new DateUtil().convertToDate("02/12/2022"), "Dessert", true);
			menuItemList.add(itemOne);
			menuItemList.add(itemTwo);
			menuItemList.add(itemThree);
			menuItemList.add(itemFour);
			menuItemList.add(itemFive);

		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();// 1. Initialize an ArrayList for type MenuItem

		for (MenuItem menuItem : menuItemList) {

			if (menuItem.getDateOfLaunch().before(new Date())) {

				if (menuItem.getActive()) {

					filteredMenuItem.add(menuItem);
				}
			}

		}

		return filteredMenuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId)
				return menuItem;
		}

		return null;
	}

}
