# [Platinum III] Deep800080 - 18175 

[문제 링크](https://www.acmicpc.net/problem/18175) 

### 성능 요약

메모리: 91380 KB, 시간: 496 ms

### 분류

기하학

### 제출 일자

2026년 3월 11일 19:13:36

### 문제 설명

<p>Ian, the owner of the boat called Deep800080 is going to make a barbecue on the lake this evening. There is a narrow straight pier running from the shore into the lake. Ian thinks it will be a good idea to make the barbecue somewhere on the pier.</p>

<p>He wants to test his new special barbecue charcoal. When it burns it produces a distinctive thick purple smoke which spreads over the water. The cloud of smoke is guaranteed to spread in a perfect circle around the barbecue site. Eventually, the cloud will reach some maximum radius and will stay unchanged for the rest of the evening until it dissipates later in the night.</p>

<p>There are multiple boats anchored in the lake in various distances from the pier. Ian wants to inform their crews about the barbecue. Being a little lazy, he hopes that the barbecue smoke will do this job for him. Ian hopes that when the cloud reaches a boat, the crew can smell the smoke, and so they immediately know there is a barbecue nearby.</p>

<p>Ian wants to maximize the number of alerted crews and thus he wants to choose a place of the barbecue grill on the pier which would maximize the number of the boats reached by the purple cloud.</p>

<p>You may assume that the boats on the lake are firmly anchored and that they do not move while the cloud is on the lake. Also, once the barbecue site is chosen, its position remains fixed for the whole event.</p>

### 입력 

 <p>The first line contains four integers N, R, A, B (0 ≤ N ≤ 3 · 10<sup>5</sup>; 1 ≤ R ≤ 10<sup>6</sup>). N is the number of boats on the lake, R is the maximal radius of the purple barbecue cloud. You may assume that the pier is so narrow and so long that it may be perceived as a straight line passing through two distinct points with coordinates (0, 0) and (A, B).</p>

<p>Each of the next N lines contains two integers X and Y describing the coordinates of one boat on the lake. No two boats share the same coordinates.</p>

<p>All coordinates are common Cartesian coordinates in the plane, their absolute value will be at most 10<sup>6</sup>.</p>

### 출력 

 <p>Output the maximum possible number of boats that can be reached by the purple barbecue cloud.</p>

<p>A boat is considered reached if its position is in the circle formed by the cloud, including its boundary. You may assume that increasing the maximal radius of the smoke cloud by 10<sup>−3</sup> would not change the solution.</p>

