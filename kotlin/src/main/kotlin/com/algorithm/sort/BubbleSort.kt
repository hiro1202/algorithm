package com.algorithm.sort

/**
 * バブルソートアルゴリズムの実装
 * 隣接する要素を比較して、必要に応じて交換を行うことで配列をソートする
 * 時間計算量: O(n²)
 * 空間計算量: O(1)
 */
class BubbleSort {
    
    /**
     * バブルソートを実行する
     * @param array ソート対象の配列（値渡し）
     * @return ソート済みの配列（新しい配列を返す）
     */
    fun sort(array: IntArray): IntArray {
        val result = array.copyOf()
        val n = result.size
        
        // 外側のループ：配列の終端から順に確定させる
        for (i in 0 until n - 1) {
            var swapped = false
            
            // 内側のループ：隣接要素の比較と交換
            for (j in 0 until n - 1 - i) {
                if (result[j] > result[j + 1]) {
                    // 要素を交換
                    val temp = result[j]
                    result[j] = result[j + 1]
                    result[j + 1] = temp
                    swapped = true
                }
            }
            
            // 交換が発生しなかった場合、ソート完了
            if (!swapped) {
                break
            }
        }
        
        return result
    }
}


