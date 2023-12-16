package oncall

import java.util.*

class WorkScheduler(
    private val calendar: MutableList<Pair<String, Boolean>>,
    private val weekdayWorkersQueue: Queue<String> = LinkedList(),
    private val weekendWorkersQueue: Queue<String> = LinkedList()
) {
    private val result = mutableListOf("") // 이름
    private val weekdayWaitingList: Queue<String> = LinkedList()
    private val weekendWaitingList: Queue<String> = LinkedList()

    fun get(): MutableList<String> {
        for ((index, dateInfo) in calendar.withIndex()) {
            when (dateInfo.second) {
                //평일
                false -> setSchedule(result[index], weekdayWorkersQueue, weekdayWaitingList)
                //휴일
                true -> setSchedule(result[index], weekendWorkersQueue, weekendWaitingList)
            }
        }
        return result.subList(1,result.size)
    }

    private fun setSchedule(yesterdayWorker: String, targetQueue: Queue<String>, targetWatingList: Queue<String>) {
        val todayWorker = targetQueue.peek()
        if (yesterdayWorker == todayWorker) {
            targetWatingList.add(todayWorker)
            rotateQueue(targetQueue)
            result.add(targetQueue.peek())
            rotateQueue(targetQueue)
        } else if (targetWatingList.size != 0) {
            result.add(targetWatingList.poll())
        } else {
            result.add(targetQueue.peek())
            rotateQueue(targetQueue)
        }
    }
    
    private fun rotateQueue(queue: Queue<String>) {
        queue.add(queue.poll())
    }
}