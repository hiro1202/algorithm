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
}
