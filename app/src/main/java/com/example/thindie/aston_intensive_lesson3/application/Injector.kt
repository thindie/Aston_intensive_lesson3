package com.example.thindie.aston_intensive_lesson3.application

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.thindie.aston_intensive_lesson3.MainActivityViewModel
import com.example.thindie.aston_intensive_lesson3.data.CountryRepositoryImpl
import com.example.thindie.aston_intensive_lesson3.data.FakeDataSource
import com.example.thindie.aston_intensive_lesson3.domain.CountryFetcher
import com.example.thindie.aston_intensive_lesson3.domain.CountryRepository
import com.example.thindie.aston_intensive_lesson3.domain.GetCountriesUseCase

object Injector {
    private fun repository(): CountryRepository {
        return CountryRepositoryImpl(FakeDataSource.invoke())
    }

    fun inject(mainActivityViewModel: MainActivityViewModel): CountryFetcher {
        return GetCountriesUseCase(repository())
    }

    fun injectVM(activity: AppCompatActivity): MainActivityViewModel {
        return ViewModelProvider(activity)[MainActivityViewModel::class.java]
    }

}