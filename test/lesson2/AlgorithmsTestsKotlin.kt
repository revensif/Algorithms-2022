package lesson2

import org.junit.jupiter.api.Tag
import kotlin.test.Test

class AlgorithmsTestsKotlin : AbstractAlgorithmsTests() {
    @Test
    @Tag("2")
    fun testOptimizeBuyAndSell() {
        optimizeBuyAndSell { lesson2.optimizeBuyAndSell(it) }
    }

    @Test
    @Tag("2")
    fun testJosephTask() {
        josephTask { menNumber, choiceInterval -> lesson2.josephTask(menNumber, choiceInterval) }
    }

    @Test
    @Tag("4")
    fun testLongestCommonSubstring() {
        longestCommonSubstring { first, second -> lesson2.longestCommonSubstring(first, second) }
    }

    @Test
    @Tag("3")
    fun testCalcPrimesNumber() {
        calcPrimesNumber { lesson2.calcPrimesNumber(it) }
    }
}