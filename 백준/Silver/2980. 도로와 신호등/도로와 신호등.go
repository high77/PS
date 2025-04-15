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
	N, L, location, time := nextInt(), nextInt(), 0, 0
	for i := 0; i < N; i++ {
		D, R, G := nextInt(), nextInt(), nextInt()
		time += D - location
		location = D

		gap := time % (R + G)
		if gap < R {
			time += R - gap
		}
	}
	time += L - location
	fmt.Print(time)
}
