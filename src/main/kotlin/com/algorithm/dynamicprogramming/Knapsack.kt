package com.algorithm.dynamicprogramming

import kotlin.math.max

/**
 * ナップサック問題の実装
 * N個の品物があり、それぞれ重さと価値が設定されている
 * 容量Wのナップサックに入れる品物を選び、価値の合計を最大化する
 * 各品物は1つずつしか選べない
 * 時間計算量: O(nW)
 * 空間計算量: O(nW)
 */
class Knapsack {

    /**
     * 5.7 ナップサック問題に対する動的計画法
     *
     * 容量制限のあるナップサックに品物を詰めて価値を最大化する
     * @param weights 各品物の重さの配列
     * @param values 各品物の価値の配列
     * @param capacity ナップサックの容量
     * @return 最大価値
     * @throws IllegalArgumentException 配列が空の場合、サイズが不一致の場合、容量が負の場合
     */
    fun solve(weights: LongArray, values: LongArray, capacity: Int): Long {
        require(weights.isNotEmpty()) { "品物が1つ以上必要です" }
        require(weights.size == values.size) { "重さと価値の配列サイズが一致しません" }
        require(capacity >= 0) { "容量は0以上である必要があります" }

        val n = weights.size

        // dp[i][w] = 最初のi個の品物から選び、容量wのナップサックに入れたときの最大価値
        // (n+1) × (capacity+1) の2次元テーブルを全て0で初期化する
        // 行: i=0は「品物が0個」のベースケース（全て0）、i=1〜nが各品物を追加した状態
        // 列: w=0は「容量が0」のベースケース（何も入らないので0）、w=1〜capacityが各容量
        // 例: n=4, capacity=5 の場合、5行×6列のテーブルができる
        //         w=0  w=1  w=2  w=3  w=4  w=5
        //   i=0 [   0,   0,   0,   0,   0,   0 ]  ← 品物なし（ベースケース）
        //   i=1 [   0,   ?,   ?,   ?,   ?,   ? ]  ← 品物1まで考慮
        //   i=2 [   0,   ?,   ?,   ?,   ?,   ? ]  ← 品物1,2まで考慮
        //   ...
        val dp = Array(n + 1) { LongArray(capacity + 1) }

        for (i in 1..n) {
            for (w in 0..capacity) {
                // まず「品物iを選ばない」前提で、前の行（i-1）の結果をそのまま引き継ぐ
                dp[i][w] = dp[i - 1][w]
                // 品物iの重さが現在の容量w以下なら、品物iを入れるかどうか比較する
                if (weights[i - 1] <= w) {
                    // 「品物iを入れない場合」と「入れる場合」を比べて、価値が大きい方を選ぶ
                    //   入れない場合: dp[i][w]（すでに上の行で前回の結果を引き継ぎ済み）
                    //   入れる場合:   今の容量wから品物iの重さを引いた残り容量で
                    //                 前回までに稼げた最大価値に、品物iの価値を足したもの
                    dp[i][w] = max(dp[i][w], dp[i - 1][w - weights[i - 1].toInt()] + values[i - 1])
                }
            }
        }

        return dp[n][capacity]
    }
}
