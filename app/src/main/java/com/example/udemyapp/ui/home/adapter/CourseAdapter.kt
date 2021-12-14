package com.example.udemyapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemyapp.R
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.ItemCourseListBinding
import com.example.udemyapp.databinding.ItemSeeAllBinding
import kotlin.reflect.KFunction1

class CourseAdapter(
    private val courses: List<Results>,
    private val callback: KFunction1<Results, Unit>,
    private val showSeeAll: Boolean = true
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = (if (showSeeAll) {
        courses.size + 1
    } else {
        courses.size
    })

    override fun getItemViewType(position: Int): Int {
        return if (position >= courses.size) SEE_ALL_ITEM
        else COURSE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            COURSE_ITEM -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val movieViewHolder = ItemCourseListBinding.inflate(layoutInflater, parent, false)
                CourseViewHolder(movieViewHolder)
            }
            else -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val seeAllBinding = ItemSeeAllBinding.inflate(layoutInflater, parent, false)
                SeeAllViewHolder(seeAllBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CourseViewHolder -> {
                holder.view.courseContainer.animation = AnimationUtils.loadAnimation(
                    holder.view.root.context,
                    R.anim.rv_animation
                )
                holder.bind(courses[position])
            }
            is SeeAllViewHolder -> {}
        }
    }


    inner class CourseViewHolder(val view: ItemCourseListBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(item: Results) {
            view.tvCourseTitle.text = item.title
            view.tvInstructorName.text = item.getInstructorsNames()
            view.tvCoursePrice.text = item.price
            view.tvRatingValue.text = item.avg_rating
            view.rbCourse.rating = item.avg_rating?.toFloat() ?: 0f
            view.tvWatchingNum.text = "(${item.num_subscribers ?: 0})"
            view.ivCourse.clipToOutline = true
            Glide.with(view.root.context)
                .load(item.image_240x135)
                .into(view.ivCourse)

            view.courseContainer.setOnClickListener {
                callback.invoke(item)
            }
        }
    }

    inner class SeeAllViewHolder(view: ItemSeeAllBinding) : RecyclerView.ViewHolder(view.root)

    companion object {
        const val COURSE_ITEM = 1
        const val SEE_ALL_ITEM = 2
    }

}