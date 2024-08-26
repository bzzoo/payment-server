package com.app.payment.payment.adapter.out.persistent

import com.app.payment.common.PersistentAdapter
import com.app.payment.payment.adapter.out.persistent.repository.PaymentRepository
import com.app.payment.payment.application.port.out.SavePaymentPort
import com.app.payment.payment.domain.PaymentEvent

import reactor.core.publisher.Mono

@PersistentAdapter
class PaymentPersistentAdapter (
  private val paymentRepository: PaymentRepository,
) : SavePaymentPort {

  override fun save(paymentEvent: PaymentEvent): Mono<Void> {
    return paymentRepository.save(paymentEvent)
  }
}