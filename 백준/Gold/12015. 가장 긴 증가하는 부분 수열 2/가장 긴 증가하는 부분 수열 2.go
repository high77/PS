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
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N := nextInt()
	list := make([]int, N)
	for i := 0; i < N; i++ {
		list[i] = nextInt()
	}

	LIS := make([]int, 0)
	LIS = append(LIS, list[0])
	for i := 1; i < N; i++ {
		n := list[i]
		if LIS[len(LIS)-1] < n {
			LIS = append(LIS, n)
		} else {
			s, e := 0, len(LIS)-1
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
	fmt.Fprintln(bw, len(LIS))
}
