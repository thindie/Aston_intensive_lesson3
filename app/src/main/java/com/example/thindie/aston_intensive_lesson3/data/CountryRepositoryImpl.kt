package com.example.thindie.aston_intensive_lesson3.data

import com.example.thindie.aston_intensive_lesson3.domain.Country
import com.example.thindie.aston_intensive_lesson3.domain.CountryRepository

class CountryRepositoryImpl(private val source: FakeDataSource) : CountryRepository {


    override suspend fun getCountries(): List<Country> {
        return source.someData.map { rawData ->
            Country(rawData.first, rawData.second)
        }
    }

}