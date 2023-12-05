package hw.dvirtsev.quicksort

import kotlin.random.Random

class SequentialQuicksort<T: Comparable<T>>(
    private val initialArray: List<T>,
    private val left: Int = 0,
    private val right: Int = initialArray.size - 1,
): AbstractQuicksort<T>(initialArray) {

    override fun sort() {
        if (left >= right) {
            return
        }

        val pivot = choosePivot(left, right)
        val newPivotPosition = split(initialArray, left, right, pivot)
        SequentialQuicksort(initialArray, left, newPivotPosition).sort()
        SequentialQuicksort(initialArray, newPivotPosition + 1, right).sort()
    }
}