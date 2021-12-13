package com.example.udemyapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.ItemCourseListBinding

class CourseAdapter constructor(private val courses: List<Results>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun getItemCount() = courses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieViewHolder = ItemCourseListBinding.inflate(layoutInflater, parent, false)
        return CourseViewHolder(movieViewHolder)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }


    inner class CourseViewHolder(val view: ItemCourseListBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(item: Results) {
            view.tvCourseTitle.text = item.title
            view.tvInstructorName.text = item.getInstructorsNames()

            view.ivCourse.clipToOutline = true
            Glide.with(view.root.context)
                .load(item.image_240x135)
                .into(view.ivCourse)
        }
    }

}