package com.algorithm.dynamicprogramming

import kotlin.math.abs
import kotlin.math.min

/**
 * 5.1 Frog 問題を動的計画法で解く
 *
 * カエルの足場ジャンプ問題（Frog 1）の実装
 * N個の足場があり、各足場に高さが設定されている
 * カエルは1つまたは2つ先の足場にジャンプでき、コストは高さの差の絶対値
 * 最初の足場から最後の足場までの最小コストを求める
 * 時間計算量: O(n)
 * 空間計算量: O(n)
 */
class FrogJump {

    /**
     * 最初の足場から最後の足場までの最小コストを求める
     * @param h 各足場の高さの配列
     * @return 最小コスト
     * @throws IllegalArgumentException 足場が1つ未満の場合
     */
    fun minCost(h: LongArray): Long {
        require(h.isNotEmpty()) { "足場が1つ以上必要です" }
        val n = h.size
        if (n == 1) return 0

        // dp[i] = 足場iに到達するまでの最小コスト
        val dp = LongArray(n) { Long.MAX_VALUE }
        dp[0] = 0

        for (i in 1 until n) {
            // 1つ前の足場からジャンプする場合
            dp[i] = dp[i - 1] + abs(h[i] - h[i - 1])
            // 2つ前の足場からジャンプする場合
            if (i >= 2) {
                dp[i] = min(dp[i], dp[i - 2] + abs(h[i] - h[i - 2]))
            }
        }

        return dp[n - 1]
    }
}
