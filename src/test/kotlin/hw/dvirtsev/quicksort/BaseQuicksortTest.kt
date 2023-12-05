package hw.dvirtsev.quicksort

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseQuicksortTest {
    fun testArrays() = arrayOf(
        arrayOf(
            listOf(),
            listOf(),
        ),
        arrayOf(
            listOf(1),
            listOf(1),
        ),
        arrayOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5),
        ),
        arrayOf(
            listOf(3, 5, 1, 4, 2),
            listOf(1, 2, 3, 4, 5),
        ),
        arrayOf(
            listOf(2, 2, 1, 3, 3),
            listOf(1, 2, 2, 3, 3),
        ),
        arrayOf(
            listOf(1, 1, 1, 1, 1),
            listOf(1, 1, 1, 1, 1),
        ),
        arrayOf(
            listOf(3, 5, 1, 4, 2, 1455, 1213, 12, 3, 414, 5, -1, 0),
            listOf(-1, 0, 1, 2, 3, 3, 4, 5, 5, 12, 414, 1213, 1455),
        ),
    )

    @ParameterizedTest
    @MethodSource("testArrays")
    fun `test sort`(initial: List<Int>, expected: List<Int>) {
        val copyInitial = initial.map { it }
        val result = runSort(copyInitial)
        Assertions.assertThat(result)
            .containsExactlyElementsOf(expected)
    }

    @Test
    fun `random arrays sort`() {
        repeat(10) {
            val array = (1..10000).map { Random.nextInt(-10000, 10000) }
            val expected = array.sorted()
            val result = runSort(array)
            Assertions.assertThat(result)
                .containsExactlyElementsOf(expected)
        }
    }

    abstract fun runSort(initial: List<Int>): List<Int>
}