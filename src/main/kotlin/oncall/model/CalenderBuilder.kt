package oncall.model

import oncall.model.Month.Companion.getEndDate
import oncall.model.Month.Companion.toMonth
import java.util.*

class CalenderBuilder(
    private val dateInfo: Pair<Int, String>
) {
    private val calender = mutableListOf<Pair<String, Boolean>>() // 날짜 정보와 휴일 여부
    private val dayQueue: Queue<String> = LinkedList(
        listOf(
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
            SUNDAY
        )
    )

    init {
        initDayQueue(dateInfo.second)
    }

    private fun initDayQueue(targetDay: String) {
        while (true) {
            if (dayQueue.peek() == targetDay) break
            rotateQueue()
        }
    }

    private fun rotateQueue() {
        dayQueue.add(dayQueue.poll())
    }

    fun make(): MutableList<Pair<String, Boolean>> {
        val month = dateInfo.first.toMonth()
        for (date in 1..getEndDate(month)) {
            setHoliday(date, month)
        }
        return calender
    }

    private fun setHoliday(date: Int, month: Month) {
        var todayDay = dayQueue.peek()
        when (isHoliday(month, date, todayDay)) {
            true -> {
                if (!isWeekend(todayDay)) todayDay += WEEKDAY_HOLIDAY_MARK
                calender.add(Pair(CALENDER_INFO_TEMPLATE.format(month.value, date, todayDay), true))
            }

            false -> calender.add(Pair(CALENDER_INFO_TEMPLATE.format(month.value, date, todayDay), false))
        }
        rotateQueue()
    }

    private fun isWeekend(todayDay: String): Boolean {
        return listOf(SATURDAY, SUNDAY).contains(todayDay)
    }

    private fun isHoliday(month: Month, date: Int, todayDay: String): Boolean {
        return (month.holiday.contains(date) || listOf(SATURDAY, SUNDAY).contains(todayDay))
    }

    companion object {
        const val WEEKDAY_HOLIDAY_MARK = "(휴일)"
        const val CALENDER_INFO_TEMPLATE = "%s월 %s일 %s"

        const val MONDAY = "월"
        const val TUESDAY = "화"
        const val WEDNESDAY = "수"
        const val THURSDAY = "목"
        const val FRIDAY = "금"
        const val SATURDAY = "토"
        const val SUNDAY = "일"
    }
}