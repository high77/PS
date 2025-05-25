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

	tc := 1
	for {
		in.Scan()
		s := in.Text()
		res := 0
		cnt := 0
		if s[0] == '-' {
			break
		}
		for _, c := range s {
			if c == '{' {
				cnt++
			} else {
				if cnt > 0 {
					cnt--
				} else {
					cnt++
					res++
				}
			}
		}
		res += cnt / 2
		fmt.Fprintf(bw, "%d. %d\n", tc, res)
		tc++
	}
}
