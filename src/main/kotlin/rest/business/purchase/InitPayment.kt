package rest.business.purchase

import model.demo.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class InitPayment {

    @GetMapping("/greeting")
    fun greeting(
            @RequestParam(value = "merchantID") merchantID: Long,
            @RequestParam(value = "customerID") customerID: Long,
            @RequestParam(value = "currency") currency: String,
            @RequestParam(value = "amount") amount: String): Greeting {

        return Greeting(2, "Customer $customerID is paying $amount $currency to the merchant $merchantID")
    }
}