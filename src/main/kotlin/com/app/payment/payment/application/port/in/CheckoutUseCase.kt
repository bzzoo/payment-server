package com.app.payment.payment.application.port.`in`

import com.app.payment.payment.domain.CheckoutResult


import reactor.core.publisher.Mono

interface CheckoutUseCase {

  fun checkout(command: CheckoutCommand): Mono<CheckoutResult>
}