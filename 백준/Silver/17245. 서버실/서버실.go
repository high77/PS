package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var in = bufio.NewScanner(os.Stdin)

func scanInt() int {
	in.Scan()
	n, _ := strconv.Atoi(in.Text())
	return n
}

func scanString() string {
	in.Scan()
	return strings.TrimSpace(in.Text())
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N, sum, s, e := scanInt(), 0, 0, 0
	computers := make([][]int, N)
	for i := 0; i < N; i++ {
		computers[i] = make([]int, N)
		for j := 0; j < N; j++ {
			computers[i][j] = scanInt()
			sum += computers[i][j]
			e = max(computers[i][j], e)
		}
	}

	for s < e {
		mid, cnt := (s+e)/2, 0
		for i := 0; i < N; i++ {
			for j := 0; j < N; j++ {
				cnt += min(mid, computers[i][j])
			}
		}
		if cnt*2 >= sum {
			e = mid
		} else {
			s = mid + 1
		}
	}

	fmt.Fprintln(bw, e)

}
