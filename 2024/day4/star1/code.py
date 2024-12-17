import re

file_path_input = "2024/day4/star1/input.txt"
file_path_test = "2024/day4/star1/test.txt"
with open(file_path_input, 'r') as file:
    input = file.readlines()

"""
Find diagonals
"""
diagonal_right= []
diagonal_left= []
count1 = len(input) - 1
count2 = 0
for right_line in input:
    right_line = right_line.strip('\n')
    left_line = right_line
    for stack1 in range(count1):
        right_line = '.' + right_line
        left_line= left_line + '.'
    for stack2 in range(count2):
        right_line = right_line + '.'
        left_line = '.' + left_line
    diagonal_right.append(right_line)
    diagonal_left.append(left_line)
    count1 -= 1
    count2 += 1

def get_vertical(m: list) -> list:
    """
    Return a list with strings of the verticals of the input
    """
    return_list = []
    for element in range(len(m[len(m)-1])):
        temp_list = ''
        for line in range(len(m)):
            temp_list = temp_list + (m[line][element])
        return_list.append(temp_list)
    return return_list

def search(m: list) -> int:
    """
    Searches the list for XMAS, SAMX
    Returns int of how many occurances
    """
    temp_sum=0
    for line in m:
       temp_sum += len(re.findall(r'(?=XMAS)|(?=SAMX)',line))
    return temp_sum

vertical_input = get_vertical(input)
vertical_diagonal_right = get_vertical(diagonal_right)
vertical_diagonal_left = get_vertical(diagonal_left)

total_sum = 0
total_sum += search(input)
total_sum += search(vertical_input)
total_sum += search(vertical_diagonal_right)
total_sum += search(vertical_diagonal_left)
print(f'{total_sum = }')