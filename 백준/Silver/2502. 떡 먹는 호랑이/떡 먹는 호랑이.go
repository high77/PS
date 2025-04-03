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
	D, K := nextInt(), nextInt()
	dp := make([][2]int, D+1)
	dp[1][0], dp[2][1] = 1, 1
	for i := 3; i <= D; i++ {
		for j := 0; j < 2; j++ {
			dp[i][j] = dp[i-1][j] + dp[i-2][j]
		}
	}
	a := 1
	for {
		if (K-(dp[D][0]*a))%dp[D][1] == 0 {
			fmt.Println(a)
			fmt.Println((K - (dp[D][0] * a)) / dp[D][1])
			break
		}
		a++
	}
}
