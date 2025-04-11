package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	N, M, cheese int
	arr          [][]int
	dx           = []int{0, 0, 1, -1}
	dy           = []int{-1, 1, 0, 0}
)

func bfs() {
	q := [][]int{{0, 0}}
	visit := make([][]bool, N)
	for i := range visit {
		visit[i] = make([]bool, M)
	}
	visit[0][0] = true
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		for d := 0; d < 4; d++ {
			nx := now[0] + dx[d]
			ny := now[1] + dy[d]
			if nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] {
				visit[nx][ny] = true
				if arr[nx][ny] == 1 {
					arr[nx][ny] = 0
					cheese--
				} else if arr[nx][ny] == 0 {
					q = append(q, []int{nx, ny})
				}
			}
		}
	}

}

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	fmt.Fscanln(br, &N, &M)
	cheese = 0
	arr = make([][]int, N)
	for i := 0; i < N; i++ {
		arr[i] = make([]int, M)
		for j := 0; j < M; j++ {
			fmt.Fscan(br, &arr[i][j])
			if arr[i][j] == 1 {
				cheese++
			}
		}
	}

	var time, res int
	time = 0

	for cheese > 0 {
		res = cheese
		time++
		bfs()
	}
	fmt.Println(time)
	fmt.Println(res)
}
