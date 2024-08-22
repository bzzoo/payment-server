package com.app.payment.payment.adapter.out.web.excutor

import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class TossPaymentExecutor (
  private val tossPaymentWebClient: WebClient,
  private val uri: String = "/v1/payments/confirm"
) : PaymentExecutor {

  override fun execute(command: PaymentConfirmCommand): Mono<String> {
    return Mono.just("string")
  }
}