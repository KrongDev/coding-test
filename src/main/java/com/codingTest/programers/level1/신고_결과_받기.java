package com.codingTest.programers.level1;

import java.util.*;

public class 신고_결과_받기 {
    private int k;
    public class Node {
        private String id;
        private int mailCount;
        private boolean suspension;
        private Set<Node> reportList;

        public Node() {
            this.mailCount = 0;
            this.reportList = new HashSet<>();
        }

        public Node(String id) {
            this();
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public int getMailCount() {
            return mailCount;
        }

        public void addMailCount() {
            this.mailCount++;
        }

        public void report(Node node) {
            // 이미 신고했을 때
            if(this.reportList.contains(node)) {
                return;
            }

            this.reportList.add(node);
            // 이미 정지 되었을 때
            if(this.suspension) {
                node.addMailCount();
                return;
            }
            // 신고수가 정지수와 같을 때
            if(this.reportList.size() == k) {
                this.suspension = true;
                sendEmail();
            }
        }

        public void sendEmail() {
            for(Node node : reportList) {
                node.addMailCount();
            }
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        this.k = k;
        Map<String, Node> idNodes = new HashMap<>();
        Map<Integer, Node> nodeIndex = new HashMap<>();
        int length = id_list.length;
        for(int i = 0; i < length; i++) {
            Node node = new Node(id_list[i]);
            idNodes.put(id_list[i], node);
            nodeIndex.put(i, node);
        }

        for(String str: report) {
            String[] data = str.split(" ");
            Node actionUser = idNodes.get(data[0]);
            Node reportUser = idNodes.get(data[1]);
            reportUser.report(actionUser);
        }
        int[] answer = new int[length];
        for(int i = 0; i < length; i++) {
            answer[i] = nodeIndex.get(i).getMailCount();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        신고_결과_받기 res = new 신고_결과_받기();
        System.out.println(Arrays.toString(res.solution(id_list, report, k)));
    }
}
