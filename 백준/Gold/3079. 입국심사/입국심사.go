package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
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

	N, M := nextInt(), nextInt()
	list := make([]int, N)
	for i := range list {
		list[i] = nextInt()
	}
	sort.Ints(list)
	s, e := 0, list[0]*M
	for s < e {
		mid, sum := (s+e)/2, 0
		for i := range list {
			cnt := mid / list[i]
			if sum >= M {
				break
			}
			sum += cnt
		}
		if sum >= M {
			e = mid
		} else {
			s = mid + 1
		}
	}
	fmt.Fprintln(bw, e)
}
