# [Platinum II] Path - 11499 

[문제 링크](https://www.acmicpc.net/problem/11499) 

### 성능 요약

메모리: 321624 KB, 시간: 1436 ms

### 분류

자료 구조, 정렬, 기하학, 스택, 볼록 껍질

### 제출 일자

2026년 3월 23일 23:15:05

### 문제 설명

<p>A histogram is a simple rectilinear polygon whose boundary consists of two chains such that the upper chain is monotone with respect to the horizontal axis and the lower chain is a horizontal line segment, called the base segment (See Figure 1).</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11499/1.png" style="height:188px; width:384px"></p>

<p style="text-align:center">Figure 1. A histogram and its base segment (v<sub>0</sub>, v<sub>1</sub>)</p>

<p>Let P be a histogram specified by a list (v<sub>0</sub>, v<sub>1</sub>, … ,v<sub>n-1</sub>) of n vertices in the counterclockwise order along the boundary such that its base segment is (v<sub>0</sub>, v<sub>1</sub>). An edge e<sub>i</sub> is a line segment connecting two vertices v<sub>i</sub> and v<sub>i+1</sub>, where i = 0, 1, … , n − 1 and v<sub>n</sub> = v<sub>0</sub>. </p>

<p>A path inside P is a simple path which does not intersect the exterior of P. The length of the path is defined as the sum of Euclidean length of the line segments of the path. The distance between two points p and q of P is the length of the shortest path inside P between p and q. Your task is to find the distance between v<sub>0</sub> and each point of a given set S of points on the boundary of P. A point of the set S is denoted by p(k, d) which represents a point q on the edge e<sub>k</sub> such that d is the distance between v<sub>k</sub> and q.</p>

<p>In the histogram of Figure 1, the shortest path between v<sub>0</sub> and q<sub>1</sub> = p(10, 2) is a polygonal chain connecting v<sub>0</sub>, v<sub>14</sub>, v<sub>12</sub> and q<sub>1</sub> in that order, and its length is 8.595242. The shortest path between v<sub>0</sub> and q<sub>2</sub> = p(1, 1) is a segment directly connecting v<sub>0</sub> and q<sub>2</sub> with length 15.033296. </p>

<p>Given a histogram P with n vertices and a set S of m points on the boundary of P, write a program to find the distances between v<sub>0</sub> and all points of S.</p>

### 입력 

 <p>Your program is to read from standard input. The input consists of T test cases. The number of test cases T is given in the first line of the input. Each test case starts with a line containing an integer, n (4 ≤ n ≤ 100,000), where n is the number of vertices of a histogram P = (v<sub>0</sub>, v<sub>1</sub>, … , v<sub>n-1</sub>). In the following n lines, each of the n vertices of P is given line by line from v<sub>0</sub> to v<sub>n-1</sub>. Each vertex is represented by two numbers, which are the x-coordinate and the y-coordinate of the vertex, respectively. Each coordinate is given as an integer between 0 and 1,000,000, inclusively. Notice that (v<sub>0</sub>, v<sub>1</sub>) is the base segment. The next line contains an integer m (1 ≤ m ≤ 100,000) which is the size of a set S given as your task. In the following m lines. Each point p(k,d) of S is given line by line, and is represented by two integers k and d, where 0 ≤ k ≤ n − 1 and 0 ≤ d < the length of edge e<sub>k</sub>. All points in the set S are distinct. </p>

### 출력 

 <p>Your program is to write to standard output. Print exactly one line for each test case. The line should contain exactly one real value which is the sum of the distances between v<sub>0</sub> and all points of S. Your output must contain the first digit after the decimal point, rounded off from the second digit. If each result is within an error range, 0.1, it will be considered correct. The Euclidean distance between two points p = (x<sub>1</sub>, y<sub>1</sub>) and q = (x<sub>2</sub>, y<sub>2</sub>) is <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msqrt><mjx-sqrt><mjx-surd><mjx-mo class="mjx-sop"><mjx-c class="mjx-c221A TEX-S1"></mjx-c></mjx-mo></mjx-surd><mjx-box style="padding-top: 0.103em;"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D465 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msub><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-msub space="3"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D465 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-script></mjx-msub><mjx-msup><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo><mjx-script style="vertical-align: 0.289em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msup><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D466 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msub><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-msub space="3"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D466 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-script></mjx-msub><mjx-msup><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo><mjx-script style="vertical-align: 0.289em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msup></mjx-box></mjx-sqrt></mjx-msqrt></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msqrt><mo stretchy="false">(</mo><msub><mi>x</mi><mn>2</mn></msub><mo>−</mo><msub><mi>x</mi><mn>1</mn></msub><msup><mo stretchy="false">)</mo><mn>2</mn></msup><mo>+</mo><mo stretchy="false">(</mo><msub><mi>y</mi><mn>2</mn></msub><mo>−</mo><msub><mi>y</mi><mn>1</mn></msub><msup><mo stretchy="false">)</mo><mn>2</mn></msup></msqrt></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(\sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}\)</span> </mjx-container></p>

