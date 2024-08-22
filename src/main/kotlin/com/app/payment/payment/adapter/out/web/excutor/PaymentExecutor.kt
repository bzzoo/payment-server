package com.app.payment.payment.adapter.out.web.excutor

import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import reactor.core.publisher.Mono

interface PaymentExecutor {
  fun execute(command: PaymentConfirmCommand): Mono<String>
}