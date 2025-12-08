class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0, len = s.length();
        boolean flag = false;
        for(int i = len - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(flag) break;
                else continue;
            }
            flag = true;
            res++;
        }

        return res;
    }
}