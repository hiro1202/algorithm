package com.algorithm.recursion

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * ユークリッドの互除法のテストクラス
 */
@DisplayName("ユークリッドの互除法")
class EuclideanAlgorithmTest {

    private lateinit var euclidean: EuclideanAlgorithm

    @BeforeEach
    fun setUp() {
        euclidean = EuclideanAlgorithm()
    }

    @Test
    @DisplayName("基本的な最大公約数の計算")
    fun `51と15の最大公約数は3であること`() {
        assertThat(euclidean.gcd(51, 15)).isEqualTo(3)
    }

    @Test
    @DisplayName("互いに素な場合")
    fun `互いに素な場合に1を返すこと`() {
        assertThat(euclidean.gcd(13, 7)).isEqualTo(1)
    }

    @Test
    @DisplayName("同じ値の場合")
    fun `同じ値の場合にその値を返すこと`() {
        assertThat(euclidean.gcd(12, 12)).isEqualTo(12)
    }

    @Test
    @DisplayName("一方が0の場合")
    fun `一方が0の場合にもう一方の値を返すこと`() {
        assertThat(euclidean.gcd(5, 0)).isEqualTo(5)
        assertThat(euclidean.gcd(0, 8)).isEqualTo(8)
    }

    @Test
    @DisplayName("引数の順序に依存しない")
    fun `引数の順序を入れ替えても同じ結果を返すこと`() {
        assertThat(euclidean.gcd(12, 8)).isEqualTo(euclidean.gcd(8, 12))
    }

    @Test
    @DisplayName("大きな数の計算")
    fun `大きな数でも正しく計算できること`() {
        assertThat(euclidean.gcd(1071, 462)).isEqualTo(21)
    }

    @Test
    @DisplayName("負の数を含む場合")
    fun `負の数を含む場合でも正しく計算できること`() {
        assertThat(euclidean.gcd(-12, 8)).isEqualTo(4)
        assertThat(euclidean.gcd(12, -8)).isEqualTo(4)
        assertThat(euclidean.gcd(-12, -8)).isEqualTo(4)
    }

    @Test
    @DisplayName("両方0の場合に例外が発生する")
    fun `両方0の場合にIllegalArgumentExceptionを投げること`() {
        assertThatThrownBy { euclidean.gcd(0, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("両方とも0にはできません")
    }
}
