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

	a, b, c := [3]int{}, [3]int{}, [3]int{}

	for i := range a {
		a[i] = nextInt()
	}
	for i := range c {
		c[i] = nextInt()
	}
	b[0] = c[0] - a[2]
	b[1] = c[1] / a[1]
	b[2] = c[2] - a[0]

	fmt.Fprintln(bw, b[0], b[1], b[2])
}
