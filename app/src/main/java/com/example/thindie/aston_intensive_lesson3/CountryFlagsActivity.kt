package com.example.thindie.aston_intensive_lesson3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.thindie.aston_intensive_lesson3.application.Injector
import com.example.thindie.aston_intensive_lesson3.application.UIBuilder

class CountryFlagsActivity : AppCompatActivity() {
    private val viewModel by lazy { Injector.injectVM(this) }
    private val linearLayout: LinearLayout by lazy { UIBuilder.build(this) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewModel
            .onShowCountries()
        viewModel
            .modelledData.observe(this) { countries ->
                countries
                    .forEach { country ->
                        linearLayout
                            .addView(
                                UIBuilder
                                    .buildListElement(
                                        activity = this@CountryFlagsActivity,
                                        name = country.countryName,
                                        bitmap = country.bitmap,
                                        parent = R.layout.list_unit_country,
                                        imageView = R.id.image_view_country_flag,
                                        textView = R.id.textview_country_name
                                    )
                            )
                    }

            }
        val button: Button = Button(this).apply {
            text = context.getString(R.string.next_exercise)
            setOnClickListener {
                startActivity(
                    Intent(
                        this@CountryFlagsActivity,
                        ActivityTextInputListener::class.java
                    )
                )
            }
        }
        linearLayout.addView(button)
        setContentView(linearLayout)
    }

    /**
     * in challenge 'do not add dependencies'
     */
    override fun onDestroy() {
        super.onDestroy()
        viewModel.lifeCycleCancelScope()
    }
}