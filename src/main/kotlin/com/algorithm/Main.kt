package com.algorithm

import com.algorithm.sort.BubbleSort
import com.algorithm.sort.CocktailSort

/**
 * アルゴリズムの実行例を示すメイン関数
 */
fun main() {
    println("=== アルゴリズム実行例 ===")
    
    // 共通のテストデータ
    val testData = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    
    // バブルソートのデモ
    println("\n--- バブルソート ---")
    val bubbleSort = BubbleSort()
    
    println("ソート前: ${testData.contentToString()}")
    val bubbleSorted = bubbleSort.sort(testData)
    println("ソート後: ${bubbleSorted.contentToString()}")
    println("元の配列: ${testData.contentToString()}")  // 値渡しなので元の配列は変更されない
    
    // カクテルソートのデモ
    println("\n--- カクテルソート ---")
    val cocktailSort = CocktailSort()
    
    println("ソート前: ${testData.contentToString()}")
    val cocktailSorted = cocktailSort.sort(testData)
    println("ソート後: ${cocktailSorted.contentToString()}")
    println("元の配列: ${testData.contentToString()}")  // 値渡しなので元の配列は変更されない
}