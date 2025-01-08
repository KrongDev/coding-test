package com.codingTest.programers.level1;

public class 하샤드_수 {
    public boolean solution(int x) {
        int check = x;
        int y = 0;
        while(check != 0) {
            y += check%10;
            check /= 10;
        }
        return x%y == 0;
    }

    public static void main(String[] args) {
        int x = 10;
        하샤드_수 res = new 하샤드_수();
        System.out.println(res.solution(x));
    }
}
