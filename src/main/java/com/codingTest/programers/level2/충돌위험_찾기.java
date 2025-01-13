package com.codingTest.programers.level2;

import java.util.*;

public class 충돌위험_찾기 {
    Map<Integer, Point> pointMap = new HashMap<>();
    Queue<MoveMap> robots = new LinkedList<>();
    Map<Point, Integer> check = new HashMap<>();

    private class MoveMap {
        Point point;
        int routePoint = 0;
        Point[] end;

        public MoveMap(Point start, Point[] end) {
            this.point = new Point(start.y, start.x);
            this.end = end;
        }

        public void moveY() {
            if(point.y > end[routePoint].y) point.y--;
            else point.y++;
        }

        public void moveX() {
            if(point.x > end[routePoint].x) point.x--;
            else point.x++;
        }

        public Point getEnd() {
            return end[routePoint];
        }

        public boolean routePointChange() {
            routePoint++;
            return routePoint < end.length;
        }
    }

    private class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return this.y == p.y && this.x == p.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        initPoints(points);
        initRobots(routes);

        int answer = 0;

        for(int value : check.values()) {
            if(value > 1) answer++;
        }
        check.clear();

        while (!robots.isEmpty()) {
            int roobotCount = robots.size();
            for (int i = 0; i < roobotCount; i++) {
                // 현재 이동할 로봇
                MoveMap moveMap = robots.poll();

                // 로봇의 y축이 도착지 y와 다를 경우 우선적으로 움직임
                if(moveMap.point.y != moveMap.getEnd().y) {
                    moveMap.moveY();
                } else {
                    moveMap.moveX();
                }

                check.put(moveMap.point, check.getOrDefault(moveMap.point, 0) + 1);

                // 도착안했으면 queue에 담기
                if(!moveMap.point.equals(moveMap.getEnd()) || moveMap.routePointChange()) {
                    robots.add(moveMap);
                }
            }

            for(int value : check.values()) {
                if(value > 1) answer++;
            }

            check.clear();
        }

        return answer;
    }

    private void initPoints(int[][] points) {
        for(int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, new Point(points[i][0], points[i][1]));
        }
    }

    private void initRobots(int[][] routes) {
        for (int[] route : routes) {
            int endRoutes = route.length - 1;
            Point[] end = new Point[endRoutes];
            for(int i = 0; i < endRoutes; i++) {
                end[i] = pointMap.get(route[i + 1]);
            }
            MoveMap moveMap = new MoveMap(pointMap.get(route[0]), end);
            robots.add(moveMap);
            check.put(moveMap.point, check.getOrDefault(moveMap.point, 0) + 1);
        }
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int[][] routes = {{1, 2, 1}, {3, 2, 1}};

        충돌위험_찾기 res = new 충돌위험_찾기();
        System.out.println(res.solution(points, routes));
    }
}
