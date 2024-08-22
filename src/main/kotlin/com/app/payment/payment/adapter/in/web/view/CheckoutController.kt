package com.app.payment.payment.adapter.`in`.web.view

import com.app.payment.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@WebAdapter
@Controller
class CheckoutController (
){

  @GetMapping("/")
  fun checkoutPage(): Mono<String> {
    return Mono.just("checkout")
  }
}