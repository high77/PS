# [Ruby V] Printed Circuit Board - 3303 

[문제 링크](https://www.acmicpc.net/problem/3303) 

### 성능 요약

메모리: 42996 KB, 시간: 996 ms

### 분류

자료 구조, 정렬, 기하학, 스택, 각도 정렬

### 제출 일자

2026년 3월 28일 12:20:20

### 문제 설명

<p>According to Wikipedia, a printed circuit board, or PCB, is used to mechanically support and electrically connect <a href="https://en.wikipedia.org/wiki/Electronic_component">electronic components</a> using <a href="https://en.wikipedia.org/wiki/Electrical_conductor">conductive</a> pathways <a href="https://en.wikipedia.org/wiki/Industrial_etching">etched</a> from <a href="https://en.wikipedia.org/wiki/Copper">copper</a> sheets <a href="https://en.wikipedia.org/wiki/Lamination">laminated</a> onto a nonconductive <a href="https://en.wikipedia.org/wiki/Substrate_(electronics)">substrate</a>. Your company wants to produce a new electronic device that will be manufactured using a PCB. The design of the required PCB is partially ready, and has the shape of a closed polygon. It consists of N nodes numbered from 1 to N. Node u and node u+1 are connected by a straight line wire segment and node N is connected to node 1 by a straight line wire segment. Wire segments are non-crossing, that is for any pair of wire segments if they share a common point then this point must be an endpoint of both segments, and each node is the endpoint of exactly two segments. The location of each node is given by x- and y-coordinates, and the origin (0,0) is the lower left corner of the board.</p>

<p>You are to write a program that computes all nodes of the circuit that can be connected to the origin by a straight line wire segment that has no common point with the polygon other than the node itself.</p>

### 입력 

 <p>The first line of the input contains one integer, N (1 ≤ N ≤ 200 000) the number of nodes of the circuit. Each of the next N lines contain two integers, x, y (0 < x, y ≤ 1 000 000) the x- and y-coordinates of a node. Nodes are numbered from 1 to N, the input line i+1 contains the coordinates of node i.</p>

### 출력 

 <p>The first line of the output contains one integer M, the number of nodes that can be connected to the origin by a straight line wire segment so that this point is the only common point with any wire segment of the circuit. The second line contains these nodes separated by space in increasing order.</p>

