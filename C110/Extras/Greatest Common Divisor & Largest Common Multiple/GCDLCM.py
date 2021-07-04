def findGCD(nums):
    result = 0
    for num in nums:
        result = gcd(result, num)
        if result == 1:
            return 1
    return result


def gcd(num1, num2):
    if num2 == 0:
        return num1
    return gcd(num2, (num1 % num2))


def lcm(num1, num2):
    return num1 * num2 // gcd(num1, num2)


def findLCM(nums):
    result = nums[0]
    for i in range(1, len(nums)):
        result = lcm(result, nums[i])
        if result == 1:
            return 1
    return result


def main():
    number_of_numbers = int(input("Enter the number of numbers\n"))
    nums = list()
    for i in range(0, number_of_numbers):
        nums.append(int(input("Enter number\n")))
    print("GCD: " + str(findGCD(nums)))
    print("LCM: " + str(findLCM(nums)))


if __name__ == '__main__':
    main()