package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
	"strings"
)

var ans strings.Builder

func hanoi(n int, s int, e int) {
	if n == 0 {
		return
	}
	hanoi(n-1, s, (6 - s - e))
	ans.WriteString(fmt.Sprintf("%d %d\n", s, e))
	hanoi(n-1, (6 - e - s), e)
}

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()
	var N int
	fmt.Fscanln(br, &N)

	n := new(big.Int).Lsh(big.NewInt(1), uint(N))
	n.Sub(n, big.NewInt(1))
	ans.WriteString(n.String())

	if N < 21 {
		ans.WriteString("\n")
		hanoi(N, 1, 3)
	}
	bw.WriteString(ans.String())
}
