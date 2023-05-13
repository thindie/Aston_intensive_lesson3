package com.example.thindie.aston_intensive_lesson3.domain

interface CountryRepository {
    suspend fun getCountries(): List<Country>
 }