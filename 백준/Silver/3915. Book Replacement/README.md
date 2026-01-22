# [Silver I] Book Replacement - 3915 

[문제 링크](https://www.acmicpc.net/problem/3915) 

### 성능 요약

메모리: 25224 KB, 시간: 216 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2026년 1월 22일 21:26:14

### 문제 설명

<p>The deadline of Prof. Hachioji's assignment is tomorrow. To complete the task, students have to copy pages of many reference books in the library.</p>

<p>All the reference books are in a storeroom and only the librarian is allowed to enter it. To obtain a copy of a reference book’s page, a student should ask the librarian to make it. The librarian brings books out of the storeroom and makes page copies according to the requests. The overall situation is shown in Figure 1.</p>

<p>Students queue up in front of the counter. Only a single book can be requested at a time. If a student has more requests, the student goes to the end of the queue after the request has been served.</p>

<p>In the storeroom, there are m desks D<sub>1</sub>, · · · , D<sub>m</sub>, and a shelf. They are placed in a line in this order, from the door to the back of the room. Up to c books can be put on each of the desks. If a student requests a book, the librarian enters the storeroom and looks for it on D<sub>1</sub>, . . . , D<sub>m</sub> in this order, and then on the shelf. After finding the book, the librarian takes it and gives a copy of a page to the student.</p>

<p style="text-align:center"><img alt="" src="https://www.acmicpc.net/upload/imagesa/figure1%20lib.png" style="height:234px; width:724px"></p>

<p style="text-align:center">Figure 1: The Library</p>

<p>Then the librarian returns to the storeroom with the requested book, to put it on D<sub>1</sub> according to the following procedure.</p>

<ul>
	<li>If D<sub>1</sub> is not full (in other words, the number of books on D<sub>1</sub> < c), the librarian puts the requested book there.</li>
	<li>If D<sub>1</sub> is full, the librarian
	<ul>
		<li>temporarily puts the requested book on the non-full desk closest to the entrance or, in case all the desks are full, on the shelf,</li>
		<li>finds the book on D<sub>1</sub> that has not been requested for the longest time (i.e. the least recently used book) and takes it,</li>
		<li>puts it on the non-full desk (except D<sub>1</sub>) closest to the entrance or, in case all the desks except D<sub>1</sub> are full, on the shelf,</li>
		<li>takes the requested book from the temporary place,</li>
		<li>and finally puts it on D1.</li>
	</ul>
	</li>
</ul>

<p>Your task is to write a program which simulates the behaviors of the students and the librarian, and evaluates the total cost of the overall process. Costs are associated with accessing a desk or the shelf, that is, putting/taking a book on/from it in the description above. The cost of an access is i for desk D<sub>i</sub> and m+1 for the shelf. That is, an access to D<sub>1</sub>,· · ·,D<sub>m</sub>, and the shelf costs 1, · · · , m, and m + 1, respectively. Costs of other actions are ignored.</p>

<p>Initially, no books are put on desks. No new students appear after opening the library.</p>

### 입력 

 <p>The input consists of multiple datasets. The end of the input is indicated by a line containing three zeros separated by a space. It is not a dataset.</p>

<p>The format of each dataset is as follows.</p>

<pre>m c n
k<sub>1</sub>
b<sub>11</sub> ... b<sub>1k1</sub>
...
k<sub>n</sub>
b<sub>n1</sub> ... b<sub>nkn</sub>
</pre>

<p>Here, all data items are positive integers. m is the number of desks not exceeding 10. c is the number of books allowed to put on a desk, which does not exceed 30. n is the number of students not exceeding 100. k<sub>i</sub> is the number of books requested by the i-th student, which does not exceed 50. b<sub>ij</sub> is the ID number of the book requested by the i-th student on the j-th turn. No two books have the same ID number. Note that a student may request the same book more than once. b<sub>ij</sub> is less than 100.</p>

<p>Here we show you an example of cost calculation for the following dataset.</p>

<pre>3 1 2
3
60 61 62
2
70 60</pre>

<p>In this dataset, there are 3 desks (D<sub>1</sub>,D<sub>2</sub>,D<sub>3</sub>). At most 1 book can be put on each desk. The number of students is 2. The first student requests 3 books of which IDs are 60, 61, and 62, respectively, and the second student 2 books of which IDs are 70 and 60, respectively.</p>

<p>The calculation of the cost for this dataset is done as follows. First, for the first request of the first student, the librarian takes the book 60 from the shelf and puts it on D<sub>1</sub> and the first student goes to the end of the queue, costing 5. Next, for the first request of the second student, the librarian takes the book 70 from the shelf, puts it on D<sub>2</sub>, moves the book 60 from D<sub>1</sub> to D<sub>3</sub>, and finally moves the book 70 from D<sub>2</sub> to D<sub>1</sub>, costing 13. Similarly, the cost for the books 61, 60, and 62, are calculated as 14, 12, 14, respectively. Therefore, the total cost is 58.</p>

### 출력 

 <p>For each dataset, output the total cost of processing all the requests, in a separate line.</p>

