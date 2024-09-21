package com.codingTest.programers.level1;

import java.util.Arrays;

public class 실패율 {

    public static class Node {
        int stage;
        double failCount;

        public Node(int stage, double failCount) {
            this.stage = stage;
            this.failCount = failCount;
        }

        public int getStage() {
            return stage;
        }

        public double getFailCount() {
            return failCount;
        }
    }
    /**
     *
     * @param N         스테이지 수
     * @param stages    사용자가 멈춰있는 스테이지 번호
     * @return result   실패율이 높은 스테이지부터 내림차순으로 정렬
     */
    public int[] solution(int N, int[] stages) {
        Node[] answer = new Node[N];

        int[] fails = new int[N];
        for (int failStage: stages) {
            if(failStage <= N) {
                fails[failStage - 1]++;
            }
        }

        int player = stages.length;
        for(int i = 0; i < N; i++) {
            answer[i] = new Node(i + 1, fails[i] == 0 ? 0 : (double) fails[i] /player);
            player -= fails[i];
        }

        Arrays.sort(answer, (a,b) ->  {
            double  compare = Double.compare(a.getFailCount(), b.getFailCount());
            if(compare != 0)
                return compare > 0 ? -1 : 1;
            return a.getStage() - b.getStage();
        });

        return Arrays.stream(answer).mapToInt(Node::getStage).toArray();
    }

    public static void main(String[] args) {
        실패율 res = new 실패율();
        int N = 4;
        int[] stages = {4, 4, 4, 4,4};
        int[] arr = res.solution(N, stages);
        System.out.println(arr);
    }
}
