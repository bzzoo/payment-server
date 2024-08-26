package com.app.payment.payment.test

import com.app.payment.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

interface PaymentDatabaseHelper {

  fun getPayments(orderId: String): PaymentEvent?

  fun clean(): Mono<Void>
}