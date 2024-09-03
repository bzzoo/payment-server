package com.app.payment.payment.adapter.out.persistent.executor

import com.app.payment.payment.adapter.out.web.exception.PSPConfirmationException
import com.app.payment.payment.adapter.out.web.exception.TossPaymentError
import com.app.payment.payment.adapter.out.web.excutor.TossPaymentExecutor
import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import com.app.payment.payment.test.PSPTestWebClientConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import java.util.*

@SpringBootTest
@Import(PSPTestWebClientConfiguration::class)
@Tag("TooLongTime")
class TossPaymentExecutorTest (
  @Autowired private val pspTestWebClientConfiguration: PSPTestWebClientConfiguration
){

  @Test
  fun `should handle correctly various TossPaymentError scenarios`() {
    generateErrorScenarios().forEach { errorScenario ->
      val command = PaymentConfirmCommand(
        paymentKey = UUID.randomUUID().toString(),
        orderId = UUID.randomUUID().toString(),
        amount = 10000L
      )

      val paymentExecutor = TossPaymentExecutor(
        tossPaymentWebClient = pspTestWebClientConfiguration.createTestTossWebClient(
          Pair("TossPayments-Test-Code", errorScenario.errorCode)
        ),
        uri = "/v1/payments/key-in"
      )

      try {
        paymentExecutor.execute(command).block()
      } catch (e: PSPConfirmationException) {
        assertThat(e.isSuccess).isEqualTo(errorScenario.isSuccess)
        assertThat(e.isFailure).isEqualTo(errorScenario.isFailure)
        assertThat(e.isUnknown).isEqualTo(errorScenario.isUnknown)
      }
    }
  }

  private fun generateErrorScenarios(): List<ErrorScenario> {
    return TossPaymentError.entries.map { error ->
      ErrorScenario(
        errorCode = error.name,
        isSuccess = error.isSuccess(),
        isFailure = error.isFailure(),
        isUnknown = error.isUnknown()
      )
    }
  }
}

data class ErrorScenario(
  val errorCode: String,
  val isFailure: Boolean,
  val isUnknown: Boolean,
  val isSuccess: Boolean
)
