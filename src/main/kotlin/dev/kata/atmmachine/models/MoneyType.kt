package dev.kata.atmmachine.models

enum class MoneyType(val value:Int) {
    FIVE_HUNDRED(500), TWO_HUNDRED(200),
    ONE_HUNDRED(100), FIFTY(50),
    TWENTY(20), TEN(10),
    FIVE(5), TWO(2), ONE(1)
}