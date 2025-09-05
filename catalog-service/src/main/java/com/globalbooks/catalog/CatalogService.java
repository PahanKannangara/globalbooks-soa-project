package com.globalbooks.catalog;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
@WebService
public interface CatalogService {
    @WebMethod
    Product getProductDetails(String productId);
}