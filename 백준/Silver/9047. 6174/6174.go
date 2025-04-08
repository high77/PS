package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func toDigits(n int) []int {
	digits := make([]int, 4)
	for i := 0; i < 4; i++ {
		digits[i] = n % 10
		n /= 10
	}
	return digits
}

func digitsToInt(digits []int) int {
	n := 0
	for _, d := range digits {
		n = n*10 + d
	}
	return n
}

func kaprekarSteps(n int) int {
	cnt := 0
	for n != 6174 {
		digits := toDigits(n)
		sort.Ints(digits)
		a := digitsToInt(digits)
		sort.Sort(sort.Reverse(sort.IntSlice(digits)))
		b := digitsToInt(digits)
		n = b - a
		cnt++
		if n == 0 { // 예외 처리: 모든 숫자가 같을 경우
			break
		}
	}
	return cnt
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	line, _ := reader.ReadString('\n')
	N, _ := strconv.Atoi(strings.TrimSpace(line))

	for i := 0; i < N; i++ {
		line, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(line))
		fmt.Fprintln(writer, kaprekarSteps(n))
	}
}
