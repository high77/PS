package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

type Team struct {
	level int
	names []string
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	// 첫 줄 입력 처리
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)
	tokens := strings.Split(input, " ")
	p, _ := strconv.Atoi(tokens[0])
	m, _ := strconv.Atoi(tokens[1])

	var teams []Team
	players := make(map[string]int)

	for i := 0; i < p; i++ {
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		tokens = strings.Split(line, " ")
		l, _ := strconv.Atoi(tokens[0])
		n := tokens[1]
		players[n] = l

		flag := false
		for i := range teams {
			if l >= teams[i].level-10 && l <= teams[i].level+10 && len(teams[i].names) < m {
				teams[i].names = append(teams[i].names, n)
				flag = true
				break
			}
		}
		if !flag {
			teams = append(teams, Team{level: l, names: []string{n}})
		}
	}

	for _, team := range teams {
		if len(team.names) < m {
			fmt.Fprintln(writer, "Waiting!")
		} else {
			fmt.Fprintln(writer, "Started!")
		}

		sort.Strings(team.names)
		for _, name := range team.names {
			fmt.Fprintf(writer, "%d %s\n", players[name], name)
		}
	}
}
