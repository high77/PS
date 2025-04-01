package main

import (
	"bufio"
	"fmt"
	"os"
)

var br = bufio.NewReader(os.Stdin)

func main() {
	var S, C int
	fmt.Fscan(br, &S, &C)
	sum := 0
	list := make([]int, S)
	for i := 0; i < S; i++ {
		fmt.Fscan(br, &list[i])
		sum += list[i]
	}
	var s, e int = 0, sum
	for s < e {
		var mid, cnt = (s + e) / 2, 0
		for i := 0; i < S; i++ {
			cnt += list[i] / mid
		}
		if cnt >= C {
			s = mid + 1
		} else {
			e = mid
		}
	}
	fmt.Println(sum - (s-1)*C)
}
