package hw.dvirtsev.quicksort

class ParallelQuicksortTest : BaseQuicksortTest() {
    override fun runSort(initial: List<Int>): List<Int> {
        return ParallelQuicksort(initial).sortAndGet()
    }
}