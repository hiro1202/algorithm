package com.algorithm.recursion

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * フィボナッチ数列のテストクラス
 */
@DisplayName("フィボナッチ数列")
class FibonacciTest {

    private lateinit var fibonacci: Fibonacci

    @BeforeEach
    fun setUp() {
        fibonacci = Fibonacci()
    }

    @Nested
    @DisplayName("再帰版")
    inner class FibTest {

        @Test
        @DisplayName("F(0)が0を返すこと")
        fun returnZeroForFibOfZero() {
            assertThat(fibonacci.fib(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1)が1を返すこと")
        fun returnOneForFibOfOne() {
            assertThat(fibonacci.fib(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(2)が1を返すこと")
        fun returnOneForFibOfTwo() {
            assertThat(fibonacci.fib(2)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(3)が2を返すこと")
        fun returnTwoForFibOfThree() {
            assertThat(fibonacci.fib(3)).isEqualTo(2)
        }

        @Test
        @DisplayName("F(5)が5を返すこと")
        fun returnFiveForFibOfFive() {
            // 0, 1, 1, 2, 3, 5
            assertThat(fibonacci.fib(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10)が55を返すこと")
        fun returnFiftyFiveForFibOfTen() {
            // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
            assertThat(fibonacci.fib(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("負の数の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionForNegativeInput() {
            assertThatThrownBy { fibonacci.fib(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("nは0以上の整数を指定してください")
        }
    }

    @Nested
    @DisplayName("ループ版")
    inner class FibLoopTest {

        @Test
        @DisplayName("F(0)が0を返すこと")
        fun returnZeroForFibLoopOfZero() {
            assertThat(fibonacci.fibLoop(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1)が1を返すこと")
        fun returnOneForFibLoopOfOne() {
            assertThat(fibonacci.fibLoop(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(5)が5を返すこと")
        fun returnFiveForFibLoopOfFive() {
            assertThat(fibonacci.fibLoop(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10)が55を返すこと")
        fun returnFiftyFiveForFibLoopOfTen() {
            assertThat(fibonacci.fibLoop(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("再帰版と同じ結果を返すこと")
        fun returnSameResultAsRecursiveVersion() {
            for (i in 0..20) {
                assertThat(fibonacci.fibLoop(i)).isEqualTo(fibonacci.fib(i))
            }
        }

        @Test
        @DisplayName("負の数の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionForNegativeInput() {
            assertThatThrownBy { fibonacci.fibLoop(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Nested
    @DisplayName("メモ化再帰版")
    inner class FibMemoTest {

        @Test
        @DisplayName("F(0)が0を返すこと")
        fun returnZeroForFibMemoOfZero() {
            assertThat(fibonacci.fibMemo(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1)が1を返すこと")
        fun returnOneForFibMemoOfOne() {
            assertThat(fibonacci.fibMemo(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(5)が5を返すこと")
        fun returnFiveForFibMemoOfFive() {
            assertThat(fibonacci.fibMemo(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10)が55を返すこと")
        fun returnFiftyFiveForFibMemoOfTen() {
            assertThat(fibonacci.fibMemo(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("再帰版と同じ結果を返すこと")
        fun returnSameResultAsRecursiveVersion() {
            for (i in 0..20) {
                assertThat(fibonacci.fibMemo(i)).isEqualTo(fibonacci.fib(i))
            }
        }

        @Test
        @DisplayName("負の数の場合にIllegalArgumentExceptionを投げること")
        fun throwExceptionForNegativeInput() {
            assertThatThrownBy { fibonacci.fibMemo(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }
}
