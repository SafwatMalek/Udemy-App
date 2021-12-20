package com.example.udemyapp.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udemyapp.data.review.Review
import com.example.udemyapp.databinding.ItemUserReivewBinding

class ReviewsAdapter constructor(val reviews: List<Review>) :
    RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder>() {


    override fun getItemCount() = reviews.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = ItemUserReivewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(review = reviews[position])
    }

    inner class ReviewViewHolder(val view: ItemUserReivewBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(review: Review) {
            if (review.content.isNotEmpty()) {
                review.user.display_name.let {
                    view.tvUserName.text = it
                }
                view.tvUserContent.text = review.content
                review.rating.let {
                    view.rbUser.rating = it
                }
            }

        }
    }

}