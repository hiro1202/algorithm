package com.algorithm.recursion

/**
 * ユークリッドの互除法の実装
 * 2つの整数の最大公約数(GCD)を再帰的に求める
 * 時間計算量: O(log(min(a, b)))
 * 空間計算量: O(log(min(a, b)))（再帰呼び出しのスタック）
 */
class EuclideanAlgorithm {

    /**
     * 2つの整数の最大公約数を再帰的に求める
     * @param a 1つ目の整数
     * @param b 2つ目の整数
     * @return aとbの最大公約数
     * @throws IllegalArgumentException 両方とも0の場合
     */
    fun gcd(a: Int, b: Int): Int {
        require(a != 0 || b != 0) { "両方とも0にはできません" }
        // Math.abs()は絶対値を返す
        val absA = Math.abs(a)
        val absB = Math.abs(b)
        // ベースケース: bが0ならaが最大公約数
        if (absB == 0) return absA
        // 再帰ステップ: gcd(a, b) = gcd(b, a % b)
        return gcd(absB, absA % absB)
    }
}
