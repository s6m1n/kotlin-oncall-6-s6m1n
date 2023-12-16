package oncall.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class WorkSchedulerTest {
    @Test
    fun `근무 일정이 적절하게 짜여졌는지 확인`() {
        val calendar = mutableListOf(
            Pair("1월 1일 월", true),
            Pair("1월 2일 화", false),
            Pair("1월 3일 수", false),
            Pair("1월 4일 목", false),
            Pair("1월 5일 금", false),
            Pair("1월 6일 토", true),
            Pair("1월 7일 일", true)
        )
        val weekdayWorkersQueue = LinkedList(listOf("A", "B", "C", "D", "E"))
        val weekendWorkersQueue = LinkedList(listOf("B", "C", "D", "A", "E"))
        val workScheduler = WorkScheduler(calendar, weekdayWorkersQueue, weekendWorkersQueue)

        val result = workScheduler.get()

        assertEquals(7, result.size)
        assertEquals(listOf("B", "A", "B", "C", "D", "C", "D"), result)
    }
}
