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
	flag := false
	for _, c := range in.Bytes() {
		if c == '-' {
			flag = true
			continue
		}
		r *= 10
		r += int(c - '0')
	}
	if flag {
		r = -r
	}
	return r
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N := nextInt()
	list := make([]int, N)
	for i := 0; i < N; i++ {
		list[i] = nextInt()
	}

	LIS := make([]int, 1000001)
	LIS[0] = list[0]
	idx := 1
	for i := 1; i < N; i++ {
		n := list[i]
		if LIS[idx-1] < n {
			LIS[idx] = n
			idx++
		} else {
			s, e := 0, idx-1
			for s < e {
				mid := (s + e) / 2
				if LIS[mid] >= n {
					e = mid
				} else {
					s = mid + 1
				}
			}
			LIS[e] = n
		}
	}
	fmt.Fprintln(bw, idx)
}
