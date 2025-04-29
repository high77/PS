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

var (
	res   int
	list  []int
	visit []bool
	done  []bool
)

func dfs(n int) {
	if visit[n] {
		done[n] = true
		res--
	} else {
		visit[n] = true
	}

	if !done[list[n]] {
		dfs(list[n])
	}

	visit[n] = false
	done[n] = true
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	T := nextInt()
	for T > 0 {
		T--
		N := nextInt()
		list = make([]int, N+1)
		visit = make([]bool, N+1)
		done = make([]bool, N+1)
		res = N
		for i := 1; i <= N; i++ {
			list[i] = nextInt()
		}

		for i := 1; i <= N; i++ {
			if !done[i] {
				dfs(i)
			}
		}
		fmt.Fprintln(bw, res)
	}
}
