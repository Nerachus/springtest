package persistence

import model.payment.Account

object AccountStore {

    private val accounts: MutableMap<Long, Account> = HashMap()

    fun getAccount(accountId: Long): Account? {
        return accounts[accountId]
    }

    fun putAccount(account: Account) {
        accounts[account.uuid] = account
    }
}