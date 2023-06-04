package com.example.myapplication//package com.example.myapplication
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.google.gson.Gson
//import okhttp3.*
//import java.io.IOException
//
//
//class spare : AppCompatActivity() {
//
//    data class ApiResponse(val imageUrl: String)
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var productAdapter: ProductAdapter
////    private lateinit var latitudeEditText: EditText
////    private lateinit var longitudeEditText: EditText
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setupDrawer()
//        setContentView(R.layout.activity_main)
//        // recycler view
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val products = listOf(
//            Product(R.drawable.product1, "Product 1", "$19.99"),
//            Product(R.drawable.product2, "Product 2", "$24.99"),
//            Product(R.drawable.product3, "Product 3", "$14.99")
//        )
//
//        productAdapter = ProductAdapter(products)
//        recyclerView.adapter = productAdapter
//    }
//
//    private fun setupDrawer() {
//        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
//        val drawerView = layoutInflater.inflate(R.layout.layout_drawer,  drawerLayout, false)
//
//        drawerLayout.addView(drawerView)
//        drawerLayout.openDrawer(GravityCompat.START)
////        val drawerLayout = findViewById<LinearLayout>(R.id.drawerLayout)
////        val drawerView = LayoutInflater.from(this).inflate(R.layout.layout_drawer, drawerLayout, false)
//
////
//
////        // saving latitude and longitude values on button click
////        latitudeEditText = findViewById(R.id.latitudeEditText)
////        longitudeEditText = findViewById(R.id.longitudeEditText)
//
//        // Set default latitude and longitude values
//        val defaultLatitude = "0.0"
//        val defaultLongitude = "0.0"
//
//        val latitudeEditText = drawerView.findViewById<EditText>(R.id.latitudeEditText)
//        val longitudeEditText = drawerView.findViewById<EditText>(R.id.longitudeEditText)
//
//        latitudeEditText.setText(defaultLatitude)
//        longitudeEditText.setText(defaultLongitude)
//
//        val saveButton: Button = findViewById(R.id.saveButton)
//        saveButton.setOnClickListener {
//            val latitude = latitudeEditText.text.toString()
//            val longitude = longitudeEditText.text.toString()
//            sendLocationData(latitude, longitude)
//            // Navigate to the homepage after saving the location data
//            loadHomePage()
//        }
//
//        setContentView(drawerLayout)
//
//    }
//
//    private fun sendLocationData(latitude: String, longitude: String) {
//        val url = "https://akhil.free.beeceptor.com/fetchImage" // Replace with your API endpoint
//
//        val requestBody = FormBody.Builder()
//            .add("latitude", latitude)
//            .add("longitude", longitude)
//            .build()
//
//        Log.d("API request", requestBody.toString())
//
//        val request = Request.Builder()
//            .url(url)
//            .post(requestBody)
//            .build()
//
//        val client = OkHttpClient()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                runOnUiThread {
//                    Toast.makeText(this@spare, "API request failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                if (response.isSuccessful) {
//                    val responseData = response.body?.string()
//
//                    // Parse the response data using Gson
//                    val gson = Gson()
//                    val apiResponse = gson.fromJson(responseData, ApiResponse::class.java)
//
//                    // Retrieve the image URL from the API response
//                    val imageUrl = apiResponse.imageUrl
//
//                    // Display the retrieved image on the homepage
//                    runOnUiThread {
//                        val productImage: ImageView = findViewById(R.id.adImage)
//                        Glide.with(this@spare)
//                            .load(imageUrl)
//                            .into(productImage)
//                    }
//                } else {
//                    // Request failed, handle the error
//                    Toast.makeText(this@spare, "API request failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })
//    }
//
//    private fun loadHomePage() {
//        setContentView(R.layout.activity_main)
//
//        // Rest of your code...
//    }
//
//
//}
//
