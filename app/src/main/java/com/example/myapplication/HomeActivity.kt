package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity()  {
    private lateinit var imageView: ImageView
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        imageView = findViewById(R.id.adImage)
        horizontalRecyclerView = findViewById(R.id.recyclerView)
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)

        // Retrieve latitude and longitude from intent extras if required
//        val latitude = intent.getStringExtra("latitude")
//        val longitude = intent.getStringExtra("longitude")

        // Load image into the ImageView
        var imageView: ImageView = findViewById(R.id.adImage)

        val imageUrl = intent.getStringExtra("imageUrl")

        Log.d("Image URL", imageUrl.toString())
        Glide.with(this)  // You can use a library like Glide or Picasso to handle image loading
            .load(imageUrl)
//            .placeholder(R.drawable.default_image) // Set a placeholder image
//            .error(R.drawable.error_image) // Set an error image
            .into(imageView)

//        In this example, you should replace imageUrl with the actual image URL you want to load, R.drawable.default_image with the resource ID of the default image you want to display as a placeholder, and R.drawable.error_image with the resource ID of the error image to be displayed in case the desired image fails to load.
//        Make sure you have the appropriate default image and error image resources available in your project's res/drawable directory.
//        By utilizing the placeholder and error functionality of Glide, you can handle situations where the desired image is not available or encounters loading errors, ensuring a fallback image is displayed in those scenarios.


        // Set up RecyclerView with a horizontal layout
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.layoutManager = layoutManager

        // Set up your RecyclerView adapter and populate it with data
        val products = listOf(
            Product(R.drawable.product1, "Umbro Soccer Ball", "$29.99"),
            Product(R.drawable.product2, "Inflatable Shade Pool", "$104.99"),
            Product(R.drawable.product3, "Legend of Zelda", "$64.99"),
            Product(R.drawable.product4, "Macbook Air M1", "$949.99"),
            Product(R.drawable.product5, "JBL GO 2 Speaker", "$22.84"),
            Product(R.drawable.product6, "Frozen Beverage Station", "$52.89"),
            Product(R.drawable.product7, "Pixel 6A", "$399.99"),
            Product(R.drawable.product8, "Victrola Player", "$204.99"),
            Product(R.drawable.product9, "Chromecast 4K", "$24.49"),
            Product(R.drawable.product10, "Dualsense Controller", "$59.99"),
        )

        productAdapter = ProductAdapter(products)
        horizontalRecyclerView.adapter = productAdapter

        val categoryLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = categoryLayoutManager

        val categories = listOf(
            Category("Sports"),
            Category("Electronics"),
            Category("Gaming"),
            Category("Grocery"),
            Category("Utilities"),
            Category("Appliances"),
            Category("Cosmetics"),
            Category("Kids"),
            Category("Health")
        )

        categoryAdapter = CategoryAdapter(categories)
        categoryRecyclerView.adapter = categoryAdapter


    }
}