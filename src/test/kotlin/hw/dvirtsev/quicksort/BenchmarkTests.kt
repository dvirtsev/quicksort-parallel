package hw.dvirtsev.quicksort

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.measureTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BenchmarkTests {
    companion object {
        private const val REPEAT_TIMES = 10
    }

    fun testSizes() = arrayOf(
        1_000,
        10_000,
        100_000,
        1_000_000,
        10_000_000,
    )

    @ParameterizedTest(name = "array size = {0}")
    @MethodSource("testSizes")
    fun `compare sequential and parallel`(size: Int) {
        val sequentialTimeRuns = buildList {
            repeat(REPEAT_TIMES) {
                val array = generateRandomArray(size)
                val duration = measureTime {
                    SequentialQuicksort(array).sortAndGet()
                }
                add(duration)
            }
        }

        val parallelTimeRuns = buildList {
            repeat(REPEAT_TIMES) {
                val array = generateRandomArray(size)
                val duration = measureTime {
                    ParallelQuicksort(array).sortAndGet()
                }
                add(duration)
            }
        }

        println("Sequential runs: $sequentialTimeRuns")
        val avgSequentialDuration = sequentialTimeRuns
            .fold(Duration.ZERO) { acc, d -> acc + d }
            .div(REPEAT_TIMES)
        println("Sequential average runtime: $avgSequentialDuration")

        println("Parallel runs: $parallelTimeRuns")
        val avgParallelDuration = parallelTimeRuns
            .fold(Duration.ZERO) { acc, d -> acc + d }
            .div(REPEAT_TIMES)
        println("Parallel average runtime: $avgParallelDuration")
    }

    private fun generateRandomArray(size: Int): List<Int> {
        return (0 until size).map { Random.nextInt() }
    }
}