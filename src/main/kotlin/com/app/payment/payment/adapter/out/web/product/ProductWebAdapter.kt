package com.app.payment.payment.adapter.out.web.product

import com.app.payment.common.WebAdapter
import com.app.payment.payment.adapter.out.web.product.client.ProductClient
import com.app.payment.payment.application.port.out.LoadProductPort
import com.app.payment.payment.domain.Product
import reactor.core.publisher.Flux

@WebAdapter
class ProductWebAdapter (
  private val productClient: ProductClient
) : LoadProductPort {

  override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
    return productClient.getProducts(cartId, productIds)
  }
}