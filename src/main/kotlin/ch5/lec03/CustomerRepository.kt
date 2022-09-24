package ch5.lec03

internal class CustomerRepository {
    fun getById(customerId: Int): Customer {
        return Customer()
    }
}

class Customer(
) {
    var email: String = ""

    fun purchase(store: IStore, product: Product, quantity: Int): Boolean {
        return if (store.hasEnoughInventory(product, quantity)) {
            store.removeInventory(product, quantity)
            true
        } else {
            false
        }
    }
}
