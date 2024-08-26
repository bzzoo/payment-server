package com.app.payment.payment.application.port.out

import com.app.payment.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

interface SavePaymentPort {

  fun save(paymentEvent: PaymentEvent): Mono<Void>
}