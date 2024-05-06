package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM
import dev.kata.atmmachine.models.MoneyType

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        val moneyReturned = obtainMoneyInBillsAndCoins(quantity)
        val invoice = formatInvoice(moneyReturned)
        return invoice
    }

    private fun formatInvoice(moneyList:Map<Int, Int>):String {
        var messageResult = ""
        moneyList.keys.forEach {
            messageResult += formatEachLineOfInvoice(moneyList.getValue(it), it)
        }
        return messageResult.substring(0, messageResult.length - 1)
    }

    private fun obtainMoneyInBillsAndCoins(quantity:Int): Map<Int, Int> {
        val moneyList = mutableMapOf(
            500 to 0, 200 to 0, 100 to 0, 50 to 0,
            20 to 0, 10 to 0, 5 to 0, 2 to 0,
            1 to 0,
        )
        var copyQuantity = quantity
        while (copyQuantity > 0) {
            for (moneyType in MoneyType.entries) {
                if (copyQuantity >= moneyType.value) {
                    moneyList[moneyType.value] = moneyList.getValue(moneyType.value) + 1
                    copyQuantity -= moneyType.value
                    break
                }
            }
        }
        return moneyList.filter { it.value >= 1 }
    }

    private fun formatEachLineOfInvoice(quantity:Int, value:Int ):String {
        val isCoin = value == 1 || value == 2
        return if (quantity == 1){
            if (isCoin) "$quantity moneda de $value\n"
            else "$quantity billete de $value\n"
        }else{
            if (isCoin) "$quantity monedas de $value\n"
            else "$quantity billetes de $value\n"
        }
    }

}