package dev.kata.atmmachine.interfaces

interface ATM {
    fun withdraw(quantity:Int): String;
}