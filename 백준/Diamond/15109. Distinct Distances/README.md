# [Diamond IV] Distinct Distances - 15109 

[문제 링크](https://www.acmicpc.net/problem/15109) 

### 성능 요약

메모리: 72072 KB, 시간: 592 ms

### 분류

기하학, 수학

### 제출 일자

2026년 3월 17일 11:05:22

### 문제 설명

<p>You’re setting up a scavenger hunt that takes place in the two-dimensional plane.</p>

<p>You’ve already decided on n distinct points of interest labeled p<sub>1</sub>, . . . , p<sub>n</sub>. The point p<sub>i</sub> is located at integer coordinates (x<sub>i</sub>, y<sub>i</sub>).</p>

<p>You now want to choose a point q for the final location. This point must have finite coordinates, but it does not necessarily need to have integer coordinates. This point also can coincide with one of the original points p<sub>i</sub>.</p>

<p>In order to make this final location interesting, you would like to minimize the number of unique distances from q to the other points.</p>

<p>More precisely, you would like to choose q that minimizes |S(q)|, where S(q) is defined as the set</p>

<p style="text-align:center">{|q − p<sub>1</sub>|, |q − p<sub>2</sub>|, . . . , |q − p<sub>n</sub>|}.</p>

<p>Here, the notation |S(q)| means the number of elements in the set S(q) and |q − p<sub>i</sub>| denotes the Euclidean distance between q and p<sub>i</sub>. Note that S(q) is a set, so if two or more distances |q − p<sub>i</sub>| are equal, they are counted as a single element in S(q).</p>

<p>Given the coordinates of the points, find the minimum value of |S(q)|.</p>

<p>Warning: Use of inexact arithmetic may make it difficult to identify distances that are exactly equal.</p>

### 입력 

 <p>The first line of input contains a single integer n (1 ≤ n ≤ 40).</p>

<p>Each of the next n lines contains two space-separated integers x<sub>i</sub> and y<sub>i</sub> (|x<sub>i</sub>|, |y<sub>i</sub>| ≤ 300), representing the coordinates of p<sub>i</sub>.</p>

### 출력 

 <p>Output, on a single line, the minimum number of unique distances from q to all other points p<sub>i</sub>.</p>

