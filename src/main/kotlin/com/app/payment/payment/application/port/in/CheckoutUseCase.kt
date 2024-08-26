package com.app.payment.payment.application.port.`in`

import com.app.payment.payment.domain.CheckoutResult
import com.example.paymentservice2.payment.application.port.`in`.CheckoutCommand


import reactor.core.publisher.Mono

interface CheckoutUseCase {

  fun checkout(command: CheckoutCommand): Mono<CheckoutResult>
}