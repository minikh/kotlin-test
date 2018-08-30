package ru.test.calc

import ru.test.Operation

interface Calculator {
    val result: List<String>
    fun calculate(operation: Operation)
}
