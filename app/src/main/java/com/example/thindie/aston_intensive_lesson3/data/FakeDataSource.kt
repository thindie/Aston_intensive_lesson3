package com.example.thindie.aston_intensive_lesson3.data

class FakeDataSource private constructor() {
    private val countryList = listOf(
        "Австрия" to "https://www.megaflag.ru/sites/default/files/images/shop/products/flag_avstriya_enl.jpg",
        "Польша" to "https://www.megaflag.ru/sites/default/files/images/directory_names/flag_polsha_enl.jpg",
        "Италия" to "https://www.megaflag.ru/sites/default/files/images/directory_names/flag_italija_enl.jpg",
        "Колумбия" to "https://www.megaflag.ru/sites/default/files/images/shop/products/flag_kolumbiya_new.jpg",
        "Мадагаскар" to "https://www.megaflag.ru/sites/default/files/images/shop/products/flag_madagaskar_new.jpg",
        "Таиланд" to "https://www.megaflag.ru/sites/default/files/images/shop/products/flag_tailand_new.jpg",
        "Дания" to "https://www.megaflag.ru/sites/default/files/images/directory_names/flag_danija_enl.jpg",
        "Швейцария" to "https://www.megaflag.ru/sites/default/files/images/shop/products/flag_shvejtsarija_new.jpg",
    )
    val someData = countryList

    companion object {
        operator fun invoke(): FakeDataSource {
            return FakeDataSource()
        }
    }
}
