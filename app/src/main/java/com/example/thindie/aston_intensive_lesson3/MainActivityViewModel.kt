package com.example.thindie.aston_intensive_lesson3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.graphics.scale
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thindie.aston_intensive_lesson3.application.Injector
import com.example.thindie.aston_intensive_lesson3.domain.CountryFetcher
import java.net.URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private val countryFetcher: CountryFetcher by lazy { Injector.inject(this) }
    private val scope: CoroutineScope by lazy { CoroutineScope(Dispatchers.IO) }

    private val _countries: MutableLiveData<List<ImageHolderUIModel>> = MutableLiveData()
    val modelledData: LiveData<List<ImageHolderUIModel>>
        get() = _countries


    fun onShowCountries() {
        scope.launch {
            _countries.postValue(
                countryFetcher()
                    .map { country ->
                        ImageHolderUIModel(
                            bitmap = getImage(country.countryFlagLink),
                            countryName = country.countryName
                        )
                    })
        }
    }

    fun onLoadSingleShotImage(hyper: String) {
        scope.launch {
            _countries.postValue(
                listOf(
                    ImageHolderUIModel(
                        bitmap = getImage(hyper, x = IMAGE_SIZE_SECOND_EXERCISE, y = IMAGE_SIZE_SECOND_EXERCISE),
                        countryName = ""
                    )
                )
            )
        }
    }

    private suspend fun getImage(
        string: String,
        x: Int = SCALED_WIDTH,
        y: Int = SCALED_HEIGHT
    ): Bitmap? {
        return withContext(scope.coroutineContext) {
            try {
                BitmapFactory
                    .decodeStream(
                        withContext(Dispatchers.IO) {
                            URL(string)
                                .openConnection()
                                .getInputStream()
                        }
                    ).scale(x, y, filter = true)
            } catch (e: Exception) {
                Log.e("ERROR_TAG", e.message.toString())
                null
            }

        }
    }

    fun lifeCycleCancelScope() {
        scope.cancel()
    }


    data class ImageHolderUIModel(
        val bitmap: Bitmap?,
        val countryName: String
    )

    companion object {
        private const val SCALED_WIDTH = 50
        private const val SCALED_HEIGHT = 50
        private const val IMAGE_SIZE_SECOND_EXERCISE = 200
    }
}