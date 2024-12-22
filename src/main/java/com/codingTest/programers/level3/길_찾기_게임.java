package com.codingTest.programers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길_찾기_게임 {

    class TreeNode {
        int val;
        int x, y;
        TreeNode left, right;

        TreeNode(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    class LoadMap {
        TreeNode root;
        int len;

        public void insert(TreeNode addNode) {
            this.root = insert(this.root, addNode);
            len++;
        }

        private TreeNode insert(TreeNode prev, TreeNode newNode) {
            if(prev == null)
                return newNode;

            if(newNode.x > prev.x) {
                prev.right = insert(prev.right, newNode);
            } else {
                prev.left = insert(prev.left, newNode);
            }
            return prev;
        }

        public int[] getPreorder() {
            int[] res = new int[len];
            preorder(this.root, 0, res);
            return res;
        }

        public int[] getPostorder() {
            int[] res = new int[len];
            postorder(this.root, 0, res);
            return res;
        }

        public int preorder(TreeNode node, int i, int[] answer) {
            if(node == null) return i;
            answer[i] = node.val;
            i = preorder(node.left, i + 1, answer);
            i = preorder(node.right, i, answer);
            return i;
        }

        public int postorder(TreeNode node, int i, int[] answer) {
            if(node == null) return i;
            i = postorder(node.left, i, answer);
            i = postorder(node.right, i, answer);
            answer[i] = node.val;
            return i + 1;

        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            treeNodes.add(new TreeNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        treeNodes.sort(Comparator.comparingInt(o -> o.y));

        LoadMap loadMap = new LoadMap();
        for(int i = len; i>0; i--) {
            loadMap.insert(treeNodes.get(i - 1));
        }
        return new int[][]{loadMap.getPreorder(), loadMap.getPostorder()};
    }

    public static void main(String[] args) {
        길_찾기_게임 res = new 길_찾기_게임();
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = res.solution(nodeinfo);
        System.out.println("preorder: " + Arrays.toString(answer[0]));
        System.out.println("postorder: " + Arrays.toString(answer[1]));

    }
}
