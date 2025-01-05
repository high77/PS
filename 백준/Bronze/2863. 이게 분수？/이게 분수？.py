import sys
input = sys.stdin.readline

def main():
    A, B = map(int , input().split())
    C, D = map(int , input().split())
    list_ = [A / C + B / D, C / D + A / B, D / B + C / A, B / A + D / C]
    print(list_.index(max(list_)))
main()