def permutation(N, M, lst):
  if len(lst) == M:
    for num in lst:
      print(num, end=' ')
    print()
    return 
  
  for i in range(1, N + 1): # 1 ~ N
    lst.append(i)
    permutation(N, M,lst)
    lst.pop()


N, M = map(int, input().split())
#visited = [False for i in range(N+1)]

permutation(N, M, [])
"""
1 ->      1 	1
		2
		3
		4
	2
		1
		2
		3
		4
	3
		1
		2
		3
		4
	4

2 ->     1
	2
	3
	4

"""