# [Platinum I] Ink Blots - 4634 

[문제 링크](https://www.acmicpc.net/problem/4634) 

### 성능 요약

메모리: 21092 KB, 시간: 204 ms

### 분류

조합론, 자료 구조, 깊이 우선 탐색, 분리 집합, 기하학, 그래프 이론, 그래프 탐색, 선분 교차 판정, 수학, 평면 그래프

### 제출 일자

2026년 3월 8일 16:30:04

### 문제 설명

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/4634/1.gif" style="height:110px; width:104px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/4634/2.gif" style="height:200px; width:258px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/4634/3.gif" style="height:237px; width:237px"></td>
		</tr>
		<tr>
			<td style="text-align:center">Figure 1: 1 White Region</td>
			<td style="text-align:center">Figure 2: 3 White Regions</td>
			<td style="text-align:center">Figure 3: 4 White Regions</td>
		</tr>
	</tbody>
</table>

<p>Drops of dark ink can fall on a white piece of paper creating a number of round ink blots. Three examples are shown above. The blots can create multiple distinct white regions. In the first figure, there is just one white region. In the second figure there is the outer white region plus a small white region bounded by the left four blots and an even smaller white region bounded by the right three blots. In the third figure, there are four white regions, one on the very outside, one inside the outer ring of blots and outside the four blots in the middle, and two tiny ones each formed between three of the four inner blots.</p>

<p>Two points are in the same white region if a path can be drawn between them that only passes through white points. Your problem is to count the number of white regions given the centers and radii of the blots.</p>

<p><strong>Math Formulas:</strong> If circles</p>

<blockquote><em>C</em><sub>1</sub> with center <em>(x</em><sub>1</sub><em>, y</em><sub>1</sub><em>)</em> and radius <em>r</em><sub>1</sub>, and<br>
<em>C</em><sub>2</sub> with center <em>(x</em><sub>2</sub><em>, y</em><sub>2</sub><em>)</em> and radius <em>r</em><sub>2</sub></blockquote>

<p>intersect in exactly two distinct points, let</p>

<blockquote><em>d</em> equal the distance between the centers of <em>C</em><sub>1</sub><em><em> </em></em>and<em><em> C</em><sub>2</sub></em>,<br>
<em>A</em> = atan2<em>(y</em><sub>2</sub><em>-y</em><sub>1</sub><em>, x</em><sub>2</sub><em>-x</em><sub>1</sub><em>)</em>, and<br>
<em>B</em> = acos<em>((</em><em><em><em>r</em><sub>1</sub><sup>2</sup> + </em></em><em><em><em><em>d</em><sup>2</sup></em></em></em><em><em><em> - r</em><sub>2</sub><sup>2</sup></em></em><em>)/(2*</em><em><em>r</em><sub>1</sub>*d</em><em>))</em>;</blockquote>

<p>then the intersection points on <em>C</em><sub>1</sub> are at angles <em>A</em>+<em>B</em> and <em>A</em>-<em>B</em> radians counterclockwise from the ray extending to the right from the center of <em>C</em><sub>1</sub>. The function atan2 is the inverse tangent function with two arguments, and acos is the inverse cosine function, both available in the math libraries of C, C++, and Java.</p>

### 입력 

 <p>There are from one to 15 data sets, followed by a final line containing only 0. A data set starts with a line containing a single positive integer <em>n</em>, which is no more than 100. It is the number of blots in the dataset. Then 3<em>n</em> positive integers follow, with a single blank or a newline separating them.  Each group of three give the data for the circular boundary of one blot: x and y coordinate of the center of the blot and its radius, in that order. Each of these numbers will be no larger than 1,000,000. All blots lie entirely on a piece of paper, and no blot touches any edge of the paper. No two circles in a dataset will be identical. Given any two distinct circles, they will either intersect at exactly two distinct points or not intersect at all. If two circles in the input intersect, then they overlap by at least one unit. More precisely, if they have radii <em>r</em><sub>1</sub> and <em>r</em><sub>2</sub>, where <em>r</em><sub>1</sub> ≤ <em>r</em><sub>2</sub>, and if <em>d</em> is the distance between their centers, then</p>

<blockquote><em>r</em><sub>2</sub><em> - r</em><sub>1</sub> + 1 ≤ <em>d</em> ≤ <em>r</em><sub>1</sub><em> + r</em><sub>2</sub><em> - </em>1.</blockquote>

<p>Three or more circles will never intersect at the same point. If <em>C</em> is a circle in the input that intersects at least one other input circle, and <em>p</em> and <em>q</em> are any of the intersection points of <em>C</em> with any of the other input circles, with <em>p</em> distinct from <em>q</em>, then <em>p</em> and <em>q</em> will be separated on <em>C</em> by at least 0.001 radians of arc. The restrictions on radii and angles ensure that standard double-precision arithmetic is sufficient for the calculations suggested above.</p>

<p>The sample input below corresponds to the figures above, though the scale is different in each figure.</p>

### 출력 

 <p>The output contains one line for each data set.  The line contains only the number of white regions for the dataset, which is never more than 200.</p>

<p><strong><em>Warning</em></strong>: Brute force raster methods of solving this problem will take up too much memory and be too slow.</p>

