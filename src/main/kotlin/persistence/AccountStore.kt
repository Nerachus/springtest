package persistence

import model.payment.Account

object AccountStore {

    val accounts: MutableMap<Long, Account> = HashMap()

    fun getAccount(accountId: Long): Account? {
        return accounts[accountId]
    }

    fun putAccount(account: Account) {
        accounts.put(account.uuid, account)
    }
}