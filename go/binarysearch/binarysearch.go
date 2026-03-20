// Package binarysearch は二分探索アルゴリズムを提供する。
package binarysearch

// Search はソート済み配列に対して二分探索を実行し、target のインデックスを返す。
// 見つからない場合は -1 と false を返す。
//
// 時間計算量: O(log n), 空間計算量: O(1)
func Search(a []int, target int) (int, bool) {
	left, right := 0, len(a)-1
	for left <= right {
		mid := left + (right-left)/2
		switch {
		case a[mid] == target:
			return mid, true
		case a[mid] > target:
			right = mid - 1
		default:
			left = mid + 1
		}
	}
	return -1, false
}
