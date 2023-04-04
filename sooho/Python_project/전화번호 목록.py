def solution(phone_book):
    phone_book.sort()
    flag = True
    for i in phone_book:
        tmp = list(i)