package com.app.payment.payment.adapter.out.web.excutor

import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import com.app.payment.payment.domain.PaymentExecutionResult
import reactor.core.publisher.Mono

interface PaymentExecutor {
  fun execute(command: PaymentConfirmCommand): Mono<PaymentExecutionResult>
}