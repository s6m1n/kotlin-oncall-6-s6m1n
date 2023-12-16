package oncall.view

class OutputView {
    fun inputMonthAndDayMessage() {
        print(INPUT_MONTH_AND_DAY_MESSAGE)
    }

    fun inputWeekdayMessage() {
        print(INPUT_WEEKDAY_WORKER_MESSAGE)
    }

    fun inputWeekendMessage() {
        print(INPUT_WEEKEND_WORKER_MESSAGE)
    }

    fun printWorkSchedule(calender: List<String>, result: List<String>) {
        for ((index, name) in result.withIndex()) {
            println(RESULT_STRING.format(calender[index], name))
        }
    }

    companion object {
        const val RESULT_STRING = "%s %s"
        const val INPUT_MONTH_AND_DAY_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val INPUT_WEEKDAY_WORKER_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val INPUT_WEEKEND_WORKER_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
    }
}