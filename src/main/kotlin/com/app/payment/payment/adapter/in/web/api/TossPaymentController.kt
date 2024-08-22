package com.app.payment.payment.adapter.`in`.web.api

import com.app.payment.common.WebAdapter
import com.app.payment.payment.adapter.`in`.web.reqeust.TossPaymentConfirmRequest
import com.app.payment.payment.adapter.`in`.web.response.ApiResponse
import com.app.payment.payment.adapter.out.web.excutor.TossPaymentExecutor
import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/v1/toss")
class TossPaymentController(
    private val tossPaymentExecutor: TossPaymentExecutor
) {

    @PostMapping("/confirm")
    fun confirm(@RequestBody request: TossPaymentConfirmRequest): Mono<ResponseEntity<ApiResponse<String>>> {
        val command = PaymentConfirmCommand(
            paymentKey = request.paymentKey,
            orderId = request.orderId,
            amount = request.amount.toLong()
        )
        return tossPaymentExecutor.execute(command)
            .map {
                ResponseEntity.ok()
                    .body(ApiResponse.with(HttpStatus.OK, "", it))
            }
    }
}