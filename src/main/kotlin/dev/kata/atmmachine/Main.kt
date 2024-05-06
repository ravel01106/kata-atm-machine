package dev.kata.atmmachine

import dev.kata.atmmachine.models.MoneyType

fun main(){
    var moneyList = mutableMapOf("500" to 0, "100" to 0, "10" to 0)
    println(moneyList.keys)
    moneyList["500"] = moneyList.getValue("500") + 1
    moneyList["500"] = moneyList.getValue("500") + 1
    moneyList["10"] = moneyList.getValue("10") + 1


    var result = ""
    for ( key in moneyList.keys.filter { moneyList.getValue(it) >= 1 }){
        result += "$key "
    }
    println(result)
    println("---------------------------")
    for (moneyType in MoneyType.entries){
        println(moneyType.value)
    }

}