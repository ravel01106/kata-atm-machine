package dev.kata.atmmachine

import dev.kata.atmmachine.models.MoneyType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AtmMachineTwoShould{
    // when the quantity entered is 1, 499 units of coins one will remain inside the machine.
    // when the quantity entered is 5, 99 units of five bills will remain inside the machine.
    // when the quantity entered is 15, 49 units of ten bills and 99 bills will remain inside the machine.
    // when the quantity entered is 1000, 0 units of five-hundred bills will remain inside the machine.
    // when the quantity entered is 64, the quantities of bills and coins in the machine shall be updated.
    // when the quantity entered is 434, the quantities of bills and coins in the machine shall be updated.
    // when the quantity entered is 1725, the quantities of bills and coins in the machine shall be updated.
    private var atmMachine: AtmMachineTwo = AtmMachineTwo()
    @BeforeEach
    fun `reset atm machine`(){
        atmMachine = AtmMachineTwo()
    }

    @Test
    fun `when the quantity entered is 1, 499 units of coins one will remain inside the machine`() {
        val message = atmMachine.withdraw(1)
        val result = atmMachine.getQuantitiesStoredBy(MoneyType.ONE)
        assertEquals("1 moneda de 1", message)
        assertEquals(499, result)

    }
}