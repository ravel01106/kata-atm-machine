package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM
import dev.kata.atmmachine.models.Money
import dev.kata.atmmachine.models.MoneyType

class AtmMachineTwo:ATM {
    private var warehouse:MutableMap<Money, Int> = mutableMapOf(
        Money(MoneyType.FIVE_HUNDRED, 2) to 0,
        Money(MoneyType.TWO_HUNDRED, 3) to 0,
        Money(MoneyType.ONE_HUNDRED, 5) to 0,
        Money(MoneyType.FIFTY, 12) to 0,
        Money(MoneyType.TWENTY, 20) to 0,
        Money(MoneyType.TEN, 50) to 0,
        Money(MoneyType.FIVE, 100) to 0,
        Money(MoneyType.TWO, 250) to 0,
        Money(MoneyType.ONE, 500) to 0,)
    override fun withdraw(quantity: Int): String {
        obtainMoneyInBillsAndCoins(quantity)
        val invoice = formatInvoice()
        return invoice
    }

    private fun formatInvoice():String {
        var messageResult = ""
        val warehouseFiltered = warehouse.filter { it.value >= 1 }
        warehouseFiltered.forEach {
            messageResult += formatEachLineOfInvoice(it.value, it.key.value.value)
        }
        return messageResult.substring(0, messageResult.length - 1)
    }
    private fun getMoneyBy(value:MoneyType):Money{
        val moneyObtained = warehouse.filter { it.key.value === value }
        return moneyObtained.keys.elementAt(0)
    }

    private fun obtainMoneyInBillsAndCoins(quantity:Int){
        var copyQuantity = quantity
        while (copyQuantity > 0) {
            for (moneyType in MoneyType.entries) {
                if (copyQuantity >= moneyType.value) {
                    warehouse[getMoneyBy(moneyType)] = warehouse.getValue(getMoneyBy(moneyType)) + 1
                    setQuantityStoredBy(moneyType)

                    copyQuantity -= moneyType.value
                    break
                }
            }
        }

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

    fun getQuantitiesStoredBy(value: MoneyType): Int {
        return getMoneyBy(value).quantity
    }
    private fun setQuantityStoredBy(value:MoneyType){
        getMoneyBy(value).quantity -= 1
    }
}