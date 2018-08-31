package ru.test.gen

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.streams.toList

class PointsLoader(private val fileName: String) {
    private val points: MutableList<String> = mutableListOf()
    private val random: Random = Random()

    val anyPoint: String
        get() {
            if (points.isEmpty()) {
                throw RuntimeException("Нет точек продаж")
            }

            return points[random.nextInt(points.size)]
        }

    fun load() {
        val pointsPath = Paths.get(fileName)
        try {
            Files.newBufferedReader(pointsPath).lines().use { points.addAll(it.toList()) }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }

    }
}
