package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    // list of our products
    private List<Product> productList = new ArrayList<Product>();

    // supplies product count
    public Supplier<Number> fetchProductCount() {
        if (productList.isEmpty()) {
            return ()->0;
        }
        return ()->productList.size();
    }

//    public MyCustomMetrics(MeterRegistry registry) {
//        Gauge.builder("no.of.products",fetchProductCount()).
//                tag("version","v1").
//                description("returns # of products").
//                register(registry);
//    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Product createProduct(@RequestBody @Valid Product product) {
        System.out.println("Create method!!!");
        return productService.createProduct(product);
    }
    @Timed(value="product.get.time",description="time to retrieve products",percentiles={0.5,0.9})
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Product> getAllProducts() {
        productList = productService.getProducts();
        return productList;
    }

    @RequestMapping(value="/list/{productId}", method=RequestMethod.GET)
    public Product getProduct(@PathVariable(value="productId")Long Id) {
        return productService.getProductById(Id);
    }

    @RequestMapping(value="/update/{productId}", method = RequestMethod.PUT)
    public Product updateProduct(@Valid @PathVariable(value="productId") Long Id, @RequestBody @Valid Product product) {
        return productService.updateProduct(Id, product);
    }

    @RequestMapping(value="/delete/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@Valid @PathVariable(value="productId") Long Id) {
         productService.deleteProduct(Id);
    }
}
