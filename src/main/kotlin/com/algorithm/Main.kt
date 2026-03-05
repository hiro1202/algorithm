package com.algorithm

import com.algorithm.binarysearch.BinarySearch
import com.algorithm.binarysearch.GeneralizedBinarySearch
import com.algorithm.greedy.CoinChange
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

    // 二分探索のデモ
    println("\n--- 二分探索 ---")
    val binarySearch = BinarySearch()
    val sortedData = intArrayOf(3, 5, 8, 10, 14, 17, 21, 39)
    println("配列: ${sortedData.contentToString()}")
    println("10 の位置: ${binarySearch.search(sortedData, 10)}")
    println("9 の位置: ${binarySearch.search(sortedData, 9)}")

    // 一般化二分探索のデモ
    println("\n--- 一般化二分探索 ---")
    val generalizedBinarySearch = GeneralizedBinarySearch()
    val firstTrue = generalizedBinarySearch.searchFirstTrue(0, 100) { x -> x >= 10 }
    println("P(x) = x >= 10 を満たす最小の x: $firstTrue")

    // 貪欲法（コイン問題）のデモ
    println("\n--- 貪欲法: コイン問題 ---")
    val coinChange = CoinChange()
    val amount = 1234
    val limits = listOf(10, 10, 10, 10, 10, 10)
    println("金額: ${amount}円")
    println("硬貨の枚数制限: 各10枚")
    println("最小枚数: ${coinChange.minCoins(amount, limits)}")
}
