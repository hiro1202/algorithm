package com.algorithm.sort

/**
 * 保留...
 * マージソートアルゴリズムの実装
 * 配列を半分に分割し、それぞれを再帰的にソートしてからマージする
 * 右半分を反転してバッファに入れることで、番兵なしで併合を簡潔に行う
 * 時間計算量: O(n log n)
 * 空間計算量: O(n)
 */
class MergeSort {

    /**
     * 12.2 マージソートの実装
     * マージソートを実行する
     *
     * @param array ソート対象の配列
     * @return ソート済みの新しい配列
     */
    fun sort(array: IntArray): IntArray {
        val result = array.copyOf()
        if (result.size <= 1) return result
        mergeSort(result, 0, result.size)
        return result
    }

    /**
     * 配列の指定範囲 [left, right) を再帰的にソートする
     *
     * @param array 対象の配列
     * @param left 左端のインデックス（含む）
     * @param right 右端のインデックス（含まない）
     */
    private fun mergeSort(array: IntArray, left: Int, right: Int) {
        // 要素が1つ以下なら何もしない
        if (right - left <= 1) return

        val mid = left + (right - left) / 2

        // 左半分 [left, mid) をソート
        mergeSort(array, left, mid)
        // 右半分 [mid, right) をソート
        mergeSort(array, mid, right)

        // 左半分をそのまま、右半分を反転してバッファにコピーする
        // こうすると左右の端から中央に向かって取り出せば、小さい順に併合できる
        val buf = mutableListOf<Int>()
        for (i in left until mid) buf.add(array[i])
        for (i in right - 1 downTo mid) buf.add(array[i])

        // バッファの左端と右端から小さい方を順に元の配列に書き戻す
        var indexLeft = 0
        var indexRight = buf.size - 1
        for (i in left until right) {
            if (buf[indexLeft] <= buf[indexRight]) {
                array[i] = buf[indexLeft++]
            } else {
                array[i] = buf[indexRight--]
            }
        }
    }
}
