package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class Problem10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SampleQueue<Integer> queue = new SampleQueue<>();

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        while (len-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(getValue(queue.pollFirst())).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(getValue(queue.peekFirst())).append("\n");
                    break;
                case "back":
                    sb.append(getValue(queue.peekLast())).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static int getValue(Integer value) {
        return value == null ? -1 : value;
    }

    public static class SampleQueue<T> {
        private T[] elements;
        private int head = -1;
        private int tail = -1;
        private int size = 0;
        private int maxSize = 10000;

        public SampleQueue() {
            elements = (T[]) new Object[maxSize];
        }

        public int size() {
            return this.size;
        }

        public void add(T element) {
            this.tail++;
            this.size++;
            this.elements[this.tail] = element;
        }

        public T pollFirst() {
            if(isEmpty()) return null;
            this.size--;
            this.head++;
            return this.elements[head];
        }

        public T peekFirst() {
            if(isEmpty()) return null;
            return this.elements[head + 1];
        }

        public T peekLast() {
            if(isEmpty()) return null;
            return this.elements[tail];
        }

        public boolean isEmpty() {
            return this.head == this.tail;
        }
    }
}
