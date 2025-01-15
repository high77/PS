a1, a2 = map(int, input().split())
b1, b2 = map(int, input().split())
c1, c2 = map(int, input().split())

# Calculate squared lengths of the sides
len_ab = (b1 - a1) ** 2 + (b2 - a2) ** 2
len_bc = (b1 - c1) ** 2 + (b2 - c2) ** 2
len_ac = (c1 - a1) ** 2 + (c2 - a2) ** 2

lengths = sorted([len_ab, len_bc, len_ac])
lengths_sqrt = sorted([len_ab ** 0.5, len_bc ** 0.5, len_ac ** 0.5])

d = lengths[0] + lengths[1]

if lengths_sqrt[2] >= lengths_sqrt[1] + lengths_sqrt[0]:
    print('X')
else:
    result = []
    if lengths_sqrt[0] == lengths_sqrt[1] == lengths_sqrt[2]:
        result.append('Jung')
    elif lengths_sqrt[0] == lengths_sqrt[1] or lengths_sqrt[1] == lengths_sqrt[2]:
        if d < lengths[2]:
            result.append('Dunkak')
        elif d == lengths[2]:
            result.append('Jikkak')
        else:
            result.append('Yeahkak')
        result.append('2')
    else:
        if d < lengths[2]:
            result.append('Dunkak')
        elif d == lengths[2]:
            result.append('Jikkak')
        else:
            result.append('Yeahkak')
    result.append('Triangle')
    print(''.join(result))
