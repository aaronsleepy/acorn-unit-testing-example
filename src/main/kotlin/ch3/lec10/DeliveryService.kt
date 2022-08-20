package ch3.lec10

import java.time.LocalDateTime

class DeliveryService {
    fun isDeliveryValid(delivery: Delivery): Boolean {
        return delivery.date.isAfter(LocalDateTime.now().plusDays(2))
    }
}

data class Delivery(
    val date: LocalDateTime
)