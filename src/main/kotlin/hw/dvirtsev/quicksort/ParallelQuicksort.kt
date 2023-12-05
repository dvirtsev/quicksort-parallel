package hw.dvirtsev.quicksort

import java.util.Collections.swap
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveAction

class ParallelQuicksort<T: Comparable<T>>(
    private val initialArray: List<T>,
    private val blockSize: Int = 16,
    private val poolSize: Int = 4,
): AbstractQuicksort<T>(initialArray) {

    override fun sort() {
        val initialTask = QuicksortAction(initialArray)
        ForkJoinPool(poolSize).invoke(initialTask)
    }

    private inner class QuicksortAction(
        private val array: List<T>,
        private val left: Int = 0,
        private val right: Int = array.size - 1,
    ) : RecursiveAction() {

        override fun compute() {
            if (left >= right) {
                return
            }

            if (right - left < blockSize) {
                bubbleSort(array, left, right)
                return
            }

            val pivot = choosePivot(left, right)
            val newPivotPosition = split(initialArray, left, right, pivot)

            val firstTask = QuicksortAction(initialArray, left, newPivotPosition)
            val secondTask = QuicksortAction(initialArray, newPivotPosition + 1, right)

            invokeAll(firstTask, secondTask)
        }

        private fun bubbleSort(array: List<T>, left: Int, right: Int) {
            for (i in left..right) {
                for (j in i..right) {
                    if (array[i] > array[j]) {
                        swap(array, i, j)
                    }
                }
            }
        }
    }
}