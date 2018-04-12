package model.payment

import java.math.BigDecimal

data class PaymentResponse(val status: String, val balance: BigDecimal?)