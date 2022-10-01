package ch6.lec01

class Order(
    private val _products: MutableList<Product> = mutableListOf()
) {
    val products: List<Product>
        get() = this._products

    fun addProduct(product: Product) {
        _products.add(product)

    }
}