# [Platinum III] Manhattan Positioning System - 13467 

[문제 링크](https://www.acmicpc.net/problem/13467) 

### 성능 요약

메모리: 13332 KB, 시간: 96 ms

### 분류

기하학, 선분 교차 판정

### 제출 일자

2026년 3월 14일 12:30:12

### 문제 설명

<p>The Manhattan Positioning System (MPS) is a modern variant of GPS, optimized for use in large cities. MPS assumes all positions are discrete points on a regular two-dimensional grid. Within MPS, a position is represented by a pair of integers (X,Y ).</p>

<p>To determine its position, an MPS receiver first measures its distance to a number of beacons. Beacons have known, fixed locations. MPS signals propagate only along the X and Y axes through the streets of the city, not diagonally through building blocks. When an MPS receiver at (X<sub>R</sub>,Y<sub>R</sub>) measures its distance to a beacon at (X<sub>B</sub>,Y<sub>B</sub>), it thus obtains the Manhattan distance: |X<sub>R</sub> − X<sub>B</sub>| + |Y<sub>R</sub> − Y<sub>B</sub>|.</p>

<p>Given the positions of a number of beacons and the Manhattan-distances between the receiver and each beacon, determine the position of the receiver. Note that the receiver must be at an integer grid position (MPS does not yet support fractional coordinates).</p>

### 입력 

 <p>The first line contains an integer N, the number of beacons (1 ≤ N ≤ 1000). Then follow N lines, each containing three integers, X<sub>i</sub>, Y<sub>i</sub>, and D<sub>i</sub>, such that −10<sup>6</sup> ≤ X<sub>i</sub>, Y<sub>i</sub> ≤ 10<sup>6</sup> and 0 ≤ D<sub>i</sub> ≤ 4·10<sup>6</sup>. The pair (X<sub>i</sub>, Y<sub>i</sub>) denotes the position of beacon i, while Di is the Manhattan distance between receiver and beacon i.</p>

<p>No two beacons have the same position.</p>

### 출력 

 <p>If there is exactly one receiver position consistent with the input, write one line with two integers, X<sub>R</sub> and Y<sub>R</sub>, the position of the receiver.</p>

<p>If multiple receiver positions are consistent with the input, write one line with the word “uncertain”.</p>

<p>If no receiver position is consistent with the input, write one line with the word “impossible”.</p>

