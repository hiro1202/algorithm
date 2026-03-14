package bruteforce

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
		{"存在しない要素", []int{10, 20, 30, 40, 50}, 99, -1, false},
		{"空の配列", []int{}, 1, -1, false},
		{"重複値は最初に見つかった位置を返す", []int{5, 3, 7, 3, 9}, 3, 1, true},
		{"負の数", []int{-5, 3, -7, 0, 9}, -7, 2, true},
		{"単一要素", []int{42}, 42, 0, true},
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

func TestFindMin(t *testing.T) {
	tests := []struct {
		name    string
		a       []int
		want    int
		wantErr bool
	}{
		{"複数要素", []int{30, 10, 50, 20, 40}, 10, false},
		{"先頭が最小", []int{1, 5, 3, 8}, 1, false},
		{"末尾が最小", []int{5, 3, 8, 1}, 1, false},
		{"負の数を含む", []int{3, -5, 7, -10, 2}, -10, false},
		{"単一要素", []int{42}, 42, false},
		{"空の配列", []int{}, 0, true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := FindMin(tt.a)
			if (err != nil) != tt.wantErr {
				t.Fatalf("FindMin(%v) error = %v, wantErr %v", tt.a, err, tt.wantErr)
			}
			if !tt.wantErr && got != tt.want {
				t.Errorf("FindMin(%v) = %d, want %d", tt.a, got, tt.want)
			}
		})
	}
}

func TestFindMinPairSum(t *testing.T) {
	tests := []struct {
		name    string
		a, b    []int
		want    int
		wantErr bool
	}{
		{"通常ケース", []int{30, 10, 50}, []int{20, 5, 40}, 15, false},
		{"負の数を含む", []int{3, -5, 7}, []int{4, -2, 8}, -7, false},
		{"単一要素同士", []int{10}, []int{20}, 30, false},
		{"1つ目が空", []int{}, []int{1, 2}, 0, true},
		{"2つ目が空", []int{1, 2}, []int{}, 0, true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := FindMinPairSum(tt.a, tt.b)
			if (err != nil) != tt.wantErr {
				t.Fatalf("FindMinPairSum(%v, %v) error = %v, wantErr %v", tt.a, tt.b, err, tt.wantErr)
			}
			if !tt.wantErr && got != tt.want {
				t.Errorf("FindMinPairSum(%v, %v) = %d, want %d", tt.a, tt.b, got, tt.want)
			}
		})
	}
}
