package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        var messageResult = ""
        var moneyList = obtainMoneyInBillsAndCoins(quantity)

        for ( key in moneyList.keys.filter { moneyList.getValue(it) >= 1 }){
            val value = moneyList.getValue(key)
            messageResult += if (moneyList.getValue(key) == 1){
                if (key == "1" || key == "2") "$value moneda de $key\n"
                else "$value billete de $key\n"
            }else{
                if (key == "1" || key == "2") "$value monedas de $key\n"
                else "$value billetes de $key\n"
            }
        }
        return messageResult.substring(0, messageResult.length -1)
    }

    private fun obtainMoneyInBillsAndCoins(quantity:Int): Map<String, Int>{
        var moneyList = mutableMapOf(
            "500" to 0, "200" to 0, "100" to 0, "50" to 0,
            "20" to 0, "10" to 0, "5" to 0, "2" to 0,
            "1" to 0,
        )
        var copyQuantity = quantity
        while (copyQuantity > 0){
            when(copyQuantity){
                in 500..1500 -> {
                    moneyList["500"] = moneyList.getValue("500") + 1
                    copyQuantity -= 500
                }
                in 200..1500 -> {
                    moneyList["200"] = moneyList.getValue("200") + 1
                    copyQuantity -= 200
                }
                in 100..199 -> {
                    moneyList["100"] = moneyList.getValue("100") + 1
                    copyQuantity -= 100
                }
                in 50..99 -> {
                    moneyList["50"] = moneyList.getValue("50") + 1
                    copyQuantity -= 50
                }
                in 20..49 -> {
                    moneyList["20"] = moneyList.getValue("20") + 1
                    copyQuantity -= 20
                }
                in 10..19 -> {
                    moneyList["10"] = moneyList.getValue("10") + 1
                    copyQuantity -= 10
                }
                in 5..9 -> {
                    moneyList["5"] = moneyList.getValue("5") + 1
                    copyQuantity -= 5
                }
                in 2..4 -> {
                    moneyList["2"] = moneyList.getValue("2") + 1
                    copyQuantity -= 2
                }
                1 -> {
                    moneyList["1"] = moneyList.getValue("1") + 1
                    copyQuantity -= 1
                }
            }
        }
        return moneyList.toMap()
    }

}