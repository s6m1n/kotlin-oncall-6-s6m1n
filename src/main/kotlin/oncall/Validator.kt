package oncall

object Validator {

    fun validateLength(input: String) {
        require(input.length == 1) { MESSAGE_INVALID_LENGTH }
    }

    fun validateDay(input: String) {
        require(listOf("월","화","수","목","금","토","일").contains(input)) { MESSAGE_IS_NOT_DATE }
    }

    fun validateIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(MESSAGE_INVALID_NUMBER_FORMAT)
        }
    }

    fun validateNumRange(input: Int) {
        require(input in 1..12) { MESSAGE_INVALID_NUMBER_RANGE }
    }

    private const val MESSAGE_INVALID_NUMBER_FORMAT = "[ERROR] 월은 숫자로 입력해주세요"
    private const val MESSAGE_INVALID_NUMBER_RANGE = "[ERROR] 1월부터 12월 중에 입력해주세요"
    private const val MESSAGE_INVALID_LENGTH = "[ERROR] 요일은 한 글자로 입력해주세요"
    private const val MESSAGE_IS_NOT_DATE = "[ERROR] 적절한 요일을 입력해주세요"
}