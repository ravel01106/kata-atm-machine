package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        var messageResult = ""

        if (quantity >= 1){
            messageResult += "1 moneda de 1"
        }
        return messageResult
    }

}