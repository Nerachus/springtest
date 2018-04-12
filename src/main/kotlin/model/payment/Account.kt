package model.payment

import java.math.BigDecimal

data class Account(val accountID : Long, val currency: String, var balance: BigDecimal)