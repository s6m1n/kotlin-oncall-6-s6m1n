package oncall.util

object Validator {

    fun validateLength(input: String) {
        require(input.length == 1) { INVALID_INPUT }
    }

    fun validateDay(input: String) {
        require(listOf("월","화","수","목","금","토","일").contains(input)) { INVALID_INPUT }
    }

    fun validateIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT)
        }
    }

    fun validateNumRange(input: Int) {
        require(input in 1..12) { INVALID_INPUT }
    }

    // String 리스트의 모든 요소의 길이를 확인
    fun validateElementLength(input: List<String>) {
        require(input.all { it.length in 1..5 }) { INVALID_INPUT_MESSAGE }
    }

    // String 리스트의 크기를 확인 (리스트 요소 갯수)
    fun validateSize(input: List<String>) {
        require(input.size in 5..35) { INVALID_INPUT_MESSAGE }
    }

    // String 리스트의 중복 여부 확인
    fun validateNotDuplicated(input:List<String>){
        require(input.distinct().size == input.size) { INVALID_INPUT_MESSAGE }
    }

    const val INVALID_INPUT = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    private const val INVALID_INPUT_MESSAGE = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
}