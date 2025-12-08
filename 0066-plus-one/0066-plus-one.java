class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1, i = len - 1, num;
        while(i > -1) {
            num = digits[i] + carry;
            digits[i] = num%10;
            carry = num/10;
            if(carry == 0) break;
            i--;
        }
        if(carry == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        } 
        return digits;
    }
}