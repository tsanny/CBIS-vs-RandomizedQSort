from random import randint

def generate(length, name, reversed=False, random=False, sorted=False):
    text=""
    file = open(name, "w")
    if sorted:
        for i in range(1, length+1):
            text += str(i) + "\n"
    elif random:
        for i in range(1, length+1):
            text += str(randint(1, length)) + "\n"
    elif reversed:
        for i in range(length, 0, -1):
            text += str(i) + "\n"
    file.write(text.strip())

generate(200, "small_sorted.txt", sorted=True)
generate(200, "small_reversed.txt", reversed=True)
generate(200, "small_random.txt", random=True)
generate(2000, "medium_sorted.txt", sorted=True)
generate(2000, "medium_reversed.txt", reversed=True)
generate(2000, "medium_random.txt", random=True)
generate(20000, "large_sorted.txt", sorted=True)
generate(20000, "large_reversed.txt", reversed=True)
generate(20000, "large_random.txt", random=True)