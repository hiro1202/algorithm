package binarysearch

import "testing"

func TestSearch(t *testing.T) {
	tests := []struct {
		name      string
		a         []int
		target    int
		wantIndex int
		wantFound bool
	}{
		{"中間の要素", []int{10, 20, 30, 40, 50}, 30, 2, true},
		{"先頭の要素", []int{10, 20, 30, 40, 50}, 10, 0, true},
		{"末尾の要素", []int{10, 20, 30, 40, 50}, 50, 4, true},
		{"存在しない要素（範囲内）", []int{10, 20, 30, 40, 50}, 25, -1, false},
		{"存在しない要素（範囲外・大）", []int{10, 20, 30, 40, 50}, 99, -1, false},
		{"存在しない要素（範囲外・小）", []int{10, 20, 30, 40, 50}, 1, -1, false},
		{"空の配列", []int{}, 1, -1, false},
		{"単一要素（一致）", []int{42}, 42, 0, true},
		{"単一要素（不一致）", []int{42}, 99, -1, false},
		{"負の数を含むソート済み配列", []int{-10, -5, 0, 3, 7}, -5, 1, true},
		{"2要素（先頭一致）", []int{1, 2}, 1, 0, true},
		{"2要素（末尾一致）", []int{1, 2}, 2, 1, true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, found := Search(tt.a, tt.target)
			if got != tt.wantIndex || found != tt.wantFound {
				t.Errorf("Search(%v, %d) = (%d, %v), want (%d, %v)",
					tt.a, tt.target, got, found, tt.wantIndex, tt.wantFound)
			}
		})
	}
}
