import re

file_path_test = "2024/day3/star2/test.txt"
file_path_input = "2024/day3/star2/input.txt"
with open(file_path_input,'r') as file:
    input = file.read()

matches = re.findall(r"mul\(\d*,\d*\)|do\(\)|don't\(\)",input)
sum_matches = 0
active = True
for match in matches:
    if match == "do()":
        active = True
        continue
    if match == "don't()":
        active = False
        continue
    if active:
        factors = re.findall(r"(\d*),(\d*)", match)
        x = int(factors[0][0])
        y = int(factors[0][1])
        sum_matches += x * y
print(f"{sum_matches = }")