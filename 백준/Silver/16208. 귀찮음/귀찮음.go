package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	// 첫 줄: N 입력
	input, _ := reader.ReadString('\n')
	N, _ := strconv.Atoi(strings.TrimSpace(input))

	// 두 번째 줄: 숫자 리스트 입력
	line, _ := reader.ReadString('\n')
	tokens := strings.Fields(line)

	list := make([]int, N)
	sum := 0

	for i := 0; i < N; i++ {
		list[i], _ = strconv.Atoi(tokens[i])
		sum += list[i]
	}

	sort.Ints(list)

	ans := 0
	for _, n := range list {
		sum -= n
		ans += sum * n
	}

	fmt.Println(ans)
}
