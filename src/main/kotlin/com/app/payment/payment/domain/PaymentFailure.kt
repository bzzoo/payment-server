package com.app.payment.payment.domain

data class PaymentFailure (
  val errorCode: String,
  val message: String
)