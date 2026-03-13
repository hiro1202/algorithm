package com.algorithm.recursion

/**
 * フィボナッチ数列の実装
 * n番目のフィボナッチ数を再帰的に求める
 * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
 * 時間計算量: O(2^n)
 * 空間計算量: O(n)（再帰呼び出しのスタック）
 */
class Fibonacci {

    /**
     * 4.5 フィボナッチ数列を求める再帰関数
     *
     * n番目のフィボナッチ数を再帰的に求める
     * @param n フィボナッチ数列のインデックス（0始まり）
     * @return n番目のフィボナッチ数
     * @throws IllegalArgumentException nが負の数の場合
     */
    fun fib(n: Int): Int {
        require(n >= 0) { "nは0以上の整数を指定してください" }
        // ベースケース: F(0) = 0, F(1) = 1
        if (n == 0) return 0
        if (n == 1) return 1
        // 再帰ステップ: F(n) = F(n-1) + F(n-2)
        return fib(n - 1) + fib(n - 2)
    }

    /**
     * n番目のフィボナッチ数をforループで求める
     * 時間計算量: O(n)
     * 空間計算量: O(1)
     * @param n フィボナッチ数列のインデックス（0始まり）
     * @return n番目のフィボナッチ数
     * @throws IllegalArgumentException nが負の数の場合
     */
    fun fibLoop(n: Int): Int {
        require(n >= 0) { "nは0以上の整数を指定してください" }
        if (n == 0) return 0
        // 直前の2つの値を保持して順に計算する
        var prev = 0
        var current = 1
        for (i in 2..n) {
            val next = prev + current
            prev = current
            current = next
        }
        return current
    }

    /**
     * n番目のフィボナッチ数をメモ化再帰（動的計画法）で求める
     * 一度計算した結果を配列に保存し、同じ計算を繰り返さない
     * 時間計算量: O(n)
     * 空間計算量: O(n)（メモ用の配列）
     * @param n フィボナッチ数列のインデックス（0始まり）
     * @return n番目のフィボナッチ数
     * @throws IllegalArgumentException nが負の数の場合
     */
    fun fibMemo(n: Int): Int {
        require(n >= 0) { "nは0以上の整数を指定してください" }
        // メモ用の配列（-1は未計算を表す）
        val memo = IntArray(n + 1) { -1 }
        return fibMemoHelper(n, memo)
    }

    private fun fibMemoHelper(n: Int, memo: IntArray): Int {
        // 計算済みならメモから返す
        if (memo[n] != -1) return memo[n]
        // ベースケース
        val result = if (n == 0) 0
        else if (n == 1) 1
        // 再帰ステップ（結果はメモに保存される）
        else fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo)
        memo[n] = result
        return result
    }
}
