package main

import (
	"bufio"
	"fmt"
	"os"
	"unicode"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	// 첫 줄은 필요 없으므로 무시
	reader.ReadString('\n')

	// 두 번째 줄 입력
	line, _ := reader.ReadString('\n')

	var sum, num int64
	hasDigit := false

	for _, c := range line {
		if unicode.IsDigit(c) {
			num = num*10 + int64(c-'0')
			hasDigit = true
		} else if hasDigit {
			sum += num
			num = 0
			hasDigit = false
		}
	}

	if hasDigit {
		sum += num
	}

	fmt.Println(sum)
}
