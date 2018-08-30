package ru.test.gen

class GeneratorApp {

    fun start(pointsFileName: String, countOperations: Long, operationsFileName: String) {

        val amountGenerator = AmountGenerator(10000f, 100000f)
        val timeGenerator = TimeGenerator()
        val pointsLoader = PointsLoader(pointsFileName)
        pointsLoader.load()

        val operationsGenerator = OperationsGenerator(operationsFileName, amountGenerator, timeGenerator, pointsLoader)
        operationsGenerator.generate(countOperations)

        println("end generated")
    }

}

fun main(args: Array<String>) {
    if (args.size != 3) {
        throw RuntimeException("Параметров должно быть 3")
    }

    val pointsFileName = args[0]
    val countOperations = java.lang.Long.parseLong(args[1])
    val operationsFileName = args[2]

    GeneratorApp().start(pointsFileName, countOperations, operationsFileName)
}
