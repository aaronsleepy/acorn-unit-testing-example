package ch5.lec03


/**
 * 예제 5.9 외부 애플리케이션과 도메인 모델 연결하기
 */
class CustomerController(
    private val _emailGateway: IEmailGateway
) {
    private val _customerRepository: CustomerRepository = CustomerRepository()
    private val _productRepository: ProductRepository = ProductRepository()
    private val _mainStore: IStore = Store()

    fun purchase(customerId: Int, productId: Int, quantity: Int): Boolean {
        val customer = _customerRepository.getById(customerId)
        val product = _productRepository.getById(productId)

        val isSuccess = customer.purchase(_mainStore, product, quantity)

        if (isSuccess) {
            _emailGateway.sendReceipt(customer.email, product.name, quantity)
        }

        return isSuccess

    }
}
