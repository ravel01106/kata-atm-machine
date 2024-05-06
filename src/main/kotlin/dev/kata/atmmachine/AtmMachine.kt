package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM
import dev.kata.atmmachine.models.MoneyType

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        val moneyList = obtainMoneyInBillsAndCoins(quantity)
        val invoice = formatInvoice(moneyList)
        return invoice
    }

    private fun formatInvoice(moneyList:Map<Int, Int>):String {
        var messageResult = ""
        for ( key in moneyList.keys.filter { moneyList.getValue(it) >= 1 }){
            val isCoin = key == 1 || key == 2
            val value = moneyList.getValue(key)
            messageResult += if (moneyList.getValue(key) == 1){
                if (isCoin) "$value moneda de $key\n"
                else "$value billete de $key\n"
            }else{
                if (isCoin) "$value monedas de $key\n"
                else "$value billetes de $key\n"
            }
        }
        return messageResult.substring(0, messageResult.length -1)
    }

    private fun obtainMoneyInBillsAndCoins(quantity:Int): Map<Int, Int>{
        val moneyList = mutableMapOf(
            500 to 0, 200 to 0, 100 to 0, 50 to 0,
            20 to 0, 10 to 0, 5 to 0, 2 to 0,
            1 to 0,
        )
        var copyQuantity = quantity
        while (copyQuantity > 0){
            for (moneyType in MoneyType.entries){
                if (copyQuantity >= moneyType.value){
                    moneyList[moneyType.value] = moneyList.getValue(moneyType.value) + 1
                    copyQuantity -= moneyType.value
                    break
                }
            }
        }
        return moneyList.toMap()
    }

}