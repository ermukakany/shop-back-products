package io.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductParser {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductData productData = objectMapper.readValue(new File("resources/product.json"), ProductData.class);

            // Access the parsed data
            List<Product> products = productData.getData();
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}