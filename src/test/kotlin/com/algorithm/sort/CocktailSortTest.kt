package com.algorithm.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * カクテルソートアルゴリズムのテストクラス
 */
@DisplayName("カクテルソート")
class CocktailSortTest {
    
    private lateinit var cocktailSort: CocktailSort
    
    @BeforeEach
    fun setUp() {
        cocktailSort = CocktailSort()
    }
    
    @Test
    @DisplayName("基本的なソート機能のテスト")
    fun `基本的な配列をソートできること`() {
        // Given
        val input = intArrayOf(64, 34, 25, 12, 22, 11, 90)
        val expected = intArrayOf(11, 12, 22, 25, 34, 64, 90)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
        // 元の配列が変更されていないことを確認
        assertThat(input).isEqualTo(intArrayOf(64, 34, 25, 12, 22, 11, 90))
    }
    
    @Test
    @DisplayName("空の配列のテスト")
    fun `空の配列をソートできること`() {
        // Given
        val input = intArrayOf()
        val expected = intArrayOf()
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("単一要素の配列のテスト")
    fun `単一要素の配列をソートできること`() {
        // Given
        val input = intArrayOf(42)
        val expected = intArrayOf(42)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("すでにソート済みの配列のテスト")
    fun `すでにソート済みの配列を処理できること`() {
        // Given
        val input = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("逆順の配列のテスト")
    fun `逆順の配列をソートできること`() {
        // Given
        val input = intArrayOf(5, 4, 3, 2, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("同じ値を含む配列のテスト")
    fun `同じ値を含む配列をソートできること`() {
        // Given
        val input = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        val expected = intArrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("負の数を含む配列のテスト")
    fun `負の数を含む配列をソートできること`() {
        // Given
        val input = intArrayOf(-3, 7, -1, 0, 5, -8, 2)
        val expected = intArrayOf(-8, -3, -1, 0, 2, 5, 7)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    @DisplayName("両端が最小・最大値の配列のテスト")
    fun `両端が最小最大値の配列をソートできること`() {
        // Given - カクテルソートが効果的なケース
        val input = intArrayOf(1, 8, 6, 4, 2, 9)
        val expected = intArrayOf(1, 2, 4, 6, 8, 9)
        
        // When
        val result = cocktailSort.sort(input)
        
        // Then
        assertThat(result).isEqualTo(expected)
    }
    
}