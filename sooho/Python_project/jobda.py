from itertools import combinations
#5, 5, 5, 6, 6, 6
def solution(n,a,b,c,v):
    lst = list(combinations(1000,3))
    nmax = -1
    if a[0] > v or b[0] > v or c[0] > v:return -1
    for i in a:
        for j in b:
            if i * j > v: break
            for h in c:
                if nmax < i*j*h < v:
                    nmax = i * j * h
                elif i * h * j == v: return i*j*h
                else: break
    return nmax


print(solution(3, [1,2,3],[4,5,6],[10,11,12],101))



