package oncall.model

import oncall.model.Month.Companion.toMonth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MonthTest {
    @Test
    fun `toMonth 메서드가 정수를 적절한 Month로 반환하는지 테스트`() {
        assertEquals(Month.JANUARY, 1.toMonth())
        assertEquals(Month.FEBRUARY, 2.toMonth())
        assertEquals(Month.MARCH, 3.toMonth())
        assertEquals(Month.APRIL, 4.toMonth())
        assertEquals(Month.MAY, 5.toMonth())
        assertEquals(Month.JUNE, 6.toMonth())
        assertEquals(Month.JULY, 7.toMonth())
        assertEquals(Month.AUGUST, 8.toMonth())
        assertEquals(Month.SEPTEMBER, 9.toMonth())
        assertEquals(Month.OCTOBER, 10.toMonth())
        assertEquals(Month.NOVEMBER, 11.toMonth())
        assertEquals(Month.DECEMBER, 12.toMonth())
    }

    @Test
    fun `잘못된 월에 대한 예외 테스트`() {
        assertThrows<IllegalArgumentException> { 0.toMonth() }
        assertThrows<IllegalArgumentException> { 13.toMonth() }
    }

    @Test
    fun `getEndDate 메서드 테스트`() {
        assertEquals(31, Month.getEndDate(Month.JANUARY))
        assertEquals(28, Month.getEndDate(Month.FEBRUARY))
        assertEquals(31, Month.getEndDate(Month.MARCH))
        assertEquals(30, Month.getEndDate(Month.APRIL))
        assertEquals(31, Month.getEndDate(Month.MAY))
        assertEquals(30, Month.getEndDate(Month.JUNE))
        assertEquals(31, Month.getEndDate(Month.JULY))
        assertEquals(31, Month.getEndDate(Month.AUGUST))
        assertEquals(30, Month.getEndDate(Month.SEPTEMBER))
        assertEquals(31, Month.getEndDate(Month.OCTOBER))
        assertEquals(30, Month.getEndDate(Month.NOVEMBER))
        assertEquals(31, Month.getEndDate(Month.DECEMBER))
    }
}
