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

	in.Scan()
	S := []rune(in.Text())
	cnt := [2]int{}

	for i := 0; i < len(S); i++ {
		cnt[S[i]-'0']++
	}
	for i := range cnt {
		cnt[i] /= 2
	}
	for i := len(S) - 1; i >= 0; i-- {
		if cnt[0] == 0 {
			break
		}
		if S[i] == '0' {
			cnt[0]--
			S[i] = '2'
		}
	}
	for i := 0; i < len(S); i++ {
		if cnt[1] == 0 {
			break
		}
		if S[i] == '1' {
			cnt[1]--
			S[i] = '2'
		}
	}

	for i := range S {
		if S[i] != '2' {
			fmt.Fprint(bw, string(S[i]))
		}
	}
	fmt.Fprintln(bw)

}
