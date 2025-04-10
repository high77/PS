package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)

	// 전체 이동 횟수 계산
	totalMoves := new(big.Int).Lsh(big.NewInt(1), uint(n)) // 2^n
	totalMoves.Sub(totalMoves, big.NewInt(1))             // 2^n - 1

	fmt.Fprintln(writer, totalMoves.String())
	
	// n이 20 이하일 때만 하노이 진행
	if n <= 20 {
		hanoiProgress(n, 1, 3, writer)
	}
}

// 하노이 이동 경로를 출력하는 함수
func hanoiProgress(n, from, to int, writer *bufio.Writer) {
	if n == 1 {
		fmt.Fprintln(writer, from, to)
		return
	}
	// 보조 기둥 계산
	auxiliary := 6 - from - to
	hanoiProgress(n-1, from, auxiliary, writer)
	fmt.Fprintln(writer, from, to)
	hanoiProgress(n-1, auxiliary, to, writer)
}