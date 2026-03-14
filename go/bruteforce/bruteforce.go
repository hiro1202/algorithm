// Package bruteforce は全探索アルゴリズムを提供する。
package bruteforce

import "errors"

// Search は配列を先頭から順に走査し、target と一致する最初のインデックスを返す。
// 見つからない場合は -1 と false を返す。
//
// 時間計算量: O(n), 空間計算量: O(1)
func Search(a []int, target int) (int, bool) {
	for i, v := range a {
		if v == target {
			return i, true
		}
	}
	return -1, false
}

// FindMin は配列の最小値を返す。
// 配列が空の場合は error を返す。
//
// 時間計算量: O(n), 空間計算量: O(1)
func FindMin(a []int) (int, error) {
	if len(a) == 0 {
		return 0, errors.New("配列が空です")
	}
	min := a[0]
	for _, v := range a[1:] {
		if v < min {
			min = v
		}
	}
	return min, nil
}

// FindMinPairSum は2つの配列からそれぞれ1つずつ要素を選んだときの合計の最小値を返す。
// いずれかの配列が空の場合は error を返す。
//
// 時間計算量: O(n*m), 空間計算量: O(1)
func FindMinPairSum(a, b []int) (int, error) {
	if len(a) == 0 || len(b) == 0 {
		return 0, errors.New("配列が空です")
	}
	min := a[0] + b[0]
	for _, x := range a {
		for _, y := range b {
			if s := x + y; s < min {
				min = s
			}
		}
	}
	return min, nil
}
