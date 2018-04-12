package persistence

import model.payment.Account
import java.math.BigDecimal

object AccountStore {

    private val accounts: MutableMap<Long, Account> = HashMap()

    init {
        accounts[0] = Account(1, "CHF", BigDecimal(100))
        accounts[1] = Account(2, "CHF", BigDecimal(200))
        accounts[2] = Account(3, "CHF", BigDecimal(300))
    }

    fun getAccount(accountId: Long): Account? {
        return accounts[accountId]
    }

    fun putAccount(account: Account) {
        accounts[account.accountID] = account
    }
}