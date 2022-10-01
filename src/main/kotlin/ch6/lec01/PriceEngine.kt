package ch6.lec01

import kotlin.math.min

class PriceEngine {
    fun calculateDiscount(vararg products: Product): Double {
        val discount = products.size * 0.01
        return min(discount, 0.2)
    }
}

data class Product(
    private val _name: String
)