def distinct(lst):
  sorted_lst = sorted(lst)
  distinct_lst = [] if len(sorted_lst) == 0 else sorted_lst[:1]
  for index in range(1, len(sorted_lst)):
    if sorted_lst[index] != sorted_lst[index - 1]:
      distinct_lst.append(sorted_lst[index])
  return distinct_lst
