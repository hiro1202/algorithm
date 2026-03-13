package com.algorithm.bruteforce

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * 全探索アルゴリズムのテストクラス
 */
@DisplayName("全探索")
class BruteForceSearchTest {

    private lateinit var bruteForceSearch: BruteForceSearch

    @BeforeEach
    fun setUp() {
        bruteForceSearch = BruteForceSearch()
    }

    @Nested
    @DisplayName("値の探索")
    inner class SearchTest {

        @Test
        @DisplayName("配列内に存在する要素を見つけられること")
        fun findExistingElement() {
            // Given
            val array = intArrayOf(10, 20, 30, 40, 50)
            val target = 30

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(2)
        }

        @Test
        @DisplayName("配列内に存在しない要素の場合-1を返すこと")
        fun returnMinusOneForNonExistingElement() {
            // Given
            val array = intArrayOf(10, 20, 30, 40, 50)
            val target = 99

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(-1)
        }

        @Test
        @DisplayName("空の配列に対して-1を返すこと")
        fun returnMinusOneForEmptyArray() {
            // Given
            val array = intArrayOf()
            val target = 1

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(-1)
        }

        @Test
        @DisplayName("先頭の要素を見つけられること")
        fun findFirstElement() {
            // Given
            val array = intArrayOf(10, 20, 30, 40, 50)
            val target = 10

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(0)
        }

        @Test
        @DisplayName("末尾の要素を見つけられること")
        fun findLastElement() {
            // Given
            val array = intArrayOf(10, 20, 30, 40, 50)
            val target = 50

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(4)
        }

        @Test
        @DisplayName("重複する値がある場合に最初のインデックスを返すこと")
        fun returnFirstIndexForDuplicateValues() {
            // Given
            val array = intArrayOf(5, 3, 7, 3, 9)
            val target = 3

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(1)
        }

        @Test
        @DisplayName("負の数を見つけられること")
        fun findNegativeNumber() {
            // Given
            val array = intArrayOf(-5, 3, -7, 0, 9)
            val target = -7

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(2)
        }

        @Test
        @DisplayName("単一要素の配列で要素を見つけられること")
        fun findElementInSingleElementArray() {
            // Given
            val array = intArrayOf(42)
            val target = 42

            // When
            val result = bruteForceSearch.search(array, target)

            // Then
            assertThat(result).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("最小値探索")
    inner class FindMinTest {

        @Test
        @DisplayName("複数要素の配列から最小値を返すこと")
        fun findMinFromMultipleElements() {
            val array = intArrayOf(30, 10, 50, 20, 40)
            assertThat(bruteForceSearch.findMin(array)).isEqualTo(10)
        }

        @Test
        @DisplayName("最小値が先頭にある配列で正しく返すこと")
        fun findMinAtHead() {
            val array = intArrayOf(1, 5, 3, 8)
            assertThat(bruteForceSearch.findMin(array)).isEqualTo(1)
        }

        @Test
        @DisplayName("最小値が末尾にある配列で正しく返すこと")
        fun findMinAtTail() {
            val array = intArrayOf(5, 3, 8, 1)
            assertThat(bruteForceSearch.findMin(array)).isEqualTo(1)
        }

        @Test
        @DisplayName("負の数を含む配列から最小値を返すこと")
        fun findMinWithNegativeNumbers() {
            val array = intArrayOf(3, -5, 7, -10, 2)
            assertThat(bruteForceSearch.findMin(array)).isEqualTo(-10)
        }

        @Test
        @DisplayName("単一要素の配列でその値を返すこと")
        fun findMinInSingleElementArray() {
            val array = intArrayOf(42)
            assertThat(bruteForceSearch.findMin(array)).isEqualTo(42)
        }

        @Test
        @DisplayName("空の配列でIllegalArgumentExceptionを投げること")
        fun throwExceptionForEmptyArray() {
            assertThatThrownBy { bruteForceSearch.findMin(intArrayOf()) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("配列が空です")
        }
    }

    @Nested
    @DisplayName("2配列の最小合計値探索")
    inner class FindMinPairSumTest {

        @Test
        @DisplayName("2つの配列の最小値同士の合計を返すこと")
        fun returnSumOfMinValues() {
            val array1 = intArrayOf(30, 10, 50)
            val array2 = intArrayOf(20, 5, 40)
            assertThat(bruteForceSearch.findMinPairSum(array1, array2)).isEqualTo(15)
        }

        @Test
        @DisplayName("負の数を含む配列で正しく合計を返すこと")
        fun returnSumWithNegativeNumbers() {
            val array1 = intArrayOf(3, -5, 7)
            val array2 = intArrayOf(4, -2, 8)
            assertThat(bruteForceSearch.findMinPairSum(array1, array2)).isEqualTo(-7)
        }

        @Test
        @DisplayName("単一要素同士の配列で合計を返すこと")
        fun returnSumOfSingleElementArrays() {
            val array1 = intArrayOf(10)
            val array2 = intArrayOf(20)
            assertThat(bruteForceSearch.findMinPairSum(array1, array2)).isEqualTo(30)
        }

        @Test
        @DisplayName("1つ目の配列が空の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionWhenFirstArrayEmpty() {
            assertThatThrownBy { bruteForceSearch.findMinPairSum(intArrayOf(), intArrayOf(1, 2)) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }

        @Test
        @DisplayName("2つ目の配列が空の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionWhenSecondArrayEmpty() {
            assertThatThrownBy { bruteForceSearch.findMinPairSum(intArrayOf(1, 2), intArrayOf()) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }
}
