package com.example.metrics;

import com.example.products.controller.ProductController;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class MyCustomMetrics {
//    @Lazy
    @Autowired
    ProductController productController;

    // supplies product count
    public Supplier<Number> fetchProductCount() {
        return productController.fetchProductCount();
    }
    public MyCustomMetrics(MeterRegistry registry) {
        Gauge.builder("no.of.products",fetchProductCount()).
                tag("version","v1").
                description("returns # of products").
                register(registry);
    }
}
