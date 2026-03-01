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

    /**
     * 線形探索で最小値を求める
     * @param array 探索対象の配列
     * @return 最小値
     * @throws IllegalArgumentException 配列が空の場合
     */
    fun findMin(array: IntArray): Int {
        require(array.isNotEmpty()) { "配列が空です" }
        // 先頭要素を仮の最小値とする
        var min = array[0]
        // 2番目以降の要素を順に比較し、より小さい値があれば更新
        for (i in 1 until array.size) {
            if (array[i] < min) {
                min = array[i]
            }
        }
        return min
    }

    /**
     * 2つの配列からそれぞれ1つずつ要素を選んだときの合計の最小値を求める
     * 各配列の最小値同士を足すことで O(n + m) で求められる
     * @param array1 1つ目の配列
     * @param array2 2つ目の配列
     * @return 合計の最小値
     * @throws IllegalArgumentException いずれかの配列が空の場合
     */
    fun findMinSum(array1: IntArray, array2: IntArray): Int {
        require(array1.isNotEmpty()) { "配列が空です" }
        require(array2.isNotEmpty()) { "配列が空です" }
        // 最初のペアの合計を仮の最小値とする
        var min = array1[0] + array2[0]
        // 全てのペアを総当たりで比較する
        for (i in array1.indices) {
            for (j in array2.indices) {
                val sum = array1[i] + array2[j]
                if (sum < min) {
                    min = sum
                }
            }
        }
        return min
    }
}
