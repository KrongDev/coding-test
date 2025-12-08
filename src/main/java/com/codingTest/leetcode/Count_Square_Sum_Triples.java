package com.codingTest.leetcode;

public class Count_Square_Sum_Triples {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                long sumOfSquares = (long)a * a + (long)b * b;
                if (sumOfSquares > (long)n * n) {
                    continue;
                }

                double sqrtValue = Math.sqrt(sumOfSquares);

                long c = Math.round(sqrtValue);
                if (c * c == sumOfSquares && c <= n) {
                    count++;
                }
            }
        }

        return count;
    }
}
