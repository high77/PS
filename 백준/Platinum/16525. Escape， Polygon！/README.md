# [Platinum II] Escape, Polygon! - 16525 

[문제 링크](https://www.acmicpc.net/problem/16525) 

### 성능 요약

메모리: 46920 KB, 시간: 296 ms

### 분류

수학, 기하학, 조합론, 두 포인터, 회전하는 캘리퍼스

### 제출 일자

2026년 3월 9일 20:53:35

### 문제 설명

<p>A suspicious-looking convex polygon wants to escape its current position by translating itself along some straight-line direction. Three very diligent straight lines want to lock it up by placing themselves along three distinct sides of the polygon. Then, if the triple of lines defines a triangle and the polygon lies inside this triangle, it will be locked up. Otherwise, it will escape.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/1992a244-399f-486d-88aa-b57dd4d8017a/-/preview/" style="width: 609px; height: 202px;"></p>

<p>Figure (a) above illustrates a triple that will lock the polygon up. For (b), the lines do not define a triangle since two of them are parallel, and so the polygon will escape. In (c), the polygon lies outside the triangle defined by the triple and it will easily escape.</p>

<p>Given a polygon, you must compute the number of distinct triples of lines that can lock the polygon up.</p>

### 입력 

 <p>The first line contains an integer N (3 ≤ N ≤ 10<sup>5</sup>) representing the number of vertices of the polygon. Each of the next N lines describes a vertex with two integers X and Y (−10<sup>8</sup> ≤ X, Y ≤ 10<sup>8</sup>) indicating the coordinates of the vertex in the XY plane. The vertices are given in counter-clockwise order and they define a simple convex polygon. No three vertices are collinear.</p>

### 출력 

 <p>Output a single line with an integer indicating the number of distinct triples of lines that can lock the given polygon up.</p>

