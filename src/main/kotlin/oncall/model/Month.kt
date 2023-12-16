package oncall.model

enum class Month(val value: Int, val holiday: List<Int?>) {
    JANUARY(1, listOf(1)),
    FEBRUARY(2, listOf()),
    MARCH(3, listOf(1)),
    APRIL(4, listOf()),
    MAY(5, listOf(5)),
    JUNE(6, listOf(6)),
    JULY(7, listOf()),
    AUGUST(8, listOf(15)),
    SEPTEMBER(9, listOf()),
    OCTOBER(10, listOf(3, 9)),
    NOVEMBER(11, listOf()),
    DECEMBER(12, listOf(25));

    companion object {
        fun Int.toMonth(): Month {
            return when (this) {
                JANUARY.value -> JANUARY
                FEBRUARY.value -> FEBRUARY
                MARCH.value -> MARCH
                APRIL.value -> APRIL
                MAY.value -> MAY
                JUNE.value -> JUNE
                JULY.value -> JULY
                AUGUST.value -> AUGUST
                SEPTEMBER.value -> SEPTEMBER
                OCTOBER.value -> OCTOBER
                NOVEMBER.value -> NOVEMBER
                DECEMBER.value -> DECEMBER
                else -> throw IllegalArgumentException(INVALID_MONTH)
            }
        }

        fun getEndDate(month: Month): Int {
            return when (month.value) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                4, 6, 9, 11 -> 30
                2 -> 28
                else -> throw IllegalArgumentException(INVALID_MONTH)
            }
        }

        const val INVALID_MONTH = "[ERROR] 유효한 월이 아닙니다."
    }
}