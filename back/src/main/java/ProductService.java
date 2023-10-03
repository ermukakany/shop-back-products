package io.product;

import java.util.List;
import java.util.PoductParser;


@Service
public class ProductService {

    private final Map<String, Product> produits = new HashMap<String, Product>();
    // Constructeur
    public ProductService() {
        super();
        initProducts();
    }
    // Initialisation des produits fictifs
    private void initProducts() {
        // Création de produit fictifs
        Product produit= new Product("...");
        
        // Ajouts dans la map
        produits.put(produit.getId(), produit);  
    }

    @Autowired
    private List<Product> data;

   /*  public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    } */

    // Chercher la liste des produits
    public List<Product> findAll() {
        return data.findAll();
    }

    //Chercher un produit
    public Product findById(int id){
        return data.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //M à J le produit
    public Product update(Product produit){
        return produit;
    }

    //Effacer le produit
    public void deleteById(int id){
        data.deleteById(id);

    }

   //Ajouter un produit
    public Product add(Product produit){
        return data.add(produit);
    }
}
