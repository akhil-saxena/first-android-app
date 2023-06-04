package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val latitudeEditText: EditText = findViewById(R.id.latitudeEditText);
        val longitudeEditText: EditText = findViewById(R.id.longitudeEditText);
        val submitButton: Button = findViewById(R.id.submitButton);

        // Set default latitude and longitude values
        val defaultLatitude = "123.67"
        val defaultLongitude = "167.45"
        latitudeEditText.setText(defaultLatitude)
        longitudeEditText.setText(defaultLongitude)

        submitButton.setOnClickListener {
            val latitude = latitudeEditText.text.toString()
            val longitude = longitudeEditText.text.toString()

            sendRequest(latitude, longitude)
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            intent.putExtra("latitude", latitude)
            intent.putExtra("longitude", longitude)
            // Navigate to the homepage after saving the location data
            startActivity(intent)
        }
    }

    private fun sendRequest(latitude: String, longitude: String) {
//        val url = "https://example.com/api/image?lat=$latitude&lng=$longitude" // how to insert location data in API
        val url = "https://akhil.free.beeceptor.com/fetchImage" // Replace with your API endpoint

        val requestBody = FormBody.Builder()
            .add("latitude", latitude)
            .add("longitude", longitude)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        Log.d("API request", requestBody.toString())
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "API request failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }


            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()

                    val gson = Gson()
                    // Parse the API response using Gson
                    val imageResponse = gson.fromJson(responseBody, APIResponse::class.java)

                    // Retrieve the image URL from the API response
                    val imageUrl = imageResponse?.imageUrl
                    Log.d("Image URL in Response", imageUrl.toString())

                    // Pass the image URL to the ImageActivity
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    intent.putExtra("imageUrl", imageUrl)
                    startActivity(intent)
                } else { // Request failed, handle the error
                    Toast.makeText(this@MainActivity, "API request failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
        )
    }
}