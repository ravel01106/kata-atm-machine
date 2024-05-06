package dev.kata.atmmachine

import dev.kata.atmmachine.interfaces.ATM

class AtmMachine: ATM {
    override fun withdraw(quantity: Int): String {
        var copyQuantity = quantity
        var messageResult = ""
        while (copyQuantity > 0){
            println(copyQuantity)
            when(copyQuantity){
                in 10..19 -> {
                    messageResult += "1 billete de 10\n"
                    copyQuantity -= 10
                }
                in 5..9 -> {
                    messageResult += "1 billete de 5\n"
                    copyQuantity -= 5
                }
                in 2..4 -> {
                    messageResult += "1 moneda de 2\n"
                    copyQuantity -= 2
                }
                1 -> {
                    messageResult += "1 moneda de 1\n"
                    copyQuantity -= 1
                }
            }

        }
        return messageResult.substring(0, messageResult.length-1)
    }

}