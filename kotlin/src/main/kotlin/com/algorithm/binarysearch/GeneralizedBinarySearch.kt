package com.algorithm.binarysearch

/**
 * 条件判定関数 P(x) を使う一般化二分探索
 * P(left) = false, P(right) = true を満たす区間から、
 * P(x) = true となる最小の x を探索する。
 * 時間計算量: O(log n) (n は探索区間長 rightInit - leftInit)
 * 空間計算量: O(1)
 */
class GeneralizedBinarySearch {

    /**
     * 6.2 一般化した二分探索法の基本形
     *
     * 実行例:
     * val answer = searchFirstTrue(0, 100) { x -> x >= 10 }
     * // answer == 10
     */
    fun searchFirstTrue(leftInit: Int, rightInit: Int, predicate: (Int) -> Boolean): Int {
        require(leftInit < rightInit) { "leftInit は rightInit より小さい必要があります" }
        require(!predicate(leftInit)) { "predicate(leftInit) は false である必要があります" }
        require(predicate(rightInit)) { "predicate(rightInit) は true である必要があります" }

        var left = leftInit
        var right = rightInit

        while (right - left > 1) {
            val mid = left + (right - left) / 2
            if (predicate(mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        return right
    }
}
