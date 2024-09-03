package com.app.payment.payment.adapter.out.persistent.exception

import com.app.payment.payment.domain.PaymentStatus


class PaymentAlreadyProcessedException(
  val status: PaymentStatus,
  message: String
) : RuntimeException(message) {
}