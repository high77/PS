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

func max(a,b int) int {
	if a>b{
		return a
	}else{
		return b
	}
}

func main() {
	in.Split(bufio.ScanWords)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	N,K := nextInt(),nextInt()
	list := make([]int,N)
	
	for i:=range list{list[i]=nextInt()}
	s,e,ans:=0,1000000000+K,0
	for s<=e{
		mid,sum:=(s+e)/2,0
		flag := false
		for i:=range list{
			sum+=max(mid-list[i],0)
			if sum>K {
				flag = true
				break
			}
		}
		if flag {
			e=mid-1
		}else {
			s=mid+1
			ans=max(ans,mid)
		}
	}
	fmt.Println(ans)
}
