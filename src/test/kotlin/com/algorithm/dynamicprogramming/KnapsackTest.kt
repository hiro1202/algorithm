package com.algorithm.dynamicprogramming

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * ナップサック問題のテストクラス
 */
@DisplayName("ナップサック問題")
class KnapsackTest {

    private lateinit var knapsack: Knapsack

    @BeforeEach
    fun setUp() {
        knapsack = Knapsack()
    }

    @Nested
    @DisplayName("正常系")
    inner class NormalCases {

        @Test
        @DisplayName("品物を選択して最大価値を求められること")
        fun solveBasicKnapsack() {
            // Given
            val weights = longArrayOf(2, 1, 3, 2)
            val values = longArrayOf(3, 2, 6, 1)
            val capacity = 5

            // When
            val result = knapsack.solve(weights, values, capacity)

            // Then — 品物1(w=2,v=3) + 品物3(w=3,v=6) = w=5, v=9
            assertThat(result).isEqualTo(9)
        }

        @Test
        @DisplayName("容量が0の場合は0を返すこと")
        fun returnZeroForZeroCapacity() {
            // Given
            val weights = longArrayOf(2, 3)
            val values = longArrayOf(3, 4)

            // When
            val result = knapsack.solve(weights, values, 0)

            // Then
            assertThat(result).isEqualTo(0)
        }

        @Test
        @DisplayName("全品物が入る場合に全価値の合計を返すこと")
        fun returnTotalValueWhenAllItemsFit() {
            // Given
            val weights = longArrayOf(1, 2, 3)
            val values = longArrayOf(10, 20, 30)
            val capacity = 10

            // When
            val result = knapsack.solve(weights, values, capacity)

            // Then
            assertThat(result).isEqualTo(60)
        }

        @Test
        @DisplayName("1つも入らない場合に0を返すこと")
        fun returnZeroWhenNoItemFits() {
            // Given
            val weights = longArrayOf(5, 6, 7)
            val values = longArrayOf(10, 20, 30)
            val capacity = 4

            // When
            val result = knapsack.solve(weights, values, capacity)

            // Then
            assertThat(result).isEqualTo(0)
        }

        @Test
        @DisplayName("品物が1つで容量に入る場合にその価値を返すこと")
        fun returnValueForSingleItemThatFits() {
            // Given
            val weights = longArrayOf(3)
            val values = longArrayOf(5)

            // When
            val result = knapsack.solve(weights, values, 3)

            // Then
            assertThat(result).isEqualTo(5)
        }

        @Test
        @DisplayName("品物が1つで容量に入らない場合に0を返すこと")
        fun returnZeroForSingleItemThatDoesNotFit() {
            // Given
            val weights = longArrayOf(5)
            val values = longArrayOf(10)

            // When
            val result = knapsack.solve(weights, values, 3)

            // Then
            assertThat(result).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("異常系")
    inner class ErrorCases {

        @Test
        @DisplayName("空の配列でIllegalArgumentExceptionを投げること")
        fun throwExceptionForEmptyArray() {
            assertThatThrownBy { knapsack.solve(longArrayOf(), longArrayOf(), 10) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("品物が1つ以上必要です")
        }

        @Test
        @DisplayName("weightsとvaluesのサイズ不一致でIllegalArgumentExceptionを投げること")
        fun throwExceptionForMismatchedArraySizes() {
            assertThatThrownBy { knapsack.solve(longArrayOf(1, 2), longArrayOf(10), 5) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("重さと価値の配列サイズが一致しません")
        }

        @Test
        @DisplayName("容量が負の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionForNegativeCapacity() {
            assertThatThrownBy { knapsack.solve(longArrayOf(1), longArrayOf(10), -1) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("容量は0以上である必要があります")
        }
    }
}
