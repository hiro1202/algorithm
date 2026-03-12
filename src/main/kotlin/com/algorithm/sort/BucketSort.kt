package com.algorithm.sort

/**
 * 保留...
 * バケットソートアルゴリズムの実装
 * 値の範囲をバケット（区間）に分割し、各バケット内を挿入ソートで整列してから結合する
 * 時間計算量: O(n + k)（平均）、O(n²)（最悪、全要素が1つのバケットに集中した場合）
 * 空間計算量: O(n + k)（kはバケット数）
 */
class BucketSort {

    /**
     * バケットソートを実行する
     *
     * @param array ソート対象の配列
     * @return ソート済みの新しい配列
     */
    fun sort(array: IntArray): IntArray {
        val n = array.size
        if (n <= 1) return array.copyOf()

        // 配列の最小値と最大値を求める
        var minValue = array[0]
        var maxValue = array[0]
        for (i in 1 until n) {
            if (array[i] < minValue) minValue = array[i]
            if (array[i] > maxValue) maxValue = array[i]
        }

        // 全要素が同じ値の場合はそのままコピーを返す
        if (minValue == maxValue) return array.copyOf()

        // バケット数は要素数と同じにする
        val bucketCount = n
        val range = maxValue - minValue

        // 各バケットをリストの配列として用意する
        val buckets = Array(bucketCount) { mutableListOf<Int>() }

        // 各要素をバケットに振り分ける
        for (value in array) {
            // 値を0〜bucketCount-1の範囲にマッピング
            var index = ((value.toLong() - minValue) * (bucketCount - 1) / range).toInt()
            if (index >= bucketCount) index = bucketCount - 1
            buckets[index].add(value)
        }

        // 各バケット内を挿入ソートで整列する
        for (bucket in buckets) {
            insertionSort(bucket)
        }

        // 全バケットを順に結合して結果を作る
        val result = IntArray(n)
        var pos = 0
        for (bucket in buckets) {
            for (value in bucket) {
                result[pos] = value
                pos++
            }
        }

        return result
    }

    /**
     * リストに対して挿入ソートを実行する
     * バケット内の少数の要素をソートするのに適している
     *
     * @param list ソート対象のリスト（in-placeで変更される）
     */
    private fun insertionSort(list: MutableList<Int>) {
        for (i in 1 until list.size) {
            val key = list[i]
            var j = i - 1
            // keyより大きい要素を右にずらす
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = key
        }
    }
}
