package com.example.thindie.aston_intensive_lesson3

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.thindie.aston_intensive_lesson3.application.Injector
import com.google.android.material.textfield.TextInputEditText

class ActivityTextInputListener : AppCompatActivity(R.layout.activity_text_input_listener) {
    private val viewModel by lazy { Injector.injectVM(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inputText: TextInputEditText = findViewById(R.id.text_input_edit)
        inputText.addTextChangedListener { changingText ->
            viewModel.onLoadSingleShotImage(changingText.toString())
        }

        viewModel.modelledData.observe(this) { singleShot ->
            val imageView: ImageView = findViewById(R.id.target_image_view)
            imageView.setImageBitmap(singleShot.first().bitmap)
        }
    }
}


