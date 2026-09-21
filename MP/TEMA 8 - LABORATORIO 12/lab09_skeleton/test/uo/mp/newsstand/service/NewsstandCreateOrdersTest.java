package uo.mp.newsstand.service;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.exception.NewsStandException;

public class NewsstandCreateOrdersTest {
	
	private Magazine magazine;
	private String nameMagazine;
	private int instockMagazine;
	private int salesMagazine;
	private Frequency frequency;
	private Newspaper newspaper;
	private String nameNewspaper;
	private int instockNewspaper;
	private int salesNewspaper;
	
	@BeforeEach
	public void setUp() throws Exception {
		nameMagazine = "Hola";
		instockMagazine=7;
		salesMagazine=10;
		frequency = Frequency.BIMONTHLY;
		magazine = new Magazine(nameMagazine, salesMagazine, instockMagazine, frequency);
		nameNewspaper = "ABC";
		instockNewspaper=4;
		salesNewspaper=8;
		newspaper = new Newspaper(nameNewspaper, salesNewspaper, instockNewspaper);
	}
	
	/**
	 * GIVEN: A newspaper with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void enoughCopiesNewspaperNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		newspaper.setStock(33);
		stand.addPublication(newspaper);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(),stand.createOrders().toString());
	}

	/**
	 * GIVEN: A newspaper with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void copiesintheLimitNewspaperNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		newspaper.setStock(10);
		stand.addPublication(newspaper);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(),stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A newspaper with no enough copies in stock 
	 * WHEN: generate orders
	 * THEN: new order is generated with name and 20
	 * @throws NewsStandException 
	 */
	@Test
	public void noEnoughCopiesNewspaperNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		newspaper.setStock(7);
		stand.addPublication(newspaper);
		int number = newspaper.getSales() + (newspaper.getStock() * 2);
		Order order = new Order(nameNewspaper, number);
		List<Order> check = new LinkedList<>();
		check.add(order);
		assertEquals(check.toString(),stand.createOrders().toString());
	}

	/**
	 * GIVEN: A weekly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void enoughCopiesWeeklyMagazineNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setStock(33);
		stand.addPublication(magazine);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(),stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void limitCopiesWeeklyMagazineNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.WEEKLY);
		magazine.setStock(10);
		stand.addPublication(magazine);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(), stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 * @throws NewsStandException 
	 */
	@Test
	public void weeklyMagazineCopiesUnder5Order20() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.WEEKLY);
		magazine.setStock(4);
		stand.addPublication(magazine);
		Order expected = new Order(nameMagazine, 20);
		List<Order> check = new LinkedList<>();
		check.add(expected);
		assertEquals(check.toString(), stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold
	 * @throws NewsStandException 
	 */
	@Test
	public void weeklyMagazine5CopiesOrderSold() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setStock(5);
		magazine.setFrequency(Frequency.WEEKLY);
		stand.addPublication(magazine);
		Order expected = new Order(nameMagazine, salesMagazine);
		List<Order> check = new LinkedList<>();
		check.add(expected);
		assertEquals(check.toString(), stand.createOrders().toString());
	}
	
	
	
	/**
	 * GIVEN: A monthly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void enoughCopiesMonthlyMagazineNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.MONTHLY);
		magazine.setStock(33);
		stand.addPublication(magazine);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(), stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock in the limit (10)
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsStandException 
	 */
	@Test
	public void limitCopiesMonthlyMagazineNoOrderTest() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.MONTHLY);
		magazine.setStock(10);
		stand.addPublication(magazine);
		List<Order> check = new LinkedList<>();
		assertEquals(check.toString(), stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 * @throws NewsStandException 
	 */
	@Test
	public void monthlyMagazineCopiesUnder5Order20() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.MONTHLY);
		magazine.setStock(4);
		stand.addPublication(magazine);
		Order order = new Order(nameMagazine, 20);
		List<Order> check = new LinkedList<>();
		check.add(order);
		assertEquals(check.toString(),stand.createOrders().toString());
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold +
	 * 									  number of copies in stock
	 * @throws NewsStandException 
	 */
	@Test
	public void monthlyMagazine5CopiesOrderSoldPlusStock() throws NewsStandException {
		Newsstand stand = new Newsstand();
		magazine.setFrequency(Frequency.MONTHLY);
		magazine.setStock(5);
		stand.addPublication(magazine);
		int to_order = magazine.getSales()+magazine.getStock();
		Order order = new Order(nameMagazine, to_order);
		List<Order> check = new LinkedList<>();
		check.add(order);
		assertEquals(check.toString(),stand.createOrders().toString());
	}
	
}
