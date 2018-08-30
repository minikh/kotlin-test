package ru.test.gen

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class TimeGenerator {
    private val from: LocalDateTime
    private val random: Random = Random()
    private val days: Long

    init {
        val now = LocalDateTime.now()
        val year = now.minusYears(1).year
        from = LocalDateTime.of(year, 1, 1, 0, 0, 0, 0)
        val to = LocalDateTime.of(year + 1, 1, 1, 0, 0, 0, 0)
        days = ChronoUnit.DAYS.between(from, to)
    }

    fun generate(): LocalDateTime {
        return from
                .plusDays(random.nextInt(days.toInt()).toLong())
                .plusHours(random.nextInt(24).toLong())
                .plusMinutes(random.nextInt(60).toLong())
                .plusSeconds(random.nextInt(60).toLong())
    }
}
