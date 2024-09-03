package com.app.payment.payment.adapter.`in`.web.api

import com.app.payment.common.WebAdapter
import com.app.payment.payment.adapter.`in`.web.reqeust.TossPaymentConfirmRequest
import com.app.payment.payment.adapter.`in`.web.response.ApiResponse
import com.app.payment.payment.adapter.out.web.excutor.TossPaymentExecutor
import com.app.payment.payment.application.port.`in`.PaymentConfirmCommand
import com.app.payment.payment.application.port.`in`.PaymentConfirmUseCase
import com.app.payment.payment.domain.PaymentConfirmationResult
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController

class TossPaymentController(
    private val tossPaymentExecutor: TossPaymentExecutor,
    private val paymentConfirmUseCase: PaymentConfirmUseCase,
) {

    @RequestMapping("v0/toss/confirm", method = [RequestMethod.POST])
    fun confirmLegacy(@RequestBody request: TossPaymentConfirmRequest): Mono<ResponseEntity<ApiResponse<String>>> {
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

    @RequestMapping("v1/toss/confirm", method = [RequestMethod.POST])
    fun confirm(@RequestBody request: TossPaymentConfirmRequest): Mono<ResponseEntity<ApiResponse<PaymentConfirmationResult>>> {
        val command = PaymentConfirmCommand(
            paymentKey = request.paymentKey,
            orderId = request.orderId,
            amount = request.amount.toLong()
        )

        return paymentConfirmUseCase.confirm(command)
            .map { ResponseEntity.ok()
                .body(ApiResponse.with(HttpStatus.OK, "", it))
            }
    }
}