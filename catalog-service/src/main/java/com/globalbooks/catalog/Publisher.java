package com.globalbooks.catalog;
import jakarta.xml.ws.Endpoint;
public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/catalog", new CatalogServiceImpl());
        System.out.println("CatalogService is published at http://localhost:8081/catalog");
    }
}