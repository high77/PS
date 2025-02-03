import sys
input = sys.stdin.readline

def main():
    h1,m1,s1 = map(int,input().split(":"))
    h2,m2,s2 = map(int,input().split(":"))
    t1 = h1 * 60 * 60 + m1 * 60 + s1
    t2 = h2 * 60 * 60 + m2 * 60 + s2
    t = t2 - t1 if t2 > t1 else t2 - t1 + 24 * 60 * 60
    h = t // 60 // 60
    m = t // 60 % 60
    s = t % 60
    print("{:02}:{:02}:{:02}".format(h,m,s))


if __name__ == "__main__":
    main()
