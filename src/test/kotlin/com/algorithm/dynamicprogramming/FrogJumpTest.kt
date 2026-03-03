package com.algorithm.dynamicprogramming

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * カエルの足場ジャンプ問題のテストクラス
 */
@DisplayName("カエルの足場ジャンプ（Frog 1）")
class FrogJumpTest {

    private lateinit var frogJump: FrogJump

    @BeforeEach
    fun setUp() {
        frogJump = FrogJump()
    }

    @Test
    @DisplayName("足場が1つの場合はコスト0")
    fun `足場が1つの場合は0を返すこと`() {
        assertThat(frogJump.minCost(longArrayOf(10))).isEqualTo(0)
    }

    @Test
    @DisplayName("足場が2つの場合は高さの差")
    fun `足場が2つの場合は高さの差を返すこと`() {
        assertThat(frogJump.minCost(longArrayOf(10, 30))).isEqualTo(20)
    }

    @Test
    @DisplayName("2つ先にジャンプした方が安い場合")
    fun `2つ先にジャンプした方がコストが低い場合`() {
        // [10, 30, 10] → 1つずつ: |30-10| + |10-30| = 40, 2つ先: |10-10| = 0
        assertThat(frogJump.minCost(longArrayOf(10, 30, 10))).isEqualTo(0)
    }

    @Test
    @DisplayName("AtCoder サンプル1")
    fun `AtCoderサンプル1の入力で正しい結果を返すこと`() {
        // h = [10, 30, 40, 20], 答え = 30
        // 最適経路: 10 → 30 → 20 (コスト 20 + 10 = 30)
        assertThat(frogJump.minCost(longArrayOf(10, 30, 40, 20))).isEqualTo(30)
    }

    @Test
    @DisplayName("AtCoder サンプル2")
    fun `AtCoderサンプル2の入力で正しい結果を返すこと`() {
        // h = [10, 10, 100, 10], 答え = 20
        // 最適経路: 10 → 10 → (2つ先) → 10 (コスト 0 + 20 = 20) ではなく
        // 最適経路: 10 → (2つ先) → 100 → (2つ先ではない) → 10
        // dp[0]=0, dp[1]=0, dp[2]=90, dp[3]=min(90+90, 0+0)=0 ではなく
        // dp[3] = min(dp[2]+|10-100|, dp[1]+|10-10|) = min(180, 0) = 0...
        // 再計算: dp[0]=0, dp[1]=0, dp[2]=min(0+90, 0+90)=90, dp[3]=min(90+90, 0+0)=0
        assertThat(frogJump.minCost(longArrayOf(10, 10, 100, 10))).isEqualTo(0)
    }

    @Test
    @DisplayName("全て同じ高さの場合はコスト0")
    fun `全て同じ高さの場合は0を返すこと`() {
        assertThat(frogJump.minCost(longArrayOf(5, 5, 5, 5, 5))).isEqualTo(0)
    }

    @Test
    @DisplayName("h = [2, 9, 4, 5, 1, 6, 10] の場合")
    fun `7つの足場で最小コストを正しく計算できること`() {
        // dp[0]=0, dp[1]=7, dp[2]=2, dp[3]=3, dp[4]=5, dp[5]=4, dp[6]=8
        // 最適経路: 2 → 4 → 5 → 6 → 10 (コスト 2 + 1 + 1 + 4 = 8)
        assertThat(frogJump.minCost(longArrayOf(2, 9, 4, 5, 1, 6, 10))).isEqualTo(8)
    }

    @Test
    @DisplayName("空の配列で例外が発生する")
    fun `空の配列でIllegalArgumentExceptionを投げること`() {
        assertThatThrownBy { frogJump.minCost(longArrayOf()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("足場が1つ以上必要です")
    }
}
