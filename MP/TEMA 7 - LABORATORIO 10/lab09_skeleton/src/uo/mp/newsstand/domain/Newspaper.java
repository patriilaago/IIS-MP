package uo.mp.newsstand.domain;

public class Newspaper extends Publication {

	public Newspaper(String name, int sales, int stock) {
		super(name, sales, stock);
	}


	@Override
	public Order generateOrders() {
		return new Order(getName(), getSales() + (getStock() * 2));
	}

	@Override
	public String serialize() {
		return "newspaper" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}
}
