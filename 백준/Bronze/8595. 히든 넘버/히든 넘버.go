package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"unicode"
)

var in = bufio.NewScanner(os.Stdin)

func nextInt() int {
	in.Scan()
	n, _ := strconv.Atoi(in.Text())
	return n
}

func main() {
	//in.Split(bufio.ScanWords)
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()
	br.ReadString('\n')

	S, _ := br.ReadString('\n')

	var ans, tmp int64

	for _, c := range S {
		if unicode.IsDigit(c) {
			tmp = tmp*10 + int64(c-'0')
		} else {
			ans += tmp
			tmp = 0
		}
	}
	ans += tmp

	fmt.Fprintln(bw, ans)

}
