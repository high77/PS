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
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N, M := nextInt(), nextInt()
	visit := make([][]bool, M)
	for i := range visit {
		visit[i] = make([]bool, N)
	}
	x, y, d, cnt := 0, 0, 0, 1
	dx, dy := []int{0, 1, 0, -1}, []int{1, 0, -1, 0}
	visit[x][y] = true

	for N*M > cnt {
		nx, ny := x+dx[d], y+dy[d]
		if nx < 0 || ny < 0 || nx >= M || ny >= N || visit[nx][ny] {
			d = (d + 1) % 4
		} else {
			visit[nx][ny] = true
			x, y = nx, ny
			cnt++
		}
	}
	fmt.Fprintln(bw, y, x)

}
