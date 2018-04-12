package rest.business.account

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/account")
class AccountInfo {

    val counter = AtomicLong()

    @GetMapping("/getHello")
    fun account(@RequestParam(value = "name", defaultValue = "World") name: String) : String {
        return "Welcome $name, your account balance is 0.00000000234234 ETH"
    }

}