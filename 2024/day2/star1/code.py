# lines are reports
# numbers are levels
# rules:
#   all levels are either increasing or decreasing
#   any two adjacent levels differ by at least one or at most three 1 <= diff >= 3
# how many reports are safe?

# 7 6 4 2 1: Safe because the levels are all decreasing by 1 or 2.
# 1 2 7 8 9: Unsafe because 2 7 is an increase of 5.
# 9 7 6 2 1: Unsafe because 6 2 is a decrease of 4.
# 1 3 2 4 5: Unsafe because 1 3 is increasing but 3 2 is decreasing.
# 8 6 4 4 1: Unsafe because 4 4 is neither an increase or a decrease.
# 1 3 6 7 9: Safe because the levels are all increasing by 1, 2, or 3.
# So, in this example, 2 reports are safe.

file_path_test = "/home/emil/AdventofCode/2024/day2/star1/test.txt"
file_path_input = "/home/emil/AdventofCode/2024/day2/star1/input.txt"
sum = 0

with open(file_path_input,"r") as file:
    for reports in file.readlines():
        levels = [int(val) for val in reports.split(" ")]
        prev_val = None
        prev_diff = 0
        safe = True
        for x in levels:
            if prev_val == None:
                prev_val = x
                continue
            diff = x - prev_val
            if prev_diff < 0 and diff > 0 or prev_diff > 0 and diff < 0 :
                safe = False
                break
            if not 1 <= abs(diff) <= 3:
                safe = False
                break
            prev_val = x
            prev_diff = diff
        if safe:
            sum += 1
print(f"{sum = }")