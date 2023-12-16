package oncall

import camp.nextstep.edu.missionutils.Console
import oncall.Validator.INVALID_INPUT
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
            val (month, day) = Console.readLine().split(SPLITTER)
            validateIsDigit(month)
            validateNumRange(month.toInt())
            validateDay(day)
            validateLength(day)
            return Pair(month.toInt(), day)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalArgumentException(INVALID_INPUT)
        }
    }

    fun readValidNames(): List<String> {
        val input = Console.readLine().split(SPLITTER)
        validateElementLength(input)
        validateSize(input)
        validateNotDuplicated(input)
        return input
    }

    companion object {
        const val SPLITTER = ","
    }
}