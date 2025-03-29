package main

import (
	"fmt"
	"math"
)

func main() {
	var a, b, c, d int
	var ans int
	for {
		fmt.Scan(&a, &b, &c, &d)
		if a == 0 && b == 0 && c == 0 && d == 0 {
			break
		}
		ans = 0
		for {
			if a == b && b == c && c == d {
				break
			}
			ans++
			tmp := a
			a = int(math.Abs(float64(a - b)))
			b = int(math.Abs(float64(b - c)))
			c = int(math.Abs(float64(c - d)))
			d = int(math.Abs(float64(d - tmp)))
		}
		fmt.Println(ans)
	}

}
