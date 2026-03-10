package com.algorithm.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * マージソートアルゴリズムのテストクラス
 */
@DisplayName("マージソート")
class MergeSortTest {

    private lateinit var mergeSort: MergeSort

    @BeforeEach
    fun setUp() {
        mergeSort = MergeSort()
    }

    @Nested
    @DisplayName("正常系")
    inner class NormalCases {

        @Test
        @DisplayName("基本的な配列をソートできること")
        fun sortBasicArray() {
            // Given
            val input = intArrayOf(64, 34, 25, 12, 22, 11, 90)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(11, 12, 22, 25, 34, 64, 90))
            assertThat(input).isEqualTo(intArrayOf(64, 34, 25, 12, 22, 11, 90))
        }

        @Test
        @DisplayName("空の配列をソートできること")
        fun sortEmptyArray() {
            // Given
            val input = intArrayOf()

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf())
        }

        @Test
        @DisplayName("単一要素の配列をソートできること")
        fun sortSingleElementArray() {
            // Given
            val input = intArrayOf(42)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(42))
        }

        @Test
        @DisplayName("すでにソート済みの配列を処理できること")
        fun sortAlreadySortedArray() {
            // Given
            val input = intArrayOf(1, 2, 3, 4, 5)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
        }

        @Test
        @DisplayName("逆順の配列をソートできること")
        fun sortReverseSortedArray() {
            // Given
            val input = intArrayOf(5, 4, 3, 2, 1)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
        }

        @Test
        @DisplayName("同じ値を含む配列をソートできること")
        fun sortArrayWithDuplicates() {
            // Given
            val input = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9))
        }

        @Test
        @DisplayName("負の数を含む配列をソートできること")
        fun sortArrayWithNegativeNumbers() {
            // Given
            val input = intArrayOf(-3, 7, -1, 0, 5, -8, 2)

            // When
            val result = mergeSort.sort(input)

            // Then
            assertThat(result).isEqualTo(intArrayOf(-8, -3, -1, 0, 2, 5, 7))
        }
    }
}
