# lägg in i två arrays, sortera dessa och sedan kör för varje index

file_path_test = "/home/emil/AdventofCode/2024/day1/star1/test.txt"
file_path_input = "/home/emil/AdventofCode/2024/day1/star1/input.txt"
array_left = []
array_right = []

with open(file_path_input, "r") as file:
    for line in file:
        values = line.split()
        array_left.append(int(values[0]))
        array_right.append(int(values[1]))

array_left.sort()
array_right.sort()

count = 0
sum = 0
for value_left in array_left:
    count = 0
    for value_right in array_right:
        if value_left < value_right:
            break
        if value_left == value_right:
            count += 1
    sum += value_left * count
print(F"Sum is: {sum}")