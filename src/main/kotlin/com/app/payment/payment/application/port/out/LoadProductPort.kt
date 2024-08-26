package com.app.payment.payment.application.port.out

import com.app.payment.payment.domain.Product
import reactor.core.publisher.Flux

interface LoadProductPort {

  fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}