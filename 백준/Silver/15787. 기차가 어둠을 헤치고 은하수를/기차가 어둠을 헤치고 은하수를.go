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
	N, M := nextInt(), nextInt()
	train := make([]int, N)
	set := make(map[int]struct{})

	for i := 0; i < M; i++ {
		order, idx := nextInt(), nextInt()-1
		if order == 1 {
			train[idx] |= (1 << (nextInt() - 1))
		} else if order == 2 {
			train[idx] &= ^(1 << (nextInt() - 1))
		} else if order == 3 {
			train[idx] = (train[idx] << 1) &^ (1 << 20)
		} else {
			train[idx] >>= 1
		}
	}

	for _, t := range train {
		set[t] = struct{}{}
	}
	fmt.Println(len(set))
}
