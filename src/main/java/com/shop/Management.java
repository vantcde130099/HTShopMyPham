package com.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop.model.Brand;
import com.shop.model.Color;
import com.shop.model.Customer;
import com.shop.model.Order;
import com.shop.model.OrderItems;
import com.shop.model.OrderStatus;
import com.shop.model.Payment;
import com.shop.model.Product;
import com.shop.model.ProductCategory;
import com.shop.model.Staff;

public class Management {
	public static void main(String[] args) {
		// createProductAndBrand();
		createOrderAndCustomerAndOrderStatusAndOrderItemsAndProduct();
		ConnectionUtil.getSessionFactory().close();
	}

	private static void createProductAndBrand() {

		Color color = new Color("Olive", "808000");
		Color color1 = new Color("Lime", "00FF00");
		List<Color> listColor = new ArrayList<Color>();
		listColor.add(color);
		listColor.add(color1);
		ProductCategory category = new ProductCategory(0, "Lipstick", "This is lipstick");
		Brand b = new Brand("Gucci");
		Product p = new Product("POWDER KISS LIQUID LIPCOLOUR", "Italia", (float) 3.50,
				"a liquid lipcolour with a whipped, mousse-like texture that delivers soft-focus moisture-matte, comfortable colour with ten hours of hydration.",
				25, 100, b, category, listColor);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for (Color c : listColor) {
				session.save(c);
			}
			session.save(category);
			session.save(b);
			session.save(p);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createOrderAndCustomerAndOrderStatusAndOrderItemsAndProduct() {
		OrderStatus status1 = new OrderStatus("In Process");
		OrderStatus status2 = new OrderStatus("Paid");
		Customer customer = new Customer("nobody", "nobody99dn", "Tran", "Van", "Danang", "0798850400");

		Product p = new Product("POWDER KISS LIQUID LIPCOLOUR", "Italia", (float) 3.50,
				"a liquid lipcolour with a whipped, mousse-like texture that delivers soft-focus moisture-matte, comfortable colour with ten hours of hydration.",
				25, 100);
		Product p1 = new Product("LOVE ME LIPSTICK", "Brush", (float) 3.50,
				"a weightless argan oil-infused lipstick that delivers an instant hit of powerful colour and all-day moisture in a luxurious satin-soft finish",
				19, 200);

		OrderItems item1 = new OrderItems(3, new Date(), p);
		OrderItems item2 = new OrderItems(3, new Date(), p1);
		List<OrderItems> items = new ArrayList<OrderItems>();
		items.add(item1);
		items.add(item2);
		Staff staff = new Staff("beo", "tran", "noone", "nobiet", "123412", "Giang DOng");
		Payment payment = new Payment("COD", "Giao hang tan nha");
		Order order = new Order(new Date(), status2, customer, items, payment, staff);
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(p);
			session.save(p1);
			session.save(status1);
			session.save(status2);
			session.save(customer);
			session.save(staff);
			session.save(payment);
			for (OrderItems ot : items) {
				session.save(ot);
			}

			session.save(order);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
