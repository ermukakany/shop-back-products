import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;

public class ProductContainer {
    private TreeMap<Integer, Product> objectMap;

    public ProductContainer() {
        objectMap = new TreeMap<>();
    }

    public void addObject (Product obj) {
        objectMap.put(obj.getId(), obj);
    }

    public Product getObjectById(int id) {
        return objectMap.get(id);
    }

    public void removeObjectById(int id) {
        objectMap.remove(id);
    }

    public boolean containsObject(int id) {
        return objectMap.containsKey(id);
    }

    public int size() {
        return objectMap.size();
    }

    public int getLastId() {
        return objectMap.lastKey();
    }

    public Product getLastProduct() {
        // Get the last ID
        Integer lastId = objectMap.lastKey();
        // Get the corresponding object for the last ID
        return objectMap.get(lastId);
    }

    public String toJsonString() {
        String productJsonString = "{\"data\":[\n";
        Iterator<Map.Entry<Integer, Product>> iterator = objectMap.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            Integer key = entry.getKey();
            Product product = entry.getValue();

            // Check if the current entry is the last one in the TreeMap
            boolean isLast = key.equals(objectMap.lastKey());
            if (isLast) {
                productJsonString += product.toJsonString() + "\n";
            }
            else {
                productJsonString += product.toJsonString() + ",\n";
            }
        }
        productJsonString += "\n]\n}";

        return  productJsonString;
    }

    public boolean save(String filePath) {
       // try {
       //      // Create an instance of ObjectMapper
       //      ObjectMapper objectMapper = new ObjectMapper();
       //      // Serialize the object to JSON and save it to a file
       //      objectMapper.writeValue(new File(filepath), this.objectMap);
       //      return true;
       //  } catch (Exception e) {
       //      e.printStackTrace();
       //  }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write the JSON string to the file
            String jsonString = this.toJsonString();
            fileWriter.write(jsonString);
            System.out.println("JSON string written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
