package com.app.payment.payment.adapter.out.persistent.repository

import com.app.payment.payment.domain.PaymentEvent

import reactor.core.publisher.Mono

interface PaymentRepository {

  fun save(paymentEvent: PaymentEvent): Mono<Void>

  fun getPayment(orderId: String): Mono<PaymentEvent>

  fun complete(paymentEvent: PaymentEvent): Mono<Void>
}