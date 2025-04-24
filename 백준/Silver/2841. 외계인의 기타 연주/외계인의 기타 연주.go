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
	N, _, ans := nextInt(), nextInt(), 0
	stack := make([][]int, 7)
	for i := 0; i < N; i++ {
		a, b := nextInt(), nextInt()
		for len(stack[a]) > 0 && stack[a][len(stack[a])-1] > b {
			stack[a] = stack[a][:len(stack[a])-1]
			ans++
		}
		if len(stack[a]) == 0 || stack[a][len(stack[a])-1] < b {
			stack[a] = append(stack[a], b)
			ans++
		}
	}
	fmt.Println(ans)

}
