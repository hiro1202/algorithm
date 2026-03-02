package com.algorithm.recursion

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 再帰を使った総和計算のテストクラス
 */
@DisplayName("再帰による総和計算")
class SumRecursionTest {

    private lateinit var sumRecursion: SumRecursion

    @BeforeEach
    fun setUp() {
        sumRecursion = SumRecursion()
    }

    @Test
    @DisplayName("n=1のとき1を返す")
    fun `n=1のとき1を返すこと`() {
        assertThat(sumRecursion.sum(1)).isEqualTo(1)
    }

    @Test
    @DisplayName("n=5のとき15を返す")
    fun `n=5のとき15を返すこと`() {
        // 1 + 2 + 3 + 4 + 5 = 15
        assertThat(sumRecursion.sum(5)).isEqualTo(15)
    }

    @Test
    @DisplayName("n=10のとき55を返す")
    fun `n=10のとき55を返すこと`() {
        // 1 + 2 + ... + 10 = 55
        assertThat(sumRecursion.sum(10)).isEqualTo(55)
    }

    @Test
    @DisplayName("n=100のとき5050を返す")
    fun `n=100のとき5050を返すこと`() {
        assertThat(sumRecursion.sum(100)).isEqualTo(5050)
    }

    @Test
    @DisplayName("nが0以下の場合に例外が発生する")
    fun `nが0以下の場合にIllegalArgumentExceptionを投げること`() {
        assertThatThrownBy { sumRecursion.sum(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("nは1以上の整数を指定してください")
    }

    @Test
    @DisplayName("nが負の数の場合に例外が発生する")
    fun `nが負の数の場合にIllegalArgumentExceptionを投げること`() {
        assertThatThrownBy { sumRecursion.sum(-5) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
