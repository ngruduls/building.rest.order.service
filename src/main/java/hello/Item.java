package hello;

public class Item {

	private final String identifier;
    private final int price;
    private final Boolean used;
	
    public Item(String identifier, int price) {
    	this(identifier, price, false);
    }
    
    public Item(String identifier, int price, Boolean used) {
    	this.identifier = identifier;
    	this.price = price;
    	this.used = used;
    }

	public String getIdentifier() {
		return identifier;
	}

	public int getPrice() {
		return price;
	}

	public Boolean isUsed() {
		return used;
	}
	
	public String warehouseByItemPrice(int price) {
		if (this.price < 100) {
			return "A";
		} else if (this.price >= 100 && this.price < 200) {
			return "B";
		} else {
			return "N/A";
		}
	}
}