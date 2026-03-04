package com.algorithm.binarysearch

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("一般化二分探索")
class GeneralizedBinarySearchTest {

    private lateinit var generalizedBinarySearch: GeneralizedBinarySearch

    @BeforeEach
    fun setUp() {
        generalizedBinarySearch = GeneralizedBinarySearch()
    }

    @Test
    @DisplayName("P(x)=trueとなる最小のxを返す")
    fun `条件を満たす最小の値を返すこと`() {
        val result = generalizedBinarySearch.searchFirstTrue(0, 100) { x -> x >= 10 }
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("境界が隣接している場合はrightを返す")
    fun `right-leftが1の場合rightを返すこと`() {
        val result = generalizedBinarySearch.searchFirstTrue(9, 10) { x -> x >= 10 }
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("leftInitがrightInit以上の場合は例外")
    fun `leftInitがrightInit以上の場合に例外を投げること`() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(10, 10) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("leftInit は rightInit より小さい必要があります")
    }

    @Test
    @DisplayName("predicate(leftInit)=trueの場合は例外")
    fun `predicate_leftInit_trueの場合に例外を投げること`() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(10, 100) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("predicate(leftInit) は false である必要があります")
    }

    @Test
    @DisplayName("predicate(rightInit)=falseの場合は例外")
    fun `predicate_rightInit_falseの場合に例外を投げること`() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(0, 9) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("predicate(rightInit) は true である必要があります")
    }
}
