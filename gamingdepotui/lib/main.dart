import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class Product {
  final String title;
  final double rating;
  final int totalReviews;
  final double discountedPrice;
  final double originalPrice;
  final String imageUrl;
  final String category;
  final double discountPercentage;

  Product({
    required this.title,
    required this.rating,
    required this.totalReviews,
    required this.discountedPrice,
    required this.originalPrice,
    required this.imageUrl,
    required this.category,
    required this.discountPercentage,
  });
}

//sample data
List<Product> products = [
  Product(
    title: "BOYA BOYALINK 2 Wireless Lavalier Microphone for iPhone Camera Android, Mini Lapel Micophone Wireless, 48 KHz 24 Bit, 6mm Mic, 1000ft, 30h Use, Noise Cancelling, Clip on Mic USB-C/Lightning/3.5mm TRS",
    rating: 4.6,
    totalReviews: 375,
    discountedPrice: 89.68,
    originalPrice: 159.0,
    imageUrl: "https://m.media-amazon.com/images/I/71pAqiVEs3L._AC_UL320_.jpg",
    category: "Phones",
    discountPercentage: 43.6,
  ),
  Product(
    title: "LISEN USB C to Lightning Cable, 240W 4 in 1 Charging Cable 6.6FT, Chubby USB A/C to C/Lightning with Light for iPhone 16e 15 14 Pro/MacBook Air 17/iPad/Samsung/Switch 2, Multi Chargers for All Devices",
    rating: 4.3,
    totalReviews: 2457,
    discountedPrice: 9.99,
    originalPrice: 15.99,
    imageUrl: "https://m.media-amazon.com/images/I/61nbF6aVIPL._AC_UL320_.jpg",
    category: "Laptops",
    discountPercentage: 37.52,
  ),
  Product(
    title: "DJI Mic 2 (2 TX + 1 RX + Charging Case), Wireless Lavalier Microphone, Intelligent Noise Cancelling, 32-bit Float Internal Recording, 820 ft.(250m) Range, Microphone for iPhone, Android, Camera",
    rating: 4.6,
    totalReviews: 3044,
    discountedPrice: 314.0,
    originalPrice: 349.0,
    imageUrl: "https://m.media-amazon.com/images/I/61h78MEXojL._AC_UL320_.jpg",
    category: "Laptops",
    discountPercentage: 10.03,
  ),
];

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'E-Commerce Demo',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const ProductListScreen(),
    );
  }
}








class ProductListScreen extends StatelessWidget {
  const ProductListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Products'),
      ),
      body: ListView.builder(
        padding: const EdgeInsets.all(10),
        itemCount: products.length,
        itemBuilder: (context, index) {
          final product = products[index];
          return Card(
            margin: const EdgeInsets.symmetric(vertical: 8),
            child: Padding(
              padding: const EdgeInsets.all(10),
              child: Row(
                children: [
                  Image.network(
                    product.imageUrl,
                    width: 100,
                    height: 100,
                    fit: BoxFit.cover,
                  ),
                  const SizedBox(width: 10),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(product.title,
                            maxLines: 3, overflow: TextOverflow.ellipsis, style: const TextStyle(fontWeight: FontWeight.bold)),
                        const SizedBox(height: 5),
                        Text("Category: ${product.category}"),
                        const SizedBox(height: 5),
                        Row(
                          children: [
                            Icon(Icons.star, color: Colors.amber, size: 16),
                            const SizedBox(width: 4),
                            Text("${product.rating} (${product.totalReviews} reviews)"),
                          ],
                        ),
                        const SizedBox(height: 5),
                        Text(
                          "\$${product.discountedPrice}  ",
                          style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.green),
                        ),
                        Text(
                          "\$${product.originalPrice}",
                          style: const TextStyle(
                              fontSize: 14, decoration: TextDecoration.lineThrough, color: Colors.grey),
                        ),
                        Text(
                          "${product.discountPercentage}% off",
                          style: const TextStyle(fontSize: 14, color: Colors.red),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
