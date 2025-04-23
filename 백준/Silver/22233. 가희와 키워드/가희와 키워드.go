package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

//var in = bufio.NewScanner(os.Stdin)
//
//func nextInt() int {
//	in.Scan()
//	r := 0
//	for _, c := range in.Bytes() {
//		r *= 10
//		r += int(c - '0')
//	}
//	return r
//}

func main() {
	br := bufio.NewReader(os.Stdin)
	wr := bufio.NewWriter(os.Stdout)
	defer wr.Flush()
	var N, M int
	fmt.Fscan(br, &N, &M)
	set := make(map[string]bool)
	var word string
	cnt := 0
	for i := 0; i < N; i++ {
		fmt.Fscan(br, &word)
		set[word] = true
		cnt++
	}
	var words string
	for i := 0; i < M; i++ {
		fmt.Fscan(br, &words)
		for _, word := range strings.Split(words, ",") {
			if set[word] {
				set[word] = false
				cnt--
			}
		}
		fmt.Fprintf(wr, "%d\n", cnt)
	}

}
