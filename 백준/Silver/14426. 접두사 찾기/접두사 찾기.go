package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strings"
)

func hasPrefix(list []string, prefix string) bool {
	idx := sort.Search(len(list), func(i int) bool {
		return list[i] >= prefix
	})
	return idx < len(list) && strings.HasPrefix(list[idx], prefix)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanLines)

	// Read N and M
	scanner.Scan()
	var N, M int
	fmt.Sscanf(scanner.Text(), "%d %d", &N, &M)

	// Read N words
	list := make([]string, N)
	for i := 0; i < N; i++ {
		scanner.Scan()
		list[i] = scanner.Text()
	}
	sort.Strings(list)

	// Read M queries
	ans := 0
	for i := 0; i < M; i++ {
		scanner.Scan()
		if hasPrefix(list, scanner.Text()) {
			ans++
		}
	}

	fmt.Println(ans)
}
