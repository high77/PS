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

	R, B := nextInt(), nextInt()
	for i := 1; i < R; i++ {
		for j := 1; j < R; j++ {
			if i*2+(j-2)*2 == R && (i-2)*(j-2) == B {
				fmt.Fprintf(bw, "%d %d", j, i)
				return
			}
		}
	}

}
