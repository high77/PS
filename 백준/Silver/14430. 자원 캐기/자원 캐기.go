package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var in = bufio.NewScanner(os.Stdin)

func nextInt() int {
	in.Scan()
	n, _ := strconv.Atoi(in.Text())
	return n
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N, M := nextInt(), nextInt()
	arr, dp := make([][]int, N+1), make([][]int, N+1)
	for i := range arr {
		arr[i] = make([]int, M+1)
		dp[i] = make([]int, M+1)
	}

	for i := 1; i <= N; i++ {
		for j := 1; j <= M; j++ {
			arr[i][j] = nextInt()
			dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + arr[i][j]
		}
	}

	fmt.Fprint(bw, dp[N][M])
}
