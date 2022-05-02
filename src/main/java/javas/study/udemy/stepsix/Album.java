package javas.study.udemy.stepsix;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }
    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) return playList.add(checkedSong);
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song song = songs.findSong(title);
        if (song != null) return playList.add(song);
        return false;
    }

    private class SongList {
        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean add (Song song) {
            if (songs.contains(song)) {
                return false;
            }
            return songs.add(song);
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) return song;
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber -1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
