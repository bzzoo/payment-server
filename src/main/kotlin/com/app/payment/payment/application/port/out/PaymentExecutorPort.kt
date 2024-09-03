package com.app.payment.payment.application.port.out

import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import com.app.payment.payment.domain.PaymentExecutionResult
import reactor.core.publisher.Mono

interface PaymentExecutorPort {

  fun execute(command: PaymentConfirmCommand): Mono<PaymentExecutionResult>
}