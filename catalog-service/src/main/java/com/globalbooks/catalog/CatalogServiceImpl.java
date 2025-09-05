package com.globalbooks.catalog;
import jakarta.jws.WebService;
@WebService(endpointInterface = "com.globalbooks.catalog.CatalogService")
public class CatalogServiceImpl implements CatalogService {
    @Override
    public Product getProductDetails(String productId) {
        Product p = new Product();
        p.productId = productId;
        p.productName = "The SOA Journey";
        p.price = 25.50;
        return p;
    }
}