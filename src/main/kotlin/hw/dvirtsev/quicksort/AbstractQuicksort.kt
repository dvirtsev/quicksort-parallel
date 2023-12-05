package hw.dvirtsev.quicksort

import java.util.Collections.swap
import kotlin.random.Random

abstract class AbstractQuicksort<T: Comparable<T>>(private val initialArray: List<T>) {

    fun sortAndGet(): List<T> {
        sort()
        return initialArray
    }

    protected abstract fun sort()

    protected fun choosePivot(left: Int, right: Int): Int {
        return (left + right) / 2
    }

    protected fun split(array: List<T>, left: Int, right: Int, pivot: Int): Int {
        var leftIndex = left
        var rightIndex = right
        val pivotElem = array[pivot]

        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < pivotElem) {
                leftIndex++
            }
            while (array[rightIndex] > pivotElem) {
                rightIndex--
            }
            if (leftIndex >= rightIndex) {
                break
            }
            swap(array, leftIndex, rightIndex)
            leftIndex++
            rightIndex--
        }

        return rightIndex
    }
}