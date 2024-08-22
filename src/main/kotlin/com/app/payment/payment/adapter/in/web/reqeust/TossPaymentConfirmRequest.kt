package com.app.payment.payment.adapter.`in`.web.reqeust

data class TossPaymentConfirmRequest (
  val paymentKey: String,
  val orderId: String,
  val amount: String
)