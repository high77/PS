package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var in = bufio.NewScanner(os.Stdin)

func scanInt() int {
	in.Scan()
	n, _ := strconv.Atoi(in.Text())
	return n
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N := scanInt()

	LIS := make([]int, 1000001)
	idx := 0
	for i := 0; i < N; i++ {
		n := scanInt()
		if i == 0 {
			LIS[idx] = n
			idx++
			continue
		}
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
