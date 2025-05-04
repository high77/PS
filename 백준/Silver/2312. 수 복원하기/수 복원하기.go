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

	T := nextInt()
	check := make([]bool, 100001)
	for i := 2; i < 101; i++ {
		if check[i] {
			continue
		}
		for j := i + i; j < 100001; j += i {
			check[j] = true
		}
	}

	for T > 0 {
		T--
		N := nextInt()
		i, cnt := 2, 0
		for N > 1 {
			if !check[i] {
				if N%i != 0 {
					if cnt > 0 {
						fmt.Fprintln(bw, i, cnt)
					}
					i++
					cnt = 0
				} else {
					N /= i
					cnt++
				}
			} else {
				i++
			}
		}
		if cnt > 0 {
			fmt.Fprintln(bw, i, cnt)
		}
	}
}
