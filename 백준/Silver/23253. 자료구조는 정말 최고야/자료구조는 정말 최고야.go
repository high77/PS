package main

import (
	"bufio"
	"fmt"
	"os"
)

var in = bufio.NewScanner(os.Stdin)

//func nextInt() int {
//	in.Scan()
//	n, _ := strconv.Atoi(in.Text())
//	return n
//}

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
