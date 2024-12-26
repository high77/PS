import sys
input = sys.stdin.readline

def Main():
    subject = ["kor","eng","math"]
    fruit = ["apple","pear","orange"]
    color = ["red","blue","green"]
    N,M = map(int,input().split())
    dict_ = {}
    for i in range(N):
        s1,f1,c1 = input().split()
        a,b,c=-1,-1,-1
        for i in range(3):
            if s1==subject[i]:
                a = i
            if f1==fruit[i]:
                b = i
            if c1==color[i]:
                c = i
        a = str(a)
        b= str(b)
        c = str(c)
        if "___" in dict_:dict_["___"]+=1
        else:dict_["___"]=1
        if a+"__" in dict_:dict_[a+"__"]+=1
        else:dict_[a+"__"]=1
        if "_"+b+"_" in dict_:dict_["_"+b+"_"]+=1
        else :dict_["_"+b+"_"]=1
        if "__"+c in dict_ : dict_["__"+c]+=1
        else: dict_["__"+c]=1
        if a+b+"_" in dict_ : dict_[a+b+"_"]+=1
        else: dict_[a+b+"_"]=1
        if a+"_"+c in dict_ : dict_[a+"_"+c]+=1
        else: dict_[a+"_"+c] = 1
        if "_"+b+c in dict_: dict_["_"+b+c] += 1
        else: dict_["_"+b+c] = 1
        if a+b+c in dict_: dict_[a+b+c] += 1
        else:dict_[a+b+c] = 1
    for i in range(M):
        s2,f2,c2 = input().split()
        if s2=="-":s2="_"
        if f2=="-":f2="_"
        if c2=="-":c2="_"
        for i in range(3):
            if s2 == subject[i]:s2= str(i)
            if f2 == fruit[i]:f2 =  str(i)
            if c2 == color[i]:c2 =  str(i)
        if s2+f2+c2 in dict_:print(dict_[s2+f2+c2])
        else:print(0)
Main()