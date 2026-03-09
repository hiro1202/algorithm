package com.algorithm.sort

/**
 * 挿入ソートアルゴリズムの実装
 * 未整列部分から要素を1つずつ取り出し、整列済み部分の適切な位置に挿入していく
 * 時間計算量: O(n²)（最悪・平均）、O(n)（最良、ほぼ整列済みの場合）
 * 空間計算量: O(1)
 */
class InsertionSort {

    /**
     * 挿入ソートを実行する
     *
     * 配列の2番目の要素から順に、整列済み部分の正しい位置に挿入していく。
     * 挿入位置より後ろの要素は1つずつ右にずらす。
     *
     * @param array ソート対象の配列（in-placeで変更される）
     * @return ソート済みの配列（入力と同じ参照）
     */
    fun sort(array: IntArray): IntArray {
        for (i in 1 until array.size) {
            val key = array[i]
            var j = i - 1
            // keyより大きい要素を右にずらす
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = key
        }
        return array
    }
}
