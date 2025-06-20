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

func max(a,b int) int{
	if a>b {
		return a
	}else{
		return b
	}
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N,ans := nextInt(),0
	list,dp := make([]int,N),make([]int,N)
	for i:=range dp{
		dp[i] = 1
		list[i] = nextInt()
	}
	
	for i:=range dp{
		for j:=0;j<i;j++{
			if list[i]>list[j] {
				dp[i] = max(dp[j]+1,dp[i])
			}
		}
		ans = max(ans, dp[i])
	}
	

	fmt.Fprint(bw, ans)
}
