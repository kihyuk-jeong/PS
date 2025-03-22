package pro.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Album {
    int index;
    int play;

    public Album(int index, int play) {
        this.index = index;
        this.play = play;
    }

    @Override
    public String toString() {
        return "Album{" +
                "index=" + index +
                ", play=" + play +
                '}';
    }
}

public class 베스트앨범 {

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solve(genres, plays);

    }

    private static void solve(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Album>> albumMap = new HashMap<>();

        int length = genres.length;

        for (int i = 0; i < length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> list = map.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .map(Map.Entry::getKey)
                .toList();

        for (String s : list) {
            albumMap.put(s, new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            List<Album> albums = albumMap.get(genres[i]);
            albums.add(new Album(i, plays[i]));
        }

        for (List<Album> albums : albumMap.values()) {
            Collections.sort(albums, (a, b) -> {
                if (a.play == b.play) {
                    return Integer.compare(a.index, b.index);
                }
                return Integer.compare(b.play, a.play);
            });
        }

        // 정렬된 키 목록을 사용하여 LinkedHashMap에 순서 보장
        Map<String, List<Album>> sortedAlbumMap = new LinkedHashMap<>();
        for (String genre : list) {
            sortedAlbumMap.put(genre, albumMap.get(genre));
        }

        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedAlbumMap.keySet()) {
            List<Album> albums = sortedAlbumMap.get(genre);
            for (int i = 0; i < Math.min(2, albums.size()); i++) {
                answer.add(albums.get(i).index);
            }
        }

        System.out.println(answer);
    }
}
