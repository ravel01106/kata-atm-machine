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
    // when the quantity entered is 1500, 0 units of five-hundred bills will remain inside the machine.
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

    @Test
    fun `when the quantity entered is 5, 99 units of five bills will remain inside the machine`(){
        val message = atmMachine.withdraw(5)
        val result = atmMachine.getQuantitiesStoredBy(MoneyType.FIVE)
        assertEquals(99, result)
        assertEquals("1 billete de 5", message)

    }

    @Test
    fun `when the quantity entered is 15, 49 units of ten bills and 99 bills will remain inside the machine`(){
        val message = atmMachine.withdraw(15)
        val resultTenBill = atmMachine.getQuantitiesStoredBy(MoneyType.TEN)
        val resultFiveBill = atmMachine.getQuantitiesStoredBy(MoneyType.FIVE)
        assertEquals("1 billete de 10\n1 billete de 5", message)
        assertEquals(49, resultTenBill)
        assertEquals(99, resultFiveBill)
    }

    @Test
    fun `withdraw two five-hundred bills when the quantity entered is 1000`(){
        val message = atmMachine.withdraw(1000)
        val result = atmMachine.getQuantitiesStoredBy(MoneyType.FIVE_HUNDRED)
        assertEquals("2 billetes de 500", message)
        assertEquals(0, result)
    }

    @Test
    fun `when the quantity entered is 1500, 0 units of five-hundred bills will remain inside the machine`(){
        val message = atmMachine.withdraw(1500)
        val result = atmMachine.getQuantitiesStoredBy(MoneyType.FIVE_HUNDRED)
        assertEquals(0, result)
        assertEquals("2 billetes de 500\n2 billetes de 200\n1 billete de 100", message)

    }


}