package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func abs(n int) int {
	if n < 0 {
		return -n
	}
	return n
}

func main() {
	reader := bufio.NewReader(os.Stdin)

	for {
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		parts := strings.Fields(line)

		if len(parts) != 4 {
			continue
		}

		a, _ := strconv.Atoi(parts[0])
		b, _ := strconv.Atoi(parts[1])
		c, _ := strconv.Atoi(parts[2])
		d, _ := strconv.Atoi(parts[3])

		if a == 0 && b == 0 && c == 0 && d == 0 {
			break
		}

		steps := 0
		for !(a == b && b == c && c == d) {
			steps++
			a, b, c, d = abs(a-b), abs(b-c), abs(c-d), abs(d-a)
		}
		fmt.Println(steps)
	}
}
