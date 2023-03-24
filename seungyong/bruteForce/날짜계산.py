e, s, m = map(int, input().split())
year = 0
E = 0
S = 0
M = 0
while(True):
  E += 1
  if E > 15:
    E = 1
  S += 1
  if S > 28:
    S = 1
  M += 1
  if M > 19:
    M = 1
  year += 1
  #print(year, E, S, M)
  if E == e and S == s and M == m:
    print(year)
    break
