package main

import (
    "fmt"
    "math"
)

func main() {
    for {
        var a, b, c, d, ans int
        fmt.Scan(&a, &b, &c, &d)
        if a|b|c|d == 0 { 
            break
        }
        
        for a != b || b != c || c != d {
            ans++
            a, b, c, d = int(math.Abs(float64(a-b))), int(math.Abs(float64(b-c))), int(math.Abs(float64(c-d))), int(math.Abs(float64(d-a)))
        }
        fmt.Println(ans)
    }
}
