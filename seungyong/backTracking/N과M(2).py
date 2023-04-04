def permutation(N, M,current, lst):
  if len(lst) == M:
    for num in lst:
      print(num, end=' ')
    print()
  
  for i in range(current, N + 1): # 1 ~ N
    if visited[i] == False:
      visited[i] = True
      lst.append(i)
      permutation(N, M, i,lst)
      lst.pop()
      visited[i] = False


N, M = map(int, input().split())
visited = [False for i in range(N+1)]

permutation(N, M, 1, [])
"""
1 ->       1(X) 
	2(O)   -> 1 2
	3(O)   -> 1 3
	4(O)   -> 1 4

2 ->       2(X)  
	3(O)    -> 2 3
	4(O)    -> 2 4

3 ->       3(X)    
	4(O)    -> 3 4
4 ->       4(X)    -> 4 4
"""