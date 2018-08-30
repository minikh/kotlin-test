package ru.test

import ru.test.gen.OperationsDateTimeFormatter
import java.math.BigDecimal
import java.time.LocalDateTime

data class Operation(
        val date: LocalDateTime,
        val pointNumber: String,
        val number: Long = 0,
        val amount: BigDecimal
) {


    fun date(): String {
        return date.format(OperationsDateTimeFormatter.DATE_FORMATTER)
    }

    fun print(): String {
        return arrayOf(
                date(),
                date.format(OperationsDateTimeFormatter.TIME_FORMATTER),
                pointNumber,
                number.toString(),
                amount.toString(),
                "\n").joinToString(DELIMITER)
    }

    companion object {
        const val DELIMITER = "\t"

        fun create(line: String): Operation? {
            val strings = line.split(Operation.DELIMITER.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (strings.size != 5) {
                return null
            }

            val date = LocalDateTime.parse(strings[0] + " " + strings[1], OperationsDateTimeFormatter.DATE_TIME_FORMATTER)
            return Operation(
                    date = date,
                    pointNumber = strings[2],
                    number = strings[3].toLong(),
                    amount = strings[4].toBigDecimal()
            )
        }
    }
}
