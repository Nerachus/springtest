package rest.business.purchase

import model.demo.Greeting
import model.payment.PaymentResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import persistence.AccountStore
import java.math.BigDecimal

@RestController
@RequestMapping("/payments")
class InitPayment {

    @GetMapping("/transfer")
    fun transfer(
            @RequestParam(value = "srcAccount") srcAccount: Long,
            @RequestParam(value = "dstAccount") dstAccount: Long,
            @RequestParam(value = "currency", defaultValue = "CHF") currency: String?,
            @RequestParam(value = "amount") amount: BigDecimal): PaymentResponse {

        AccountStore.getAccount(srcAccount)?.let {it.balance-=amount}
        AccountStore.getAccount(dstAccount)?.let {it.balance+=amount}
        return PaymentResponse("success", AccountStore.getAccount(dstAccount)?.balance)
    }

    @GetMapping("/multitransfer")
    fun multitransfer(
            @RequestParam(value = "srcAccount") srcAccount: Long,
            @RequestParam(value = "currency", defaultValue = "CHF") currency: String?,
            @RequestParam(value = "amount") amount: BigDecimal,
            @RequestParam(value = "dstAccounts") dstAccounts: List<Long>,
            @RequestParam(value = "dstPercentage") dstPercentage: List<BigDecimal>
            ): PaymentResponse {

        AccountStore.getAccount(srcAccount)?.let {it.balance-=amount}
        for (i in 0..(dstAccounts.count()-1)) {
            AccountStore.getAccount(dstAccounts[i])?.let { it.balance += (amount * dstPercentage[i]) }
        }

        return PaymentResponse("success", AccountStore.getAccount(dstAccounts[0])?.balance)
    }
}