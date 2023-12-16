package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.util.Validator.INVALID_INPUT
import oncall.util.Validator.validateDay
import oncall.util.Validator.validateElementLength
import oncall.util.Validator.validateIsDigit
import oncall.util.Validator.validateLength
import oncall.util.Validator.validateNotDuplicated
import oncall.util.Validator.validateNumRange
import oncall.util.Validator.validateSize

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