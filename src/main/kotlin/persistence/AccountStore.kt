package persistence

import model.payment.Account

object AccountStore {

    val accounts: MutableMap<String, Account> = HashMap()

    fun getAccount(accountId: String): Account? {
        return accounts[accountId]
    }

    fun putAccount(account: Account) {
        accounts.put(account.id, account)
    }
}