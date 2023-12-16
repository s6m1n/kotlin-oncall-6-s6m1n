package oncall

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

        println("월, 시작 요일: ${dateInfo}")
        println("평일 근무자: $weekdayNames")
        println("휴일 근무자: $weekendNames")

        val calenderBuilder = CalenderBuilder(dateInfo)
        val calender = calenderBuilder.make()
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