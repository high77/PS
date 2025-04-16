package main

import (
	"bufio"
	"fmt"
	"math"
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

var N, K int
var list []int
var ans = math.MaxInt32
var location [][]int

func f(k, i int) {
	if k == K {
		res := 0
		min := make([]int, N)
		for j := range min {
			min[j] = math.MaxInt32
		}

		for _, shelter := range list {
			a := location[shelter][0]
			b := location[shelter][1]
			for j := 0; j < N; j++ {
				x := abs(a - location[j][0])
				y := abs(b - location[j][1])
				min[j] = minInt(min[j], x+y)
			}
		}
		for _, n := range min {
			res = maxInt(res, n)
		}
		ans = minInt(ans, res)
		return
	}
	for j := i + 1; j < N; j++ {
		list[k] = j
		f(k+1, j)
	}
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	in.Split(bufio.ScanWords)
	N = nextInt()
	K = nextInt()

	list = make([]int, K)
	location = make([][]int, N)

	for i := 0; i < N; i++ {
		location[i] = make([]int, 2)
		location[i][0] = nextInt()
		location[i][1] = nextInt()
	}
	f(0, -1)
	fmt.Println(ans)
}
