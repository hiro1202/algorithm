package com.algorithm.greedy

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * 貪欲法によるコイン問題のテストクラス
 */
@DisplayName("貪欲法: コイン問題")
class CoinChangeTest {

    private lateinit var coinChange: CoinChange

    @BeforeEach
    fun setUp() {
        coinChange = CoinChange()
    }

    @Nested
    @DisplayName("正常系")
    inner class NormalCases {

        @Test
        @DisplayName("各硬貨を1枚ずつ使って666円を支払えること")
        fun payWithOneOfEachCoin() {
            // Given: 666円 = 500 + 100 + 50 + 10 + 5 + 1
            val amount = 666
            val limits = listOf(1, 1, 1, 1, 1, 1)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(6)
        }

        @Test
        @DisplayName("500円硬貨のみで1000円を支払えること")
        fun payWithOnly500YenCoins() {
            // Given
            val amount = 1000
            val limits = listOf(10, 0, 0, 0, 0, 0)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(2)
        }

        @Test
        @DisplayName("1円硬貨のみで5円を支払えること")
        fun payWithOnly1YenCoins() {
            // Given
            val amount = 5
            val limits = listOf(0, 0, 0, 0, 0, 10)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(5)
        }

        @Test
        @DisplayName("500円が1枚しかないとき残りを小さい硬貨で補えること")
        fun fallbackToSmallerCoinsWhenLargeRunsOut() {
            // Given: 1000円を500円1枚 + 100円5枚で支払う
            val amount = 1000
            val limits = listOf(1, 5, 0, 0, 0, 0)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(6)
        }

        @Test
        @DisplayName("金額が0のとき0枚を返すこと")
        fun returnZeroForZeroAmount() {
            // Given
            val amount = 0
            val limits = listOf(10, 10, 10, 10, 10, 10)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(0)
        }

        @Test
        @DisplayName("十分な枚数があるとき最小枚数で支払えること")
        fun payWithMinimumCoinsWhenSufficient() {
            // Given: 615円 = 500×1 + 100×1 + 10×1 + 5×1 = 4枚
            val amount = 615
            val limits = listOf(10, 10, 10, 10, 10, 10)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(4)
        }
    }

    @Nested
    @DisplayName("支払い不可能なケース")
    inner class ImpossibleCases {

        @Test
        @DisplayName("硬貨が足りないとき-1を返すこと")
        fun returnMinusOneWhenInsufficientCoins() {
            // Given: 500円を払いたいが100円が4枚しかない
            val amount = 500
            val limits = listOf(0, 4, 0, 0, 0, 0)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(-1)
        }

        @Test
        @DisplayName("全ての硬貨が0枚で金額が正のとき-1を返すこと")
        fun returnMinusOneWhenAllCoinsZero() {
            // Given
            val amount = 100
            val limits = listOf(0, 0, 0, 0, 0, 0)

            // When
            val result = coinChange.minCoins(amount, limits)

            // Then
            assertThat(result).isEqualTo(-1)
        }
    }

    @Nested
    @DisplayName("異常系")
    inner class ErrorCases {

        @Test
        @DisplayName("金額が負のときIllegalArgumentExceptionを投げること")
        fun throwExceptionForNegativeAmount() {
            assertThatThrownBy { coinChange.minCoins(-1, listOf(1, 1, 1, 1, 1, 1)) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("金額は0以上である必要があります")
        }

        @Test
        @DisplayName("枚数制限のサイズが不正なときIllegalArgumentExceptionを投げること")
        fun throwExceptionForInvalidLimitsSize() {
            assertThatThrownBy { coinChange.minCoins(100, listOf(1, 1, 1)) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("枚数制限は6種類分必要です")
        }
    }
}
