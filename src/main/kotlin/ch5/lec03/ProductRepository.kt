package ch5.lec03

internal class ProductRepository {
    fun getById(productId: Int): Product {
        return Product()
    }
}

class Product(
) {
    var id: Int = 0
    var name: String = ""

    companion object {
        val Shampoo: Product = Product()
    }
}

