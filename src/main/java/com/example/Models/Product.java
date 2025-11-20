package com.example.Models;


import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productTitle;
    private Double productRating;
    private Integer totalReviews;
    private Double discountedPrice;
    private Double originalPrice;
    private String isBestSeller;
    private String isSponsored;
    private String hasCoupon;
    private String sustainabilityTags;
    private String productImageUrl;
    
    @Column(length = 2048) 
    private String productPageUrl;

    private String productCategory;
    private Double discountPercentage;


    
    public Product(Long id, String productTitle, Double productRating, Integer totalReviews, Double discountedPrice,
            Double originalPrice, String isBestSeller, String isSponsored, String hasCoupon, String sustainabilityTags,
            String productImageUrl, String productPageUrl, String productCategory, Double discountPercentage) {
        this.id = id;
        this.productTitle = productTitle;
        this.productRating = productRating;
        this.totalReviews = totalReviews;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.isBestSeller = isBestSeller;
        this.isSponsored = isSponsored;
        this.hasCoupon = hasCoupon;
        this.sustainabilityTags = sustainabilityTags;
        this.productImageUrl = productImageUrl;
        this.productPageUrl = productPageUrl;
        this.productCategory = productCategory;
        this.discountPercentage = discountPercentage;
    }

    public Product() {}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductTitle() {
        return productTitle;
    }
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
    public Double getProductRating() {
        return productRating;
    }
    public void setProductRating(Double productRating) {
        this.productRating = productRating;
    }
    public Integer getTotalReviews() {
        return totalReviews;
    }
    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }
    public Double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public Double getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }
    public String getIsBestSeller() {
        return isBestSeller;
    }
    public void setIsBestSeller(String isBestSeller) {
        this.isBestSeller = isBestSeller;
    }
    public String getIsSponsored() {
        return isSponsored;
    }
    public void setIsSponsored(String isSponsored) {
        this.isSponsored = isSponsored;
    }
    public String getHasCoupon() {
        return hasCoupon;
    }
    public void setHasCoupon(String hasCoupon) {
        this.hasCoupon = hasCoupon;
    }
    public String getSustainabilityTags() {
        return sustainabilityTags;
    }
    public void setSustainabilityTags(String sustainabilityTags) {
        this.sustainabilityTags = sustainabilityTags;
    }
    public String getProductImageUrl() {
        return productImageUrl;
    }
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }
    public String getProductPageUrl() {
        return productPageUrl;
    }
    public void setProductPageUrl(String productPageUrl) {
        this.productPageUrl = productPageUrl;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public Double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    
}
