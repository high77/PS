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
	N, M := nextInt(), nextInt()
	list := make([]int, N+1)
	arr := make([][]int, N+1)
	ans := make([]int, 0)

	for i := 0; i < M; i++ {
		k, prev := nextInt(), nextInt()
		for j := 1; j < k; j++ {
			now := nextInt()
			arr[prev] = append(arr[prev], now)
			list[now]++
			prev = now
		}
	}

	visit := make([]bool, N+1)
	q := make([]int, 0)

	for i := 1; i <= N; i++ {
		if list[i] == 0 {
			q = append(q, i)
		}
	}

	for len(q) > 0 {
		now := q[0]
		if visit[now] {
			fmt.Fprintln(bw,0)
			return
		}
		ans = append(ans, now)
		visit[now] = true
		for _, i := range arr[now] {
			list[i]--
			if list[i] == 0 {
				q = append(q, i)
			}
		}
		q = q[1:]
	}

	if len(ans) == N {
		for _, i := range ans {
			fmt.Fprintln(bw,i)

		}
	} else {
		fmt.Fprintln(bw,0)
	}

}
