package ru.test.gen

import java.time.format.DateTimeFormatter

object OperationsDateTimeFormatter {
    val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd")
    val TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("kk:mm:ss")
    val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd kk:mm:ss")
}
