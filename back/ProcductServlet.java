package io.product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ProductServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/product/".length());
		
		Product product = DataStore.getInstance().getProduct(name);
		
		if(product != null){
			String json = "{\n";
            json += "\"id\": " + JSONObject.quote(product.getId()) + ",\n";
            json += "\"code\": " + JSONObject.quote(product.getCode()) + ",\n";
			json += "\"name\": " + JSONObject.quote(product.getName()) + ",\n";
			json += "\"description\": " + JSONObject.quote(product.getDescription()) + ",\n";
			json += "\"image\": " + product.getImage() + "\n";
            json += "\"price\": " + JSONObject.quote(product.getPrice()) + ",\n";
            json += "\"category\": " + JSONObject.quote(product.getCategory()) + ",\n";
            json += "\"quantity\": " + JSONObject.quote(product.getQuantity()) + ",\n";
            json += "\"inventoryStatus\": " + JSONObject.quote(product.getInventoryStatus()) + ",\n";
            json += "\"rating\": " + JSONObject.quote(product.getRating()) + ",\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//Produit non trouvé
			response.getOutputStream().println("{}");
		}
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
        String image = request.getParameter("image");
		double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String inventoryStatus = request.getParameter("inventoryStatus");
        int rating = Integer.parseInt(request.getParameter("rating"));
		
		DataStore.getInstance().putProduct(new Product(id, code, name, description, image, price, category, quantity, inventoryStatus, rating));
	}
}