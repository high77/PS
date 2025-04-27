package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func repeat(s string, count int) string {
	if count <= 0 {
		return ""
	}
	return strings.Repeat(s, count)
}

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush() // 마지막에 한 번만 flush해서 성능 최적화

	var N int
	fmt.Fscan(br, &N)

	if N == 1 {
		bw.WriteString("*\n")
		bw.Flush()
		return
	}

	idx := 1
	width := N * 4

	for i := 1; i <= N; i++ {
		bw.WriteString(repeat("* ", i-1))

		lineWidth := width - (i*4 - 1)
		if i >= 2 {
			lineWidth += 2
		}
		bw.WriteString(repeat("*", lineWidth))
		if i >= 3 {
			bw.WriteString(repeat(" *", idx))
			idx++
		}
		bw.WriteString("\n")

		switch {
		case i == 1:
			bw.WriteString("*\n")
		case i == N:
			bw.WriteString("*" + repeat(" *", N*2-2) + "\n")
		default:
			bw.WriteString(repeat("* ", i))
			bw.WriteString(repeat(" ", (N-i)*4-1))
			bw.WriteString(repeat(" *", i-1))
			bw.WriteString("\n")
		}
	}

	bw.WriteString("*" + repeat(" *", N*2-2) + "\n")

	for i := N - 1; i >= 1; i-- {
		bw.WriteString(repeat("* ", i))
		bw.WriteString(repeat(" ", (N-i)*4-3))
		bw.WriteString(repeat(" *", i))
		bw.WriteString("\n")

		bw.WriteString(repeat("* ", i-1))
		bw.WriteString(repeat("*", (N-i)*4+1))
		bw.WriteString(repeat(" *", i-1))
		bw.WriteString("\n")
	}
}
