package oncall

import java.util.*

class OncallController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun start() {
        outputView.inputMonthAndDayMessage()
        val dateInfo = getValidMonthAndDay()

        outputView.inputWeekdayMessage()
        val weekdayNames = getValidNames()

        outputView.inputWeekendMessage()
        val weekendNames = getValidNames()

        val calenderBuilder = CalenderBuilder(dateInfo)
        val calender = calenderBuilder.make()

        val workScheduler = WorkScheduler(calender, LinkedList(weekdayNames), LinkedList(weekendNames))
        val result = workScheduler.get()

        outputView.printWorkSchedule(calender.map { it.first }, result)

    }

    private fun getValidNames(): List<String> {
        return try {
            inputView.readValidNames()
        } catch (error: IllegalArgumentException) {
            println(error.message)
            getValidNames()
        }
    }

    private fun getValidMonthAndDay(): Pair<Int, String> {
        return try {
            inputView.readValidMonthAndDay()
        } catch (error: IllegalArgumentException) {
            println(error.message)
            getValidMonthAndDay()
        }
    }
}