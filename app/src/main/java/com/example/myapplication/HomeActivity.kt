package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity()  {
    private lateinit var imageView: ImageView
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        imageView = findViewById(R.id.adImage)
        horizontalRecyclerView = findViewById(R.id.recyclerView)

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
            Product(R.drawable.product1, "Product 1", "$19.99"),
            Product(R.drawable.product2, "Product 2", "$24.99"),
            Product(R.drawable.product3, "Product 3", "$14.99")
        )

        productAdapter = ProductAdapter(products)
        horizontalRecyclerView.adapter = productAdapter

    }
}