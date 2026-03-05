package com.algorithm.greedy

import kotlin.math.min

/**
 * 貪欲法によるコイン問題の実装
 * 各硬貨の額面と枚数制限が与えられたとき、目標金額を支払うために必要な最小枚数を求める
 * 大きい額面の硬貨から優先的に使用する
 * 時間計算量: O(n)（nは硬貨の種類数）
 * 空間計算量: O(1)
 */
class CoinChange {

    // 硬貨の額面（降順）
    private val denominations = listOf(500, 100, 50, 10, 5, 1)

    /**
     * 7.1 コイン問題を貪欲法で解く
     *
     * 貪欲法でコインの最小枚数を求める
     * @param amount 支払う金額
     * @param limits 各硬貨の枚数制限（denominationsと同じ順序）
     * @return 必要な最小枚数。支払えない場合は-1
     * @throws IllegalArgumentException 金額が負の場合、またはlimitsのサイズが不正な場合
     */
    fun minCoins(amount: Int, limits: List<Int>): Int {
        require(amount >= 0) { "金額は0以上である必要があります" }
        require(limits.size == denominations.size) { "枚数制限は${denominations.size}種類分必要です" }

        var remaining = amount
        var totalCoins = 0

        for (i in denominations.indices) {
            // 枚数制限がない場合の枚数
            var count = remaining / denominations[i]

            // 枚数制限を考慮
            count = min(count, limits[i])

            // 残り金額を求めて、答えに枚数を加算する
            remaining -= denominations[i] * count
            totalCoins += count
        }

        // 残り金額が0でなければ支払えない
        return if (remaining == 0) totalCoins else -1
    }
}
