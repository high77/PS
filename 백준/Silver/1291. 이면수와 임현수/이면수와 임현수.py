import math

def num_digits(n):
    return len(str(n))

def is_prime(n):
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def check1(n):
    digits = [int(d) for d in str(n)]
    return n >= 4 and n != 5 and sum(digits) % 2 == 1

def check2(n):
    if n in (2, 4):
        return True
    if is_prime(n) or n == 1:
        return False
    factors = [i for i in range(2, n) if n % i == 0 and is_prime(i)]
    return len(factors) % 2 == 0

n = int(input())
if check1(n) and check2(n):
    print(4)
elif check1(n):
    print(1)
elif check2(n):
    print(2)
else:
    print(3)
