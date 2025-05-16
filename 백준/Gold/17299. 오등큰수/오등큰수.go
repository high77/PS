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

	N := nextInt()
	list := make([]int, N)
	res := make([]int, N)
	cntMap := make(map[int]int)
	stack := []int{}

	for i := range list {
		list[i] = nextInt()
		cntMap[list[i]]++
	}

	for i := N - 1; i >= 0; i-- {
		n := cntMap[list[i]]
		for len(stack) > 0 && cntMap[stack[len(stack)-1]] <= n {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			res[i] = -1
		} else {
			res[i] = stack[len(stack)-1]
		}
		stack = append(stack, list[i])
	}

	for i := range res {
		fmt.Fprint(bw, res[i], " ")
	}
}
