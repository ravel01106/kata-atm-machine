package dev.kata.atmmachine
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AtmMachineShould{
    // withdraw one coin when the quantity entered is 1
    // withdraw one five bill when the quantity entered is 5
    // withdraw one ten five bill and one five bill when the quantity entered is 15
    // withdraw two five-hundred bills when the quantity entered is 500
    // withdraw one twenty bill, one ten bill
    // withdraw the necessary bills and coins when the quantity entered is 1725
    @Test
    fun `withdraw one coin when the quantity entered is 1`(){
        val atmMachine: AtmMachine = AtmMachine()
        val result = atmMachine.withdraw(1)
        assertEquals("1 moneda de 1", result)
    }

}