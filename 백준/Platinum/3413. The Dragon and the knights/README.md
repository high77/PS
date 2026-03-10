# [Platinum II] The Dragon and the knights - 3413 

[문제 링크](https://www.acmicpc.net/problem/3413) 

### 성능 요약

메모리: 207616 KB, 시간: 2168 ms

### 분류

자료 구조, 오일러 지표 (χ=V-E+F), 기하학

### 제출 일자

2026년 3월 10일 20:02:27

### 문제 설명

<p>The Dragon of the Wawel Castle, following the conflict with the local Shoemakers’ Guild, decided to move its hunting grounds out of Kraków, to a less hostile neighborhood. Now it is bringing havoc and terror to the peaceful and serene Kingdom of Bytes.</p>

<p>In the Kingdom of Bytes there are n rivers and each of them flows along a straight line (that is, you may think of the Kingdom as the Euclidean plane divided by infinite lines). No three rivers have a common point. The rivers divide the Kingdom into some districts.</p>

<p>Fortunately, there are m valiant knights in the Kingdom. Each of them has taken his post and swore an oath to protect his district. The Kingdom is thus protected for evermore... or is it?</p>

<p>It is known that Dragon will not attack a district which has at least one knight inside. The knights, however, are famous for their courage in battle, not for their intelligence. They may have forgotten to protect some of the districts.</p>

<p>Given a map of the Kingdom and the knights’ positions, determine whether all districts are protected.</p>

### 입력 

 <p>The first line of the input contains the number of test cases T. The descriptions of the test cases follow:</p>

<p>Each test case starts with a line containing the number of rivers n (1 ≤ n ≤ 100) and the number of knights m (1 ≤ m ≤ 50 000). Then follow n lines describing rivers. The j-th of them contains three space-separated integers A<sub>j</sub> , B<sub>j</sub> , C<sub>j</sub> of absolute values not exceeding 10 000. These integers are the coefficients of the equation A<sub>j</sub> · x + B<sub>j</sub> · y + C<sub>j</sub> = 0 of the line along which the j-th river flows. After that, there are m lines describing the positions of the knights: the i-th of these lines contains two integers X<sub>i</sub>, Y<sub>i</sub> (−10<sup>9</sup> ≤ X<sub>i</sub>, Y<sub>i</sub> ≤ 10<sup>9</sup>)—the coordinates of the i-th knight. You may assume that no knight is standing in a river (his shining armour would quickly rust if he did). Two knights may occupy the same post (their coordinates can be equal). No two rivers flow along the same line and no three rivers have a common point.</p>

### 출력 

 <p>Print the answers to the test cases in the order in which they appear in the input. For each test case, output a single line containing a single word PROTECTED if all districts are safe from the Dragon, and VULNERABLE otherwise.</p>

