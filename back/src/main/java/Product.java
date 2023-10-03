package io.product;
import java.io.IOException;
import java.text.ParseException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @JsonProperty("id")
    public int getId(){
        return id;
    }

    @JsonProperty("code")
    public String getCode() {
		return code;
	}

    @JsonProperty("name")
    public String getName() {
		return name;
	}

    @JsonProperty("description")
	public int getDescription() {
		return description;
	}

    @JsonProperty("image")
    public String getImage() {
		return image;
	}
    @JsonProperty("price")
	public String getPrice() {
		return price;
	}

    @JsonProperty("category")
	public int getCategory() {
		return category;
	}

    @JsonProperty("quantity")
    public String getQuantity() {
		return quantity;
	}

    @JsonProperty("inventoryStatus")
	public String getInventoryStatus() {
		return inventoryStatus;
	}

    @JsonProperty("rating")
	public int getRating() {
		return rating;
	}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", inventoryStatus='" + inventoryStatus + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String toJsonString() {
        return  "{\n" +
                "\"id\": " + this.id + ",\n" + 
                "\"code\": " + JSONObject.quote(this.code) + ",\n" + 
                "\"name\": " + JSONObject.quote(this.name) + ",\n" +
                "\"description\": " + JSONObject.quote(this.description) + ",\n" + 
                "\"image\": " + JSONObject.quote(this.image) + ",\n" + 
                "\"price\": " + this.price + ",\n" + 
                "\"category\": " + JSONObject.quote(this.category) + ",\n" + 
                "\"quantity\": " + this.quantity + ",\n" + 
                "\"inventoryStatus\": " + JSONObject.quote(this.inventoryStatus) + ",\n" + 
                "\"rating\": " + this.rating + "\n" + 
                "}";
    }
}
