package ru.test.gen

import java.math.BigDecimal
import java.util.*

class AmountGenerator(private val min: Float, private val max: Float) {
    private val rand = Random()

    operator fun next(): BigDecimal {
        return BigDecimal((rand.nextFloat() * (max - min) + min).toDouble())
    }
}
