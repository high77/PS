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

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N, M := nextInt(), nextInt()
	dp := make([][]int, 11)
	for i := range dp {
		dp[i] = make([]int, 31)
	}
	for i := 1; i <= M; i++ {
		dp[1][i] = 1
	}
	for i := 1; i <= N; i++ {
		dp[i][i] = 1
	}
	for i := 2; i <= N; i++ {
		for j := i; j <= M; j++ {
			dp[i][j] = dp[i][j-1] + dp[i-1][j-1]
		}
	}
	fmt.Fprint(bw, dp[N][M])
}
