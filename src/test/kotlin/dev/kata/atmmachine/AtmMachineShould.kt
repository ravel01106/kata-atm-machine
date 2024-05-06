package dev.kata.atmmachine
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AtmMachineShould{
    // withdraw one coin of one when the quantity entered is 1
    // withdraw one five bill when the quantity entered is 5
    // withdraw one ten five bill and one five bill when the quantity entered is 15
    // withdraw two five-hundred bills when the quantity entered is 1000
    // withdraw one twenty bill, one ten bill, two twopennies when the quantity entered is 34
    // withdraw the necessary bills and coins when the quantity entered is 434
    // withdraw the necessary bills and coins when the quantity entered is 1725
    private var atmMachine: AtmMachine = AtmMachine()
    @BeforeEach
    fun `reset atm machine`(){
        atmMachine = AtmMachine()
    }

    @Test
    fun `withdraw one coin of one when the quantity entered is 1`(){
        val result = atmMachine.withdraw(1)
        assertEquals("1 moneda de 1", result)
    }

    @Test
    fun `withdraw one five bill when the quantity entered is 5`(){
        val result = atmMachine.withdraw(5)
        assertEquals("1 billete de 5", result)
    }
    @Test
    fun `withdraw one ten five bill and one five bill when the quantity entered is 15`(){
        val result = atmMachine.withdraw(15)
        assertEquals("1 billete de 10\n1 billete de 5", result)
    }
    @Test
    fun `withdraw two five-hundred bills when the quantity entered is 1000`(){
        val result = atmMachine.withdraw(1000)
        assertEquals("2 billetes de 500", result)
    }

    @Test
    fun `withdraw one twenty bill, one ten bill, two twopennies when the quantity entered is 34`(){
        val result = atmMachine.withdraw(34)
        assertEquals("1 billete de 20\n1 billete de 10\n2 monedas de 2", result)
    }
    @Test
    fun `withdraw the necessary bills and coins when the quantity entered is 434`(){
        val result = atmMachine.withdraw(434)
        assertEquals("2 billetes de 200\n1 billete de 20\n1 billete de 10\n2 monedas de 2", result)
    }
    @Test
    fun `withdraw the necessary bills and coins when the quantity entered is 1725`(){
        val result = atmMachine.withdraw(1725)
        assertEquals("3 billetes de 500\n1 billete de 200\n1 billete de 20\n1 billete de 5", result)
    }

}