package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder>() {

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.categoryButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]
        holder.button.text = category.categoryName
        holder.button.setOnClickListener {
            // Handle item click event
            Toast.makeText(
                holder.itemView.context,
                "Clicked on ${category.categoryName}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
