package oncall.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalenderBuilderTest {
    @Test
    fun `2월에 맞는 캘린더를 생성하는지 검사`() {
        val dateInfo = Pair(2, CalenderBuilder.MONDAY)
        val calenderBuilder = CalenderBuilder(dateInfo)

        val calender = calenderBuilder.make()

        assertEquals(28, calender.size)  // 2월은 28일까지 있다.
        assertEquals("2월 1일 월", calender[0].first)
        assertEquals("2월 28일 일", calender[27].first)
    }

    @Test
    fun `4월에 맞는 캘린더를 생성하는지 검사`() {
        val dateInfo = Pair(4, CalenderBuilder.MONDAY)
        val calenderBuilder = CalenderBuilder(dateInfo)

        val calender = calenderBuilder.make()

        assertEquals(30, calender.size)  // 4월은 30일까지 있다.
        assertEquals("4월 1일 월", calender[0].first)
        assertEquals("4월 30일 화", calender[29].first)
    }

    @Test
    fun `휴일을 잘 표시하는지 테스트`() {
        val dateInfo = Pair(5, CalenderBuilder.MONDAY)  // 5월 1일은 노동절로 휴일입니다.
        val calenderBuilder = CalenderBuilder(dateInfo)

        val calender = calenderBuilder.make()

        assertEquals("5월 5일 금(휴일)", calender[4].first)
        assertEquals(true, calender[4].second)
    }
}
