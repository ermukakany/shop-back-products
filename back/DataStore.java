package io.product;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Example DataStore class that provides access to user data.
 * Pretend this class accesses a database.
 */
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

	public product getProduct(String code) {
		return productDBMap.get(code);
	}

	public void putProduct(product product) {
		productDBMap.put(product.getCode(), product);
	}
}