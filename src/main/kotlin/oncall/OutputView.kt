package oncall

class OutputView {
    fun inputMonthAndDayMessage(){
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
    }

    fun inputWeekdayMessage(){
        print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
    }

    fun inputWeekendMessage(){
        print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
    }
}