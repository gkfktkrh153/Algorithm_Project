
N, M = map(int, input().split())

visited = [False for i in range(N+1)]
arr = []

def func(k):
    if len(arr) == M:
        for num in arr:
            print(num, end =' ' )
        print()
    for i in range(k, N + 1):
        if visited[i] == False:
            visited[i] = True
            arr.append(i)
            func(i+1)
            visited[i] = False
            arr.pop()
func(1)