package ru.test.calc

import ru.test.Operation
import java.math.BigDecimal
import java.util.*

class OperationsOfPointsCalculator internal constructor() : Calculator {

    private val operations: MutableMap<String, BigDecimal> = HashMap()

    override val result: List<String>
        get() = operations.entries
                .asSequence()
                .sortedByDescending { it.value }
                .map { "${it.key}${Operation.DELIMITER}${it.value}" }
                .toList()

    override fun calculate(operation: Operation) {
        val amount = operations.putIfAbsent(operation.pointNumber, operation.amount) ?: return
        operations[operation.pointNumber] = amount.add(operation.amount)
    }
}
