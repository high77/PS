package main

import (
	"bufio"
	"fmt"
	"os"
)

var in = bufio.NewScanner(os.Stdin)

func nextInt() int {
	in.Scan()
	r := 0
	for _, c := range in.Bytes() {
		r *= 10
		r += int(c - '0')
	}
	return r
}

func main() {
	in.Split(bufio.ScanWords)
	S, C, sum := nextInt(), nextInt(), 0
	list := make([]int, S)
	for i := 0; i < S; i++ {
		list[i] = nextInt()
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
