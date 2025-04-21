package main

import (
	"bufio"
	"fmt"
	"os"
)

//var in = bufio.NewScanner(os.Stdin)
//
//func nextInt() int {
//	in.Scan()
//	r := 0
//	for _, c := range in.Bytes() {
//		r *= 10
//		r += int(c - '0')
//	}
//	return r
//}

const (
	r = 12
	c = 6
)

var (
	field [r][c]rune
	visit [r][c]bool
	dx    = [4]int{0, 0, -1, 1}
	dy    = [4]int{-1, 1, 0, 0}
)

func bfs(x, y int, color rune) bool {
	q := [][2]int{{x, y}}
	toClear := [][2]int{{x, y}}
	cnt := 1
	visit[x][y] = true

	for len(q) > 0 {
		cur := q[0]
		q = q[1:]
		for d := 0; d < 4; d++ {
			nx, ny := cur[0]+dx[d], cur[1]+dy[d]
			if nx < 0 || ny < 0 || nx >= r || ny >= c || visit[nx][ny] || field[nx][ny] != color {
				continue
			}
			visit[nx][ny] = true
			q = append(q, [2]int{nx, ny})
			toClear = append(toClear, [2]int{nx, ny})
			cnt++
		}
	}
	if cnt >= 4 {
		for _, cur := range toClear {
			field[cur[0]][cur[1]] = '.'
		}
		return true
	}
	return false
}

func down() {
	for j := 0; j < c; j++ {
		c := false
		idx := 0
		for i := r - 1; i >= 0; i-- {
			if !c {
				if field[i][j] == '.' {
					c = true
					idx = i
				}
			} else {
				if field[i][j] != '.' {
					field[idx][j] = field[i][j]
					field[i][j] = '.'
					idx--
				}
			}
		}
	}
}

func main() {
	br := bufio.NewReader(os.Stdin)
	ans := 0

	for i := range field {
		var line string
		fmt.Fscan(br, &line)
		for j, ch := range line {
			field[i][j] = ch
		}
	}

	for {
		visit = [r][c]bool{}
		hasCleared := false
		for i := 0; i < r; i++ {
			for j := 0; j < c; j++ {
				if visit[i][j] || field[i][j] == '.' {
					continue
				}
				if bfs(i, j, field[i][j]) {
					hasCleared = true
				}

			}
		}
		if !hasCleared {
			break
		}
		ans++
		down()
	}

	fmt.Println(ans)
}
