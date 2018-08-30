package ru.test.calc

import ru.test.Operation
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class CalculatorApp {

    fun start(operationsFileName: String, operationsOfDaysFileName: String, operationsOfPointsFileName: String) {

        try {
            Files.newBufferedReader(Paths.get(operationsFileName)).lines().use { lineStream ->

                val pointsCalculator = OperationsOfPointsCalculator()
                val daysCalculator = OperationsOfDaysCalculator()

                lineStream
                        .map { Operation.create(it) }
                        .filter { it != null }
                        .forEach {
                            pointsCalculator.calculate(it!!)
                            daysCalculator.calculate(it)
                        }

                Files.write(Paths.get(operationsOfDaysFileName), pointsCalculator.result)
                Files.write(Paths.get(operationsOfPointsFileName), daysCalculator.result)

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        println("end calculated")
    }
}

fun main(args: Array<String>) {
    if (args.size != 3) {
        throw RuntimeException("Параметров должно быть 3")
    }

    val operationsFileName = args[0]
    val operationsOfDaysFileName = args[1]
    val operationsOfPointsFileName = args[2]

    CalculatorApp().start(operationsFileName, operationsOfDaysFileName, operationsOfPointsFileName)
}
