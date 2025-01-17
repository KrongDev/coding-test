package com.codingTest.programers.level1;

public class 키패드_누르기 {
    private static final int[][] keyPad = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
    };

    private StringBuilder sb;
    private static final String R = "R";
    private static final String L = "L";
    private boolean rightKnob;

    private int[] left = {3, 0};
    private int[] right = {3, 2};

    public String solution(int[] numbers, String hand) {
        rightKnob = "right".equals(hand);
        sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            moveHand(numbers[i]);
        }
        return sb.toString();
    }

    private void moveHand(int number) {
        int[] point = keyPad[number];

        if(point[1] == 0) {
            sb.append("L");
            left = point;
            return;
        }


        if(point[1] == 2) {
            sb.append("R");
            right = point;
            return;
        }

        int leftMove = Math.abs(point[0] - left[0]) + Math.abs(point[1] - left[1]);
        int rightMove = Math.abs(point[0] - right[0]) + Math.abs(point[1] - right[1]);

        if(leftMove == rightMove) {
            if(rightKnob) {
                sb.append("R");
                right = point;
            } else {
                sb.append("L");
                left = point;
            }
            return;
        }
        if(leftMove < rightMove) {
            sb.append("L");
            left = point;
        } else {
            sb.append("R");
            right = point;
        }
    }

    public static void main(String[] args) {
        키패드_누르기 res = new 키패드_누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(res.solution(numbers,hand));
    }

}
