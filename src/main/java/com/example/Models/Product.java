package com.example.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_title", length = 500)
    private String productTitle;

    @Column(name = "product_rating", precision = 3, scale = 2)
    private BigDecimal productRating;

    @Column(name = "total_reviews")
    private Integer totalReviews;

    @Column(name = "discounted_price", precision = 10, scale = 2)
    private BigDecimal discountedPrice;

    @Column(name = "original_price", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(name = "is_best_seller", length = 50)
    private String isBestSeller;

    @Column(name = "is_sponsored", length = 50)
    private String isSponsored;

    @Column(name = "has_coupon", length = 50)
    private String hasCoupon;

    @Column(name = "sustainability_tags", columnDefinition = "TEXT")
    private String sustainabilityTags;

    @Column(name = "product_image_url", length = 1000)
    private String productImageUrl;

    @Column(name = "product_page_url", length = 2000)
    private String productPageUrl;

    @Column(name = "product_category", length = 200)
    private String productCategory;

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    public Product() {}

    public Product(Long id, String productTitle, BigDecimal productRating, Integer totalReviews,
                    BigDecimal discountedPrice, BigDecimal originalPrice, String isBestSeller,
                    String isSponsored, String hasCoupon, String sustainabilityTags,
                    String productImageUrl, String productPageUrl, String productCategory,
                    BigDecimal discountPercentage) {
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

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductTitle() { return productTitle; }
    public void setProductTitle(String productTitle) { this.productTitle = productTitle; }

    public BigDecimal getProductRating() { return productRating; }
    public void setProductRating(BigDecimal productRating) { this.productRating = productRating; }

    public Integer getTotalReviews() { return totalReviews; }
    public void setTotalReviews(Integer totalReviews) { this.totalReviews = totalReviews; }

    public BigDecimal getDiscountedPrice() { return discountedPrice; }
    public void setDiscountedPrice(BigDecimal discountedPrice) { this.discountedPrice = discountedPrice; }

    public BigDecimal getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(BigDecimal originalPrice) { this.originalPrice = originalPrice; }

    public String getIsBestSeller() { return isBestSeller; }
    public void setIsBestSeller(String isBestSeller) { this.isBestSeller = isBestSeller; }

    public String getIsSponsored() { return isSponsored; }
    public void setIsSponsored(String isSponsored) { this.isSponsored = isSponsored; }

    public String getHasCoupon() { return hasCoupon; }
    public void setHasCoupon(String hasCoupon) { this.hasCoupon = hasCoupon; }

    public String getSustainabilityTags() { return sustainabilityTags; }
    public void setSustainabilityTags(String sustainabilityTags) { this.sustainabilityTags = sustainabilityTags; }

    public String getProductImageUrl() { return productImageUrl; }
    public void setProductImageUrl(String productImageUrl) { this.productImageUrl = productImageUrl; }

    public String getProductPageUrl() { return productPageUrl; }
    public void setProductPageUrl(String productPageUrl) { this.productPageUrl = productPageUrl; }

    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public BigDecimal getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(BigDecimal discountPercentage) { this.discountPercentage = discountPercentage; }
}
