package oncall

import camp.nextstep.edu.missionutils.Console
import oncall.Validator.validateDay
import oncall.Validator.validateElementLength
import oncall.Validator.validateIsDigit
import oncall.Validator.validateLength
import oncall.Validator.validateNotDuplicated
import oncall.Validator.validateNumRange
import oncall.Validator.validateSize

class InputView {

    fun readValidMonthAndDay(): Pair<Int, String> {
        try {
            val (month, day) = Console.readLine().split(",")
            validateIsDigit(month)
            validateNumRange(month.toInt())
            validateDay(day)
            validateLength(day)
            return Pair(month.toInt(), day)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
        }
    }

    fun readValidNames(): List<String> {
        val input = Console.readLine().split(",")
        validateElementLength(input)
        validateSize(input)
        validateNotDuplicated(input)
        return input
    }
}