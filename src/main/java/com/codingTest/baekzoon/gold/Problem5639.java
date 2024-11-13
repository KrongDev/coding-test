package com.codingTest.baekzoon.gold;

import java.io.*;

public class Problem5639 {

    public static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class  BinaryTree {
        TreeNode root;

        public void add(int val) {
            this.root = this.add(root, val);
        }

        public TreeNode add(TreeNode current, int val) {
            if (current == null) {
                current = new TreeNode(val);
            }

            if(current.val == val) {
                return current;
            }

            if(current.val > val) {
                current.left = add(current.left, val);
            } else {
                current.right = add(current.right, val);
            }
            return current;
        }

        public StringBuilder printPost() {
            StringBuilder result = new StringBuilder();
            printPost(result, root);
            return result;
        }

        public void printPost(StringBuilder sb, TreeNode current) {
            if(current == null) return;
            printPost(sb, current.left);
            printPost(sb, current.right);
            sb.append(current.val).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BinaryTree bt = new BinaryTree();
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            bt.add(Integer.parseInt(str));
        }

        bw.write(bt.printPost().toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
