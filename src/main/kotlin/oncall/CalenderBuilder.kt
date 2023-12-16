package oncall

import oncall.Month.Companion.getEndDate
import oncall.Month.Companion.toMonth
import java.util.*

class CalenderBuilder(
    private val dateInfo: Pair<Int, String>
) {
    private val calender = mutableMapOf<String, Boolean>() // 날짜 정보와 휴일 여부
    private val dayQueue: Queue<String> = LinkedList(listOf("월", "화", "수", "목", "금", "토", "일"))

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

    fun make(): MutableMap<String, Boolean> {
        val month = dateInfo.first.toMonth()
        for (date in 1..getEndDate(month)) {
            setWeekDay(date, month)
        }
        return calender
    }

    private fun setWeekDay(date: Int, month: Month) {
        var todayDay = dayQueue.peek()
        when (isHolyday(month, date, todayDay)) {
            true -> {
                if (!isWeekend(todayDay)) {
                    todayDay = todayDay + "(휴일)"
                }
                calender.put("${month.value}월 ${date}일 ${todayDay}", true)
            }

            false -> calender.put("${month.value}월 ${date}일 ${todayDay}", false)
        }
        rotateQueue()
    }

    private fun isWeekend(todayDay: String): Boolean {
        return listOf("토", "일").contains(todayDay)
    }

    private fun isHolyday(month: Month, date: Int, todayDay: String): Boolean {
        return (month.holiday.contains(date) || listOf("토", "일").contains(todayDay))
    }
}