package com.algorithm.sort

/**
 * 保留...
 * クイックソートアルゴリズムの実装
 * ピボットを選び、それより小さい要素を左側、大きい要素を右側に分割して再帰的にソートする
 * 時間計算量: O(n log n)（平均）、O(n²)（最悪）
 * 空間計算量: O(log n)（再帰のスタック）
 */
class QuickSort {

    /**
     * 12.3 クイックソートの実装
     * クイックソートを実行する
     *
     * @param array ソート対象の配列
     * @return ソート済みの新しい配列
     */
    fun sort(array: IntArray): IntArray {
        val result = array.copyOf()
        if (result.size <= 1) return result
        quickSort(result, 0, result.size)
        return result
    }

    /**
     * 配列の指定範囲 [left, right) を再帰的にソートする
     *
     * @param array 対象の配列
     * @param left 左端のインデックス（含む）
     * @param right 右端のインデックス（含まない）
     */
    private fun quickSort(array: IntArray, left: Int, right: Int) {
        if (right - left <= 1) return

        // ピボットとして中央の要素を選び、右端に退避する
        val pivotIndex = (left + right) / 2
        val pivot = array[pivotIndex]
        array[pivotIndex] = array[right - 1].also { array[right - 1] = array[pivotIndex] }

        // ピボット未満の要素を左に詰めていく
        // iはピボット未満の要素の右端を指す
        var i = left
        for (j in left until right - 1) {
            if (array[j] < pivot) {
                array[i] = array[j].also { array[j] = array[i] }
                i++
            }
        }

        // ピボットを正しい位置に挿入する
        array[i] = array[right - 1].also { array[right - 1] = array[i] }

        // 再帰的に解く
        quickSort(array, left, i)       // 左半分（ピボット未満）
        quickSort(array, i + 1, right)  // 右半分（ピボット以上）
    }
}
