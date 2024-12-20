package com.codingTest.programers.level1;

import java.util.*;

public class 개인정보_수집_유효기간 {
    private Map<String, Integer> termsMap = new HashMap<String, Integer>();

    private int todayYear;
    private int todayMonth;
    private int todayDay;

    public int[] solution(String today, String[] terms, String[] privacies) {
        setTermsMap(terms);
        setToday(today);

        int[] answer = getCutPrivaciesIndex(privacies).stream().mapToInt(Integer::valueOf).toArray();
        return answer;
    }

    private void setTermsMap(String[] terms) {
        for(String term : terms) {
            String[] termData = term.split(" ");
            termsMap.put(termData[0], Integer.parseInt(termData[1]));
        }
    }

    private void setToday(String today) {
        String[] todayData = today.split("\\.");
        todayYear = Integer.parseInt(todayData[0]);
        todayMonth = Integer.parseInt(todayData[1]);
        todayDay = Integer.parseInt(todayData[2]);
    }

    private List<Integer> getCutPrivaciesIndex(String[] privacies) {
        List<Integer> cutPrivacies = new ArrayList<Integer>();

        for(int i = 0; i < privacies.length; i++) {
            String[] privaciesData = privacies[i].split(" ");
            int term = termsMap.get(privaciesData[1]);
            String[] createdAt = privaciesData[0].split("\\.");
            int year = Integer.parseInt(createdAt[0]);
            int month = Integer.parseInt(createdAt[1]);
            int day = Integer.parseInt(createdAt[2]);

            int gapYear = todayYear - year;
            int gapMonth = todayMonth - month + gapYear * 12;
            // term 보다 작은 개월수를 가진 경우
            if(gapMonth < term) {
                continue;
            }

            if(gapMonth == term && day > todayDay) {
                continue;
            }

            cutPrivacies.add(i + 1);
        }

        return cutPrivacies;
    }

//    public static void main(String[] args) {
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//
//        개인정보_수집_유효기간 res = new 개인정보_수집_유효기간();
//        System.out.println(Arrays.toString(res.solution(today, terms, privacies)));
//    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        개인정보_수집_유효기간 res = new 개인정보_수집_유효기간();
        System.out.println(Arrays.toString(res.solution(today, terms, privacies)));
    }
}
