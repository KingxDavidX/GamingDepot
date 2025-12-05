package com.example.catalog.model;

import java.math.BigDecimal;

public class Product {

    private long product_id;
    private String product_title;
    private BigDecimal product_rating;
    private Integer total_reviews;
    private BigDecimal discounted_price;
    private BigDecimal original_price;
    private String is_best_seller;
    private String is_sponsored;
    private String has_coupon;
    private String sustainability_tags;
    private String product_image_url;
    private String product_page_url;
    private String product_category;
    private BigDecimal discount_percentage;
    private int category_id;

    public Product() {}

    public Product(Long product_id, String product_title, BigDecimal product_rating, Integer total_reviews,
                   BigDecimal discounted_price, BigDecimal original_price, String is_best_seller,
                   String is_sponsored, String has_coupon, String sustainability_tags,
                   String product_image_url, String product_page_url, String productCategory,
                   BigDecimal discount_percentage, int category_id) {
        this.product_id = product_id;
        this.product_title = product_title;
        this.product_rating = product_rating;
        this.total_reviews = total_reviews;
        this.discounted_price = discounted_price;
        this.original_price = original_price;
        this.is_best_seller = is_best_seller;
        this.is_sponsored = is_sponsored;
        this.has_coupon = has_coupon;
        this.sustainability_tags = sustainability_tags;
        this.product_image_url = product_image_url;
        this.product_page_url = product_page_url;
        this.product_category = productCategory;
        this.discount_percentage = discount_percentage;
        this.category_id = category_id;
    }


    //region getters/setters

    public Long getProduct_id() { return product_id; }
    public void setProduct_id(Long product_id) { this.product_id = product_id; }

    public String getProduct_title() { return product_title; }
    public void setProduct_title(String product_title) { this.product_title = product_title; }

    public BigDecimal getProduct_rating() { return product_rating; }
    public void setProduct_rating(BigDecimal product_rating) { this.product_rating = product_rating; }

    public Integer getTotal_reviews() { return total_reviews; }
    public void setTotal_reviews(Integer total_reviews) { this.total_reviews = total_reviews; }

    public BigDecimal getDiscounted_price() { return discounted_price; }
    public void setDiscounted_price(BigDecimal discounted_price) { this.discounted_price = discounted_price; }

    public BigDecimal getOriginal_price() { return original_price; }
    public void setOriginal_price(BigDecimal original_price) { this.original_price = original_price; }

    public String getIs_best_seller() { return is_best_seller; }
    public void setIs_best_seller(String is_best_seller) { this.is_best_seller = is_best_seller; }

    public String getIs_sponsored() { return is_sponsored; }
    public void setIs_sponsored(String is_sponsored) { this.is_sponsored = is_sponsored; }

    public String getHas_coupon() { return has_coupon; }
    public void setHas_coupon(String has_coupon) { this.has_coupon = has_coupon; }

    public String getSustainability_tags() { return sustainability_tags; }
    public void setSustainability_tags(String sustainability_tags) { this.sustainability_tags = sustainability_tags; }

    public String getProduct_image_url() { return product_image_url; }
    public void setProduct_image_url(String product_image_url) { this.product_image_url = product_image_url; }

    public String getProduct_page_url() { return product_page_url; }
    public void setProduct_page_url(String product_page_url) { this.product_page_url = product_page_url; }

    public String getProduct_category() { return product_category; }
    public void setProduct_category(String product_category) { this.product_category = product_category; }

    public BigDecimal getDiscount_percentage() { return discount_percentage; }
    public void setDiscount_percentage(BigDecimal discount_percentage) { this.discount_percentage = discount_percentage; }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    //endregion


}
