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
            int[] res = copy(digits);
            res[0] = 1;
            return res;
        } 
        return digits;
    }

    private int[] copy(int[] arr) {
        int[] res = new int[arr.length + 1];

        for(int i = 0; i < arr.length; i++) {
            res[i + 1] = arr[i];
        }
        return res;
    }
}