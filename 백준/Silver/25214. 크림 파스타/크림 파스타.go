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
	N, minN, res := nextInt(), int(^uint(0)>>1), 0

	for i := 0; i < N; i++ {
		tmp := nextInt()
		if tmp < minN {
			minN = tmp
		} else {
			res = max(res, tmp-minN)
		}
		fmt.Fprint(bw, res, " ")
	}

}
