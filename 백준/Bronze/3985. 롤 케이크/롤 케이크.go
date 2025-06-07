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

	L, N, max1, max2, ans1, ans2 := nextInt(), nextInt(), 0, 0, 0, 0
	check := make([]bool, L+1)
	for i := 1; i <= N; i++ {
		a, b := nextInt(), nextInt()
		cnt := b - a - 1
		if cnt > max1 {
			max1 = cnt
			ans1 = i
		}
		cnt = 0
		for j := a; j <= b; j++ {
			if check[j] {
				continue
			}
			cnt++
			check[j] = true
		}
		if cnt > max2 {
			max2 = cnt
			ans2 = i
		}

	}

	fmt.Fprintf(bw, "%d\n%d", ans1, ans2)

}
