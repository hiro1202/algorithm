package com.algorithm.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 線形探索アルゴリズムのテストクラス
 */
@DisplayName("線形探索")
class LinearSearchTest {

    private lateinit var linearSearch: LinearSearch

    @BeforeEach
    fun setUp() {
        linearSearch = LinearSearch()
    }

    @Test
    @DisplayName("要素が見つかる場合のテスト")
    fun `配列内に存在する要素を見つけられること`() {
        // Given
        val array = intArrayOf(10, 20, 30, 40, 50)
        val target = 30

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(2)
    }

    @Test
    @DisplayName("要素が見つからない場合のテスト")
    fun `配列内に存在しない要素の場合-1を返すこと`() {
        // Given
        val array = intArrayOf(10, 20, 30, 40, 50)
        val target = 99

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    @DisplayName("空の配列のテスト")
    fun `空の配列に対して-1を返すこと`() {
        // Given
        val array = intArrayOf()
        val target = 1

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    @DisplayName("先頭の要素を探索するテスト")
    fun `先頭の要素を見つけられること`() {
        // Given
        val array = intArrayOf(10, 20, 30, 40, 50)
        val target = 10

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(0)
    }

    @Test
    @DisplayName("末尾の要素を探索するテスト")
    fun `末尾の要素を見つけられること`() {
        // Given
        val array = intArrayOf(10, 20, 30, 40, 50)
        val target = 50

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(4)
    }

    @Test
    @DisplayName("重複する値がある場合、最初のインデックスを返すテスト")
    fun `重複する値がある場合に最初のインデックスを返すこと`() {
        // Given
        val array = intArrayOf(5, 3, 7, 3, 9)
        val target = 3

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(1)
    }

    @Test
    @DisplayName("負の数を探索するテスト")
    fun `負の数を見つけられること`() {
        // Given
        val array = intArrayOf(-5, 3, -7, 0, 9)
        val target = -7

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(2)
    }

    @Test
    @DisplayName("単一要素の配列で見つかるテスト")
    fun `単一要素の配列で要素を見つけられること`() {
        // Given
        val array = intArrayOf(42)
        val target = 42

        // When
        val result = linearSearch.search(array, target)

        // Then
        assertThat(result).isEqualTo(0)
    }
}
