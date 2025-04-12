package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	br := bufio.NewReader(os.Stdin)

	var N, ans int
	fmt.Fscan(br, &N)
	arr := make([][2]int, N)
	for i := range arr {
		fmt.Fscan(br, &arr[i][0], &arr[i][1])
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i][0] < arr[j][0]
	})

	for i := range arr {
		if ans < arr[i][0] {
			ans = arr[i][0] + arr[i][1]
		} else {
			ans += arr[i][1]
		}
	}

	fmt.Println(ans)
}
