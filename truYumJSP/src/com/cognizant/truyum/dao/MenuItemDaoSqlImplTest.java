package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.copy.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-10s%-20s%-10s%-15s%-15s%-15s%-10s", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		String active;
		String freeDelivery;

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("\n%-10s%-20s%-10s%-15s%-15s%-15s%-10s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);

		}
	}

	public static void testGetMenuItemListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-10s%-20s%-10s%-15s%-15s%-15s%-10s", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		String active;
		String freeDelivery;

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("\n%-10s%-20s%-10s%-15s%-15s%-15s%-10s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);

		}
	}

	public static void testModifyMenuItem() throws NumberFormatException, IOException {

		MenuItem menuItem = new MenuItem(1l, "Shawarma", 80.00f, false, new DateUtil().convertToDate("12/09/2020"),
				"Starter", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();

		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
	}

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItemListAdmin();
	}

}
