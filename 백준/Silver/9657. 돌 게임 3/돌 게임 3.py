import sys
input = sys.stdin.readline

def main():
    N = int(input())
    if N%7==0 or N%7==2:
        print("CY")
    else:
        print("SK")



if __name__ == "__main__":
    main()
