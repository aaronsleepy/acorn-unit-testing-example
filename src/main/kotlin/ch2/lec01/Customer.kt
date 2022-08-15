package ch2.lec01

class Customer {
    fun purchase(store: Store, product: Product, quantity: Int): Boolean {
        return if (!store.hasEnoughInventory(product, quantity)) {
            false
        } else {
            store.removeInventory(product, quantity)
            true
        }
    }
}