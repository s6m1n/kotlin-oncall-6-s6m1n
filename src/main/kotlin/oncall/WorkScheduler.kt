package oncall

import java.util.*

class WorkScheduler(
    private val calendar: Map<String, Boolean>,
    private val weekdayWorkersQueue: Queue<String> = LinkedList(),
    private val weekendWorkersQueue: Queue<String> = LinkedList()
) {
    private val result = mutableMapOf<String, String>()

    fun make(): MutableMap<String, String> {
        for (dateInfo in calendar) {
            when (dateInfo.value) {
                false -> setWeekdaySchedule(dateInfo.key)
                true -> setWeekendSchedule(dateInfo.key)
            }
        }
        return result
    }

    private fun setWeekdaySchedule(dateInfo: String) {
        result[dateInfo] = weekdayWorkersQueue.peek()
        rotateQueue(weekdayWorkersQueue)
    }

    private fun setWeekendSchedule(dateInfo: String) {
        result[dateInfo] = weekendWorkersQueue.peek()
        rotateQueue(weekendWorkersQueue)
    }

    private fun rotateQueue(queue: Queue<String>) {
        queue.add(queue.poll())
    }
}