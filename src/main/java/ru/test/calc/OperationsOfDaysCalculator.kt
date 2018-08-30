package ru.test.calc

import ru.test.Operation
import java.math.BigDecimal
import java.util.*

class OperationsOfDaysCalculator : Calculator {

    private val operations: MutableMap<String, BigDecimal> = HashMap()

    override val result: List<String>
        get() = operations.entries
                .asSequence()
                .sortedBy { it.key }
                .map { "${it.key}${Operation.DELIMITER}${it.value}" }
                .toList()

    override fun calculate(operation: Operation) {
        val amount = operations.putIfAbsent(operation.date(), operation.amount) ?: return
        operations[operation.date()] = amount.add(operation.amount)
    }
}
