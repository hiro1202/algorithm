package com.algorithm.search

/**
 * 線形探索アルゴリズムの実装
 * 配列の先頭から末尾まで順番に要素を比較して、目的の値を探す
 * 時間計算量: O(n)
 * 空間計算量: O(1)
 */
class LinearSearch {

    /**
     * 線形探索を実行する
     * @param array 探索対象の配列
     * @param target 探索する値
     * @return 見つかった場合はそのインデックス、見つからない場合は-1
     */
    fun search(array: IntArray, target: Int): Int {
        for (i in array.indices) {
            if (array[i] == target) {
                return i
            }
        }
        return -1
    }
}
