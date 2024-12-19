package com.codingTest.programers.pccp.guest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 데이터_분석 {
    private final String[] cols = {"code", "date", "maximum", "remain"};

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // filter
        int[][] filterData = this.filter(data, ext, val_ext);
        // sort
        this.sort(filterData, sort_by);
        return filterData;
    }

    private int[][] filter(int[][] data, String ext, int val_ext) {
        List<int[]> res = new ArrayList<int[]>();
        int filterIndex = this.getColsIndex(ext);
        for(int[] row: data) {
            if(row[filterIndex] <= val_ext) {
                res.add(row);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private void sort(int[][] data, String sort_by) {
        int sortIndex = this.getColsIndex(sort_by);
        Arrays.sort(data, Comparator.comparingInt(p -> p[sortIndex]));
    }

    private int getColsIndex(String ext) {
        for(int i = 0; i < cols.length; i++) {
            if(cols[i].equals(ext)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        데이터_분석 res = new 데이터_분석();
        int[][] answer = res.solution(data, ext, val_ext, sort_by);
        for(int[] row: answer) {
            System.out.println(Arrays.toString(row));
        }
    }
}
