package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	line, _ := reader.ReadString('\n')
	line = strings.TrimSpace(line)
	var a, b, c float64
	fmt.Sscanf(line, "%f %f %f", &a, &b, &c)
	fmt.Println(int(math.Max(a*b/c, a/b*c)))
}
