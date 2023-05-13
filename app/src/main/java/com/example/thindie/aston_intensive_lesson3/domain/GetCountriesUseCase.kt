package com.example.thindie.aston_intensive_lesson3.domain

class GetCountriesUseCase(private val repository: CountryRepository) : CountryFetcher {
    override suspend operator fun invoke(): List<Country> = repository.getCountries()
}