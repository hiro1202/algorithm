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
        @DisplayName("F(0) = 0")
        fun `F(0)は0を返すこと`() {
            assertThat(fibonacci.fib(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1) = 1")
        fun `F(1)は1を返すこと`() {
            assertThat(fibonacci.fib(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(2) = 1")
        fun `F(2)は1を返すこと`() {
            assertThat(fibonacci.fib(2)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(3) = 2")
        fun `F(3)は2を返すこと`() {
            assertThat(fibonacci.fib(3)).isEqualTo(2)
        }

        @Test
        @DisplayName("F(5) = 5")
        fun `F(5)は5を返すこと`() {
            // 0, 1, 1, 2, 3, 5
            assertThat(fibonacci.fib(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10) = 55")
        fun `F(10)は55を返すこと`() {
            // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
            assertThat(fibonacci.fib(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("負の数の場合に例外が発生する")
        fun `負の数の場合にIllegalArgumentExceptionを投げること`() {
            assertThatThrownBy { fibonacci.fib(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("nは0以上の整数を指定してください")
        }
    }

    @Nested
    @DisplayName("ループ版")
    inner class FibLoopTest {

        @Test
        @DisplayName("F(0) = 0")
        fun `F(0)は0を返すこと`() {
            assertThat(fibonacci.fibLoop(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1) = 1")
        fun `F(1)は1を返すこと`() {
            assertThat(fibonacci.fibLoop(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(5) = 5")
        fun `F(5)は5を返すこと`() {
            assertThat(fibonacci.fibLoop(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10) = 55")
        fun `F(10)は55を返すこと`() {
            assertThat(fibonacci.fibLoop(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("再帰版と同じ結果を返す")
        fun `再帰版と同じ結果を返すこと`() {
            for (i in 0..20) {
                assertThat(fibonacci.fibLoop(i)).isEqualTo(fibonacci.fib(i))
            }
        }

        @Test
        @DisplayName("負の数の場合に例外が発生する")
        fun `負の数の場合にIllegalArgumentExceptionを投げること`() {
            assertThatThrownBy { fibonacci.fibLoop(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Nested
    @DisplayName("メモ化再帰版")
    inner class FibMemoTest {

        @Test
        @DisplayName("F(0) = 0")
        fun `F(0)は0を返すこと`() {
            assertThat(fibonacci.fibMemo(0)).isEqualTo(0)
        }

        @Test
        @DisplayName("F(1) = 1")
        fun `F(1)は1を返すこと`() {
            assertThat(fibonacci.fibMemo(1)).isEqualTo(1)
        }

        @Test
        @DisplayName("F(5) = 5")
        fun `F(5)は5を返すこと`() {
            assertThat(fibonacci.fibMemo(5)).isEqualTo(5)
        }

        @Test
        @DisplayName("F(10) = 55")
        fun `F(10)は55を返すこと`() {
            assertThat(fibonacci.fibMemo(10)).isEqualTo(55)
        }

        @Test
        @DisplayName("再帰版と同じ結果を返す")
        fun `再帰版と同じ結果を返すこと`() {
            for (i in 0..20) {
                assertThat(fibonacci.fibMemo(i)).isEqualTo(fibonacci.fib(i))
            }
        }

        @Test
        @DisplayName("負の数の場合に例外が発生する")
        fun `負の数の場合にIllegalArgumentExceptionを投げること`() {
            assertThatThrownBy { fibonacci.fibMemo(-1) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }
}
