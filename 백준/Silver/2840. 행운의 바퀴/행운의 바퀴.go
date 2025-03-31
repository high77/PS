package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	line, _ := reader.ReadString('\n')
	tokens := strings.Fields(line)
	N, _ := strconv.Atoi(tokens[0])
	K, _ := strconv.Atoi(tokens[1])

	res := make([]rune, N)
	for i := range res {
		res[i] = '?'
	}
	alpha := make(map[rune]bool)

	idx := 0
	for i := 0; i < K; i++ {
		line, _ := reader.ReadString('\n')
		tokens := strings.Fields(line)
		a, _ := strconv.Atoi(tokens[0])
		b := rune(tokens[1][0])

		idx = (N + idx - (a % N)) % N
		if res[idx] == b {
			continue
		}
		if res[idx] != '?' || alpha[b] {
			fmt.Println("!")
			return
		}
		alpha[b] = true
		res[idx] = b
	}

	var ans strings.Builder
	for i := 0; i < N; i++ {
		ans.WriteRune(res[(idx+i)%N])
	}
	fmt.Println(ans.String())
}
