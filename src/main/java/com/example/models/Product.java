package com.example.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private Long productId;
    private List<Cart> carts = new ArrayList<>();
    private Category category;
    private String productTitle;
    private BigDecimal productRating;
    private Integer totalReviews;
    private BigDecimal discountedPrice;
    private BigDecimal originalPrice;
    private String isBestSeller;
    private String isSponsored;
    private String hasCoupon;
    private String sustainabilityTags;
    private String productImageUrl;
    private String productPageUrl;
    private String productCategory;
    private BigDecimal discountPercentage;

    public Product() {}

    public Product(Long productId, String productTitle, BigDecimal productRating, Integer totalReviews,
                   BigDecimal discountedPrice, BigDecimal originalPrice, String isBestSeller,
                   String isSponsored, String hasCoupon, String sustainabilityTags,
                   String productImageUrl, String productPageUrl, String productCategory,
                   BigDecimal discountPercentage) {
        this.productId = productId;
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


    //region getters/setters

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

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
//endregion


}
