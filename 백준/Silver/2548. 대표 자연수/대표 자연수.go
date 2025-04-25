package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
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
	N := nextInt()
	list := make([]int, N)
	for i := 0; i < N; i++ {
		list[i] = nextInt()
	}
	sort.Ints(list)
	fmt.Println(list[(N-1)/2])

}
