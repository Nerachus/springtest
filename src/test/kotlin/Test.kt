import model.payment.Account
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenM

class Test {

    @Test
    fun test() {
        val mockAccount = mock(Account::class.java)

        whenM(mockAccount.id).thenReturn("1")

        assertThat(mockAccount.id).isEqualTo("1")
    }
}