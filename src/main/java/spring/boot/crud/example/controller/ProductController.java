package spring.boot.crud.example.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import spring.boot.crud.example.Formatter.LogFormatter;
import spring.boot.crud.example.entity.Product;
import spring.boot.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Formatter;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@RestController
public class ProductController {

    private final static Logger logger = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService service;

    @PostConstruct
    private void init(){
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();

        LogFormatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        logger.addHandler(handler);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        logger.info("In ProductController.addProduct. Calling service.saveProduct");
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        logger.info("In ProductController.addProduct. Calling service.saveProduct with a list");
        return service.saveProduct(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        logger.info("In ProductController.findAllProduct. Calling service.getProduct");
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        logger.info("In ProductController.findProductById. Calling service.getProductById");
        return service.getProductById(id);
    }

    @GetMapping(value="/productByName/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        logger.info("In ProductController.findProductByName. Calling service.getProductByName");
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        logger.info("In ProductController.updateProduct. Calling service.updateProduct");
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        logger.info("In ProductController.deleteProduct. Calling service.deleteProduct");
        return service.deleteProduct(id);
    }
}
