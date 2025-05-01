package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush() // 마지막에 한 번만 flush해서 성능 최적화
	var N int
	fmt.Fscan(br, &N)
	ans := 1
	for i := 1; i <= N; i++ {
		ans *= i
		ans %= 10000000
		for ans%10 == 0 {
			ans /= 10
		}
	}
	fmt.Fprintln(bw, ans%10)

}
