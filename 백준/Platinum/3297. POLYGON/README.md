# [Platinum IV] POLYGON - 3297 

[문제 링크](https://www.acmicpc.net/problem/3297) 

### 성능 요약

메모리: 12216 KB, 시간: 88 ms

### 분류

다이나믹 프로그래밍, 기하학, 볼록 껍질

### 제출 일자

2026년 3월 21일 14:50:49

### 문제 설명

<p>There are N points in a plane whose coordinates are natural numbers. A convex polygon with maximal number of vertices is a convex polygon whose vertices are some of given points and the origin having maximal possible number of vertices. Origin, i.e. point with coordinates (0,0), must be one of vertices of a convex polygon with maximal number of vertices.</p>

<p>Write a program that will determine number of vertices in such polygon.</p>

<p>A polygon is convex if every line segment whose endpoints are inside that polygon is also completely inside it.</p>

<p>Consecutive edges of a polygon must not be parallel.</p>

### 입력 

 <p>The first line of input file contains a natural number N, 2 ≤ N ≤ 100, a number of given points.</p>

<p>Each of the following N lines contains two natural numbers X and Y, 1 ≤ X ≤ 100, 1 ≤ Y ≤ 100, separated by a space character, coordinates of one point. All points will be different.</p>

### 출력 

 <p>The first and only line of output file should contain number of vertices of convex polygon with maximal number of vertices.</p>

<p>Note: the result will always be at least 3.</p>

