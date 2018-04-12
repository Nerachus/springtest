import model.payment.Account
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenM

class Test {

    @Test
    fun test() {
        val mockAccount = mock(Account::class.java)

        whenM(mockAccount.uuid).thenReturn(1L)

        assertThat(mockAccount.uuid).isEqualTo(1L)
    }
}