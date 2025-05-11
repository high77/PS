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

	T := nextInt()
	for T > 0 {
		T--
		n, k, ID, m := nextInt(), nextInt(), nextInt(), nextInt()
		table := make([][]int, n+1)
		scores, cnt, times := make([]int, n+1), make([]int, n+1), make([]int, n+1)
		for i := range table {
			table[i] = make([]int, k+1)
		}
		for i := 0; i < m; i++ {
			id, num, score := nextInt(), nextInt(), nextInt()
			times[id] = i
			cnt[id]++
			if table[id][num] < score {
				scores[id] -= table[id][num] - score
				table[id][num] = score
			}
		}
		rank := 1
		for i := 1; i <= n; i++ {
			if i == ID {
				continue
			}
			if scores[i] > scores[ID] {
				rank++
			} else if scores[i] == scores[ID] {
				if cnt[i] < cnt[ID] {
					rank++
				} else if cnt[i] == cnt[ID] && times[i] < times[ID] {
					rank++
				}
			}
		}
		fmt.Fprintln(bw, rank)
	}
}
