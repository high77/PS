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

	_, N := nextInt(), nextInt()
	flag := true
	for i := 0; i < N; i++ {
		M := nextInt()
		tmp := 200001
		for j := 0; j < M; j++ {
			a := nextInt()
			if a > tmp {
				flag = false
			}
			tmp = a
		}
	}
	if flag {
		fmt.Fprintln(bw, "Yes")
	} else {
		fmt.Fprintln(bw, "No")
	}
}
