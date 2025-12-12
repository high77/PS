def reverse_bit(bit):
    bit = list(bit)
    for idx in range(len(bit)):
        bit[idx] = str(abs(int(bit[idx])-1))
        
    return "".join(bit)

def delete_file(N, before_bit, after_bit):
    answer = "Deletion failed"
    
    for _ in range(N):
        before_bit = reverse_bit(bit=before_bit)
    
    if before_bit == after_bit:
        answer = "Deletion succeeded"
        
    return answer


if __name__ == "__main__":
    N = int(input())
    before_bit = input()
    after_bit = input()
    
    print(delete_file(N=N, before_bit=before_bit, after_bit=after_bit))