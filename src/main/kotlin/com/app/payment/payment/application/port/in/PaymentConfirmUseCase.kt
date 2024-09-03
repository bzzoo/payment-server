package com.app.payment.payment.application.port.`in`

import com.app.payment.payment.domain.PaymentConfirmationResult
import reactor.core.publisher.Mono

interface PaymentConfirmUseCase {

  fun confirm(command: PaymentConfirmCommand): Mono<PaymentConfirmationResult>
}