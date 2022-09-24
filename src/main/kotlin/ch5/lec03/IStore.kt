package ch5.lec03

interface IStore {
    fun hasEnoughInventory(product: Product, quantity: Int): Boolean

    fun removeInventory(product: Product, quantity: Int): Unit

    fun addInventory(product: Product, quantity: Int): Unit

    fun getInventory(product: Product): Int
}