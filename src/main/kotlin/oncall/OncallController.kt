package oncall

class OncallController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun start() {
        outputView.inputMonthAndDayMessage()
        val dateInfo = getValidMonthAndDay()
        outputView.inputWeekDayMessage()
        val names = getValidNames()
        println(names.toString())
    }

    private fun getValidNames(): Any {
        return try {
            inputView.readValidNames()
        }catch  (error: IllegalArgumentException) {
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