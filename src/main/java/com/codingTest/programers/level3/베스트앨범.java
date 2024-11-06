package com.codingTest.programers.level3;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Album>> genreAlbums = new HashMap<>();

        // 각 장르별 총 재생 횟수 및 앨범 목록 생성
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + playCount);
            genreAlbums.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Album(i, playCount));
        }

        // 장르별 재생 횟수 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 앨범을 재생 횟수 및 인덱스 기준으로 정렬하고 상위 두 개 선택
            List<Album> albums = genreAlbums.get(genre);
            albums.sort((a1, a2) -> a2.playCount != a1.playCount ? a2.playCount - a1.playCount : a1.index - a2.index);

            for (int i = 0; i < Math.min(2, albums.size()); i++) {
                answer.add(albums.get(i).index);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        베스트앨범 res = new 베스트앨범();
        System.out.println(Arrays.toString(res.solution(genres, plays)));
    }

    class Album {
        int index;
        int playCount;

        public Album(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }
}

