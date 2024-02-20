package com.example.stylemirror_1_1.Activity;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    public static class Product {
        private String id;
        private String name;
        private String description;
        private String url;
        private String price;

        public Product(String id, String name, String description, String url, String price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.url = url;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}