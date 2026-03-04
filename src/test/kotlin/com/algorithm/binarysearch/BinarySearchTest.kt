package com.algorithm.binarysearch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("二分探索")
class BinarySearchTest {

    private lateinit var binarySearch: BinarySearch

    @BeforeEach
    fun setUp() {
        binarySearch = BinarySearch()
    }

    @Test
    @DisplayName("配列内に存在する値を探索できる")
    fun `配列内に存在する値のインデックスを返すこと`() {
        val array = intArrayOf(3, 5, 8, 10, 14, 17, 21, 39)

        assertThat(binarySearch.search(array, 10)).isEqualTo(3)
        assertThat(binarySearch.search(array, 3)).isEqualTo(0)
        assertThat(binarySearch.search(array, 39)).isEqualTo(7)
    }

    @Test
    @DisplayName("配列内に存在しない値は-1を返す")
    fun `配列内に存在しない値の場合-1を返すこと`() {
        val array = intArrayOf(3, 5, 8, 10, 14, 17, 21, 39)

        assertThat(binarySearch.search(array, -100)).isEqualTo(-1)
        assertThat(binarySearch.search(array, 9)).isEqualTo(-1)
        assertThat(binarySearch.search(array, 100)).isEqualTo(-1)
    }

    @Test
    @DisplayName("空配列の場合は-1を返す")
    fun `空配列の場合-1を返すこと`() {
        val array = intArrayOf()

        assertThat(binarySearch.search(array, 1)).isEqualTo(-1)
    }
}
