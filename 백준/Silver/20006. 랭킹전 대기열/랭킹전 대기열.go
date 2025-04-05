package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

type Player struct {
	name  string
	level int
}

type Team struct {
	level  int
	members []Player
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	// 입력 읽기
	input, _ := reader.ReadString('\n')
	tokens := strings.Fields(input)
	p, _ := strconv.Atoi(tokens[0])
	m, _ := strconv.Atoi(tokens[1])

	var teams []Team

	for i := 0; i < p; i++ {
		line, _ := reader.ReadString('\n')
		tokens := strings.Fields(line)
		l, _ := strconv.Atoi(tokens[0])
		n := tokens[1]
		player := Player{name: n, level: l}

		assigned := false
		for i := range teams {
			if l >= teams[i].level-10 && l <= teams[i].level+10 && len(teams[i].members) < m {
				teams[i].members = append(teams[i].members, player)
				assigned = true
				break
			}
		}
		if !assigned {
			teams = append(teams, Team{level: l, members: []Player{player}})
		}
	}

	for _, team := range teams {
		if len(team.members) < m {
			fmt.Fprintln(writer, "Waiting!")
		} else {
			fmt.Fprintln(writer, "Started!")
		}

		sort.Slice(team.members, func(i, j int) bool {
			return team.members[i].name < team.members[j].name
		})

		for _, player := range team.members {
			fmt.Fprintf(writer, "%d %s\n", player.level, player.name)
		}
	}
}
