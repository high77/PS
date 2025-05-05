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
	mapper := map[byte]byte{
		'1': '`', '2': '1', '3': '2', '4': '3', '5': '4',
		'6': '5', '7': '6', '8': '7', '9': '8', '0': '9',
		'-': '0', '=': '-',

		'[': 'P', ']': '[', '\\': ']',
		';': 'L', '\'': ';',
		',': 'M', '.': ',', '/': '.',
		' ': ' ',

		'W': 'Q', 'E': 'W', 'R': 'E', 'T': 'R', 'Y': 'T',
		'U': 'Y', 'I': 'U', 'O': 'I', 'P': 'O',

		'S': 'A', 'D': 'S', 'F': 'D', 'G': 'F', 'H': 'G',
		'J': 'H', 'K': 'J', 'L': 'K',

		'X': 'Z', 'C': 'X', 'V': 'C', 'B': 'V', 'N': 'B',
		'M': 'N',
	}

	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		line := scanner.Text()
		for i := 0; i < len(line); i++ {
			if val, ok := mapper[line[i]]; ok {
				fmt.Printf("%c", val)
			} else {
				fmt.Printf("%c", line[i])
			}
		}
		fmt.Println()
	}
}
