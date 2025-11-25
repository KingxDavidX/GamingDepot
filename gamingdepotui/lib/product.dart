class Product {
  final int productId;
  final String productTitle;
  final double? productRating;
  final int? totalReviews;
  final double? discountedPrice;
  final double? originalPrice;
  final String? isBestSeller;
  final String? isSponsored;
  final String? hasCoupon;
  final String? sustainabilityTags;
  final String? productImageUrl;
  final String? productPageUrl;
  final String? productCategory;
  final double? discountPercentage;

  Product({
    required this.productId,
    required this.productTitle,
    this.productRating,
    this.totalReviews,
    this.discountedPrice,
    this.originalPrice,
    this.isBestSeller,
    this.isSponsored,
    this.hasCoupon,
    this.sustainabilityTags,
    this.productImageUrl,
    this.productPageUrl,
    this.productCategory,
    this.discountPercentage,
  });

  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      productId: json['product_id'],
      productTitle: json['product_title'],
      productRating: json['product_rating'] != null
          ? (json['product_rating'] as num).toDouble()
          : null,
      totalReviews: json['total_reviews'],
      discountedPrice: json['discounted_price'] != null
          ? (json['discounted_price'] as num).toDouble()
          : null,
      originalPrice: json['original_price'] != null
          ? (json['original_price'] as num).toDouble()
          : null,
      isBestSeller: json['is_best_seller'],
      isSponsored: json['is_sponsored'],
      hasCoupon: json['has_coupon'],
      sustainabilityTags: json['sustainability_tags'],
      productImageUrl: json['product_image_url'],
      productPageUrl: json['product_page_url'],
      productCategory: json['product_category'],
      discountPercentage: json['discount_percentage'] != null
          ? (json['discount_percentage'] as num).toDouble()
          : null,
    );
  }
}
