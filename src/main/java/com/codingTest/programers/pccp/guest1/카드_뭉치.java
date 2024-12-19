package com.codingTest.programers.pccp.guest1;

public class 카드_뭉치 {
    private final String SUCCESS = "Yes";
    private final String FAIL = "No";

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;

        for (int i = 0; i < goal.length; i++) {
            if(i < goal.length - 1 && checkCard(cards1, cards2, card1Index, card2Index, goal[i], goal[i + 1])) {
                card2Index++;
                continue;
            }
            if(checkCard1(cards1, card1Index, goal[i])) {
                card1Index++;
                continue;
            }
            if(checkCard2(cards2, card2Index, goal[i])) {
                card2Index++;
                continue;
            }
            return FAIL;
        }
        return SUCCESS;
    }

    private boolean checkCard(String[] cards1, String[] cards2, int card1Index, int card2Index, String text, String next) {
        if(card1Index == cards1.length || card2Index == cards2.length) return false;
        if(!cards1[card1Index].equals(text)) return false;
        if(!cards1[card1Index].equals(cards2[card2Index])) return false;
        return checkCard2(cards2, card2Index + 1, next);
    }

    private boolean checkCard1(String[] cards1, int card1Index, String text) {
        if(card1Index == cards1.length) return false;
        return cards1[card1Index].equals(text);
    }

    private boolean checkCard2(String[] cards2, int card2Index, String text) {
        if(card2Index == cards2.length) return false;
        return cards2[card2Index].equals(text);
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "water", "drink"};
        카드_뭉치 res = new 카드_뭉치();
        System.out.println(res.solution(cards1, cards2, goal));
    }
}
