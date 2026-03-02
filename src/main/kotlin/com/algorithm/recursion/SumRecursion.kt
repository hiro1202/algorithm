package com.algorithm.recursion

/**
 * 再帰を使った総和計算の実装
 * 1からNまでの総和を再帰的に求める
 * 時間計算量: O(n)
 * 空間計算量: O(n)（再帰呼び出しのスタック）
 */
class SumRecursion {

    /**
     * 1からnまでの総和を再帰的に求める
     * @param n 総和の上限値
     * @return 1からnまでの総和
     * @throws IllegalArgumentException nが0以下の場合
     */
    fun sum(n: Int): Int {
        require(n > 0) { "nは1以上の整数を指定してください" }
        // ベースケース: n=1のとき1を返す
        if (n == 1) return 1
        // 再帰ステップ: nと(1からn-1までの総和)を足す
        return n + sum(n - 1)
    }
}
