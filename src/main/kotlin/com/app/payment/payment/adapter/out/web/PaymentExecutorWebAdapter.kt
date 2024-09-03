package com.app.payment.payment.adapter.out.web

import com.app.payment.common.WebAdapter
import com.app.payment.payment.adapter.out.web.excutor.PaymentExecutor
import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import com.app.payment.payment.application.port.out.PaymentExecutorPort
import com.app.payment.payment.domain.PaymentExecutionResult
import reactor.core.publisher.Mono

@WebAdapter
class PaymentExecutorWebAdapter (
  private val paymentExecutor: PaymentExecutor
) : PaymentExecutorPort {

  override fun execute(command: PaymentConfirmCommand): Mono<PaymentExecutionResult> {
    return paymentExecutor.execute(command)
  }
}