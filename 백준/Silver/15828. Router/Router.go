package main

import (
	"bufio"
	"container/list"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	line, _ := reader.ReadString('\n')
	N, _ := strconv.Atoi(strings.TrimSpace(line))

	q := list.New()
	for {
		input, err := reader.ReadString('\n')
		if err != nil {
			break
		}
		n, _ := strconv.Atoi(strings.TrimSpace(input))

		if n == -1 {
			break
		} else if n == 0 {
			if q.Len() > 0 {
				q.Remove(q.Front())
			}
		} else {
			if q.Len() < N {
				q.PushBack(n)
			}
		}
	}

	if q.Len() == 0 {
		fmt.Println("empty")
	} else {
		var sb strings.Builder
		for e := q.Front(); e != nil; e = e.Next() {
			sb.WriteString(fmt.Sprint(e.Value))
			if e.Next() != nil {
				sb.WriteByte(' ')
			}
		}
		fmt.Println(sb.String())
	}
}
