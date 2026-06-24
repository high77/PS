class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p=0;
        int y=0;
        for (char c:s.toCharArray()){
            if (c=='p' || c=='P') p++;
            else if (c=='y' || c=='Y') y++;
        }


        return p==y?true:false;
    }
}