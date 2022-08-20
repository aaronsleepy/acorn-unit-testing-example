package ch2.lec01

import java.lang.IllegalArgumentException

class Store(
    private var _inventory: MutableMap<Product, Int> = mutableMapOf()
) {
    fun getInventory(product: Product) = _inventory.getOrDefault(product, 0)

    fun hasEnoughInventory(product: Product, quantity: Int) = getInventory(product) >= quantity

    fun removeInventory(product: Product, quantity: Int) {
        if (hasEnoughInventory(product, quantity)) {
            _inventory[product] = _inventory[product]!!.minus(quantity)
        } else {
            throw IllegalArgumentException("Not enough inventory")
        }
    }

    fun addInventory(product: Product, quantity: Int) {
        _inventory[product] = _inventory.getOrDefault(product, 0)
            .plus(quantity)
    }

}

enum class Product {
    Shampoo,
    Book,
}