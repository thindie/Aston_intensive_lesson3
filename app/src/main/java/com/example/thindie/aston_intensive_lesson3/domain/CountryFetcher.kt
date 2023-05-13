package com.example.thindie.aston_intensive_lesson3.domain

interface CountryFetcher {
    suspend operator fun invoke(): List<Country>
}
