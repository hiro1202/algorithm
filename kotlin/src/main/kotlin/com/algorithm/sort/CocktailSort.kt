package com.algorithm.sort

/**
 * カクテルソート（シェーカーソート）アルゴリズムの実装
 * バブルソートの改良版で、両方向に要素を動かすことで効率を向上させる
 * 時間計算量: O(n²) 平均・最悪時、O(n) 最良時
 * 空間計算量: O(1)
 */
class CocktailSort {
    
    /**
     * カクテルソートを実行する
     * @param array ソート対象の配列（値渡し）
     * @return ソート済みの配列（新しい配列を返す）
     */
    fun sort(array: IntArray): IntArray {
        val result = array.copyOf()
        val n = result.size
        
        var left = 0
        var right = n - 1
        var swapped = true
        
        while (swapped && left < right) {
            swapped = false
            
            // 左から右へのパス：最大値を右端に移動
            for (i in left until right) {
                if (result[i] > result[i + 1]) {
                    swap(result, i, i + 1)
                    swapped = true
                }
            }
            
            // 右端が確定したので範囲を縮小
            right--
            
            // 交換が発生しなかった場合、ソート完了
            if (!swapped) break
            
            swapped = false
            
            // 右から左へのパス：最小値を左端に移動
            for (i in right downTo left + 1) {
                if (result[i] < result[i - 1]) {
                    swap(result, i, i - 1)
                    swapped = true
                }
            }
            
            // 左端が確定したので範囲を縮小
            left++
        }
        
        return result
    }
    
    /**
     * 配列内の2つの要素を交換する
     */
    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}

