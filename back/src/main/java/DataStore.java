package io.product;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class DataStore {

	//Map of names to product instances.
	private Map<String, Product> productDBMap = new HashMap<>();
	
	//this class is a singleton and should not be instantiated directly!
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	private DataStore(){
	    ObjectMapper objectMapper = new ObjectMapper();
        ProductData productData = objectMapper.readValue(new File("front/assets/products.json"), ProductData.class);

        // Access the parsed data
        List<Product> products = productData.getData();
        for (Product product : products) {
            System.out.println(product);
            productDBMap.put(product.getCode(), product);
        }
	}


	public ProductContainer getAllProduct() {
		return productDBMap;
	}

	public Product getProduct(int id) {
		return productDBMap.getObjectById(id);
	}

	public void deleteProduct(int id) {
		productDBMap.removeObjectById(id);
		productDBMap.save("front/assets/products.json");
	}

	public boolean containsProduct(int id) {
		return productDBMap.containsObject(id);
	}

	public void putProduct(Product product) {
		productDBMap.addObject(product);
		productDBMap.save("front/assets/products.json");
	}

    public Product getLastProduct() {
        return productDBMap.getLastProduct();
    }

	public product getProduct(String code) {
		return productDBMap.get(code);
	}

	public void putProduct(product product) {
		productDBMap.put(product.getCode(), product);
	}
}