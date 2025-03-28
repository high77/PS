package main

import (
	"fmt"
	"strconv"
)

func main() {
	var n string
	fmt.Scanln(&n)

	switch len(n) {
	case 4:
		fmt.Println(20)
	case 2:
		first, _ := strconv.Atoi(string(n[0]))
		second, _ := strconv.Atoi(string(n[1]))
		fmt.Println(first + second)
	default:
		if n[len(n)-1] == '0' {
			first, _ := strconv.Atoi(string(n[0]))
			fmt.Println(first + 10)
		} else {
			last, _ := strconv.Atoi(string(n[len(n)-1]))
			fmt.Println(last + 10)
		}
	}
}