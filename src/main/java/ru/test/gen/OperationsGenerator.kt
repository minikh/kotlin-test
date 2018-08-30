package ru.test.gen

import ru.test.Operation
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

internal class OperationsGenerator(
        private val operationsFileName: String,
        private val amountGenerator: AmountGenerator,
        private val timeGenerator: TimeGenerator,
        private val pointsLoader: PointsLoader
) {

    fun generate(countOperations: Long) {
        try {
            Files.newBufferedWriter(Paths.get(operationsFileName)).use { bufferedWriter ->
                for (operationNumber in 0 until countOperations) {
                    val operation = Operation(
                            date = timeGenerator.generate(),
                            pointNumber = pointsLoader.anyPoint,
                            number = operationNumber,
                            amount = amountGenerator.next()
                    )

                    bufferedWriter.write(operation.print())
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
