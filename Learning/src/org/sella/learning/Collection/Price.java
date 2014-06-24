package org.sella.learning.Collection;

class Price {

	private String item;
	private int price;

	public Price(final String itm, final int pr) {
		this.item = itm;
		this.price = pr;
	}

	@Override
	public int hashCode() {
		int hashcode = 0;
		hashcode = price * 20;
		hashcode += item.hashCode();
		System.out.println("In hashcode" + hashcode);
		return hashcode;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Price) {
			final Price pp = (Price) obj;
			final boolean valid = (pp.item.equals(this.item) && pp.price == this.price);
			System.out.println("In equals" + valid);
			return valid;
		} else {
			System.out.println("In equals" + false);
			return false;
		}
	}

	public String getItem() {
		return item;
	}

	public void setItem(final String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(final int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item: " + item + "  price: " + price;
	}
}