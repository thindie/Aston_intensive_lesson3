package com.example.thindie.aston_intensive_lesson3.application

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.thindie.aston_intensive_lesson3.R

object UIBuilder {
    fun build(activity: AppCompatActivity): LinearLayout {
        return LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
        }
    }

    @Suppress("LongParameterList")
    @SuppressLint("ResourceType")
    fun buildListElement(
        activity: AppCompatActivity,
        name: String,
        @LayoutRes parent: Int,
        @IdRes imageView: Int,
        @IdRes textView: Int?,
        bitmap: Bitmap?,
    ): View {
        return LayoutInflater.from(activity).inflate( parent, null)
            .apply {
                val image: ImageView = findViewById(imageView)
                if (bitmap != null) {
                    image.setImageBitmap(
                        bitmap
                    )
                } else Toast.makeText(
                    activity,
                    context.getString(R.string.lost_connection),
                    Toast.LENGTH_SHORT
                ).show()

                if (textView != null) {
                    val countyName: TextView = findViewById(textView)
                    countyName.text = name
                }
            }
    }
}