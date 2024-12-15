import re

file_path_test = "2024/day3/star1/test.txt"
file_path_input = "2024/day3/star1/input.txt"
with open(file_path_input,'r') as file:
    input = file.read()

matches = re.findall(r"mul\((\d+),(\d+)\)" ,input)
sum_producs = 0
for match in matches:
    x = int(match[0])
    y = int(match[1])
    sum_producs += x * y
print(f"{sum_producs = }")