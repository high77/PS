# [Silver II] Piscina - 13697 

[문제 링크](https://www.acmicpc.net/problem/13697) 

### 성능 요약

메모리: 11720 KB, 시간: 68 ms

### 분류

그리디 알고리즘, 기하학

### 제출 일자

2026년 1월 30일 21:18:38

### 문제 설명

<p>O Centro Comunitário decidiu construir uma nova piscina, em tempo para o verão do ano que vem. A nova piscina será retangular, com dimensões X por Y e profundidade Z. A piscina será recoberta com um novo tipo de azulejos cerâmicos, de alta tecnologia, que é produzido em três tamanhos distintos: 5 × 5, 15 × 15 e 30 × 30 (em centímetros). Cada azulejo desses tamanhos custa 2 centavos, 15 centavos e 50 centavos, respectivamente. Os azulejos são de alta qualidade, feitos com um material que não pode ser cortado (ou seja, os azulejos devem ser utilizados inteiros).</p>

<p>A única loja local que vende esse tipo de azulejo tem em estoque uma certa quantidade de azulejos de cada tamanho. Você deve escrever um programa que determine se o estoque de azulejos disponível na loja é suficiente para azulejar toda a piscina. Se o estoque for suficiente, seu programa deve determinar também o número de azulejos de cada tamanho que são necessários para que o custo de azulejar a piscina seja o menor possível.</p>

<p>Os azulejos devem ser usados para recobrir completamente toda a superfície da piscina, sem deixar qualquer espaço sem azulejos, e sem deixar sobras de azulejos transpassando as bordas da piscina.</p>

### 입력 

 <p>A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas. A primeira linha contém três números reais X, Y e Z, representando as dimensões e a profundidade da piscina, em metros, com precisão de uma casa decimal (0 < X, Y ≤ 50.0 e 0 < Z ≤ 2.0). A segunda linha contém três números inteiros P, M e G, representando a quantidade disponível de azulejos de tamanho pequeno, médio e grande (0 ≤ P, M, G ≤ 2000000), respectivamente. O final da entrada é indicado por X = Y = Z = 0.</p>

### 출력 

 <p>Para cada caso de teste da entrada seu programa deve produzir uma linha de saída. Se ́e possível recobrir completamente a piscina com o estoque disponível, imprima uma linha com três inteiros descrevendo respectivamente as quantidades de azulejos pequenos, médios e grandes para recobrir toda a piscina, com o menor custo possível. Caso contrário, imprima uma linha contendo a palavra ‘impossivel’ (note a ausência de acentuação).</p>

