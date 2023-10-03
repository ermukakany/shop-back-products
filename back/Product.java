package io.product;

public class Product {
    private int id;
    private String code;
    private String name;
    private String description;
    private String image;
    private double price;
    private String category;
    private int quantity;
    private String inventoryStatus;
    private int rating;


// Constructeur
  public Product(int id, String code, String name, String description, String image, double price, String category, int quantity, String inventoryStatus, int rating) {
    super();
    this.id = id;
    this.code = code;
    this.name = name;
    this.description = description;
    this.image = image;
    this.price = price;
    this.category = category;
    this.quantity = quantity;
    this.inventoryStatus = inventoryStatus;
    this.rating = rating;

    }

    // Getters

    public int getId(){
        return id;
    }

    public String getCode() {
		return code;
	}

    public String getName() {
		return name;
	}

	public int getDescription() {
		return description;
	}

    public String getImage() {
		return image;
	}

	public String getPrice() {
		return price;
	}

	public int getCategory() {
		return category;
	}


    public String getQuantity() {
		return quantity;
	}

	public String getInventoryStatus() {
		return inventoryStatus;
	}

	public int getRating() {
		return rating;
	}
}
