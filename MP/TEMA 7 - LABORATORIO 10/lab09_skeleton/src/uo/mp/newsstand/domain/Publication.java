package uo.mp.newsstand.domain;

import uo.mp.util.check.ArgumentChecks;

public abstract class Publication {
	private String name;
	private int instock;
	private int sales;

	protected Publication(String name, int sales, int stock) {
		setName(name);
		setSales(sales);
		setStock(stock);
	}

	public void setStock(int stock) {
		ArgumentChecks.isTrue( stock > 0, "Trying to create a new Publication: Illegal stock under zero" );
		
		this.instock = stock;
	}

	public void setSales(int sales) {
		ArgumentChecks.isTrue( sales > 0, "Trying to create a new Publication: Illegal sales under zero" );
		
		this.sales = sales;
	}

	private void setName(String name) {
		ArgumentChecks.isNotNull( name, "Trying to create a new Publication: Illegal null name" );
		ArgumentChecks.isNotBlank( name, "Trying to create a new Publication: Illegal blank name" );
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return instock;
	}

	public int getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return getName() + "\t" + getStock() + "\t" + getSales();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public abstract Order generateOrders();
	public abstract String serialize();
}
