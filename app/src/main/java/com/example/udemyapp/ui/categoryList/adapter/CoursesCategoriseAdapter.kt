package com.example.udemyapp.ui.categoryList.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemyapp.R
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.ItemCourseByCategoryListBinding

class CoursesCategoriseAdapter(val onClick: (Results) -> Unit) :
    PagingDataAdapter<Results, CoursesCategoriseAdapter.CourseCategoriesViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Results>() {
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseCategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val courseViewHolder = ItemCourseByCategoryListBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return CourseCategoriesViewHolder(courseViewHolder)
    }

    override fun onBindViewHolder(holder: CourseCategoriesViewHolder, position: Int) {
        holder.view.courseContainer.animation = AnimationUtils.loadAnimation(
            holder.view.root.context,
            R.anim.rv_animation
        )
        getItem(position)?.let { holder.bind(item = it) }
    }

    inner class CourseCategoriesViewHolder(val view: ItemCourseByCategoryListBinding) :
        RecyclerView.ViewHolder(view.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Results) {
            view.tvCourseTitle.text = item.title
            view.tvInstructorName.text = item.getInstructorsNames()
            view.tvCoursePrice.text = item.getPriceWithCurrency()
            view.tvRatingValue.text = item.avg_rating
            view.rbCourse.rating = item.avg_rating?.toFloat() ?: 0f
            view.tvWatchingNum.text = "(${item.num_subscribers ?: 0})"
            view.ivCourse.clipToOutline = true
            Glide.with(view.root.context)
                .load(item.image_125_H)
                .into(view.ivCourse)

            view.courseContainer.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}