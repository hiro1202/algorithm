package com.algorithm.sort

/**
 * 保留...
 * ヒープソートアルゴリズムの実装
 * 配列を最大ヒープに構築し、最大値を末尾に移動する操作を繰り返してソートする
 * 時間計算量: O(n log n)
 * 空間計算量: O(1)
 */
class HeapSort {

    /**
     * 12.4 ヒープソートの実装
     * ヒープソートを実行する
     *
     * @param array ソート対象の配列
     * @return ソート済みの新しい配列
     */
    fun sort(array: IntArray): IntArray {
        val result = array.copyOf()
        val n = result.size
        if (n <= 1) return result

        // ステップ1: 配列全体をヒープにするフェーズ
        for (i in n / 2 - 1 downTo 0) {
            heapify(result, i, n)
        }

        // ステップ2: ヒープから1個1個最大値をpopするフェーズ
        for (i in n - 1 downTo 1) {
            result[0] = result[i].also { result[i] = result[0] } // ヒープの最大値を右端に移動
            heapify(result, 0, i) // ヒープサイズはiに縮小
        }

        return result
    }

    /**
     * i番目の頂点を根とする部分木について、ヒープ条件を満たすようにする
     * 配列のうち0番からn-1番までの部分についてのみ考える
     *
     * @param array 対象の配列
     * @param i 根ノードのインデックス
     * @param n ヒープとして扱う範囲のサイズ
     */
    private fun heapify(array: IntArray, i: Int, n: Int) {
        val child1 = i * 2 + 1 // 左の子供
        if (child1 >= n) return // 子供がないときは終了

        // 子供同士を比較して、大きい方を選ぶ
        var largerChild = child1
        if (child1 + 1 < n && array[child1 + 1] > array[child1]) largerChild++

        if (array[largerChild] <= array[i]) return // 逆転がなかったら終了

        // 親と大きい方の子を交換
        array[i] = array[largerChild].also { array[largerChild] = array[i] }

        // 交換先の部分木について再帰的にヒープ条件を修正
        heapify(array, largerChild, n)
    }
}
