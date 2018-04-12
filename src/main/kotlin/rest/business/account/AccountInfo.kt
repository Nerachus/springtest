package rest.business.account

import model.payment.Account
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import persistence.AccountStore
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/account")
class AccountInfo {

    val counter = AtomicLong()

    @GetMapping("/account")
    fun account(@RequestParam(value = "accountId", defaultValue = "1") accountId: Long): Account? {
        return AccountStore.getAccount(accountId)
    }

    @GetMapping("/create")
    fun create(@RequestParam(value = "accountId", defaultValue = "1") accountId: Long) {
        return AccountStore.putAccount(Account(accountId, "CHF", BigDecimal(0)))
    }
}