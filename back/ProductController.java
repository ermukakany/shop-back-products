package io.product;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id){
        return productService.findById(id);
    }

    @PostMapping
    public ToDo create(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product){
        return productService.add(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteById(id);
    }

}