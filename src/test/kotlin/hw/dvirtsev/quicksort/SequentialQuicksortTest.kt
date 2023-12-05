package hw.dvirtsev.quicksort

class SequentialQuicksortTest : BaseQuicksortTest() {
    override fun runSort(initial: List<Int>): List<Int> {
        return SequentialQuicksort(initial).sortAndGet()
    }
}