package main

import (
	"bufio"
	"fmt"
	"os"
)

var in = bufio.NewScanner(os.Stdin)

func nextInt() int {
	in.Scan()
	r := 0
	for _, c := range in.Bytes() {
		r *= 10
		r += int(c - '0')
	}
	return r
}

func minutes() int {
	in.Scan()
	line := in.Bytes()
	return int(line[0]-'0')*600 + int(line[1]-'0')*60 + int(line[3]-'0')*10 + int(line[4]-'0')
}

func main() {
	in.Split(bufio.ScanWords)
	N := nextInt()
	score := [2]int{0, 0}
	time := [2]int{0, 0}
	now := 0
	for i := 0; i < N; i++ {
		team := nextInt() - 1
		tmp := minutes()
		if score[0] > score[1] {
			time[0] += tmp - now
		} else if score[0] < score[1] {
			time[1] += tmp - now
		}
		now = tmp
		score[team]++
	}

	if score[0] > score[1] {
		time[0] += 2880 - now
	} else if score[0] < score[1] {
		time[1] += 2880 - now
	}

	fmt.Printf("%02d:%02d\n", time[0]/60, time[0]%60)
	fmt.Printf("%02d:%02d", time[1]/60, time[1]%60)
}
