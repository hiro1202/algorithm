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
    @DisplayName("条件を満たす最小の値を返すこと")
    fun returnFirstTrueValue() {
        val result = generalizedBinarySearch.searchFirstTrue(0, 100) { x -> x >= 10 }
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("right-leftが1の場合rightを返すこと")
    fun returnRightWhenAdjacentBoundary() {
        val result = generalizedBinarySearch.searchFirstTrue(9, 10) { x -> x >= 10 }
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("leftInitがrightInit以上の場合に例外を投げること")
    fun throwExceptionWhenLeftNotLessThanRight() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(10, 10) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("leftInit は rightInit より小さい必要があります")
    }

    @Test
    @DisplayName("predicate(leftInit)がtrueの場合に例外を投げること")
    fun throwExceptionWhenPredicateLeftIsTrue() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(10, 100) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("predicate(leftInit) は false である必要があります")
    }

    @Test
    @DisplayName("predicate(rightInit)がfalseの場合に例外を投げること")
    fun throwExceptionWhenPredicateRightIsFalse() {
        assertThatThrownBy {
            generalizedBinarySearch.searchFirstTrue(0, 9) { x -> x >= 10 }
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("predicate(rightInit) は true である必要があります")
    }
}
