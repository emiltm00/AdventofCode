# lägg in i två arrays, sortera dessa och sedan kör för varje index

file_path_test = "/home/emil/AdventofCode/2024/day1/star1/test.txt"
file_path_input = "/home/emil/AdventofCode/2024/day1/star1/input.txt"
array_left = []
array_right = []

with open(file_path_input, "r") as file:
    for line in file:
        values = line.split()
        array_left.append(values[0])
        array_right.append(values[1])

array_left.sort()
array_right.sort()

index = 0
sum = 0
for value in array_left:
    sum += abs(int(value) - int(array_right[index]))
    index += 1

print(F"Sum: {sum}") 