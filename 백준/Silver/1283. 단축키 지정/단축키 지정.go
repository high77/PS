package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"unicode"
)

func buildLine(words []string, i, j int) string {
	word := words[i]
	var builder strings.Builder
	for k, w := range words {
		if k > 0 {
			builder.WriteByte(' ')
		}
		if k == i {
			builder.WriteString(word[:j])
			builder.WriteByte('[')
			builder.WriteByte(word[j])
			builder.WriteByte(']')
			builder.WriteString(word[j+1:])
		} else {
			builder.WriteString(w)
		}
	}
	return builder.String()
}

func assignShortcut(words []string, used map[rune]struct{}) (string, bool) {
	for i, word := range words {
		if word == "" {
			continue
		}
		ch := unicode.ToLower(rune(word[0]))
		if _, exists := used[ch]; !exists {
			used[ch] = struct{}{}
			return buildLine(words, i, 0), true
		}
	}
	for i, word := range words {
		for j, r := range word {
			ch := unicode.ToLower(r)
			if _, exists := used[ch]; !exists {
				used[ch] = struct{}{}
				return buildLine(words, i, j), true
			}
		}
	}
	return "", false
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	scanner.Scan()
	var n int
	fmt.Sscanf(scanner.Text(), "%d", &n)

	used := make(map[rune]struct{})

	for i := 0; i < n; i++ {
		scanner.Scan()
		line := scanner.Text()
		words := strings.Fields(line)

		if res, ok := assignShortcut(words, used); ok {
			fmt.Fprintln(writer, res)
		} else {
			fmt.Fprintln(writer, line)
		}
	}
}
