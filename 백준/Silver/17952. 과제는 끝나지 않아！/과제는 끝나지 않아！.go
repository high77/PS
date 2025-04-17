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

type Work struct {
	score, time int
}

func main() {
	in.Split(bufio.ScanWords)
	N := nextInt()
	ans := 0
	stack := []Work{}
	for i := 0; i < N; i++ {
		if nextInt() == 1 {
			score := nextInt()
			time := nextInt()
			if time == 1 {
				ans += score
			} else {
				stack = append(stack, Work{score, time - 1})
			}
		} else {
			if len(stack) == 0 {
				continue
			}
			w := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if w.time == 1 {
				ans += w.score
			} else {
				stack = append(stack, Work{w.score, w.time - 1})
			}
		}
	}
	fmt.Println(ans)
}
