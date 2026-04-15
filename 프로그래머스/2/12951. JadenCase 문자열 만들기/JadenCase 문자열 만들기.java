class Solution {
    public StringBuilder solution(String S) {
        StringBuilder res = new StringBuilder();
        int l = S.length();
        for (int i=0;i<l;i++){
            char c = S.charAt(i);
            if (97<=c && c<=122){
                if (i==0 || S.charAt(i-1)==' ') c-=' ';                
            }else if (65<=c && c<=90){
                if (i!=0 && S.charAt(i-1)!=' ') c+=' ';   
            }
            res.append((char)c);
        }
        
        return res;
    }
}