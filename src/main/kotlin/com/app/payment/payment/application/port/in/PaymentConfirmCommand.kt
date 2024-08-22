package com.app.payment.payment.application.port.`in`

data class PaymentConfirmCommand (
  val paymentKey: String,
  val orderId: String,
  val amount: Long
)