package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        var copyQuantity = quantity
        var messageResult = ""
        if (quantity >= 5){
            messageResult += "1 billete de 5"
            copyQuantity -= 5
        }else if (quantity >= 1){
            messageResult += "1 moneda de 1"
            copyQuantity -= 1
        }
        return messageResult
    }

}