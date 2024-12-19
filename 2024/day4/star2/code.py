import re
file_path_input = "/home/emil/AdventofCode/2024/day4/star2/input.txt"
file_path_test = "2024/day4/star2/test.txt"
with open(file_path_input, 'r') as file:
    input_content = file.readlines()
input_content = [line.strip('\n') for line in input_content]

sum = 0
for row, line in enumerate(input_content):
    for col, element in enumerate(line):
        if element == 'A':
            if row > 0 and row < len(input_content) - 1 and col > 0 and col < len(line) - 1:
                str1 = input_content[row-1][col-1] + input_content[row][col] + input_content[row+1][col+1]
                str2 = input_content[row-1][col+1] + input_content[row][col] + input_content[row+1][col-1]
                found1 = len(re.findall(r'MAS|SAM',str1))
                found2 = len(re.findall(r'MAS|SAM',str2))
                if found1 and found2:
                    sum += 1
print(f'{sum = }')