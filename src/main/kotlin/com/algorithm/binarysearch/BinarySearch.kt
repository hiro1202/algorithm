package com.algorithm.binarysearch

/**
 * 二分探索アルゴリズムの実装
 * ソート済み配列に対して中央要素を比較しながら探索範囲を半分ずつ絞り込む
 * 時間計算量: O(log n)
 * 空間計算量: O(1)
 */
class BinarySearch {

    /**
     * 6.1 配列から目的の値を検索する二分探索法
     *
     * 二分探索を実行する
     * @param array 探索対象のソート済み配列
     * @param target 探索する値
     * @return 見つかった場合はそのインデックス、見つからない場合は-1
     */
    fun search(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                array[mid] == target -> return mid
                array[mid] > target -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return -1
    }
}
