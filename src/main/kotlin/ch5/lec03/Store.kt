package ch5.lec03

class Store(
    private var _inventory: MutableMap<Product, Int> = mutableMapOf()
) : IStore {
    var id: Int = 0

    override fun hasEnoughInventory(product: Product, quantity: Int): Boolean {
        return getInventory(product) >= quantity
    }

    override fun removeInventory(product: Product, quantity: Int) {
        if (!hasEnoughInventory(product, quantity)) {
            throw Exception("Not enough inventory")
        }

        _inventory[product]!!.minus(quantity).also { _inventory[product] = it }
    }

    override fun addInventory(product: Product, quantity: Int) {
        _inventory.getOrDefault(product, 0).plus(quantity)
            .also { _inventory[product] = it }
    }

    override fun getInventory(product: Product): Int {
        return _inventory.getOrDefault(product, 0)
    }
}
