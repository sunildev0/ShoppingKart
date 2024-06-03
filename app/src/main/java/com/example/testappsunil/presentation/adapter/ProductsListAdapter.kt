package com.example.testappsunil.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testappsunil.utils.OnProductItemClickListener
import com.example.testappsunil.R
import com.example.testappsunil.databinding.ProductsListItemBinding
import com.example.testappsunil.db.ProductsData

class ProductsListAdapter(private val clickListener: OnProductItemClickListener) :
    RecyclerView.Adapter<ProductsListAdapter.ProductsListViewHolder>() {

    private var mData = emptyList<ProductsData>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(friendData: List<ProductsData>) {
        mData = friendData
        notifyDataSetChanged()
    }

    inner class ProductsListViewHolder(
        private val binding: ProductsListItemBinding,
        private val listener: OnProductItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductsData) {

            binding.data = item

            binding.tvPrice.text = String.format("Price: %s", item.price.toString())
            binding.tvRating.text = String.format("Rating: %s", item.avg.toString())
            binding.tvPages.text = String.format("Pages: %s", item.pages.toString())

            itemView.setOnClickListener {
                listener.onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        return ProductsListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.products_list_item,
                parent,
                false
            ), clickListener
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}